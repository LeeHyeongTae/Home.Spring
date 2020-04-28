package com.lht91.web.member;

import java.util.List;

public interface MemberService {

	void join(Member member);

	int count();

	public Member login(Member member);
	
	public Member detail(String userid);

	public boolean check(String userid);
	
	public void saveFile(Member member);
	
	public List<Member> readFile();

	boolean update(Member member);

	boolean delete(Member member);

}
