package kr.ksw3230.multiBoard.service.board;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.ksw3230.multiBoard.model.board.dao.BoardDAO;
import kr.ksw3230.multiBoard.model.board.dto.BoardDTO;
import kr.ksw3230.multiBoard.model.board.dto.BoardParam;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	BoardDAO boardDao;

	@Override
	public void insert(BoardDTO dto) {
		boardDao.insert(dto);
	}

	@Override
	public int selectCount() {
		return boardDao.selectCount();
	}

	@Override
	public List<BoardDTO> selectList(HashMap<String, Integer> hmap) {
		return boardDao.selectList(hmap);
	}

	@Override
	public void increment(int idx) {
		boardDao.increment(idx);
	}

	@Override
	public BoardDTO selectByIdx(int idx) {
		return boardDao.selectByIdx(idx);
	}

	@Override
	public void delete(int idx) {
		boardDao.delete(idx);
	}

	@Override
	public void update(BoardDTO dto) {
		boardDao.update(dto);
	}

	@Override
	public void incrementSeq(HashMap<String, Integer> hmap) {
		boardDao.incrementSeq(hmap);
	}

	@Override
	public void reply(BoardDTO dto) {
		boardDao.reply(dto);
	}

	@Override
	public List<BoardDTO> selectNotice() {
		return boardDao.selectNotice();
	}

	@Override
	public int selectCountMulti(HashMap<String, String> hmap) {
		return boardDao.selectCountMulti(hmap);
	}

	@Override
	public List<BoardDTO> selectListMulti(BoardParam param) {
		return boardDao.selectListMulti(param);
	}

	@Override
	public BoardDTO selectLastNotice() {
		return boardDao.selectLastNotice();
	}
	
}
