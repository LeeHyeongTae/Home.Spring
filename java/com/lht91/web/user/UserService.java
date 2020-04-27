package com.lht91.web.user;

import java.util.List;

public interface UserService {

	public void signup(User user);

	public int count();

	public User login(User user);
	public User detail(String userid);

	public boolean update(User user);

	public boolean remove(String userid);

	public List<User> list();
	
	public void saveFile(User user);
	
	public List<User> readFile();

}