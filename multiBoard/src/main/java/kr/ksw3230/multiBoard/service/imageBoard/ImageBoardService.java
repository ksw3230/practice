package kr.ksw3230.multiBoard.service.imageBoard;

import java.util.HashMap;
import java.util.List;

import kr.ksw3230.multiBoard.model.imageBoard.dto.ImageBoardDTO;

public interface ImageBoardService {

	public void insert(ImageBoardDTO dto);
	public int selectList();
	public List<ImageBoardDTO> getList(HashMap<String, Integer> hmap);
	public ImageBoardDTO selectOne(int idx);
	public void update(ImageBoardDTO dto);
	public void delete(int idx);
	public int getLevel(String userid);
	public List<ImageBoardDTO> select4List();
}
