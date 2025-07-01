package com.pro.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pro.entity.Notes;
import com.pro.entity.User;

@Component
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public int saveUser(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		int i = (Integer)session.save(user);
		System.out.print("User Successfully registered!!!!");
		tx.commit();
		return i;
	}

	@Override
	public User login(String email, String password) {
		String str = "from User where email=:em and password=:password";
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query<User> q = session.createQuery(str);
		System.out.print("Login Successfully");
		q.setParameter("em",email);
		q.setParameter("password",password);
		
		return q.uniqueResult();
		
	}

	@Override
	public int saveNotes(Notes notes) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		int i = (Integer)session.save(notes);
		tx.commit();
		session.close();
		return i;
	}

	@Override
	public List<Notes> getNotesByUser(User user) {
	    String hql = "from Notes where user = :us";
	    Session session = sessionFactory.openSession();
	    Transaction tx = session.beginTransaction();

	    Query<Notes> q = session.createQuery(hql, Notes.class);
	    q.setParameter("us", user); // ✅ Correct usage

	    List<Notes> notesList = q.getResultList();

	    tx.commit();
	    session.close();
	    
	    return notesList;
	}

	@Override
	public Notes getNotesNyId(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Notes n= session.get(Notes.class, id);
		return n;
	}

	@Override
	public void deleteNotes(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Notes n= session.get(Notes.class, id);
		session.delete(n);
		tx.commit();
		session.close();
	}

	@Override
	public void updateNotes(Notes n) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(n);
		tx.commit();
		session.close();
	}
	
}
