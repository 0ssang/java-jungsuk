package jungsuk.ch11;

import java.util.List;

public class MyVector {
    Object[] objArr;
    int size= 0;

    public MyVector() {
        this(16);
    }
    public MyVector(int capacity){
        objArr = new Object[capacity];
    }
    //objArr에 저장된 객체의 개수를 반환
    public int size(){
        return size;
    }
    // objArr의 길이를 반환
    public int capacity(){
        return objArr.length;
    }
    //객체 배열 objArr이 비어있는지 확인.
    public boolean isEmpty(){
        return size == 0;
    }
    //objArr 배열에 Object obj객체 추가하기
    public void add(Object obj){
        if(size+1 > objArr.length){
            Object[] temp = new Object[objArr.length * 2];
            System.arraycopy(objArr, 0, temp, 0, size);
            objArr = temp;
        }
        objArr[size++] = obj;
    }
    //objArr에 저장된 객체를 반환하는 메서드
    public Object get(int index){
        if(index < 0 || index >= size)
            throw new RuntimeException("인덱스 오류");
        return objArr[index];
    }
    //objArr의 모든 객체를 출력하는 toString 오버라이딩
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Object o : objArr) {
            sb.append(o).append(",");
        }
        return sb.toString();
    }
    //배열 objArr에서 지정된 객체가 저장되어있는 위치index를 반환.
    public int indexOf(Object obj){
        for (int i = 0; i < objArr.length; i++) {
            if(objArr[i] == obj) return i;
        }
        return -1;
    }
    //objArr에서 지정된 객체를 삭제하는 메서드 (indexOf() 이용)
    boolean remove(Object obj){
        int index = indexOf(obj);
        if(index < 0 || index >= size){
            return false;
        }
        if(index != size-1)
            System.arraycopy(objArr, index+1, objArr, index, size - index - 1);
        objArr[size - 1] = null;
        size--;
        return true;
    }
}

