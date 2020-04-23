package com.lht91.web.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lht91.web.util.Messenger;

@RestController
@RequestMapping("/member")
public class MemberController {
	@Autowired MemberService memberService;
	
	@PostMapping("/join")
	public Messenger join(Member member) {
		int count = memberService.count();
		memberService.join(member);
		return (memberService.count()==count+1)? Messenger.SUCCESS:Messenger.FAIL;
	}
	
	@PostMapping("/login")
	public Map<String, Object> login(Member member) {
		Map<String, Object> returnMap = new HashMap<>();
		Member joinedMember = memberService.login(member);
		if(joinedMember!=null) {
			returnMap.put("member", joinedMember);
			returnMap.put("messenger", Messenger.SUCCESS);
		}else {
			returnMap.put("messenger", Messenger.FAIL);
		}
		return returnMap;
	}
	
}
