package kr.ksw3230.fboard.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.ksw3230.fboard.model.dao.FboardDAO;
import kr.ksw3230.fboard.model.dto.FboardDTO;

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
	
}
