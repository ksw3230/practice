package kr.ksw3230.multiBoard.service.admin;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.ksw3230.multiBoard.model.admin.dao.AdminDAO;
import kr.ksw3230.multiBoard.model.member.dto.MemberDTO;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Inject
	AdminDAO adminDao;

	@Override
	public List<MemberDTO> getMemberList() {
		return adminDao.getMemberList();
	}

	@Override
	public MemberDTO getOneMemberInfo(String userid) {
		return adminDao.getOneMemberInfo(userid);
	}

	@Override
	public void deleteMember(String userid) {
		adminDao.deleteMember(userid);
		
	}

	@Override
	public void update(MemberDTO dto) {
		adminDao.update(dto);
	}
	
	
	
	
}
