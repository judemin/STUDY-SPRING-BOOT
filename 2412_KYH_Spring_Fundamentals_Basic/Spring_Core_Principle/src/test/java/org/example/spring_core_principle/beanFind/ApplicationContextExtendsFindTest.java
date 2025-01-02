package org.example.spring_core_principle.beanFind;

import org.example.spring_core_principle.discount.DiscountPolicy;
import org.example.spring_core_principle.discount.FixDiscountPolicy;
import org.example.spring_core_principle.discount.RateDiscountPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextExtendsFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("부모 타입으로 조회시, 자식이 둘 이상 있으면 중복 오류 발생")
    void findBeanByParentTypeDuplicate(){
        // DiscountPolicy bean = ac.getBean(DiscountPolicy.class);
        assertThrows(
                NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(DiscountPolicy.class)
        );
    }

    @Test
    @DisplayName("부모 타입으로 조회시, 자식이 둘 이상 있으면 Bean 이름 지정")
    void findBeanByParentTypeBeanName(){
        DiscountPolicy rateDiscountPolicty = ac.getBean("rateDiscountPolicy", DiscountPolicy.class);
        assertThat(rateDiscountPolicty).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    @DisplayName("특정 하위 타입으로 조회")
    void findBeanBySubType(){
        RateDiscountPolicy bean = ac.getBean(RateDiscountPolicy.class);
        assertThat(bean).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    @DisplayName("부모 타입으로 모두 조회하기")
    void findAllBeanByParentType(){
        Map<String, DiscountPolicy> beans = ac.getBeansOfType(DiscountPolicy.class);
        assertThat(beans).hasSize(2);
        // 실제 개발 환경에서는 log보다 테스트 성공 여부만 보게된다
        for (String key : beans.keySet()) {
            System.out.println(key + " : " + beans.get(key));
        }
    }

    @Test
    @DisplayName("부모 타입으로 모두 조회하기 - Object")
    void findAllBeanByObjectType(){
        // Java의 모든 Class의 부모는 Object이기 때문에
        // 아래와 같이 Object 타입으로 조회하면 모두 출력할 수 있다
        Map<String, Object> beans = ac.getBeansOfType(Object.class);
        for (String key : beans.keySet()) {
            System.out.println(key + " : " + beans.get(key));
        }
    }

    // 새로운 Spring Configuration Class 정의
    @Configuration
    static class TestConfig{
        // DiscountPolicy형인 이유는 한눈에 파악할 수 있게 하기 위해서이다
        @Bean
        public DiscountPolicy rateDiscountPolicy(){
            return new RateDiscountPolicy();
        }

        @Bean
        public DiscountPolicy discountPolicy(){
            return new FixDiscountPolicy();
        }
    }
}
