package kr.ksw3230.multiBoard.model.imageBoard.dto;

import java.util.Date;

public class ImageCommentDTO {
	
	private int idx;
	private int ref;
	private String userid;
	private String content;
	private Date writeDate;
	
	public ImageCommentDTO() {}

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

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	@Override
	public String toString() {
		return "ImageCommentDTO [idx=" + idx + ", ref=" + ref + ", userid=" + userid + ", content=" + content
				+ ", writeDate=" + writeDate + "]";
	}
	
	

}
