package com.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.CartDTO;
import com.dto.GoodsDTO;
import com.dto.MemberDTO;

@Repository
public class GoodsDAO {

	@Autowired
	SqlSessionTemplate template;

	public List<GoodsDTO> goodsList(String gCategory) {
		List<GoodsDTO> list = 
				template.selectList("GoodsMapper.goodsList", gCategory);
		return list;
	}

	public GoodsDTO goodsRetrieve(String gCode) {
		GoodsDTO dto = 
				template.selectOne("GoodsMapper.goodsRetrieve",gCode);
		return dto;
	}

	public void cartAdd(CartDTO cart) {
		int n = template.insert("CartMapper.cartAdd",cart);
		
	}

	public List<CartDTO> cartList(String userid) {
		List<CartDTO> list = template.selectList("CartMapper.cartList", userid);
		return list;
	}

	public void cartUpdate(Map<String, String> map) {
		int n = template.update("CartMapper.cartUpdate", map);
	}

	public void cartDelete(int num) {
		int n = template.delete("CartMapper.cartDel", num);
	}
	
	
}
