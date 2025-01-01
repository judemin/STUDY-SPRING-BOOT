package org.example.spring_core_principle;

import org.example.spring_core_principle.member.Grade;
import org.example.spring_core_principle.member.Member;
import org.example.spring_core_principle.member.MemberService;
import org.example.spring_core_principle.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        //MemberService memberService = new MemberServiceImpl();

        // 기존 방식과는 다르게 AppConfig에서 MemberService 구현체를 return
        // AppConfig appConfig = new AppConfig();
        // MemberService memberService = appConfig.memberService();

        // Spring의 시작은 ApplicationContext
        // Spring의 모든 것을 관리해준다
        // AnnotationConfigApplicationContext, Annotation 기반의 Config내의 Spring Bean을 등록하여 관리
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // 기본적으로 Bean은 메소드 명으로 등록됨
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMemeber(1L);
        System.out.println("[new Memeber]: " + member.getName());
        System.out.println("[find Memeber]: " + findMember.getName());
    }
}
