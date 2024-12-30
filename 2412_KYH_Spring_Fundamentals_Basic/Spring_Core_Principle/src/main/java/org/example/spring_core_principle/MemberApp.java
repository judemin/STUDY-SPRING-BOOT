package org.example.spring_core_principle;

import org.example.spring_core_principle.member.Grade;
import org.example.spring_core_principle.member.Member;
import org.example.spring_core_principle.member.MemberService;
import org.example.spring_core_principle.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memeberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memeberService.join(member);

        Member findMember = memeberService.findMemeber(1L);
        System.out.println("[new Memeber]: " + member.getName());
        System.out.println("[find Memeber]: " + findMember.getName());
    }
}
