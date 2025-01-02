package org.example.spring_core_principle.beanFind;

import org.assertj.core.api.Assertions;
import org.example.spring_core_principle.AppConfig;
import org.example.spring_core_principle.member.MemberService;
import org.example.spring_core_principle.member.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("이름없이 타입으로만 조회")
    void findBeanByType(){
        // 같은 타입이 여러개일 경우 문제가 생기기는 한다
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanBySpecificType(){
        // 구체 타입으로 조회하면 변경시에 유연성이 떨어진다
        // 아래 방식은 구현에 의존한 것이라고 볼 수 있다 (역할과 구현의 분리가 잘 되지 않은 것)
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    // Negative Test
    @Test
    @DisplayName("빈 이름으로 조회X")
    void findBeanByNameX(){
        // ac.getBean("xxxxx", MemberService.class);
        MemberService xxxxx = ac.getBean("xxxxx", MemberService.class);
        org.junit.jupiter.api.Assertions.assertThrows(
                NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxxx", MemberService.class)
        );
    }
}
