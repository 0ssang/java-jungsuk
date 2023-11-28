--SELECT * FROM TABLE1;

--INSERT  INTO TABLE1 VALUES(2, '남궁성',15000 ,'부장', SYSDATE, '본부');

--UPDATE TABLE1
--SET DEPT_NAME = '개발팀'
--WHERE ID = 3;

--SELECT * FROM TABLE1;

SELECT ROUND(SYSDATE, 'month') FROM DUAL; --23/12/01
SELECT ROUND(SYSDATE, 'day') FROM DUAL;   --23/11/19

SELECT TO_CHAR(sysdate, 'mm/dd/yyyy') FROM DUAL;
SELECT TO_CHAR(sysdate, 'yyyy-mm-dd') FROM DUAL;

SELECT *  FROM S_EMP -- for(e : S_EMP) print(e) 와 같다. JAVA코드와 치환 할 줄 알아야 한다.
WHERE name = '박구곤';

SELECT 1 FROM S_DEPT;

---------------------------------5장 GROUP BY / HAVING  ----------------------------
SELECT TITLE, DEPT_ID
FROM S_EMP;

-- 그냥 사용하면 중복제거의 효과를 누릴 수 있다.------
SELECT dept_id AS 부서번호
FROM S_EMP
GROUP BY DEPT_ID;

-- 부서별 평균 급여를 계산하시오--
SELECT DEPT_ID, AVG(SALARY)
FROM S_EMP
GROUP BY DEPT_ID;

--- 부서별로 사원인 사람들의 평균연봉을 구하는 쿼리--------
SELECT dept_id AS 부서번호, AVG(salary) AS 평균연봉
FROM S_EMP
WHERE TITLE = '사원'
GROUP BY DEPT_ID;

---사원 수가 2명보다 많은 직무별로 평균연봉과 사원 수 구하기---
SELECT TITLE, AVG(SALARY), COUNT(*)
FROM S_EMP
GROUP BY TITLE
HAVING COUNT(*) > 2;

----------------------------6장 JOIN --------------------------
---작원S_EMP 테이블과 부서 S_DEPT 테이블을 JOIN하여 사원의 이름과 부서 부서명을 나타내시오.
SELECT e.NAME --직원이름 COLUMN ambiguosly defined
     , d.NAME    -- 부서이름
FROM S_EMP e, S_DEPT d
WHERE e.DEPT_ID  = d.ID; --EQUIJOIN. 꼭 = 연산이 아니어도 < > 이어도 조건만 참이 되는 값을 연결하여 조인한다.

-- 직원 테이블 S_EMP와 급여 테이블 SALGRADE을 JOIN하여 사원의 이름NAME과 급여SALARY 그리고 해당 급여등급GRADE 을 나타내시오.
SELECT e.NAME AS 이름, s.GRADE AS 급여등급
FROM S_EMP e, SALGRADE s
WHERE e.SALARY BETWEEN s.LOSAL AND s.HISAL; -- NON-EQUIJOIN의 조건을 WHERE 절에 적는다.

--서울 지역에 근무하는 사원에 대해 각 사원의 이름과근무하는 부서명을 나타내시오.--
SELECT e.NAME, d.NAME
FROM S_EMP e  ,S_DEPT d , S_REGION r
WHERE e.DEPT_ID  = d.ID AND d.REGION_ID = r.ID AND r.NAME = '서울특별시';



---- 직원 중에 '김정미' 와 같은 직책title 을 가지는 사원의 이름Name과 직책title, 급여salary, 부서번호dept_id를 나타내시오. (SELF JOIN을 사용할 것)---
--예상 정답--
SELECT name, TITLE , SALARY , DEPT_ID
FROM S_EMP
WHERE NAME <> '김정미' AND TITLE = '과장';

--내가 작성한 쿼리--

--SELECT e1.NAME, e1.TITLE , e1. SALARY , e1.DEPT_ID
SELECT e1.name,e1.title, e1.salary, e1.dept_id
FROM S_EMP e1, S_EMP e2
WHERE e1.title = e2.title
  AND e2.name = '김정미'
  AND e1.name != '김정미';


--------------------------------7장--------------------------------------------
-----------가장 적은평균급여를 받는 직책에 대해 그 직책과 평균급여를 나타내시오.----------------

