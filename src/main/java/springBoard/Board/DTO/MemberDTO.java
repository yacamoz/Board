package springBoard.Board.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MemberDTO {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable=false)
    private String memberId;
    private String memberPassword;
    private String memberName;
    private String memberEmail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberPassword() {
        return memberPassword;
    }

    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public void update(MemberDTO updateMember){
        this.memberId = updateMember.memberId;
        this.memberPassword = updateMember.memberPassword;
        this.memberName = updateMember.memberName;
        this.memberEmail = updateMember.memberEmail;
    }

    public boolean matchId(Long newId){
        if (newId == null){
            return false;
        }
        return newId.equals(id);
    }

    public boolean matchMemberId(String newId){
        if (newId == null){
            return false;
        }
        return newId.equals(memberId);
    }

    public boolean matchPassword(String newPassword){
        if (newPassword == null){
            return false;
        }
        return newPassword.equals(memberPassword);
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "id=" + id +
                ", memberId='" + memberId + '\'' +
                ", memberPassword='" + memberPassword + '\'' +
                ", memberName='" + memberName + '\'' +
                ", memberEmail='" + memberEmail + '\'' +
                '}';
    }
}
