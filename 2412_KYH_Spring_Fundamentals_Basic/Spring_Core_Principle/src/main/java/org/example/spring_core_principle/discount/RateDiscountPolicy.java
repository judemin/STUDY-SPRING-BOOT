package org.example.spring_core_principle.discount;

import org.example.spring_core_principle.member.Grade;
import org.example.spring_core_principle.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    // Ctrl + Shift + T로 새로운 테스트 바로 생성 가능
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
