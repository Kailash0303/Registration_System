package com.registration.Configuration;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.registration.Entity.UserInformation;

public class HibernateConfiguration {
	public static final SessionFactory getSessionFactory() {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(UserInformation.class);
		SessionFactory factory = cfg.buildSessionFactory();
		return factory;
	}
}
