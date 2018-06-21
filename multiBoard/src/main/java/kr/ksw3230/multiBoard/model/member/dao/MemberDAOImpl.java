package kr.ksw3230.multiBoard.model.member.dao;

import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.ksw3230.multiBoard.model.member.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	SqlSession sqlSession;

	@Override
	public void join(MemberDTO dto) {
		sqlSession.insert("member.join", dto);
	}

	@Override
	public String idCheck(String userid) {
		return sqlSession.selectOne("member.id_check", userid);
	}

	@Override
	public String login(Map<String, Object> map) {
		return sqlSession.selectOne("member.login", map);
	}

	@Override
	public MemberDTO getInfo(String userid) {
		return sqlSession.selectOne("member.getInfo", userid);
	}

	@Override
	public void update(MemberDTO dto) {
		sqlSession.update("member.update", dto);
	}

	@Override
	public String admin_login(Map<String, Object> map) {
		return sqlSession.selectOne("admin.login",map);
	}

	@Override
	public void deleteMember(String userid) {
		sqlSession.delete("member.deleteMember", userid);
	}
}
