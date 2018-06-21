package kr.ksw3230.multiBoard.service.member;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.ksw3230.multiBoard.model.member.dao.MemberDAO;
import kr.ksw3230.multiBoard.model.member.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	MemberDAO memberDao;

	@Override
	public void join(MemberDTO dto) {
		memberDao.join(dto);
		
	}

	@Override
	public String idCheck(String userid) {
		return memberDao.idCheck(userid);
	}

	@Override
	public String login(Map<String, Object> map) {
		return memberDao.login(map);
	}

	@Override
	public MemberDTO getInfo(String userid) {
		return memberDao.getInfo(userid);
	}

	@Override
	public void update(MemberDTO dto) {
		memberDao.update(dto);
	}

	@Override
	public String admin_login(Map<String, Object> map) {
		return memberDao.admin_login(map);
	}

	@Override
	public void deleteMember(String userid) {
		memberDao.deleteMember(userid);
	}
}
