package org.example.spring_core_principle;

import org.example.spring_core_principle.member.Grade;
import org.example.spring_core_principle.member.Member;
import org.example.spring_core_principle.member.MemberService;
import org.example.spring_core_principle.member.MemberServiceImpl;
import org.example.spring_core_principle.order.Order;
import org.example.spring_core_principle.order.OrderService;
import org.example.spring_core_principle.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        // MemberService memberService = new MemberServiceImpl();
        // OrderService orderService = new OrderServiceImpl();

        // 기존 방식과는 다르게 AppConfig에서
        // MemberService, OrderService 구현체를 받아와 사용
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memeberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 1000);
        // Order의 toString이 호출된다
        System.out.println("[order]: " + order);
        System.out.println("[order]: " + order.calculatePrice());
    }
}
