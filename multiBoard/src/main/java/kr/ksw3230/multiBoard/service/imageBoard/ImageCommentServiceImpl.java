package kr.ksw3230.multiBoard.service.imageBoard;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.ksw3230.multiBoard.model.imageBoard.dao.ImageCommentDAO;
import kr.ksw3230.multiBoard.model.imageBoard.dto.ImageCommentDTO;

@Service
public class ImageCommentServiceImpl implements ImageCommentService {

	@Inject
	ImageCommentDAO imageCommentDAO;

	@Override
	public void insert(ImageCommentDTO dto) {
		imageCommentDAO.insert(dto);
	}

	@Override
	public List<ImageCommentDTO> selectList(int idx) {
		return imageCommentDAO.selectList(idx);
	}

	@Override
	public void delete(int idx) {
		imageCommentDAO.delete(idx);
	}

	@Override
	public int reqlyCount(int idx) {
		return imageCommentDAO.replyCount(idx);
	}
}