----------HAVING 절에 서브쿼리를 작성하여 풀이 AVG(SALARY)를 기준으로...----------------
SELECT TITLE , avg(SALARY)
FROM S_EMP
GROUP BY TITLE
HAVING avg(SALARY) = (
    SELECT MIN(AVG(SALARY))
    FROM S_EMP
    GROUP BY TITLE
);

----------------HAVING 절에 들어갈 서브쿼리-------------------------
SELECT MIN(AVG(SALARY))
FROM S_EMP
GROUP BY TITLE; --809


------------- WHERE 절에 서브쿼리를 작성하여 풀이 TITLE(최솟값)을 기준으로...-------------
SELECT TITLE , AVG(SALARY)
FROM S_EMP
WHERE TITLE = (SELECT TITLE
               FROM S_EMP
               GROUP BY TITLE
               HAVING  AVG(SALARY) = (SELECT MIN(AVG(SALARY))
                                      FROM S_EMP
                                      GROUP BY TITLE))
GROUP BY TITLE ;
---------------WHERE 절에 들어갈 서브쿼리 ----------------------
SELECT TITLE
FROM S_EMP
GROUP BY TITLE
HAVING  AVG(SALARY) = (SELECT MIN(AVG(SALARY)) --809를 뽑기위해 대입하기.
                       FROM S_EMP
                       GROUP BY TITLE);

---------------------10장--------------


--스칼라 서브쿼리 예제--

SELECT e.NAME AS 사원이름 , d.NAME AS 부서이름
FROM S_EMP e, S_DEPT d
WHERE e.DEPT_ID = d.ID;

SELECT e.NAME AS 사원이름,
       (SELECT NAME FROM s_dept WHERE s_dept.ID = e.DEPT_ID) AS 부서이름
FROM S_EMP e;

SELECT *
FROM DICTIONARY
WHERE table_name LIKE 'USER%';

SELECT OBJECT_name --사용자가 소유한 모든 테이블 조회
FROM user_objects
WHERE OBJECT_type = 'TABLE';

--SELECT constraint_name. constraint_type, SEARCH_condition, r_constraint_name
FROM USER_CONSTRAINTS -- s_EMP의 테이블레벨 제한 검색
WHERE TABLE_name = 'S_emp'

--13장 OBJECT--
INSERT INTO s_emp (id, name, salary) values(c_emp_seq.nextval, 'aaa', 1000);
INSERT INTO s_emp (id, name, salary) SELECT c_emp_seq.nextval, 'aaa', 1000 FROM S_EMP;
DELETE FROM S_EMP se WHERE id > 25;
SELECT * FROM S_EMP se;

--자동으로 unique number를 생성하는 sequence 생성하기--
--nextval = 사용가능한 다음 sequence값을 반환한다.
--currval = 현재 sequence값을 포함한다.
CREATE SEQUENCE c_emp_seq
    INCREMENT BY 1
    START WITH 26
    MAXVALUE 9999999
    NOCACHE
NOCYCLE;

----INDEX 만들기------
CREATE INDEX name_index ON S_EMP(name);
SELECT * FROM ind; --만들어진 인덱스 확인하기.

DROP INDEX name_index; --인덱스 삭제하기--

----VIEW 만들기------
CREATE VIEW vw_emp_dept as
SELECT e.NAME  name , d.NAME dept_name
FROM S_EMP e, S_DEPT d
WHERE e.dept_id = d.id;

SELECT * FROM VW_EMP_DEPT;

SELECT * FROM USER_views; -- USER VIEW 확인

---------------14장 ADVANCED FUNCTION------------------
-- 1. NVL FUNCTION

-- 2. DECODE FUNCTION
--s_EMP 테이블에서 각 사우너의 이름과 급여, 급여등급을 나타내시오.
-- 급여가 4000원만원 이상이면 A등급, 3000만원 이상이면 B등급, 2000만원 이상이면 C등급, 1000만원 이상이면 D등급, 1000만원 이하이면 E등급으로 나타내시오.
SELECT NAME, SALARY, DECODE(TRUNC(SALARY/1000), 0, 'E', 1, 'D', 2, 'C', 3, 'B', 'A')급여등급
FROM S_EMP;

-- 3. CASE문
SELECT id, name,
       CASE salary
           WHEN 1000 THEN 'LOW'
           WHEN 5000 THEN 'HIGH'
           ELSE 'Medium'
           END
