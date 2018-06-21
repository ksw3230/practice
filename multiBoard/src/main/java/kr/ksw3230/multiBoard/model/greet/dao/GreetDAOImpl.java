package kr.ksw3230.multiBoard.model.greet.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.ksw3230.multiBoard.model.greet.dto.GreetDTO;
import kr.ksw3230.multiBoard.model.greet.dto.GreetParam;

@Repository
public class GreetDAOImpl implements GreetDAO {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public void insert(HashMap<String, String> map) {
		sqlSession.insert("greet.insert", map);
	}

	@Override
	public List<GreetDTO> selectList() {
		return sqlSession.selectList("greet.selectList");
	}

	@Override
	public void delete(int idx) {
		sqlSession.delete("greet.delete", idx);
	}

	@Override
	public int selectLevel(String userid) {
		return sqlSession.selectOne("greet.selectLevel", userid);
	}

	@Override
	public void levelUp(GreetParam param) {
		sqlSession.update("greet.levelUp", param);
	}

}
