package kr.ksw3230.fboard.service;

import java.util.HashMap;
import java.util.List;

import kr.ksw3230.fboard.model.dto.FboardDTO;

public interface FboardService {
	public void insert(FboardDTO dto);
	public int selectCount();
	public List<FboardDTO> selectList(HashMap<String, Integer> hmap);
	public void increment(int idx);
	public FboardDTO selectByIdx(int idx);
	public List<String> getAttach(int idx);
	public void update(FboardDTO dto) throws Exception;
	public void deleteFile(String fullName);
	public void delete(int idx);
}
