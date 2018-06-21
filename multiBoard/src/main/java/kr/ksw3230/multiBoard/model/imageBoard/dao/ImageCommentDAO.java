package kr.ksw3230.multiBoard.model.imageBoard.dao;

import java.util.List;

import kr.ksw3230.multiBoard.model.imageBoard.dto.ImageCommentDTO;

public interface ImageCommentDAO {
	
	public void insert(ImageCommentDTO dto);
	public List<ImageCommentDTO> selectList(int idx);
	public void delete(int idx);
	public int replyCount(int idx);

}
