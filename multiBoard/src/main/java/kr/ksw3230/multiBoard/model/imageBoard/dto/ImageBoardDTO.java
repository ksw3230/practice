package kr.ksw3230.multiBoard.model.imageBoard.dto;

import org.springframework.web.multipart.MultipartFile;

public class ImageBoardDTO {

	private int idx;
	private String userid;
	private String title;
	private String content;
	private String pictureUrl;
	private MultipartFile file;
	
	private int replyCount;

	public ImageBoardDTO() {}

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

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public int getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}

	@Override
	public String toString() {
		return "ImageBoardDTO [idx=" + idx + ", userid=" + userid + ", title=" + title + ", content=" + content
				+ ", pictureUrl=" + pictureUrl + ", file=" + file + ", replyCount=" + replyCount + "]";
	}

	
	
}
