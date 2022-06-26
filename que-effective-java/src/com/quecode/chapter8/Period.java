package com.quecode.chapter8;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

public final class Period implements Serializable {
    private Date start;
    private Date end;

    /**
     * @param  start 시작 시각
     * @param  end 종료 시각. 시작 시각보다 뒤여야 한다.
     * @throws IllegalArgumentException 시작 시각이 종료 시각보다 늦을 때 발생한다.
     * @throws NullPointerException start나 end가 null이면 발생한다.
     */
    public Period(Date start, Date end) {
        if (start.compareTo(end) > 0)
            throw new IllegalArgumentException(
                    start + "가 " + end + "보다 늦다.");
        this.start = start;
        this.end   = end;
    }

    public Date start() {
        return start;
    }
    public Date end() {
        return end;
    }

    public String toString() {
        return start + " - " + end;
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
        if (start.compareTo(end)>0){
            throw new InvalidObjectException(start + "가 " + end + "보다 늦다.");
        }
    }

//    // 코드 50-3 수정한 생성자 - 매개변수의 방어적 복사본을 만든다. (304쪽)
//    public Period(Date start, Date end) {
//        this.start = new Date(start.getTime());
//        this.end   = new Date(end.getTime());
//
//        if (this.start.compareTo(this.end) > 0)
//            throw new IllegalArgumentException(
//                    this.start + "가 " + this.end + "보다 늦다.");
//    }
//
//    // 코드 50-5 수정한 접근자 - 필드의 방어적 복사본을 반환한다. (305쪽)
//    public Date start() {
//        return new Date(start.getTime());
//    }
//
//    public Date end() {
//        return new Date(end.getTime());
//    }

    // 나머지 코드 생략
    public static void main(String[] args) {
        Date start = new Date();
        Date end = new Date();
        Period p = new Period(start,end);
        end.setYear(78); // p의 내부를 수정했다.
    }
}
