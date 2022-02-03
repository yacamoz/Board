package springBoard.Board.controller.boardyong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import springBoard.Board.DTO.BoardDTO;
import springBoard.Board.DTO.MemberDTO;
import springBoard.Board.DTO.ReplyDTO;
import springBoard.Board.Repository.BoardRepository;
import springBoard.Board.Repository.MemberRepository;
import springBoard.Board.Repository.ReplyRepository;

import javax.servlet.http.HttpSession;

@Controller
public class BoardController {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private ReplyRepository replyRepository;

    @GetMapping("/board")
    public String boardList(Model model){
        model.addAttribute("boardDTO", boardRepository.findAll());
        return"boardList";
    }

    @GetMapping("/view/{bid}")
    public String view(@PathVariable Long bid, Model model, HttpSession session){
        model.addAttribute("boardDTO", boardRepository.findById(bid).get());
        BoardDTO thisBoard = boardRepository.findById(bid).get();
        MemberDTO member = (MemberDTO)session.getAttribute("member");
        model.addAttribute("replyDTO", replyRepository.findByBoardId(bid));

        if(member.matchMemberId(thisBoard.getMemberId())){
            session.setAttribute("writer", member);
        } else {
            session.removeAttribute("writer");
        }
        return"view";
    }

    @PostMapping("/deleteBoard/{bid}")
    public String deleteBoard(@PathVariable Long bid, HttpSession session){
        BoardDTO thisBoard = boardRepository.findById(bid).get();
        MemberDTO writer = (MemberDTO)session.getAttribute("writer");
        if(!writer.matchMemberId(thisBoard.getMemberId())){
            return "redirect:/";
        }
        boardRepository.deleteById(bid);
        return"redirect:/board";
    }

    @GetMapping("/writing")
    public String writing(HttpSession session, Model model) {
        MemberDTO member1 = (MemberDTO)session.getAttribute("member");
        model.addAttribute("memberDTO", member1);
        return"write";
    }

    @PostMapping("/writeBoard")
    public String writeBoard(BoardDTO boardDTO) {
        boardRepository.save(boardDTO);
        return"redirect:/board";
    }

    @PostMapping("/updateBoard/{bid}")
    public String updateBoardForm(@PathVariable Long bid, Model model, HttpSession session){
        model.addAttribute("boardDTO", boardRepository.findById(bid).get());
        MemberDTO writer = (MemberDTO)session.getAttribute("writer");
        BoardDTO thisBoard = boardRepository.findById(bid).get();
        if(!writer.matchMemberId(thisBoard.getMemberId())){
            return "redirect:/";
        }
        model.addAttribute("boardDTO", boardRepository.findById(bid).get());
        return"updateBoard";
    }

    @PostMapping("/updatingBoard/{bid}")
    public String updateBoard(@PathVariable Long bid, Model model, HttpSession session, BoardDTO updateBoard){
        model.addAttribute("boardDTO", boardRepository.findById(bid).get());
        MemberDTO writer = (MemberDTO)session.getAttribute("writer");
        BoardDTO thisBoard = boardRepository.findById(bid).get();
        if(!writer.matchMemberId(thisBoard.getMemberId())){
            return "redirect:/";
        }
        thisBoard.update(updateBoard);
        boardRepository.save(thisBoard);
        return"redirect:/board";
    }

    @PostMapping("/api/createReply/{bid}")
    public String createReply(@PathVariable Long bid, ReplyDTO replyDTO){
        replyRepository.save(replyDTO);
        return String.format("redirect:/view/%d", bid);
    }

    @PostMapping("/deleteReply/{rid}")
    public String deleteReply(@PathVariable Long rid, HttpSession session){
        MemberDTO member1 = (MemberDTO)session.getAttribute("member");
        ReplyDTO thisReply = replyRepository.findById(rid).get();
        Long bid = thisReply.getBoardId();
        if(!member1.matchMemberId(thisReply.getMemberId())){
            return "redirect:/";
        }
        replyRepository.deleteById(rid);
        return String.format("redirect:/view/%d", bid);
    }
}
