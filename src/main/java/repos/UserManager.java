package repos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import domain.User;

public class UserManager {
    protected SessionFactory sessionFactory;
 
    protected void setup() {
    	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
    	        .configure() // configures settings from hibernate.cfg.xml
    	        .build();
    	try {
    	    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    	} catch (Exception ex) {
    	    StandardServiceRegistryBuilder.destroy(registry);
    	}
    }
 
    protected void exit() {
    	sessionFactory.close();
    }
 
    protected void createUser(User user) {
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
		 
	    session.save(user);
		 
	    session.getTransaction().commit();
	    session.close();
    }
    
    protected void createUser(Integer uId, String state) {
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	    
	    User user = new User(uId, state);	 
	    session.save(user);
		 
	    session.getTransaction().commit();
	    session.close();
    }
 
    protected List<User> getUserById(Long id) {
    	Session session = sessionFactory.openSession();
    	
    	Query query = session.createQuery("from User where id = :_id")
    						 .setParameter("_id", id);
    	List list = query.list();
     
        session.close();
        
        return list;
    }
    
    protected List<User> getUserByUid(Integer uId) {
    	Session session = sessionFactory.openSession();
    	
    	Query query = session.createQuery("from User where uId = :_uId")
    						 .setParameter("_uId", uId);
    	List list = query.list();
     
        session.close();
        
        return list;
    }
    
    protected List<User> getUserByState(String state) {
    	Session session = sessionFactory.openSession();
    	
    	Query query = session.createQuery("from User where state = :_state")
    						 .setParameter("_state", state);
    	List list = query.list();
     
        session.close();
        
        return list;
    }
 
    protected void updateUserById(Long id, Integer uId, String state) {
    	User user = new User();
    	user.setId(id);
        user.setUid(uId);
        user.setState(state);
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
     
        session.update(user);
     
        session.getTransaction().commit();
        session.close();
    }
 
    protected void deleteUserById(Long id) {
    	User user = new User();
    	user.setId(id);
     
        Session session = sessionFactory.openSession();
        session.beginTransaction();
     
        session.delete(user);
     
        session.getTransaction().commit();
        session.close();
    }
    
    protected void deleteUserByUid(Integer uId) {   
        Session session = sessionFactory.openSession();
        session.beginTransaction();
     
        String sqlDeleteString = "delete User where uId = :_uId";
        int result = session.createQuery(sqlDeleteString)
		                    .setParameter("_uId", uId)
		                    .executeUpdate();
        
        session.close();
    }
    
    protected void deleteUserByState(String state) {   
        Session session = sessionFactory.openSession();
        session.beginTransaction();
     
        String sqlDeleteString = "delete User where state = :_state";
        int result = session.createQuery(sqlDeleteString)
		                    .setParameter("_state", state)
		                    .executeUpdate();
        
        session.close();
    }
 
    public static void main(String[] args) {
    	UserManager manager = new UserManager();
        manager.setup();
     
        //manager.createUser(123123, "state1");
        //manager.createUser(123124, "state2");
        //manager.createUser(123125, "state2");
        
//        List<User> list = manager.getUserByState("state2");
//        for(User user : list) {
//        	System.out.println(user.toString());
//        }
        //manager.deleteUserByUid(123124);
        //manager.deleteUserByState("state2");
     
        manager.exit();
    }
}
