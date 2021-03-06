package springBoard.Board.Repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import springBoard.Board.DTO.BoardDTO;
import springBoard.Board.DTO.MemberDTO;

import java.util.List;

public interface BoardRepository extends JpaRepository<BoardDTO, Long> {

}
