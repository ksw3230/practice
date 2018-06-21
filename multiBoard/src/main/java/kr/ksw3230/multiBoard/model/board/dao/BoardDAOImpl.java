package kr.ksw3230.multiBoard.model.board.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.ksw3230.multiBoard.model.board.dto.BoardDTO;
import kr.ksw3230.multiBoard.model.board.dto.BoardParam;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	SqlSession sqlSession;

	@Override
	public void insert(BoardDTO dto) {
		sqlSession.insert("board.insert", dto);
	}

	@Override
	public int selectCount() {
		return sqlSession.selectOne("board.selectCount");
	}

	@Override
	public List<BoardDTO> selectList(HashMap<String, Integer> hmap) {
		return sqlSession.selectList("board.selectList", hmap);
	}

	@Override
	public void increment(int idx) {
		sqlSession.update("board.increment",idx);
	}

	@Override
	public BoardDTO selectByIdx(int idx) {
		return sqlSession.selectOne("board.selectByIdx", idx);
	}

	@Override
	public void delete(int idx) {
		sqlSession.delete("board.delete", idx);
	}

	@Override
	public void update(BoardDTO dto) {
		sqlSession.update("board.update", dto);
	}

	@Override
	public void incrementSeq(HashMap<String, Integer> hmap) {
		sqlSession.update("board.incrementSeq", hmap);
	}

	@Override
	public void reply(BoardDTO dto) {
		sqlSession.insert("board.reply", dto);
	}

	@Override
	public List<BoardDTO> selectNotice() {
		return sqlSession.selectList("board.selectNotice");
	}

	@Override
	public int selectCountMulti(HashMap<String, String> hmap) {
		return sqlSession.selectOne("board.selectCountMulti", hmap);
	}

	@Override
	public List<BoardDTO> selectListMulti(BoardParam param) {
		return sqlSession.selectList("board.selectListMulti", param);
	}

	@Override
	public BoardDTO selectLastNotice() {
		sqlSession.selectOne("board.selectLastNotice");
		return sqlSession.selectOne("board.selectLastNotice");
	}
}
