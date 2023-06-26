package hello.core.order;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder(){

        //given
        Long memberId = 1L;
        Member member = new Member(memberId, "hyunS00", Grade.VIP);

        //when
        memberService.join(member);
        Order order = orderService.createOrder(memberId,"itemA",1000);

        //then
        Assertions.assertEquals(order.getDiscountPrice(),1000);
    }
}
