package kr.ksw3230.multiBoard.model.board.dao;

import java.util.HashMap;
import java.util.List;

import kr.ksw3230.multiBoard.model.board.dto.BoardDTO;
import kr.ksw3230.multiBoard.model.board.dto.BoardParam;

public interface BoardDAO {

	public void insert(BoardDTO dto);
	public int selectCount();
	public List<BoardDTO> selectList(HashMap<String, Integer> hmap);
	public void increment(int idx);
	public BoardDTO selectByIdx(int idx);
	public void delete(int idx);
	public void update(BoardDTO dto);
	public void incrementSeq(HashMap<String, Integer> hmap);
	public void reply(BoardDTO dto);
	public List<BoardDTO> selectNotice();
	public int selectCountMulti(HashMap<String, String> hmap);
	public List<BoardDTO> selectListMulti(BoardParam param);
	public BoardDTO selectLastNotice();
}
