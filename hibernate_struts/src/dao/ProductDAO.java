package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Query;

import pojo.Product;

import java.util.List;
import java.util.ArrayList;

public class ProductDAO {
	public void add(Product product) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		
		s.beginTransaction();
		s.save(product);
		s.getTransaction().commit();
		
		s.close();
		sf.close();
	}
	
	public void delete(int id) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		
		s.beginTransaction();
		Product product = (Product)s.get(Product.class, id);
		s.delete(product);
		s.getTransaction().commit();
		
		s.close();
		sf.close();
	}
	
	public Product get(int id) {
		Product product = null;
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		
		s.beginTransaction();
		product = (Product) s.get(Product.class, id);
		s.getTransaction().commit();
		
		s.close();
		sf.close();
		
		return product;
	}
	
	public List<Product> list(){
		List<Product> productList = new ArrayList<>();
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		
		s.beginTransaction();
		Query q = s.createQuery("from Product");
		productList = q.list();
		s.getTransaction().commit();
		
		s.close();
		sf.close();
		
		return productList;
	}
	
	public void update(Product product) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		
		s.beginTransaction();
		s.update(product);
		s.getTransaction().commit();
		
		s.close();
		sf.close();
	}
}
