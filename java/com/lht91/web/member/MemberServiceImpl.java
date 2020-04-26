package com.lht91.web.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{
	private Map<String, Object> map;
	
	public MemberServiceImpl() {
		map = new HashMap<>();
	}

	@Override
	public void join(Member member) {
		map.put(member.getUserid(), member);
	}

	@Override
	public int count() {
		return map.size();
	}

	@Override
	public Member login(Member member) {
		Member returnMember = null;
		if(map.containsKey(member.getUserid())) {
			Member m = detail(member.getUserid());
			if(member.getPassword().equals(m.getPassword())) {
				returnMember = m;
			}
		}
		return returnMember;
	}

	@Override
	public Member detail(String userid) {
		return (Member) map.get(userid);
	}

	@Override
	public boolean check(String userid) {
		return map.containsKey(userid);
	}

	@Override
	public boolean update(Member member) {
		return map.replace(member.getUserid(), map, member);
	}

	@Override
	public boolean delete(Member member) {
		return map.remove(member.getUserid(), member);
	}
}
