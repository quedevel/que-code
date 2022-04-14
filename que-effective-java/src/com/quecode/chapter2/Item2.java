package com.quecode.chapter2;

import java.util.function.Consumer;

/**
 * Description
 * 2. 생성자에 매개변수가 많다면 빌더를 고려하라.
 *
 * 핵심 정리
 * 생성자나 메서드가 처리해야 할 파라미터가 많다면 빌더를 고려하자!
 */
public class Item2 {

    static class Member{
        private long mbrSn;
        private String mbrId;
        private String mbrPw;
        private String mbrNm;
        private String email;
        private String gender;
        private int age;
        private int hp1;
        private int hp2;
        private int hp3;

        public Member(Builder builder){
            this.mbrSn = builder.mbrSn;
            this.mbrId = builder.mbrId;
            this.mbrPw = builder.mbrPw;
            this.mbrNm = builder.mbrNm;
            this.email = builder.email;
            this.gender = builder.gender;
            this.age = builder.age;
            this.hp1 = builder.hp1;
            this.hp2 = builder.hp2;
            this.hp3 = builder.hp3;
        }

        public static Builder builder(String id, String pw){
            return new Builder(id, pw);
        }

        public static class Builder {
            public long mbrSn;
            public String mbrId;
            public String mbrPw;
            public String mbrNm;
            public String email;
            public String gender;
            public int age;
            public int hp1;
            public int hp2;
            public int hp3;

            private Builder(String mbrId, String mbrPw) {
                this.mbrId = mbrId;
                this.mbrPw = mbrPw;
            }

            public Builder with(Consumer<Builder> consumer){
                consumer.accept(this);
                return this;
            }

            public Member build(){
                return new Member(this);
            }
        }

        public long getMbrSn() {
            return mbrSn;
        }
        public String getMbrId() {
            return mbrId;
        }
        public String getMbrPw() {
            return mbrPw;
        }
        public String getMbrNm() {
            return mbrNm;
        }
        public String getEmail() {
            return email;
        }
        public String getGender() {
            return gender;
        }
        public int getAge() {
            return age;
        }
        public int getHp1() {
            return hp1;
        }
        public int getHp2() {
            return hp2;
        }
        public int getHp3() {
            return hp3;
        }

        @Override
        public String toString() {
            return "Member{" +
                    "mbrSn=" + mbrSn +
                    ", mbrId='" + mbrId + '\'' +
                    ", mbrPw='" + mbrPw + '\'' +
                    ", mbrNm='" + mbrNm + '\'' +
                    ", email='" + email + '\'' +
                    ", gender='" + gender + '\'' +
                    ", age=" + age +
                    ", hp1=" + hp1 +
                    ", hp2=" + hp2 +
                    ", hp3=" + hp3 +
                    '}';
        }
    }

    public static void main(String[] args) {
        Member builderMember = Member.builder("quedevel", "1234").with(builder -> {}).build();
        System.out.println("builderMember.toString() = " + builderMember.toString());
    }
}
