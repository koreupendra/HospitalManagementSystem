package comuser.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.db.DBconn;
import com.entity.User;
@WebServlet("/user_register")
public class UserRegister extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String fullname=req.getParameter("fullname");
			String email=req.getParameter("email");
			String password=req.getParameter("password");
			User u=new User(fullname, email, password);
			UserDao dao=new UserDao(DBconn.getconn());
			boolean f=dao.register(u);
			HttpSession ser=req.getSession();
			if(f) {
				ser.setAttribute("sucMsg", "Register Successfully");
			resp.sendRedirect("sinup.jsp");	
			}else {
				ser.setAttribute("errorMsg", "Somthing Worng");
				resp.sendRedirect("sinup.jsp");	
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
