package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.GoodsDAO;
import com.dto.CartDTO;
import com.dto.GoodsDTO;
import com.dto.OrderDTO;

@Service
public class GoodsService {
@Autowired
GoodsDAO dao;

@Transactional
public void orderDone(OrderDTO oDTO, int orderNum) {
	dao.orderDone(oDTO); //주문정보저장 - insert
	dao.cartDelete(orderNum); //카트에서 삭제 두 처리를 tx 처리함 root-context.xml에 
	//txㅡManager등록필요	
}
public CartDTO orderConfirmByNum(int num) {
	CartDTO dto = dao.orderConfirmByNum(num);
	return dto;
}
public List<CartDTO> cartList(String userid) {
	List<CartDTO> list= dao.cartList(userid);
	return list;
}
public List<GoodsDTO> goodsList(String gCategory) {
	List<GoodsDTO> list= dao.goodsList(gCategory);
	return list;
}

public GoodsDTO goodsRetrieve(String gCode) {
	GoodsDTO dto= dao.goodsRetrieve(gCode);
	return dto;
}

public void cartAdd(CartDTO cart) {
	dao.cartAdd(cart);	
}
public void cartUpdate(Map<String, String> map) {
	dao.cartUpdate(map);
	
}
public void cartDelete(int num) {
	dao.cartDelete(num);
	
}
public void delAllCart(ArrayList<String> list) {
	dao.delAllCart(list);
	
}





}
