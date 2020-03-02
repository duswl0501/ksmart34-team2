package kr.or.ksmart.springboot34_mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.springboot34_mybatis.domain.Goods;
import kr.or.ksmart.springboot34_mybatis.mapper.GoodsMapper;
@Service
@Transactional
public class GoodsService {
	@Autowired
	private GoodsMapper goodsMapper;
	
	public int gDelete(Goods g) {
		return goodsMapper.gDelete(g);
	}
	
	public int gUpdate(Goods g) {
		return goodsMapper.gUpdate(g);
	}
	
	public Goods selectForUpdate(String gCode) {
		return goodsMapper.selectForUpdate(gCode);
	}
	
	public int gInsert(Goods g) {
		return goodsMapper.gInsert(g);
	}
	
	public List<Goods> getSearchGoodsList(String sk, String sv){
		return goodsMapper.getSearchGoodsList(sk, sv);
	}
	
	public List<Goods> getGoodslist(){
		List<Goods>	list = goodsMapper.getGoodslist();
		return list;
	}
}
