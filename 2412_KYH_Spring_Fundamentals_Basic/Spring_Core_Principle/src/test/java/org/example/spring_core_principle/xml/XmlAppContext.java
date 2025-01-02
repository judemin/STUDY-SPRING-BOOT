package org.example.spring_core_principle.xml;

import org.assertj.core.api.Assertions;
import org.example.spring_core_principle.member.MemberService;
import org.example.spring_core_principle.member.MemberServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlAppContext {
    @Test
    void xmlAppContext(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("appConfig.xml");
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