FROM S_EMP;

SELECT ID , NAME ,
       CASE
           WHEN salary < 1000 THEN 'Very Low'
           WHEN salary >= 1000 AND salary <= 5000 THEN  'Low'
           WHEN salary > 5000 THEN 'High'
           ELSE 'Medium'
           END
FROM S_EMP;

-- 4. PIVOT FUNCTION
--데이터를 PIVOT테이블의 형태로 보여준다.
SELECT * FROM (SELECT dept_id, title FROM S_EMP)
                  PIVOT(
                        COUNT(*)
	FOR title IN('사원', '과장', '부장', '이사', '사장')
        )
ORDER BY dept_id;

-- 4-1. PIVOT함수가 지원되지 않는 경우, dECODE함수로 처리
SELECT dept_id,
       COUNT(DECODE(title, '사원',0)) "사원",
       COUNT(DECODE(title, '과장',0)) "과장",
       COUNT(DECODE(title, '부장',0)) "부장",
       COUNT(DECODE(title, '이사',0)) "이사",
       COUNT(DECODE(title, '사',0)) "사장"
FROM S_EMP se
GROUP BY DEPT_ID
ORDER BY DEPT_ID;

-- 5. ROLLUP
--그룹별 합계를 보여주는 함수.. 부분합계와 최종 합계가 있다.
SELECT DEPT_ID, TITLE, COUNT(*)
FROM S_EMP se
WHERE DEPT_ID IN (106, 112, 113)
GROUP BY ROLLUP(DEPT_ID, TITLE)
ORDER BY DEPT_ID;

-- 6. CUBE
-- 그룹 별 합계 & 소계
SELECT DEPT_ID , TITLE , COUNT(*)  FROM S_EMP se
WHERE DEPT_ID IN (106, 112, 113)
GROUP BY CUBE(DEPT_ID, TITLE)
ORDER BY DEPT_ID;

-- 7. RANK
-- RANK() OVER (ORDER BY 컬럼명 [ASC | DESC])
SELECT id, name, SALARY,
       RANK() OVER(ORDER BY salary DESC) AS RANK
FROM S_EMP;

--그룹별 순위를 계산해서 보여주는 것도 가능 PARITION BY 사용
SELECT DEPT_ID , NAME, SALARY ,
       RANK () OVER(
		PARTITION  BY DEPT_ID
		ORDER BY SALARY DESC) AS RANK
FROM S_EMP;



-- 8. CORRELATED SUBQUERY
--자신의 급여가 자신이 속한 부서의 평균 급여보다 적은 직원에 대해 이름, 급여, 부서번호를 출력하시오.
SELECT name, salary, dept_id
FROM s_emp OUTER
WHERE salary < (SELECT AVG(salary) FROM s_emp WHERE dept_id = OUTER.dept_id)

--- 9. Multi Row Comparision Operator
-- 본인의 급여가 각 부서별 평균 급여중 어느 한 부서의 평균 급여보다 적은 급여를 받는 직원에 대해
-- 이름NAME, 급여SALARY, 부서번호를DEPT_ID 출력하시오.
SELECT NAME , SALARY , DEPT_ID
FROM S_EMP
WHERE SALARY < ANY(SELECT avg(SALARY) FROM S_EMP GROUP BY DEPT_ID);

SELECT avg(SALARY) FROM S_EMP GROUP BY DEPT_ID;

--본인이 다른 사람의 관리자(manager _id)로 되어있는 직원의 사번, 이름, 직책, 부서번호를 나타내시오.
SELECT ID , NAME , TITLE , DEPT_ID
FROM S_EMP e
WHERE 1=1
  AND EXISTS (SELECT id FROM s_emp WHERE MANAGER_ID = e.ID);


-- 10. PSEUDO COLUMN
SELECT * ,(SELECT rownum rn , * FROM S_EMP)
FROM S_EMP e
WHERE 1=1
  AND rn BETWEEN 6 AND 10; --rownum은 항상 작거나 같다는 비교를 사용해야 한다.
--AND rownum > 5;		-- 결과집합에 추가되어야 하는데 이 조건은 항상 false가 된다.
--그렇다면 중간에 있는 값은 어떻게 뽑을까, 5~10 값을 뽑아보자.


-- 11. index


-- 12. trigger


--------------------연습문제------------------
--1.직원 테이블 s_emp의 모든 행을 삭제하는 문장을 적으시오.
DELETE FROM S_EMP;

