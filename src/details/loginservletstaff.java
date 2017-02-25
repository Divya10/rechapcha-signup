package details;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.details.employee1;
import org.details.staff1;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

/**
 * Servlet implementation class loginservletstaff
 */
@WebServlet("/loginservletstaff")
public class loginservletstaff extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginservletstaff() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		String nam=request.getParameter("E-mail");
		String pas	=request.getParameter("Password");
		String remoteAddr = request.getRemoteAddr();
		ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
		reCaptcha.setPrivateKey("6LfrshYUAAAAAHTrNqufhWI336J_p-E9tYDg7xM-");

		String challenge = request
				.getParameter("recaptcha_challenge_field");
		String uresponse = request.getParameter("recaptcha_response_field");
		ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(
				remoteAddr, challenge, uresponse);

		if (reCaptchaResponse.isValid()) {
		SessionFactory sessionFactory =  new Configuration().configure().buildSessionFactory(); 
 	   Session  session =	sessionFactory.openSession();
	       session.beginTransaction();
	      
	       Query queryResult = session.createQuery("from staff1");
	       java.util.List allUsers;
	       String pa,na="";
	       int f;
	       f=0;
	       String n="";
	       
	       allUsers = queryResult.list();
	       System.out.println(allUsers.size());
	       for (int i = 0; i < allUsers.size(); i++) {
	        staff1 user = (staff1) allUsers.get(i);
	        pa=user.getStaffpass();
	        na=user.getStaffemail();
	        n=user.getStaffname();
	        if(na.equals(nam) && pa.equals(pas))
	        {
	        	System.out.println("welcome");
	            f=1;
	        	
	        	break; 
	        }
	       
	        }
	       System.out.println("delievered");
	       if(f==1)
	       {
	    	   response.setContentType("text/html");
	    	   request.setAttribute("t2",n);
		       request.setAttribute("t3",na);
		       request.getRequestDispatcher("/h7.jsp").forward(request, response);

	       }    	       
	       else
	       {
	    	   response.sendRedirect("h4.jsp");
	       }
	       
	     
	       session.getTransaction().commit();
	       session.close();
		}
		else {
			response.sendRedirect("h5.jsp");
		}
	       
	}
	
	
	}


