package org.example.spring_core_principle.singleton;

import org.example.spring_core_principle.AppConfig;
import org.example.spring_core_principle.member.MemberRepository;
import org.example.spring_core_principle.member.MemberServiceImpl;
import org.example.spring_core_principle.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        System.out.println("memberService -> memberRepository: " + memberRepository1);
        System.out.println("orderService -> memberRepository: " + memberRepository2);
        System.out.println("memberRepository: " + memberRepository);
    }

    @Test
    void Configuration(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println(bean.getClass());
    }
}
