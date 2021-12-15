package springBoard.Board.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import springBoard.Board.DTO.MemberDTO;


@Controller
public class MemberController {
    @GetMapping("/form")
    public String MemberForm(){
        return "memberForm";
    }
    @PostMapping("/createMember")
    public String CreateMember(MemberDTO memberDTO){
        System.out.println(memberDTO);
        return "home";
    }
}
