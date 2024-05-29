package jp.co.aforce.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jp.co.aforce.dao.RegistrationDAO;
import jp.co.aforce.login.PasswordUtil;

@WebServlet("/jsp/registration")
public class RegistrationServlet extends HttpServlet{
	public void doPost(
			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
		String userId = request.getParameter("user_id");
		String password = request.getParameter("password");
		
		String salt = PasswordUtil.generateSalt();
		String passwordHash = PasswordUtil.hashPassword(password, salt);
		
		HttpSession session = request.getSession();
		RegistrationDAO regDAO = new RegistrationDAO();
		try {
			if(regDAO.isExistID(userId)) {
				session.setAttribute("registerMessage", "既にこのIDは利用されています、他のIDでお試しください。");
				response.sendRedirect("registration.jsp");
			} else {
				regDAO.register(userId, passwordHash, salt);
				response.sendRedirect("registration_success.jsp");
			}
		
			
		} catch (Exception e) {
			request.getSession().setAttribute("registerMessage", "会員の登録に失敗しました。");
			e.printStackTrace();
			response.sendRedirect("registration.jsp");
		}

	}
}
