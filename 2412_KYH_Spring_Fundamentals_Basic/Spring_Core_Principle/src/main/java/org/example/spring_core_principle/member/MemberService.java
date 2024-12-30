package org.example.spring_core_principle.member;

public interface MemberService {
    void join(Member member);

    Member findMemeber(Long memberId);
}
