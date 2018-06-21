package kr.ksw3230.multiBoard.service.member;

import java.util.Map;

import kr.ksw3230.multiBoard.model.member.dto.MemberDTO;

public interface MemberService {
	public void join (MemberDTO dto);
	public String idCheck(String userid);
	public String login(Map<String,Object> map);
	public MemberDTO getInfo(String userid);
	public void update(MemberDTO dto);
	public String admin_login(Map<String,Object> map);
	public void deleteMember(String userid);
}
