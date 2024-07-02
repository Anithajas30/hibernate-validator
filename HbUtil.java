package com.model;

import org.hibernate.boot.Metadata;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.mysql.cj.xdevapi.SessionFactory;


public class HbUtil {
public static StandardServiceRegistry registry=null;
public static org.hibernate.SessionFactory sesFactory=null;
public static org.hibernate.SessionFactory getSesFactory()
{
	if(sesFactory==null)
	{
		try
		{
			registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			MetadataSources sources=new MetadataSources(registry);
			Metadata metadata=sources.getMetadataBuilder().build();
			sesFactory = metadata.getSessionFactoryBuilder().build();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			if(registry!=null)
			
				StandardServiceRegistryBuilder.destroy(registry);	
			
		}	

}
	return sesFactory;
}	
}