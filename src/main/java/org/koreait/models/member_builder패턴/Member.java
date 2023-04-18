package org.koreait.models.member_builder패턴;

public class Member {
    private Long userNo;
    private String userId;
    private String userPw;
    private String userNm;

    private Member() {} // 와부에서 객체 생성 불가

    public static Builder builder() {
        return new Builder();
    }
    protected static class Builder {
        private Member member = new Member();

        @Override
        public String toString() {
            return "Builder{" +
                    "member=" + member +
                    '}';
        }

        /** 메서드 체인 stream으로 반환을하면 메서드체인 가능 */
        public Builder userNo(Long userNo){
            member.userNo = userNo;

            return this;
        }
        public Builder userId(String userId){
            member.userId = userId;
            return this;
        }
        public Builder userPw(String userPw){
            member.userPw = userPw;
            return this;
        }
        public Builder userNm(String userNm){
            member.userNm = userNm;
            return this;
        }
        public Member build(){
            return member;
        }
    }
}
