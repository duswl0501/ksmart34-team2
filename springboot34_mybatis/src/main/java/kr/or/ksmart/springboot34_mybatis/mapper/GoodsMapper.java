package kr.or.ksmart.springboot34_mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.springboot34_mybatis.domain.Goods;

@Mapper
public interface GoodsMapper {
	public List<Goods> getGoodslist();
	
	public List<Goods> getSearchGoodsList(String sk, String sv);
	
	public int gInsert(Goods g);
	
	public Goods selectForUpdate(String gCode);
	
	public int gUpdate(Goods g);
	
	public int gDelete(Goods g);
}
