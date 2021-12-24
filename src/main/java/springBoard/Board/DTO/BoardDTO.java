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
    private Long bid;

    @Column(nullable=false)
    private String boardTitle;

    @Column(nullable=false)
    private String memberId;

    @Column(nullable=false)
    private String boardContent;

    @Column(nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date boardDate;


    public Long getBid() {
        return bid;
    }

    public void setBid(Long bid) {
        this.bid = bid;
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

    public Date getBoardDate() {
        return boardDate;
    }

    public void setBoardDate(Date boardDate) {
        this.boardDate = boardDate;
    }

    public void update(BoardDTO updateBoard){
        this.bid=updateBoard.bid;
        this.memberId= updateBoard.memberId;
        this.boardDate=updateBoard.boardDate;
        this.boardTitle=updateBoard.boardTitle;
        this.boardContent=updateBoard.boardContent;
    }

    @Override
    public String toString() {
        return "BoardDTO{" +
                "bid=" + bid +
                ", boardTitle='" + boardTitle + '\'' +
                ", memberId='" + memberId + '\'' +
                ", boardContent='" + boardContent + '\'' +
                ", boardDate=" + boardDate +
                '}';
    }
}
