package springBoard.Board.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import springBoard.Board.DTO.MemberDTO;
import springBoard.Board.Repository.MemberRepository;

import javax.servlet.http.HttpSession;


@Controller
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/form")
    public String MemberForm(){
        return "memberForm";
    }
    @PostMapping("/createMember")
    public String CreateMember(MemberDTO memberDTO){
        memberRepository.save(memberDTO);
        return "redirect:/memberlist";
    }
    @GetMapping("/memberlist")
    public String memberList(Model model) {
        model.addAttribute("memberDTO", memberRepository.findAll());
        return "memberlist";
    }
    @GetMapping("updateForm/{id}")
    public String updateForm(@PathVariable Long id, Model model, HttpSession session){
        MemberDTO member1 = (MemberDTO)session.getAttribute("member");
        if(!member1.matchId(id)){
            return "redirect:/";
        }
        model.addAttribute("memberDTO", memberRepository.findById(id).get());
        return "updateForm";
    }

    @PostMapping("/updatemember/{id}")
    public String updateMember(@PathVariable Long id, MemberDTO updatemember, HttpSession session) {
        MemberDTO member1 = (MemberDTO)session.getAttribute("member");
        if(!member1.matchId(id)){
            return "redirect:/";
        }
        MemberDTO memberdto = memberRepository.getById(id);
        memberdto.update(updatemember);
        memberRepository.save(memberdto);
        return "redirect:/memberlist";
    }

    @GetMapping("/loginform")
    public String loginMenu() {return "/loginform";}

    @PostMapping("/login")
    public String login(String memberId, String memberPassword, HttpSession session) {
        MemberDTO member = memberRepository.findByMemberId(memberId);
        if(member == null) {
            return "redirect:/loginform";
        }
        if (!member.matchPassword(memberPassword))
        {
            return "redirect:/loginform";
        }
        session.setAttribute("member", member);
        return"redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("member");
        return "redirect:/";
    }
}
