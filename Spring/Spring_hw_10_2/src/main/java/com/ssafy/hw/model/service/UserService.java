package com.ssafy.hw.model.service;

import java.util.List;

import com.ssafy.hw.model.dto.SearchCondition;
import com.ssafy.hw.model.dto.User;

public interface UserService {

	// User 객체의 정보 삽입
	int insert(User user);
	
	// 같은 ID의 User를 검색
	User searchById(String id);
	
	// 이름이 같은 User 탐색
	User searchByName(String Name);
	
	// 모든 User 탐색
	List<User> selectAll();
	
	// 조건에 따른 검색 설정
//	List<User> searchByCondition(SearchCondition con);
}