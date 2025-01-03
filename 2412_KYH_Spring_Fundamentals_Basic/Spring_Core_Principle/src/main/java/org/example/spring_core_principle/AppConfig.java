package org.example.spring_core_principle;

import org.example.spring_core_principle.discount.DiscountPolicy;
import org.example.spring_core_principle.discount.FixDiscountPolicy;
import org.example.spring_core_principle.discount.RateDiscountPolicy;
import org.example.spring_core_principle.member.MemberRepository;
import org.example.spring_core_principle.member.MemberService;
import org.example.spring_core_principle.member.MemberServiceImpl;
import org.example.spring_core_principle.member.MemoryMemberRespository;
import org.example.spring_core_principle.order.OrderService;
import org.example.spring_core_principle.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration은 Spring에서 설정 정보라는 것을 명시하는 Annotation
@Configuration
public class AppConfig {
    // 이전까지는 우리가 직접 MemberServiceImpl에서 어떤 Repository를 사용할지 결정
    @Bean
    public MemberService memberService() {
        System.out.println("[AppConfig.memberService]");
        // 생성자 주입
        // MemoryMemberRespository 구현체를 주입해준다
        return new MemberServiceImpl(memberRepository());
    }

    // 리팩토링을 아래와 같이 한다면, AppConfig만 봐도 역할을 볼 수 있다
    // 또한 구현체가 바뀔 경우 아래 return할 구현체만 바꾸면 된다
    @Bean
    public static MemoryMemberRespository memberRepository() {
        System.out.println("[AppConfig.memberRepository]");
        return new MemoryMemberRespository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("[AppConfig.orderService]");
        // 생성자 주입
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public static DiscountPolicy discountPolicy() {
        System.out.println("[AppConfig.discountPolicy]");
        // return new FixDiscountPolicy();

        // 정률% 할인 정책으로 바꾸고자 할 때 아래 1줄만 바꾸면 된다
        // AppConfig (구성) 영역만 변경될 뿐 클라이언트 (구현) 영역은 변경되지 않는다
        return new RateDiscountPolicy();
    }
}
