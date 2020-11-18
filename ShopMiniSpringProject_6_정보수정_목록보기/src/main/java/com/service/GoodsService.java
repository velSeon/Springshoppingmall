package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.GoodsDAO;
import com.dto.GoodsDTO;

@Service
public class GoodsService {
@Autowired
GoodsDAO dao;

public List<GoodsDTO> goodsList(String gCategory) {

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	List<GoodsDTO> list= dao.goodsList(gCategory);
	return list;
}

}
