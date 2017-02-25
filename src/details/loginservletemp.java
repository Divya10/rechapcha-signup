package details;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.details.employee1;
import org.details.student1;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

/**
 * Servlet implementation class loginservletemp
 */
@WebServlet("/loginservletemp")
public class loginservletemp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginservletemp() {
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
	      
	       Query queryResult = session.createQuery("from employee1");
	       java.util.List allUsers;
	       String pa,na;
	       int f;
	       f=0;
	       
	       allUsers = queryResult.list();
	       System.out.println(allUsers.size());
	       for (int i = 0; i < allUsers.size(); i++) {
	        employee1 user = (employee1) allUsers.get(i);
	        pa=user.getEmppass();
	        na=user.getEmpemail();
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
		       request.setAttribute("t2", "");
		       request.getRequestDispatcher("/dash.jsp").forward(request, response);

	       }    	       
	       else
	       {
	    	   response.sendRedirect("h4.html");
	       }
	       
	     
	       session.getTransaction().commit();
	       session.close();
		}
		else {
			System.out.print("CAPTCHA Validation Failed! Try Again.");
		}
	       
	}
	
	}


