package org.motaouia.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtilsII {
	private static StandardServiceRegistry registry;
	   private static SessionFactory sessionFactory;

	   public static SessionFactory getSessionFactory() {
	     /* if (sessionFactory == null) {
	         try {
	            StandardServiceRegistryBuilder registryBuilder = 
	                  new StandardServiceRegistryBuilder();

	            Map<String, String> settings = new HashMap<String, String>();
	            settings.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
	            settings.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/DEMO_MANY_TO_MANY_III?useSSL=false");
	            settings.put("hibernate.connection.username", "root");
	            settings.put("hibernate.connection.password", "");
	            settings.put("hibernate.show_sql", "true");
	            settings.put("hibernate.hbm2ddl.auto", "update");
	            settings.put("hibernate.show_sql", "true");

	            registry = registryBuilder.applySettings(settings).build();

	            MetadataSources sources = new MetadataSources(registry)
	                  .addAnnotatedClass(Employee.class)
	                  .addAnnotatedClass(Address.class);

	            Metadata metadata = sources.getMetadataBuilder().build();

	            sessionFactory = metadata.getSessionFactoryBuilder().build();
	         } catch (Exception e) {
	            System.out.println("SessionFactory creation failed");
	            if (registry != null) {
	               StandardServiceRegistryBuilder.destroy(registry);
	            }
	         }
	      }
	      return sessionFactory;
	      */
		  /*
		   //Hibernate version 4
		    
		     try {
				// Create the SessionFactory from hibernate.cfg.xml
				Configuration configuration = new Configuration();
				configuration.configure("hibernate.cfg.xml");
				System.out.println("Hibernate Configuration loaded");

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				System.out.println("Hibernate serviceRegistry created");

				SessionFactory sessionFactory = configuration
						.buildSessionFactory(serviceRegistry);

				return sessionFactory;
			} catch (Throwable ex) {
				System.err.println("Initial SessionFactory creation failed." + ex);
				ex.printStackTrace();
				throw new ExceptionInInitializerError(ex);
			}
			//return sessionFactory;
			 
			 */
		   //Hibernate version 5
		   try {
	            // Create the SessionFactory from hibernate.cfg.xml
	            StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder() .configure("hibernate.cfg.xml").build();
	            Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
	            return metadata.getSessionFactoryBuilder().build();
	        } 
	        catch (Throwable ex) {
	            // Make sure you log the exception, as it might be swallowed
	            System.err.println("Initial SessionFactory creation failed." + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	   }

	   public static void shutdown() {
	      if (registry != null) {
	         StandardServiceRegistryBuilder.destroy(registry);
	      }
	   }

}
