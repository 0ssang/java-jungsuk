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

---------------------8장 CONSTRAINT--------------


--스칼라 서브쿼리 예제--

SELECT e.NAME AS 사원이름 , d.NAME AS 부서이름
FROM S_EMP e, S_DEPT d
WHERE e.DEPT_ID = d.ID;

SELECT e.NAME AS 사원이름,
       (SELECT NAME FROM s_dept WHERE s_dept.ID = e.DEPT_ID) AS 부서이름
FROM S_EMP e;
