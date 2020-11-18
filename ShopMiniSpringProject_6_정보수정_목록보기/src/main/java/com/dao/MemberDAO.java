package com.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.MemberDTO;

@Repository
public class MemberDAO {
	@Autowired
	SqlSessionTemplate template;//자동주입
	
	public void memberAdd(MemberDTO m) {
		int n = template.insert("MemberMapper.memberAdd", m);
	}
	public MemberDTO login(Map<String, String> map) {
		MemberDTO dto = template.selectOne("MemberMapper.login", map);
		return dto;
	}
	public MemberDTO myPage(String userid) {
		MemberDTO dto = template.selectOne("MemberMapper.mypage",userid);
		return dto;
	}
	public void memberUpdate(MemberDTO m) {
		template.update("MemberMapper.memberUpdate", m);		
	}
	

}
