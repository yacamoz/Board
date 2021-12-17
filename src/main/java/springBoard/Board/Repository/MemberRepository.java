package springBoard.Board.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springBoard.Board.DTO.MemberDTO;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberDTO, Long> {
    MemberDTO findByMemberId(String memberId);
}
