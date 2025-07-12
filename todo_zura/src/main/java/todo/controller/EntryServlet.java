package todo.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import todo.form.InsertForm;
import todo.service.TodoService;
import todo.util.InputError;

@WebServlet("/EntryServlet")
public class EntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/todo/entry.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//値の取得と代入
		HttpSession session = request.getSession();
		String priority = request.getParameter("priority");
		String title = request.getParameter("title");
		String limitStr = request.getParameter("limit");
		
		//エラーの検出
		InputError ie = new InputError();
		List<String> errorAry = new ArrayList<>();
		Date limit = ie.inputError(errorAry,title, priority,limitStr);
				
		//エラーが出た場合フォワード
		if(errorAry.size() > 0) {
			request.setAttribute("error", true);
			request.setAttribute("errorAry", errorAry);
			request.setAttribute("title",title);
			request.setAttribute("priority",priority);
			request.setAttribute("limit",limitStr);
			request.getRequestDispatcher("/todo/entry.jsp").forward(request, response);
			
		//エラーがなければDB追加				
		}else {
			TodoService tds = new TodoService();
			InsertForm ef = new InsertForm(title,priority,limit);
			tds.register(ef);
			
			//成功メッセージの表示
			session.setAttribute("success", true);
			session.setAttribute("successMsg", title + "(" + limit +")を追加しました。");
			response.sendRedirect("IndexServlet");
		}
	}
}
