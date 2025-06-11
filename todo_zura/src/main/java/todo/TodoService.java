package todo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TodoService {
	public void findAll() {
		String sql = "INSERT INTO todo(name,type,level) VALUES(?,?,?)";

		try (Connection conn = Util.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
