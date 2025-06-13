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

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//入力をフォワード
		String title = request.getParameter("title");
		String priority = request.getParameter("priority");
		String limit = request.getParameter("limit");
		request.setAttribute("title", title);
		request.setAttribute("priority", priority);
		request.setAttribute("limit", limit);
				
		//indexをsessionに代入
		HttpSession session = request.getSession();
		String index = request.getParameter("index");
		session.setAttribute("index", index);
		
		request.getRequestDispatcher("/todo/update.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int index = Integer.parseInt((String)session.getAttribute("index"));
		
		String priority = request.getParameter("priority");
		String title = request.getParameter("title");
		
		InputError ie = new InputError();
		List<String> errorAry = ie.inputError(title, priority);
		
		String limitStr = request.getParameter("limit");
		Date limit = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date utilDate = sdf.parse(limitStr);
			limit = new Date(utilDate.getTime());
		} catch (ParseException e) {
			errorAry.add("yyyy-MM-ddの形式で入力してください。");
		}

		if (errorAry.size() > 0) {
			request.setAttribute("error", true);
			request.setAttribute("errorAry", errorAry);
			request.setAttribute("title", title);
			request.setAttribute("priority", priority);
			request.setAttribute("limit", limitStr);
			request.getRequestDispatcher("/todo/update.jsp").forward(request, response);
		} else {
			TodoService tds = new TodoService();
			UpdateForm uf = new UpdateForm(index, title, priority, limit);

			tds.update(uf);

			//成功メッセージの表示
			session.setAttribute("success", true);
			session.setAttribute("successMsg", "#" + index + "を更新しました。");

			response.sendRedirect("IndexServlet");
		}

	}
}
