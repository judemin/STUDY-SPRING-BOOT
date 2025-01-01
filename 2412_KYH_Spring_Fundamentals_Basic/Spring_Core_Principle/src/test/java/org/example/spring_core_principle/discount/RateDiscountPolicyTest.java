package org.example.spring_core_principle.discount;

import org.assertj.core.api.Assertions;
import org.example.spring_core_principle.member.Grade;
import org.example.spring_core_principle.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    // 아래는 Positive Unit Test
    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다")
    void vip_o(){
        // GIVEN
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        // WHEN
        int discount = discountPolicy.discount(member, 10000);

        // THEN
        // on-demand static import로 Assertions를 import한다
        assertThat(discount).isEqualTo(1000);
    }

    // 아래는 Negative Unit Test
    // Negative Unit Testting을 하는 것이 더 중요하다
    @Test
    @DisplayName("VIP가 아닌 경우 할인이 적용되지 않아야 한다")
    void vip_x(){
        // GIVEN
        Member member = new Member(2L, "memberBASIC", Grade.BASIC);

        // WHEN
        int discount = discountPolicy.discount(member, 10000);

        // THEN
        assertThat(discount).isEqualTo(0);
    }

}