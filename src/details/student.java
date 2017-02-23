package details;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.details.student1;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Servlet implementation class student
 */
@WebServlet("/student")
public class student extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public student() {
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
		String stname=request.getParameter("t1");
		String stpass=request.getParameter("t2");
		String stemail=request.getParameter("t4");
		String stpass1=request.getParameter("t3");
		if(stpass.equals(stpass1))
		{
			
			SessionFactory sessionFactory =  new Configuration().configure().buildSessionFactory();        		
		       
		       Session session =	sessionFactory.openSession();
		       session.beginTransaction();

		       Query queryResult = session.createQuery("from student1");
		       java.util.List allUsers;
		       String pa,na;
		       
		       allUsers = queryResult.list();
		       int f;
		       f=0;
		       for (int i = 0; i < allUsers.size(); i++) {
		        student1 user = (student1) allUsers.get(i);
		        pa=user.getStemail();
		        na=user.getStname();
		        if(stemail.equals(pa)){
		         f=1;
		         break; 
		         }
		        }
		         
		           if(f!=1){
		    student1 user= new student1();  
		      
		       user.setStname(stname);
		       user.setStpass(stpass);
		       user.setStemail(stemail);
		       session.save(user);
		       session.getTransaction().commit();
		       session.close(); 
		       user=null;
		       System.out.println(stname);
		       response.sendRedirect("h1.html");
		       

		           } 
		           else
		           {   System.out.println("duplicate");
		           response.sendRedirect("h2.html");
		           }
		            
			 }   

		
		else
		{
			System.out.println("pass do not match");
			System.out.println(stpass);
			System.out.println(stpass1);
			 response.sendRedirect("h3.html");
		}
		
		}
	}


