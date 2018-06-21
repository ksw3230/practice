package kr.ksw3230.multiBoard.model.imageBoard.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.ksw3230.multiBoard.model.imageBoard.dto.ImageCommentDTO;

@Repository
public class ImageCommentDAOImpl implements ImageCommentDAO {

	@Inject
	SqlSession sqlSession;

	@Override
	public void insert(ImageCommentDTO dto) {
		sqlSession.insert("imageComment.insert",dto);
	}

	@Override
	public List<ImageCommentDTO> selectList(int idx) {
		return sqlSession.selectList("imageComment.selectList",idx);
	}

	@Override
	public void delete(int idx) {
		sqlSession.delete("imageComment.delete", idx);
	}

	@Override
	public int replyCount(int idx) {
		return sqlSession.selectOne("imageComment.replyCount",idx);
	}
	
	
}
