package com.quecode.chapter2;

import java.util.function.Consumer;

public class User {

    private long userSn;
    private String userId;
    private String userPw;

    public User(Builder builder){
        this.userSn = builder.userSn;
        this.userId = builder.userId;
        this.userPw = builder.userPw;
    }

    public static class Builder {
        public long userSn;
        public String userId;
        public String userPw;

        private Builder() {
        }

        public Builder with(Consumer<Builder> consumer){
            consumer.accept(this);
            return this;
        }

        public User build(){
            return new User(this);
        }
    }
}
