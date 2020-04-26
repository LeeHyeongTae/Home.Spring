package com.lht91.web.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	private Map<String, Object> map;
	
	public UserServiceImpl() {
		map = new HashMap<>();
	}

	@Override
	public void signup(User user) {
		map.put(user.getUserid(), user);
	}

	@Override
	public int count() {
		return map.size();
	}

	@Override
	public User login(User user) {
		User signedUser = null;
		if(map.containsKey(user.getUserid())) {
			User u = detail(user.getUserid());
			if(user.getPassword().equals(u.getPassword())) {
				signedUser = u;
			}
		}
		
		return signedUser;
	}

	@Override
	public User detail(String userid) {
		return (User) map.get(userid);
	}

	@Override
	public boolean update(User user) {
		map.replace(user.getUserid(), user);
		return true;
	}

	@Override
	public boolean remove(String userid) {
		map.remove(userid);
		return true;
	}
	
}