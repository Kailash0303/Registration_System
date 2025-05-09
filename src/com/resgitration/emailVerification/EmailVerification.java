package com.resgitration.emailVerification;


	import java.util.regex.Pattern;
	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import com.registration.Configuration.HibernateConfiguration;


	public class EmailVerification {

	    // Regular expression for email validation
	    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
	    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

	    // Method to validate email format
	    public static boolean isValidEmail(String email) {
	        return EMAIL_PATTERN.matcher(email).matches();
	    }

	    // Method to check if email already exists in the database
	    public static boolean isEmailAlreadyInUse(String email) {
	        SessionFactory factory = HibernateConfiguration.getSessionFactory();
	        Session session = null;
	        try {
	            session = factory.openSession();
	            Long count = (Long) session.createQuery("SELECT COUNT(u) FROM UserDetails u WHERE u.email = :email")
	                    .setParameter("email", email)
	                    .uniqueResult();
	            return count != null && count > 0;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false; // In case of error, assume email is not in use (better logging needed)
	        } finally {
	            if (session != null) {
	                session.close();
	            }
	        }
	    }
	}


