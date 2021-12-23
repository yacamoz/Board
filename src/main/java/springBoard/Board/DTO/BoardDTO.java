package springBoard.Board.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class BoardDTO {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable=false)
    private String boardTitle;
    @Column(nullable=false)
    private String memberId;
    @Column(nullable=false)
    private String boardContent;
    @Column(nullable=false)
    private String boardDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBoardTitle() {
        return boardTitle;
    }

    public void setBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getBoardContent() {
        return boardContent;
    }

    public void setBoardContent(String boardContent) {
        this.boardContent = boardContent;
    }

    public String getBoardDate() {
        return boardDate;
    }

    public void setBoardDate(String boardDate) {
        this.boardDate = boardDate;
    }
}
