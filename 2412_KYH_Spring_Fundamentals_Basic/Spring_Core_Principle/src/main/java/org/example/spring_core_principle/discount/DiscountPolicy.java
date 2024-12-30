package org.example.spring_core_principle.discount;

import org.example.spring_core_principle.member.Member;

public interface DiscountPolicy {
    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
}
