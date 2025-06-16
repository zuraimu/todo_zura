package todo;

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
		
		
		//値の取得と代入
		HttpSession session = request.getSession();
		int index = Integer.parseInt((String)session.getAttribute("index"));
		String priority = request.getParameter("priority");
		String title = request.getParameter("title");
		String limitStr = request.getParameter("limit");
		
		//取得した値の形式検査
		InputError ie = new InputError();
		List<String> errorAry = new ArrayList<>();
 		Date limit = ie.inputError(errorAry,title, priority,limitStr);
		
 		//エラーが発生した場合フォワード
		if (errorAry.size() > 0) {
			request.setAttribute("error", true);
			request.setAttribute("errorAry", errorAry);
			request.setAttribute("title", title);
			request.setAttribute("priority", priority);
			request.setAttribute("limit", limitStr);
			request.getRequestDispatcher("/todo/update.jsp").forward(request, response);
			
		//エラーがなければDB追加
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
