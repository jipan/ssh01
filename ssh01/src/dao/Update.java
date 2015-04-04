package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import po.Student;

public class Update {
	public static void main(String[] args) {
		Configuration conf = new Configuration().configure();
		ServiceRegistry sr = new StandardServiceRegistryBuilder()
			.applySettings(conf.getProperties()).build();
		SessionFactory sessionFactory = conf.buildSessionFactory(sr);
		Session session = sessionFactory.openSession();
		
		Student stu = (Student) session.get(Student.class, "004");
		if(stu != null) {
			stu.setStuSex("男");
			//modified
			Transaction tran = session.beginTransaction();
			session.update(stu);
			tran.commit();
		}
		//close session
		session.close();
	}
}
