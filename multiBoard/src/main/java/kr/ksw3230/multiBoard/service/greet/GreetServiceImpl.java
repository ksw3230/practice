package kr.ksw3230.multiBoard.service.greet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.ksw3230.multiBoard.model.greet.dao.GreetDAO;
import kr.ksw3230.multiBoard.model.greet.dto.GreetDTO;
import kr.ksw3230.multiBoard.model.greet.dto.GreetParam;

@Service
public class GreetServiceImpl implements GreetService {

	@Inject
	GreetDAO greetDao;
	
	@Override
	public void insert(HashMap<String, String> map) {
		greetDao.insert(map);
	}

	@Override
	public List<GreetDTO> selectList() {
		return greetDao.selectList();
	}

	@Override
	public void delete(int idx) {
		greetDao.delete(idx);
	}

	@Override
	public int selectLevel(String userid) {
		return greetDao.selectLevel(userid);
	}

	@Override
	public void levelUp(GreetParam param) {
		greetDao.levelUp(param);
	}

}
