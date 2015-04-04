package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import po.Student;

public class Insert {
	public static void main(String[] args) {
		Configuration conf = new Configuration().configure();
//		SessionFactory sf = conf.buildSessionFactory();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
				conf.getProperties()).build();
		SessionFactory sf = conf.buildSessionFactory(serviceRegistry);
		Session session = sf.openSession();
		Student stu = new Student();
		stu.setStuNo("007");
		stu.setStuName("胡东东");
		stu.setStuSex("男");
		stu.setStuAge(23);
		stu.setStuDept("数学");
		//save
		Transaction tran = session.beginTransaction();
		session.save(stu);
		tran.commit();
		//close session
		session.close();
	}
}
