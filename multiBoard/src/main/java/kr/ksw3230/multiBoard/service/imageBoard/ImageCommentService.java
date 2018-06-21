package kr.ksw3230.multiBoard.service.imageBoard;

import java.util.List;

import kr.ksw3230.multiBoard.model.imageBoard.dto.ImageCommentDTO;

public interface ImageCommentService {

	public void insert(ImageCommentDTO dto);
	public List<ImageCommentDTO> selectList(int idx);
	public void delete(int idx);
	public int reqlyCount(int idx);

}
