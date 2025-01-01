package org.example.spring_core_principle;

import org.example.spring_core_principle.member.Grade;
import org.example.spring_core_principle.member.Member;
import org.example.spring_core_principle.member.MemberService;
import org.example.spring_core_principle.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        //MemberService memberService = new MemberServiceImpl();

        // 기존 방식과는 다르게 AppConfig에서 MemberService 구현체를 return
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMemeber(1L);
        System.out.println("[new Memeber]: " + member.getName());
        System.out.println("[find Memeber]: " + findMember.getName());
    }
}
