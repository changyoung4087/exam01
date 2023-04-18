package org.koreait.models.member_builder패턴;

public class Ex01 {
    public static void main(String[] args) {
        Member member = Member.builder()
                .userNo(1L)
                .userId("user123")
                .userPw("1234567")
                .userNm("사용자")
                .build();
        System.out.println(member);

        Member2 member2 = Member2.builder()
                .userNo(2L)
                .userId("user123456")
                .userPw("1234567890")
                .userNm("사용자11")
                .build();

        System.out.println(member2);
    }
}
