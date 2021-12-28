package springBoard.Board.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import springBoard.Board.DTO.MemberDTO;
import springBoard.Board.DTO.ReplyDTO;

import java.util.List;

public interface ReplyRepository extends JpaRepository<ReplyDTO, Long> {
    List<ReplyDTO> findByBoardId(Long bid);
}
