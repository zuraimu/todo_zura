package todo;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//DBから全データを受け取り
		TodoService tds = new TodoService();
		List<IndexForm> todoList = tds.findAll();
		request.setAttribute("list", todoList);
		
		//円グラフのデータ集計
		Map<String,Long> priorityMap = todoList.stream().collect(Collectors.groupingBy(IndexForm::getPriority,Collectors.counting()));
		List<String> labels = priorityMap.keySet().stream().toList();
		List<Long> values = labels.stream().map(priorityMap::get).toList();
		request.setAttribute("labels", labels);
		request.setAttribute("values", values);
		
		request.getRequestDispatcher("/todo/index.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
