package kr.ksw3230.multiBoard.model.admin.dao;

import java.util.List;

import kr.ksw3230.multiBoard.model.member.dto.MemberDTO;

public interface AdminDAO {

	public List<MemberDTO> getMemberList();
	public MemberDTO getOneMemberInfo(String userid);
	public void deleteMember(String userid);
	public void update(MemberDTO dto);
	
}
