package kr.ksw3230.fboard.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.ksw3230.fboard.model.dao.FboardDAO;

@Service
public class FboardServiceImpl implements FboardService {

	@Inject
	FboardDAO fboardDao;
	
}
