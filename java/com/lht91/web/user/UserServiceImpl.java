package com.lht91.web.user;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	private Map<String, Object> map;
	public final static String FILE_PATH = "/Volumes/Macintosh HD/Spring-workspace/lht91/src/main/resources/static/user/";
	
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

	@Override
	public List<User> list() {
		List<User> returnList = new ArrayList<>();
		@SuppressWarnings("rawtypes")
		Set set = map.entrySet();
		@SuppressWarnings("rawtypes")
		Iterator it = set.iterator();
		while(it.hasNext()) {
			@SuppressWarnings("unchecked")
			Map.Entry<String, User> e = (Entry<String, User>) it.next();
			returnList.add(e.getValue());
		}
		for(int i=0; i<returnList.size(); i++) {
			System.out.println(returnList.get(i));
		}
		return returnList;
	}

	@Override
	public void saveFile(User user) {
		try {
			File file = new File(FILE_PATH+"list.txt");
			@SuppressWarnings("resource")
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
					String message = user.toString();
					System.out.println(message);
					writer.write(message);
					writer.newLine();
					writer.flush();
		}catch(Exception e){
			System.out.println("파일 입력시 에러발생");
		}
	}

	@Override
	public List<User> readFile() {
		List<User> userList = new ArrayList<>();
		List<String> list = new ArrayList<>();
		try {
			File file = new File(FILE_PATH+"list.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String message = "";
			while((message = reader.readLine()) != null) {
						list.add(message);
				}
			reader.close();
		}catch(Exception e){
			System.out.println("파일 읽기에서 에러 발생");
		}
		User u = null;
		for(int i=0; i<list.size(); i++) {
			u = new User();
			String[] arr = list.get(i).split(",");
			u.setUserid(arr[0]);
			u.setName(arr[1]);
			u.setPassword(arr[2]);
			u.setSsn(arr[3]);
			u.setAddress(arr[4]);
			userList.add(u);
		}
		return userList;
	}

	@Override
	public boolean idCheck(String userid) {
		boolean checkResult = false;
		List<User> userlist = readFile();
		for(int i=0; i<userlist.size(); i++) {
			signup(userlist.get(i));
		}
		if(map.containsKey(userid)) {
			checkResult = true;
		}
		return checkResult;
	}
	
}