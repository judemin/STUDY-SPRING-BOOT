package org.example.spring_core_principle.member;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRespository();

    @Override
    public void join(Member member) {
        // 다형성에 의해서 오버라이딩된 메소드가 호출된다
        memberRepository.save(member);
    }

    @Override
    public Member findMemeber(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
