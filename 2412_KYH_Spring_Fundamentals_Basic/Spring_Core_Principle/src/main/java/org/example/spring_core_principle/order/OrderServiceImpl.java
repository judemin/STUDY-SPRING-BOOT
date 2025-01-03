package org.example.spring_core_principle.order;

import org.example.spring_core_principle.discount.DiscountPolicy;
import org.example.spring_core_principle.discount.FixDiscountPolicy;
import org.example.spring_core_principle.discount.RateDiscountPolicy;
import org.example.spring_core_principle.member.Member;
import org.example.spring_core_principle.member.MemberRepository;
import org.example.spring_core_principle.member.MemoryMemberRespository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    // MemoryMemeberRepository와 FixDiscountPolicy를 구현체로 구현하여 활용 중
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // 회원정보 조회
        Member member = memberRepository.findById(memberId);
        // 할인 정보 조회
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
