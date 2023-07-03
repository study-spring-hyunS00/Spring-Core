package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationContextBasicInfo {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findByName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        Assertions.assertInstanceOf( MemberServiceImpl.class,memberService);
    }

    @Test
    @DisplayName("빈 이름없이 타입으로 조회")
    void findByType(){
        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertInstanceOf( MemberServiceImpl.class,memberService);
    }

    @Test
    @DisplayName("빈 구체 타입으로 조회")
    void findByImplName(){
        MemberService memberService = ac.getBean("memberService",MemberService.class);
        Assertions.assertInstanceOf( MemberServiceImpl.class,memberService);
    }

    @Test
    @DisplayName("빈 이름으로 조회X")
    void findByNameX(){
//       ac.getBean("xxxxx",MemberService.class);
        Assertions.assertThrows(NoSuchBeanDefinitionException.class,()->{
            ac.getBean("xxxxx",MemberService.class);
        });
    }
}
