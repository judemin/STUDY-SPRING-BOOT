package org.example.spring_core_principle.member;

import org.assertj.core.api.Assertions;
import org.example.spring_core_principle.AppConfig;
import org.example.spring_core_principle.order.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    // Unit Test의 경우 beforeEach를 통해 MemberService 구현체 받아오기
    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join(){
        // GIVEN
        Member member = new Member(1L, "memberA", Grade.VIP);

        // WHEN
        memberService.join(member);
        Member findMember = memberService.findMemeber(1L);

        // THEN
        Assertions.assertThat(findMember).isEqualTo(member);
    }
}
