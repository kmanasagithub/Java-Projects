package com.pro.dao;

import java.util.List;

import com.pro.entity.Notes;
import com.pro.entity.User;

public interface UserDao {
	public int saveUser(User user);
	public User login(String email,String password);
	public int saveNotes(Notes notes);
	public List<Notes> getNotesByUser(User user);
	public Notes getNotesNyId(int id);
	public void updateNotes(Notes n);
	public void deleteNotes(int id);
}
