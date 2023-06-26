package hello.core.member;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join(){
        //given
        Member member = new Member(1L,"hyunsoo",Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findByMember(1L);

        //then
        Assertions.assertEquals(member,findMember);

    }
}
