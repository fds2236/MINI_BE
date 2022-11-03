package mini.vo;
import java.sql.Date;

public class MemberVO {
	// 회원
	private String id; // 회원 아이디
	private String pwd; // 회원 패스워드
	private String pwdCheck; // 패스워드 확인
	private String memName; // 회원 이름
	private String email; // 회원 이메일
//	private String emailName; // @메일명
	private String phone; // 회원 전화번호 010
//	private String phone2; // 회원 전화번호 중간 번호
//	private String phone3; // 회원 전화번호 마지막 번호
//	private String phoneNum; // 인증번호 6자리
//	private String addrNum; // 우편번호
	private String addr; // 주소
//	private String addr; // 상세 주소
	private Date regDate; // 회원 가입일, 변환해줘야 함
	
	
	// 보드
	private Integer boardNum; // 글 번호, 변환해줘야 함
	private Integer category; // 글 카테고리, 변환해줘야 함
	private String title; // 글 제목
	private String boardContent; // 글 내용
	private Date boardDate; // 글 작성일, 변환해줘야 함
	
	// 댓글
	private Integer replyNum; // 댓글 번호, 변환해줘야 함
	private String replyContent; // 댓글 내용
	private Date replyDate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPwdCheck() {
		return pwdCheck;
	}
	public void setPwdCheck(String pwdCheck) {
		this.pwdCheck = pwdCheck;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
//	public String getEmailName() {
//		return emailName;
//	}
//	public void setEmailName(String emailName) {
//		this.emailName = emailName;
//	}
//	public String getPhone1() {
//		return phone1;
//	}
//	public void setPhone1(String phone1) {
//		this.phone1 = phone1;
//	}
//	public String getPhone2() {
//		return phone2;
//	}
//	public void setPhone2(String phone2) {
//		this.phone2 = phone2;
//	}
//	public String getPhone3() {
//		return phone3;
//	}
//	public void setPhone3(String phone3) {
//		this.phone3 = phone3;
//	}
//	public String getPhoneNum() {
//		return phoneNum;
//	}
//	public void setPhoneNum(String phoneNum) {
//		this.phoneNum = phoneNum;
//	}
//	public String getAddrNum() {
//		return addrNum;
//	}
//	public void setAddrNum(String addrNum) {
//		this.addrNum = addrNum;
//	}
//	public String getAddr1() {
//		return addr1;
//	}
//	public void setAddr1(String addr1) {
//		this.addr1 = addr1;
//	}
//	public String getAddr2() {
//		return addr2;
//	}
//	public void setAddr2(String addr2) {
//		this.addr2 = addr2;
//	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Integer getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(Integer boardNum) {
		this.boardNum = boardNum;
	}
	public Integer getCategory() {
		return category;
	}
	public void setCategory(Integer category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public Integer getReplyNum() {
		return replyNum;
	}
	public void setReplyNum(Integer replyNum) {
		this.replyNum = replyNum;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public Date getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	} // 댓글 작성일, 변환해줘야 함
	
}
	
	
	