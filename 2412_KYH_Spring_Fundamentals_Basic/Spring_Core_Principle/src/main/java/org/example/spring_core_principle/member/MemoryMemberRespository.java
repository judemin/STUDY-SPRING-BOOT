package org.example.spring_core_principle.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRespository implements MemberRepository {

    // 실무에서는 동시성 이슈가 있기 때문에 ConcurrentHashMap을 써야 한다
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
