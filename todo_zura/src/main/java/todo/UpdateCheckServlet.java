package todo;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateCheckServlet
 */
@WebServlet("/UpdateCheckServlet")

public class UpdateCheckServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    String idStr = request.getParameter("id");
    String doneStr = request.getParameter("done");

    try {
      int id = Integer.parseInt(idStr);
      boolean done = Boolean.parseBoolean(doneStr);

      TodoService service = new TodoService();
      service.updateDoneStatus(id, done); 

      response.setContentType("text/plain");
      response.getWriter().write("OK");
    } catch (Exception e) {
      response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
      response.getWriter().write("NG");
    }
  }
}

