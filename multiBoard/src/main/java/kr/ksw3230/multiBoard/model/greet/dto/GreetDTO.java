package kr.ksw3230.multiBoard.model.greet.dto;

import java.util.Date;

public class GreetDTO {

	private int idx;
	private String userid;
	private String content;
	private Date reg_date;
	
	public GreetDTO() {}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	@Override
	public String toString() {
		return "ChulsukDTO [idx=" + idx + ", userid=" + userid + ", content=" + content + ", reg_date=" + reg_date
				+ "]";
	}
	
	
	
}
