package com.simplilearn.workshop.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.simplilearn.workshop.Util.HibernateUtil;
import com.simplilearn.workshop.model.Student;

public class StudentService {
	public void save(Student student) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction();
        
        session.save(student);
        
        session.getTransaction().commit();
        
        session.close();
	}
	
	public List<Student> findAll() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction();
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
        criteria.from(Student.class);
        List<Student> studentList = session.createQuery(criteria).getResultList();
        
        session.getTransaction().commit();
        
        session.close();
        
        return studentList;
	}
}
