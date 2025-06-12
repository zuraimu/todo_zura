package todo;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String index = request.getParameter("index");
		session.setAttribute("index", index);
		request.getRequestDispatcher("/todo/update.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int index = Integer.parseInt((String)session.getAttribute("index"));

		
		List<String> errorAry = new ArrayList<>(); //エラー複数取得用

		//フォームの値取得
		String priority = request.getParameter("priority");
		String title = request.getParameter("title");
		if (isTitleEmp(title)) {
			errorAry.add("タイトルは入力必須です。");
		}
		//String -> Date　変換処理
		String limitStr = request.getParameter("limit");
		Date limit = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			java.util.Date utilDate = sdf.parse(limitStr);
			limit = new Date(utilDate.getTime());
		} catch (ParseException e) {
			errorAry.add("yyyy/MM/ddの形式で入力してください。");
		}

		if (errorAry.size() > 0) {
			session.setAttribute("error", true);
			session.setAttribute("errorAry", errorAry);
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

	//タイトルが空かどうか
	private static boolean isTitleEmp(String title) {
		return (title == null || title.isEmpty());
	}

}
