package kr.or.ksmart.springboot34_mybatis.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import kr.or.ksmart.springboot34_mybatis.domain.Member;
import kr.or.ksmart.springboot34_mybatis.mapper.MemberMapper;

@Service
@Transactional
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	public List<Member> getSearchMemberList(String sk, String sv){
		return memberMapper.getSearchMemberList(sk, sv);
	}
	
	public int mDelete(Member m) {
		return memberMapper.mDelete(m);
	}
	
	public int mUpdate(Member m) {
		return memberMapper.mUpdate(m);
	}
	
	public Member selectForUpdate(String mId) {
		return memberMapper.selectForUpdate(mId);
	}
	
	public int mInsert(Member m) {
		return memberMapper.mInsert(m);
	}
	
	public List<Member> getMemberlist(){
		List<Member> list = memberMapper.getMemberlist();
		return list;
	}
}
