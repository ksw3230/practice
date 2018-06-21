package kr.ksw3230.multiBoard.model.imageBoard.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.ksw3230.multiBoard.model.imageBoard.dto.ImageBoardDTO;

@Repository
public class ImageBoardDAOImpl implements ImageBoardDAO {

	@Inject
	SqlSession sqlSession;

	@Override
	public void insert(ImageBoardDTO dto) {
		sqlSession.insert("imageBoard.insert",dto);
	}

	@Override
	public int selectList() {
		return sqlSession.selectOne("imageBoard.selectList");
	}

	@Override
	public List<ImageBoardDTO> getList(HashMap<String, Integer> hmap) {
		return sqlSession.selectList("imageBoard.getList", hmap);
	}

	@Override
	public ImageBoardDTO selectOne(int idx) {
		return sqlSession.selectOne("imageBoard.selectOne", idx);
	}

	@Override
	public void update(ImageBoardDTO dto) {
		sqlSession.update("imageBoard.updateOK", dto);
	}

	@Override
	public void delete(int idx) {
		sqlSession.delete("imageBoard.deleteOK", idx);
	}

	@Override
	public int getLevel(String userid) {
		return sqlSession.selectOne("imageBoard.getLevel", userid);
	}

	@Override
	public List<ImageBoardDTO> select4List() {
		return sqlSession.selectList("imageBoard.select4List");
	}
	
}
