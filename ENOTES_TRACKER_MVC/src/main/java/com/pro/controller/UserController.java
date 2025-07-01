package com.pro.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pro.dao.UserDao;
import com.pro.entity.Notes;
import com.pro.entity.User;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user/")
public class UserController {

	@Autowired
	private UserDao userDao;
	
	@RequestMapping("/addNotes")
	public String addNotes() {
		return "add_notes";
	}
	
	@RequestMapping("/viewNotes")
	public String viewNotes(HttpSession session,Model m) {
		User user = (User)session.getAttribute("userObj");
		List<Notes> notes = userDao.getNotesByUser(user);
		m.addAttribute("list",notes);
		return "view_notes";
	}
	
	@RequestMapping("/editNotes")
	public String editNotes(@RequestParam("id") int id,Model m) {
		Notes n = userDao.getNotesNyId(id);
		m.addAttribute("notes",n);
		return "edit_notes";
	}
	
	@RequestMapping(path="/updateNotes",method = RequestMethod.POST)
	public String updateNotes(@ModelAttribute Notes n,HttpSession session) {
		User user = (User)session.getAttribute("userObj");
		n.setUser(user);
		n.setDate(LocalDateTime.now().toString());
		userDao.updateNotes(n);
		session.setAttribute("msg", "Notes Updated Successfully");
		return "redirect:/user/viewNotes";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("userObj");
		session.setAttribute("msg", "Logout Successfully");
		return "redirect:/login";
	}
	
	@RequestMapping(path = "/saveNotes", method = RequestMethod.POST)
	public String saveNotes(@ModelAttribute Notes n,HttpSession session) {
		User user = (User)session.getAttribute("userObj");
		n.setDate(LocalDateTime.now().toString());
		n.setUser(user);
		userDao.saveNotes(n);
		session.setAttribute("msg", "Notes Added Successfully");
		return "redirect:/user/addNotes";
	}
	
	@RequestMapping(path="/deleteNotes")
	public String deleteNote(@RequestParam("id") int id,HttpSession session) {
		userDao.deleteNotes(id);
		session.setAttribute("msg", "Notes Deleted Successfully");
		return "redirect:/user/viewNotes";
	}
}
