package com.quecode.chapter2;

/**
 * Description
 * 1. 생성자 대신 정적 팩터리 메서드를 고려하라.
 *
 * 핵심 정리
 * 정적 팩터리 메서드와 public 생성자는 각각의 장단점이 있기 때문에 잘 활용하라!
 */
public class Item1 {

    static class Member {
        private String mbrId;
        private String mbrPw;

        public static Member ofMemberIdAndMbrPw(String mbrId, String mbrPw){
            Member member = new Member();
            member.setMbrId(mbrId);
            member.setMbrPw(mbrPw);
            return member;
        }

        public String getMbrId() {
            return mbrId;
        }
        public Member setMbrId(String mbrId) {
            this.mbrId = mbrId;
            return this;
        }
        public String getMbrPw() {
            return mbrPw;
        }
        public Member setMbrPw(String mbrPw) {
            this.mbrPw = mbrPw;
            return this;
        }
    }

    public static void main(String[] args) {

        Member m = Member.ofMemberIdAndMbrPw("quedevel", "1234");
        System.out.println("m.getMbrId() = " + m.getMbrId());

    }
}
