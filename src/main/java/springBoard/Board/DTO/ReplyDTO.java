package springBoard.Board.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
public class ReplyDTO {
    @Id
    @GeneratedValue
    private Long rid;

    @Column(nullable=false)
    private String memberId;

    @Column(nullable=false)
    private Long boardId;

    @Column(nullable=false)
    private String replyContent;

    @Column(nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp replyDate;

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Long getBoardId() {
        return boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    public Timestamp getReplyDate() {
        return replyDate;
    }

    public void setReplyDate(Timestamp replyDate) {
        this.replyDate = replyDate;
    }

    @Override
    public String toString() {
        return "ReplyDTO{" +
                "rid=" + rid +
                ", memberId='" + memberId + '\'' +
                ", boardId=" + boardId +
                ", replyContent='" + replyContent + '\'' +
                ", replyDate=" + replyDate +
                '}';
    }
}
