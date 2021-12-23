package springBoard.Board.controller.boardyong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import springBoard.Board.DTO.BoardDTO;
import springBoard.Board.DTO.MemberDTO;
import springBoard.Board.Repository.BoardRepository;
import springBoard.Board.Repository.MemberRepository;

import javax.servlet.http.HttpSession;

@Controller
public class BoardController {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BoardRepository boardRepository;

    @GetMapping("/board")
    public String boardList(Model model){
        model.addAttribute("boardDTO", boardRepository.findAll());
        return"boardList";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id, Model model, HttpSession session){
        MemberDTO member1 = (MemberDTO)session.getAttribute("member");
        model.addAttribute("boardDTO", boardRepository.findById(id).get());

        return"view";
    }

    @GetMapping("/writing")
    public String writing(HttpSession session, Model model) {
        MemberDTO member1 = (MemberDTO)session.getAttribute("member");
        model.addAttribute("memberDTO", member1);
        return"write";
    }

    @GetMapping("/writeboard")
    public String writeboard(BoardDTO boardDTO) {
        boardRepository.save(boardDTO);
        return"redirect:/boardList";
    }
}
