package kr.ksw3230.multiBoard.model.fboard.dao;

import java.util.HashMap;
import java.util.List;

import kr.ksw3230.multiBoard.model.fboard.dto.FboardDTO;


public interface FboardDAO {
	public void insert(FboardDTO dto);
	public void addAttach(String name);
	public int selectCount();
	public List<FboardDTO> selectList(HashMap<String, Integer> hmap);
	public void increment(int idx);
	public FboardDTO selectByIdx(int idx);
	public List<String> getAttach(int idx);
	public void update(FboardDTO dto);
	public void updateAttach(String fullName, int idx);
	public void deleteFile(String fullName);
	public void delete(int idx);
	public List<FboardDTO> select4List();
}
