package kr.ksw3230.fboard.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.ksw3230.fboard.model.dto.FboardDTO;

@Repository
public class FboardDAOImpl implements FboardDAO {

	@Inject
	SqlSession sqlSession;

	@Override
	public void insert(FboardDTO dto) {
		sqlSession.insert("fboard.insert", dto);
	}

	@Override
	public void addAttach(String fullName) {
		sqlSession.insert("fboard.addAttach", fullName);
	}

	@Override
	public int selectCount() {
		return sqlSession.selectOne("fboard.selectCount");
	}

	@Override
	public List<FboardDTO> selectList(HashMap<String, Integer> hmap) {
		return sqlSession.selectList("fboard.selectList", hmap);
	}

	@Override
	public void increment(int idx) {
		sqlSession.update("fboard.increment", idx);
	}

	@Override
	public FboardDTO selectByIdx(int idx) {
		return sqlSession.selectOne("fboard.selectByIdx", idx);
	}

	@Override
	public List<String> getAttach(int idx) {
		return sqlSession.selectList("fboard.getAttach", idx);
	}

	@Override
	public void update(FboardDTO dto) {
		sqlSession.update("fboard.update", dto);
	}

	@Override
	public void updateAttach(String fullName, int idx) {
		Map<String, Object> map = new HashMap<>();
		map.put("fullName", fullName);
		map.put("idx", idx);
		sqlSession.insert("fboard.updateAttach", map);
	}

	@Override
	public void deleteFile(String fullName) {
		sqlSession.delete("fboard.deleteFile", fullName);
	}

	@Override
	public void delete(int idx) {
		sqlSession.update("fboard.delete", idx);
	}
	
}
