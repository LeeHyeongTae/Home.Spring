package com.lht91.web.member;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{
	private static final String FILE_PATH = "/Volumes/Macintosh HD/Spring-workspace/lht91/src/main/resources/static/member/";
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
		map.replace(member.getUserid(), member);
		return true;
	}

	@Override
	public boolean delete(Member member) {
		map.remove(member.userid);
		return true;
	}

	@Override
	public void saveFile(Member member) {
		try {
		File file = new File(FILE_PATH+"adminlist.txt");
		@SuppressWarnings("resource")
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		writer.write(member.toString());
		writer.newLine();
		writer.flush();
		} catch (Exception e) {
			System.out.println("저장 오류");
		}
		
	}

	@Override
	public List<Member> readFile() {
		List<Member> memberList = new ArrayList<>();
		List<String> list = new ArrayList<>();
		try {
			File file = new File(FILE_PATH+"adminlist.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
		} catch (Exception e) {
			System.out.println("읽기 오류");
		}
		return memberList;
	}
}
