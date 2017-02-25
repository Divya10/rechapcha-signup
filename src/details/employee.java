package details;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.details.employee1;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

/**
 * Servlet implementation class employee
 */
@WebServlet("/employee")
public class employee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public employee() {
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
		String empname=request.getParameter("t1");
		String emppass=request.getParameter("t2");
		String empemail=request.getParameter("t4");
		String emppass1=request.getParameter("t3");
		String remoteAddr = request.getRemoteAddr();
		ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
		reCaptcha.setPrivateKey("6LfrshYUAAAAAHTrNqufhWI336J_p-E9tYDg7xM-");

		String challenge = request
				.getParameter("recaptcha_challenge_field");
		String uresponse = request.getParameter("recaptcha_response_field");
		ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(
				remoteAddr, challenge, uresponse);

		if (reCaptchaResponse.isValid()) {

		if(emppass.equals(emppass1))
		{
			
			SessionFactory sessionFactory =  new Configuration().configure().buildSessionFactory();        		
		       
		       Session session =	sessionFactory.openSession();
		       session.beginTransaction();

		       Query queryResult = session.createQuery("from employee1");
		       java.util.List allUsers;
		       String pa,na;
		       
		       allUsers = queryResult.list();
		       int f;
		       f=0;
		       for (int i = 0; i < allUsers.size(); i++) {
		        employee1 user = (employee1) allUsers.get(i);
		        pa=user.getEmpemail();
		        na=user.getEmpname();
		        if(empname.equals(pa)){
		         f=1;
		         break; 
		         }
		        }
		         
		           if(f!=1){
		    employee1 user= new employee1();  
		      
		       user.setEmpname(empname);
		       user.setEmppass(emppass);
		       user.setEmpemail(empemail);
		       session.save(user);
		       session.getTransaction().commit();
		       session.close(); 
		       user=null;
		       System.out.println(empname);
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
			System.out.println(emppass);
			System.out.println(emppass1);
			 response.sendRedirect("h3.jsp");
		}
		}
		else {
			response.sendRedirect("h5.jsp");
		}
		
		}

	private String getempemail() {
		// TODO Auto-generated method stub
		return null;
	}
	}


