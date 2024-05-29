package jp.co.aforce.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jp.co.aforce.beans.UserCredentials;
import jp.co.aforce.dao.LoginDAO;
import jp.co.aforce.login.PasswordUtil;

@WebServlet("/jsp/login-trial")
	public class LoginTrialServlet extends HttpServlet {
		public void doPost(
				HttpServletRequest request, HttpServletResponse response
				) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			LoginDAO loginDAO=new LoginDAO();
			String userId=request.getParameter("user_id");
			String password=request.getParameter("password");
			request.setAttribute("userId", userId);
			try {
				UserCredentials uc = loginDAO.getUserCredentials(userId);
				if(uc == null) {
					request.getSession().setAttribute("message", "IDもしくはパスワードが違います");
					request.getRequestDispatcher("login.jsp")
					.forward(request, response);
					return;
				}
				String passwordHash = uc.getPasswordHash();
				String salt = uc.getSalt();				
				String testHash = PasswordUtil.hashPassword(password, salt);
				if(!testHash.equals(passwordHash)) {
					request.getSession().setAttribute("message", "IDもしくはパスワードが違います");
					request.getRequestDispatcher("login.jsp")
					.forward(request, response);
					return;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				loginDAO.recordLastLogin(userId);
			} catch (Exception e) {
				e.printStackTrace();
			}
			HttpSession session=request.getSession();
			session.setAttribute("userId", userId);
			response.sendRedirect("welcome.jsp");
			
			
		}
	}

