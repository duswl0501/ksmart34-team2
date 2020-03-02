package kr.or.ksmart.springboot34_mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.springboot34_mybatis.domain.Member;


@Mapper
public interface MemberMapper {
	//db Member table 모든 행을 가져오는 메서드 (xml에 구현되어 있는 쿼리문을 날려주는 메서드)
	public List<Member> getMemberlist();
	
	public List<Member> getSearchMemberList(String sk, String sv);
	
	public int mInsert(Member m);
	
	public Member selectForUpdate(String mId);
	
	public int mUpdate(Member m);
	
	public int mDelete(Member m);
}