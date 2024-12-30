package org.example.spring_core_principle.member;

public interface MemberRepository {
    void save(Member member);

    Member findById(Long memberId);
}