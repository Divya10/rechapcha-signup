package details;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.details.staff1;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;


/**

 * Servlet implementation class staff
 * @param <Userdet>
 */
@WebServlet("/staff")
public class staff<Userdet> extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public staff() {
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
		String name=request.getParameter("Username");
		String pass=request.getParameter("Password");
		String email=request.getParameter("E-mail");
		String repass=request.getParameter("Pass1");
		String remoteAddr = request.getRemoteAddr();
		ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
		reCaptcha.setPrivateKey("6LfrshYUAAAAAHTrNqufhWI336J_p-E9tYDg7xM-");

		String challenge = request
				.getParameter("recaptcha_challenge_field");
		String uresponse = request.getParameter("recaptcha_response_field");
		ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(
				remoteAddr, challenge, uresponse);

		if (reCaptchaResponse.isValid()) {
		if(pass.equals(repass))
		{
			
			SessionFactory sessionFactory =  new Configuration().configure().buildSessionFactory();        		
		       
		       Session session =	sessionFactory.openSession();
		       session.beginTransaction();

		       Query queryResult = session.createQuery("from staff1");
		       java.util.List allUsers;
		       String pa,na;
		       
		       allUsers = queryResult.list();
		       int f;
		       f=0;
		       for (int i = 0; i < allUsers.size(); i++) {
		        staff1 user = (staff1) allUsers.get(i);
		        pa=user.getStaffemail();
		        na=user.getStaffname();
		        if(email.equals(pa)){
		         f=1;
		         break; 
		         }
		        }
		         
		           if(f!=1){
		    staff1 user= new staff1();  
		      
		       user.setStaffname(name);
		       user.setStaffpass(pass);
		       user.setStaffemail(email);
		       session.save(user);
		       session.getTransaction().commit();
		       session.close(); 
		       user=null;
		       System.out.println(name);
		       response.sendRedirect("h1.html");
		       

		           } 
		           else
		           {   System.out.println("duplicate");
		           response.sendRedirect("h8.jsp");
		           }
		
		
		            
			 }   

		
		else
		{
			System.out.println("pass do not match");
			System.out.println(pass);
			System.out.println(repass);
			 response.sendRedirect("h3.jsp");
		}
	}
	else {
		response.sendRedirect("h5.jsp");;
	}
		
}
	}