--2.직원 테이블에 존재하는 모든 직급title을 중복없이 출력하시오.
SELECT DISTINCT  TITLE  FROM S_EMP;

--3.직원 테이블을 부서별 내림차순, 연봉 오름차순으로 정렬하시오.
SELECT DEPT_ID , SALARY
FROM S_EMP
ORDER BY 1 DESC, 2 ASC;

--4.직원테이블에서 2015년도 이전에 입사한 직원의 수를 출력하시오.
SELECT count(*)
FROM S_EMP e
WHERE TO_NUMBER(TO_CHAR(START_DATE,'yyyy')) < 2015;

--5.연봉이 1000 이상 5000 이하인 직원을 모두 출력하시오.
SELECT NAME , SALARY
FROM S_EMP se
WHERE SALARY BETWEEN 1000 AND 5000;

--6. 각 부서dept_id 별 평균급여를 계산해서 출력하시오.
SELECT DEPT_ID , avg(SALARY)
FROM S_EMP e
GROUP BY DEPT_ID;

--7. 각 부서(dept_id)별로 직책이 사원인 직원들의 평윤 급여를 계산해서 보여주시오.
SELECT DEPT_ID , AVG(SALARY)
FROM S_EMP se
WHERE TITLE = '사원'
GROUP BY DEPT_ID;

--8. 각 지역(region_id)별로 몇 개의 부서가 있는지를 나타내시오
SELECT d.REGION_ID, COUNT(*)
FROM S_DEPT d
GROUP BY region_id;

--9. 각 부서별로 평균 급여를 구하되 평균 급여가 2000 이상인 부서만 나타내시오.
SELECT e.DEPT_ID , AVG(SALARY)
FROM S_EMP e
GROUP BY DEPT_ID HAVING avg(SALARY) >= 2000;

--10. 각 직책별로 급여의 총합을 구하되 직책이 부장인 사람은 제외하시오.
--	단, 급여총합이 8000 이상인 직책만 나타내며, 급여 총합에 대한 오름차순으로 정렬하시오.
SELECT TITLE , SUM(SALARY)
FROM S_EMP e
WHERE TITLE <> '부장'
GROUP BY TITLE
HAVING SUM(SALARY) >= 8000
ORDER BY 2 ASC ;

--11. 각 부서별로 직책이 사원인 직원들에 대해서만 평균 급여를 구하시오.
SELECT DEPT_ID , AVG(SALARY)
FROM S_EMP se
WHERE TITLE = '사원'
GROUP BY DEPT_ID;
--12. 각 부서내에서 각 직책별로 몇 명의 인원이 있는지를 나타내시오.
SELECT TITLE  ,COUNT(*)
FROM S_EMP se
GROUP BY TITLE;

--13. 각 부서내에서 몇 명의 직원이 근무하는지를 나타내시오.
SELECT DEPT_ID ,count(*)
FROM S_EMP se
GROUP BY DEPT_ID;

--14. 각 부서별로 급여의 최소값과 최대값을 나타내시오. 단, 최소값과 최대값이 같은 부서는 출력하지 마시오.
SELECT DEPT_ID, MIN(SALARY) , MAX(SALARY)
FROM S_EMP e
GROUP BY DEPT_ID
HAVING MIN(SALARY) != MAX(SALARY);

--15. 직원(S_EMP)테이블과 부서(s_DEPT)테이블을 JOIN하여 사원의 이름과 부서, 부서명을 나타내시오.
SELECT e.NAME , e.DEPT_ID , d.NAME
FROM S_EMP e, S_DEPT d
WHERE e.DEPT_ID  = d.ID;


--16. 서울 지역에 근무하는 사원에 대해 각 사원의 이름과 근무하는 부서명을 나타내시오.
SELECT e.NAME , d.NAME
FROM S_EMP e, S_DEPT d
WHERE e.DEPT_ID  = d.ID
  AND d.REGION_ID = (SELECT ID FROM S_REGION r WHERE name = '서울특별시');

