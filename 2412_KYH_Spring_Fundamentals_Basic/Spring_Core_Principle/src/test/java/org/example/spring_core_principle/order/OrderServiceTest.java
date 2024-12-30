package org.example.spring_core_principle.order;

import org.assertj.core.api.Assertions;
import org.example.spring_core_principle.member.Grade;
import org.example.spring_core_principle.member.Member;
import org.example.spring_core_principle.member.MemberService;
import org.example.spring_core_principle.member.MemberServiceImpl;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder(){
        // long과 같은 Primitive 타입으로 하면 null이 들어가지 못한다
        Long memberId = 1L;
        Member member = new Member(memberId, "memeberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 1000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
