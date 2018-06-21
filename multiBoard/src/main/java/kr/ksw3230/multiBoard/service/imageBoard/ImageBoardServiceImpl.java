package kr.ksw3230.multiBoard.service.imageBoard;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.ksw3230.multiBoard.model.imageBoard.dao.ImageBoardDAO;
import kr.ksw3230.multiBoard.model.imageBoard.dto.ImageBoardDTO;

@Service
public class ImageBoardServiceImpl implements ImageBoardService {

	@Inject
	ImageBoardDAO imageBoardDao;

	@Override
	public void insert(ImageBoardDTO dto) {
		imageBoardDao.insert(dto);
	}

	@Override
	public int selectList() {
		return imageBoardDao.selectList();
	}

	@Override
	public List<ImageBoardDTO> getList(HashMap<String, Integer> hmap) {
		return imageBoardDao.getList(hmap);
	}

	@Override
	public ImageBoardDTO selectOne(int idx) {
		return imageBoardDao.selectOne(idx);
	}

	@Override
	public void update(ImageBoardDTO dto) {
		imageBoardDao.update(dto);
	}

	@Override
	public void delete(int idx) {
		imageBoardDao.delete(idx);
	}

	@Override
	public int getLevel(String userid) {
		return imageBoardDao.getLevel(userid);
	}

	@Override
	public List<ImageBoardDTO> select4List() {
		return imageBoardDao.select4List();
	}
	
	
}
