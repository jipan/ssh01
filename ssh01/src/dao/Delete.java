package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import po.Student;

public class Delete {
	public static void main(String[] args) {
		Configuration conf = new Configuration().configure();
		ServiceRegistry registry = new StandardServiceRegistryBuilder()
			.applySettings(conf.getProperties()).build();
		SessionFactory sf = conf.buildSessionFactory(registry);
		Session session = sf.openSession();
		Student stu = (Student) session.get(Student.class, "007");
		if(stu != null) {
			//delete
			Transaction tran = session.beginTransaction();
			session.delete(stu);
			tran.commit();
		}
		//close session
		session.close();
	}
}
