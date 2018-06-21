package kr.ksw3230.fboard.model.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class FboardDAOImpl implements FboardDAO {

	@Inject
	SqlSession selSession;
	
}
