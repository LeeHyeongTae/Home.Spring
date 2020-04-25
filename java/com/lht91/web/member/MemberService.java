package com.lht91.web.member;

public interface MemberService {

	void join(Member member);

	int count();

	public Member login(Member member);
	
	public Member detail(String userid);

	public boolean check(String userid);

}
