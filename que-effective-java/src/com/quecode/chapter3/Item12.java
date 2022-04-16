package com.quecode.chapter3;

/**
 * Description
 * 12. toString을 항상 재정의하라
 *
 * 모든 구체 클래스에서 Object의 toString을 재정의하자... 라지만
 * 요즘 IDE가 좋아서 디버깅하면 다 노출되며 logger 라이브러리를 사용하면
 * toString을 재정의할 필요는 없는것 같다.
 */
public class Item12 {
    static class User{
        private String userId;
        private String userPw;
        private String userNm;

        public String getUserId() {
            return userId;
        }

        public User setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public String getUserPw() {
            return userPw;
        }

        public User setUserPw(String userPw) {
            this.userPw = userPw;
            return this;
        }

        public String getUserNm() {
            return userNm;
        }

        public User setUserNm(String userNm) {
            this.userNm = userNm;
            return this;
        }

        @Override
        public String toString() {
            return "User{" +
                    "userId='" + userId + '\'' +
                    ", userPw='" + userPw + '\'' +
                    ", userNm='" + userNm + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        User user = new User();
        user.setUserId("quedevel").setUserPw("1234").setUserNm("김동호");
        System.out.println(user.toString());
    }
}
