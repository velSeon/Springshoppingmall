package com.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.GoodsDTO;

@Repository
public class GoodsDAO {
	@Autowired
	SqlSessionTemplate template;

	public List<GoodsDTO> goodsList(String gCategory) {
		List<GoodsDTO> list= template.selectList("GoodsMapper.goodsList", gCategory);
		return list;
	}
	
}
