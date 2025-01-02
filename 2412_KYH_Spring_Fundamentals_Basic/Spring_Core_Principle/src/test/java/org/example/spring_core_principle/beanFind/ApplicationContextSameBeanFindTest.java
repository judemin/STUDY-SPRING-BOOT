package org.example.spring_core_principle.beanFind;

import org.example.spring_core_principle.AppConfig;
import org.example.spring_core_principle.discount.DiscountPolicy;
import org.example.spring_core_principle.member.MemberRepository;
import org.example.spring_core_principle.member.MemoryMemberRespository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextSameBeanFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    // 같은 타임의 Bean상황을 만들기 위해 Test내에 새로운 Class 정의
    @Configuration
    static class SameBeanConfig{
        @Bean
        public MemberRepository memberRespository1(){
            return new MemoryMemberRespository();
        }

        @Bean
        public MemberRepository memberRespository2(){
            return new MemoryMemberRespository();
        }
    }

    @Test
    @DisplayName("같은 타입이 둘 이상이 있으면, 중복 오류가 발생")
    void findBeanByTypeDuplicate(){
        // 아래와 같은 상황에서 타입으로만 호출하면
        // NoUniqueBeanDefinitionException으로 Spring이 어떤 것을 선택할지 모름
        // MemberRepository bean = ac.getBean(MemberRepository.class);

        // Negative Test
        assertThrows(
                NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(MemberRepository.class)
        );
    }

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면 빈 이름을 지정하면 된다")
    void findBeanByName(){
        // Positive Test
        MemberRepository memberRespository1 = ac.getBean("memberRespository1", MemberRepository.class);
        assertThat(memberRespository1).isInstanceOf(MemoryMemberRespository.class);
    }

    @Test
    @DisplayName("특정 타입을 모두 조회하기")
    void findAllBeanByType(){
        // Autowired를 적용할 때도 아래와 같이
        // 특정 타입에 대한 Bean을 조회하는 기능이 사용된다
        Map<String, MemberRepository> beanofType = ac.getBeansOfType(MemberRepository.class);
        for (String key : beanofType.keySet()){
            System.out.println(key + " " + beanofType.get(key));
        }
        System.out.println("[BeansOfType]: " + beanofType);
        assertThat(beanofType).hasSize(2);
    }
}
