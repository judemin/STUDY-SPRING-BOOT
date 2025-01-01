package org.example.spring_core_principle;

import org.example.spring_core_principle.discount.FixDiscountPolicy;
import org.example.spring_core_principle.member.MemberService;
import org.example.spring_core_principle.member.MemberServiceImpl;
import org.example.spring_core_principle.member.MemoryMemberRespository;
import org.example.spring_core_principle.order.OrderService;
import org.example.spring_core_principle.order.OrderServiceImpl;

public class AppConfig {
    // 이전까지는 우리가 직접 MemberServiceImpl에서 어떤 Repository를 사용할지 결정
    public MemberService memberService() {
        // 생성자 주입
        // MemoryMemberRespository 구현체를 주입해준다
        return new MemberServiceImpl(new MemoryMemberRespository());
    };

    public OrderService orderService() {
        // 생성자 주입
        return new OrderServiceImpl(new MemoryMemberRespository(), new FixDiscountPolicy());
    }
}
