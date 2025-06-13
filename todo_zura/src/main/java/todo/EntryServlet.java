package todo;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/EntryServlet")
public class EntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/todo/entry.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String priority = request.getParameter("priority");
		String title = request.getParameter("title");
		
		InputError ie = new InputError();
		List<String> errorAry = ie.inputError(title, priority);
		//String -> Date　変換処理
		String limitStr = request.getParameter("limit");
		Date limit = null;
		try { 
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    java.util.Date utilDate = sdf.parse(limitStr);
		    limit = new Date(utilDate.getTime());
		} catch (ParseException e) {
		    errorAry.add("yyyy-MM-ddの形式で入力してください。");
		}
		
		if(errorAry.size() > 0) {
			request.setAttribute("error", true);
			request.setAttribute("errorAry", errorAry);
			request.setAttribute("title",title);
			request.setAttribute("priority",priority);
			request.setAttribute("limit",limitStr);
			request.getRequestDispatcher("/todo/entry.jsp").forward(request, response);
		}else {
			//DBへの追加
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
