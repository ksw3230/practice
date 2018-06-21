package kr.ksw3230.multiBoard.model.admin.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.ksw3230.multiBoard.model.member.dto.MemberDTO;

@Repository
public class AdminDAOImpl implements AdminDAO {

	@Inject
	SqlSession sqlSession;

	@Override
	public List<MemberDTO> getMemberList() {
		return sqlSession.selectList("admin.getMemberList");
	}

	@Override
	public MemberDTO getOneMemberInfo(String userid) {
		return sqlSession.selectOne("admin.getOneMemberInfo", userid);
	}

	@Override
	public void deleteMember(String userid) {
		sqlSession.delete("admin.deleteMember", userid);
	}

	@Override
	public void update(MemberDTO dto) {
		sqlSession.update("admin.update", dto);
	}
}
