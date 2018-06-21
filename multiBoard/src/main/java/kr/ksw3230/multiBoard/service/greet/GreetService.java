package kr.ksw3230.multiBoard.service.greet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.ksw3230.multiBoard.model.greet.dao.GreetDAO;
import kr.ksw3230.multiBoard.model.greet.dto.GreetDTO;
import kr.ksw3230.multiBoard.model.greet.dto.GreetParam;

public interface GreetService {
	
	public void insert(HashMap<String, String> map);
	public List<GreetDTO> selectList();
	public void delete(int idx);
	public int selectLevel(String userid);
	public void levelUp(GreetParam param);

}
