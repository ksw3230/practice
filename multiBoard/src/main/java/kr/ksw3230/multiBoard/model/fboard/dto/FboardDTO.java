package kr.ksw3230.multiBoard.model.fboard.dto;

import java.util.Arrays;
import java.util.Date;

public class FboardDTO {
	
	private int idx;
	private String userid;
	private String title;
	private String content;
	private Date regdate;
	private int hit;
	private String show;
	private String[] files;
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
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getShow() {
		return show;
	}
	public void setShow(String show) {
		this.show = show;
	}
	public String[] getFiles() {
		return files;
	}
	public void setFiles(String[] files) {
		this.files = files;
	}
	@Override
	public String toString() {
		return "FboardDTO [idx=" + idx + ", userid=" + userid + ", title=" + title + ", content=" + content
				+ ", regdate=" + regdate + ", hit=" + hit + ", show=" + show + ", files=" + Arrays.toString(files)
				+ "]";
	}
	
	
	
}
