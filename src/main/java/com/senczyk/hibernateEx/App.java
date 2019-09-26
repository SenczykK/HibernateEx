package com.senczyk.hibernateEx;


import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;

import com.senczyk.hibernateEx.colors.Color;
import com.senczyk.hibernateEx.entity.A;
import com.senczyk.hibernateEx.entity.Aa;
import com.senczyk.hibernateEx.entity.Aaa;
import com.senczyk.hibernateEx.entity.B;
import com.senczyk.hibernateEx.entity.Bb;
import com.senczyk.hibernateEx.entity.Bbb;
import com.senczyk.hibernateEx.entity.C;


@Controller
public class App 
{
	private static SessionFactory f;

	
    public static void main( String[] args )
    {
    	try {
    		f = new Configuration()
            		.configure()
            		.addAnnotatedClass(A.class)
            		.addAnnotatedClass(B.class)
            		.addAnnotatedClass(Aa.class)
            		.addAnnotatedClass(Bb.class)
            		.addAnnotatedClass(Aaa.class)
            		.addAnnotatedClass(Bbb.class)
            		.addAnnotatedClass(C.class)
            		.buildSessionFactory();
    		
    		Session s = f.getCurrentSession();
    		
    		
    		// OneToOne uni (number is a Id for A)
    		//oneToOne(s);
    		
    		// OneToOne bi-directional (number is a Id for Aa)
    		//OneToOneBi(s);
    		
    		//OneToMany
    		//OneToMany(s);
    		
    		//save C entity
    		//saveC(s);
    		
    	}finally {
			f.close();
    	}
        
    }
    
    public static void oneToOne(Session s) {
    	A a = new A();
    	B b = new B();
    	a.setB(b);
    	
		s.beginTransaction();
		s.save(a);
		s.getTransaction().commit();
    }
    
    public static void OneToOneBi(Session s) {
    	Aa aa = new Aa();
    	Bb bb = new Bb();
    	aa.setBb(bb);
    	bb.setAa(aa);
    	
		s.beginTransaction();
		Aa aa1 = s.get(Aa.class, Integer.toUnsignedLong(2));
		Bb bb1 = s.get(Bb.class, Integer.toUnsignedLong(1));
		System.out.println("Object Aa: "+aa1.getId()+" object B: "+aa1.getBb().getId());
		System.out.println("Object Bb: "+bb1.getId()+" object A: "+bb1.getAa().getId());
		s.getTransaction().commit();
    }
    
    public static void OneToMany(Session s) {

    	Aaa AObject = new Aaa();
		Bbb BObject = new Bbb();
		Bbb CObject = new Bbb();
		Bbb DObject = new Bbb();
		BObject.setId(Integer.toUnsignedLong(1));
		CObject.setId(Integer.toUnsignedLong(2));
		DObject.setId(Integer.toUnsignedLong(3));
		AObject.add(BObject);
		AObject.add(CObject);
		AObject.add(DObject);
		
		s.beginTransaction();
		s.save(AObject);
		s.getTransaction().commit();
    }
    
    public static void saveC(Session s) {
    	C c = new C("c", LocalDate.now(), LocalDate.now(), Color.GREEN);
		
		s.beginTransaction();
		s.save(c);
		s.getTransaction().commit();
    }
}
