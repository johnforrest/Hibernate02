package com.java1234.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.java1234.model.Student;
import com.java1234.util.HibernateUtil;

public class StudentTest {

	private SessionFactory sessionFactory=HibernateUtil.getSessionFactory();

	private void add(){
	    Session session=sessionFactory.openSession(); // 生成一个session
	    session.beginTransaction(); // 开启事务

	    Student s=new Student();
	    s.setName("嘻嘻");
	    session.save(s);

	    session.getTransaction().commit(); // 提交事务
	    session.close(); // 关闭session
	}

	private void delete(){
		Session session=sessionFactory.openSession(); // 生成一个session
	    session.beginTransaction(); // 开启事务

	    Student student=(Student)session.get(Student.class, Long.valueOf(2));
	    session.delete(student);

	    session.getTransaction().commit(); // 提交事务
	    session.close(); // 关闭session
	}

	private void update(){
		Session session=sessionFactory.openSession(); // 生成一个session
	    session.beginTransaction(); // 开启事务

	    Student student=(Student)session.get(Student.class, Long.valueOf(3));
	    student.setName("张三2");
	    session.save(student);

	    session.getTransaction().commit(); // 提交事务
	    session.close(); // 关闭session
	}

	private void getAllStudent(){
		Session session=sessionFactory.openSession(); // 生成一个session
	    session.beginTransaction(); // 开启事务

	    String hql="from Student";
	    Query query=session.createQuery(hql);
	    List<Student> studentList=query.list();
	    for(Student student:studentList){
	    	System.out.println(student.getName());
	    	System.out.println(student.getId());
	    }

	    session.getTransaction().commit(); // 提交事务
	    session.close(); // 关闭session
	}

	public static void main(String[] args) {
		StudentTest studentTest=new StudentTest();
		// studentTest.add();
		// studentTest.delete();
		// studentTest.update();
		studentTest.getAllStudent();
	}
}