--17. 직원테이블s_emp 과 급여 테이블 salgrade을 join하여 사원의 이름과 급여, 그리고 해당 급여등급을 나타내시오
SELECT e.NAME , e.SALARY , s.GRADE
FROM S_EMP e , SALGRADE s
WHERE e.SALARY BETWEEN s.LOSAL AND s.HISAL;
--18. 직원s_emp 테이블과 고객s_customer 테이블에서 사원의 이름과 사번, 그리고 각 사원의 담당고객 이름을 나타내시오.
--  단, 고객에 대하여 담당영업사원이 없더라도 모든 고객의 이름을 나타내고, 사번 순으로 오름차순 정렬하시오.
SELECT e.NAME 사원이름, e.ID 사번, c.NAME 담당고객
FROM S_EMP e, S_CUSTOMER c
WHERE e.ID(+)  = c.SALES_REP_ID
ORDER BY 2 ASC;

--19. 직원중에 김정미와 같은 직책을 가지는 사원의 이름과 직책 급여 부서번호를 나타내시오 SELFJOIN을 이용할것.
SELECT e1.name, e1.title, e1.salary, e1.dept_id
FROM S_EMP e1 , S_EMP e2
WHERE 1=1
  AND e1.title = e2.title
  AND e2.name = '김정미'
  AND e1.name != '김정미';

--20.가장 적은 평균급여를 받는 직책에 대해 그 직책과 평균급여를 나타내시오.
SELECT TITLE , avg(SALARY)
FROM S_EMP e
GROUP BY TITLE
HAVING avg(SALARY) = (SELECT MIN(AVG(SALARY)) FROM S_EMP GROUP BY TITLE);

SELECT MIN(AVG(SALARY)) FROM S_EMP GROUP BY SALARY;
--21. s_emp 테이블에서 각 사원의 이름과 급여, 급여등급을 나타내시오.
--		급여가 4000이상이면 a등급 3000이상이면 b등급 2000이상이면 c등급 1000이상이면 d등급 1000만원 이하면e등급으로 나타내시오
--	단,decode사용하여 푸시오.
SELECT NAME , SALARY ,
       DECODE(TRUNC(SALARY/1000), 0, 'E', 1, 'D', 2, 'C', 3, 'B', 'A') 급여등급
FROM S_EMP se ;

--22. 자신의 급여가 자신이 속한 부서의 평균 급여보다 적은 직원에 대해 이름, 급여, 부서번호를 출력하시오.
SELECT NAME , SALARY , DEPT_ID
FROM S_EMP e
WHERE SALARY < (SELECT avg(SALARY) FROM S_EMP e2 WHERE e2.DEPT_ID = e.DEPT_ID);

--자신이 속한 부서의 평균 급여를 구하기

--23. 본인의 급여가 각 부서별 평균 급여 중 어느 한 부서의 평균급여보다 적은 급여를 받는 직원에 대해 이름, 급여, 부서번호를 출력하시오(any 출력)
SELECT NAME , SALARY , DEPT_ID
FROM S_EMP e
WHERE SALARY < ANY (SELECT avg(SALARY) FROM S_EMP GROUP BY dept_id);
--ANY = 서브쿼리에 의하여 리턴된 값 중 어느 하나와 비교.
SELECT avg(SALARY) FROM S_EMP GROUP BY dept_id;

--24. 본인이 다른 사람의관리자 manager_id로 되어있는 직원의 사번, 이름, 직책, 부서번호를 나타내시오exists사용
SELECT ID , NAME , TITLE , DEPT_ID
FROM s_emp e
WHERE EXISTS (SELECT id FROM S_EMP WHERE e.MANAGER_ID = ID);
--25. 직원 s_emp 테이블에서 이름을 사전순으로 정렬하여 5개의 데이터만 나타내시오.
SELECT *
FROM (SELECT * FROM s_emp ORDER BY name ASC)
WHERE rownum <= 5;


----------SQL 시험-----------------------------
--직급이 부장(영업부장 ,지부장 포함)인 사람이 2명 이하인 부서가 몇 개 인지 나타내는 구문을 작성하시오.


SELECT sum(count(*))
FROM S_EMP
WHERE S_EMP.TITLE LIKE  '%부장'
GROUP BY DEPT_ID HAVING count(*) <= 2;

-- 담당직원(s_customer.sales_rep_id)이 배정되지 않은 고객(s_customer.name)을모두 나타내는 구문을 작성하시오
SELECT c.NAME
FROM S_EMP e, S_CUSTOMER c
WHERE e.id(+) = c.SALES_REP_ID
  AND c.SALES_REP_ID IS NULL;

