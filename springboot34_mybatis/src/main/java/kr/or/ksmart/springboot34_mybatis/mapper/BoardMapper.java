package kr.or.ksmart.springboot34_mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.springboot34_mybatis.domain.Board;

@Mapper
public interface BoardMapper {
	public List<Board> getBoardlist(Map<String, Object> map);
	
	public int getBoardRowCount();
}
