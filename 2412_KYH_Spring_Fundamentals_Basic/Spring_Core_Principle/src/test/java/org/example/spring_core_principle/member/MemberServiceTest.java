package org.example.spring_core_principle.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

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
