package todo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import todo.form.AccountForm;
import todo.service.AccountService;
import todo.util.InputError;
import todo.util.Util;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		request.getRequestDispatcher("/todo/login.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		
		InputError ie = new InputError();
		List<String> errorAry = new ArrayList<>();
		ie.inputError(errorAry, user, pass);

		//エラーが出た場合フォワード
		if (errorAry.size() > 0) {
			request.setAttribute("error", true);
			request.setAttribute("errorAry", errorAry);
			request.setAttribute("user", user);
			request.setAttribute("pass", pass);
			request.getRequestDispatcher("/todo/login.jsp").forward(request, response);

			//エラーがなければDBと照合
		} else {
			AccountService tds = new AccountService();
			String hashPass = Util.toSha256(pass);
			AccountForm af = new AccountForm(user, hashPass);
			if(tds.collation(af)) {
				session.setAttribute("user", user);
				response.sendRedirect("IndexServlet");
			}else {
				errorAry.add("ユーザー名もしくはパスワードが間違っています。");
				request.setAttribute("error", true);
				request.setAttribute("errorAry", errorAry);
				request.getRequestDispatcher("/todo/login.jsp").forward(request, response);
			}
		}
	}
}
