package kr.ksw3230.multiBoard.model.board.dto;

import java.util.Date;

public class BoardDTO {
	
	private int idx;			// 입력되는 순서대로 부여되는 일련번호
	private int ref;			// 게시글의 글번호
	private int lev;			// 답변의 레벨
	private int seq;			// 답변글의 일련번호
	private String userid;		// 작성자
	private String title;		// 글 제목
	private String content;		// 글 내용
	private Date writeDate;		// 작성일
	private int hit;			// 조회수
	private String ip;			// 작성자 IP
	private String notice= "";	// 공지글
	
	public BoardDTO() {	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public int getLev() {
		return lev;
	}

	public void setLev(int lev) {
		this.lev = lev;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	@Override
	public String toString() {
		return "BoardDTO [idx=" + idx + ", ref=" + ref + ", lev=" + lev + ", seq=" + seq + ", userid=" + userid
				+ ", title=" + title + ", content=" + content + ", writeDate=" + writeDate + ", hit=" + hit + ", ip="
				+ ip + ", notice=" + notice + "]";
	}
	
	

}
