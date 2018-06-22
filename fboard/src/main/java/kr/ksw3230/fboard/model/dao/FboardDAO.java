package kr.ksw3230.fboard.model.dao;

import java.util.HashMap;
import java.util.List;

import kr.ksw3230.fboard.model.dto.FboardDTO;

public interface FboardDAO {
	public void insert(FboardDTO dto);
	public void addAttach(String name);
	public int selectCount();
	public List<FboardDTO> selectList(HashMap<String, Integer> hmap);
	public void increment(int idx);
	public FboardDTO selectByIdx(int idx);
}
