package org.example.spring_core_principle.singleton;

import org.assertj.core.api.Assertions;
import org.example.spring_core_principle.AppConfig;
import org.example.spring_core_principle.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SingletonTest {

    @Test
    @DisplayName("Spring 없는 순수한 DI Container")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();

        // 1. 조회1 : 호출할 때마가 객체 생성
        MemberService memberService1 = appConfig.memberService();

        // 2. 조회2 : 호출할 때마가 객체 생성
        MemberService memberService2 = appConfig.memberService();

        // 참조값이 다른 것을 확인
        System.out.println(memberService1);
        System.out.println(memberService2);

        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }

    // Spring Container를 쓰면
    // Spring Container가 자동적으로 모든 객체를
    // Singleton Pattern으로 생성하고 관리한다
    @Test
    @DisplayName("Singleton Pattern을 적용한 객체 사용")
    void singletonServiceTest() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println(singletonService1);
        System.out.println(singletonService2);

        Assertions.assertThat(singletonService1).isSameAs(singletonService2);
    }

    @Test
    @DisplayName("Spring Container와 Singleton")
    void springContainerTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        // 1. 조회1
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);

        // 2. 조회2
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        // 참조값이 같은 것을 확인
        System.out.println(memberService1);
        System.out.println(memberService2);

        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }
}
