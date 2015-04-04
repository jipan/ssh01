package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import po.Student;

public class Query {
	public static void main(String[] args) {
		Configuration conf = new Configuration().configure();
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(
				conf.getProperties()).build();
		SessionFactory factory = conf.buildSessionFactory(registry);
		Session session = factory.openSession();
		
		//HQL
		/*String hql = "from Student where stuSex='男'";
		org.hibernate.Query query = session.createQuery(hql);
		List<?> list = query.list();
		for (int i = 0; i < list.size(); i++) {
			Student stu = (Student) list.get(i);
			System.out.println(stu.getStuName());
		}*/
		
		String hql = "select stuNo,stuName,stuSex from Student";
		org.hibernate.Query query = session.createQuery(hql);
		List<?> list = query.list();
		for (int i = 0; i < list.size(); i++) {
			Object[] obj = (Object[]) list.get(i);
			System.out.println();
			for (int j = 0; j < obj.length; j++) {
				System.out.print(obj[j] + " ");
			}
		}
		
		/*Student stu = (Student) session.get(Student.class, "001");
		String stuNo = stu.getStuNo();
		String stuName = stu.getStuName();
		String stuSex = stu.getStuSex();
		int stuAge = stu.getStuAge();
		String stuDept = stu.getStuDept();
		
		System.out.println("输出学生信息:");
		System.out.println(stuNo + " " + stuName + " " + stuSex + " " + stuAge + "" +stuDept);*/
		//close session
		session.close();
	}
}
