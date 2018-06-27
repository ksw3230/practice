package kr.ksw3230.multiBoard.service.fboard;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.ksw3230.multiBoard.model.fboard.dao.FboardDAO;
import kr.ksw3230.multiBoard.model.fboard.dto.FboardDTO;


@Service
public class FboardServiceImpl implements FboardService {

	@Inject
	FboardDAO fboardDao;
	
	@Transactional
	@Override
	public void insert(FboardDTO dto) {
		fboardDao.insert(dto);
		String[] files = dto.getFiles();
		if(files==null) return;
		for(String name : files) {
			fboardDao.addAttach(name);
		}
		
	}

	@Override
	public int selectCount() {
		return fboardDao.selectCount();
	}

	@Override
	public List<FboardDTO> selectList(HashMap<String, Integer> hmap) {
		return fboardDao.selectList(hmap);
	}

	@Override
	public void increment(int idx) {
		fboardDao.increment(idx);
	}

	@Override
	public FboardDTO selectByIdx(int idx) {
		return fboardDao.selectByIdx(idx);
	}

	@Override
	public List<String> getAttach(int idx) {
		return fboardDao.getAttach(idx);
	}
	
	@Transactional
	@Override
	public void update(FboardDTO dto) throws Exception{
		fboardDao.update(dto);
		String[] files = dto.getFiles();
		for(String name : files) {
			fboardDao.updateAttach(name, dto.getIdx());
		}
	}

	@Override
	public void deleteFile(String fullName) {
		fboardDao.deleteFile(fullName);
	}

	@Override
	public void delete(int idx) {
		fboardDao.delete(idx);
	}

	@Override
	public List<FboardDTO> select4List() {
		return fboardDao.select4List();
	}
	
}
