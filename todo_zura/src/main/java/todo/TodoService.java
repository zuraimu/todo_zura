package todo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TodoService {

	//DB内のデータをリストとして返す。
	public List<IndexForm> findAll() {
		String sql = "SELECT * FROM todo";
		List<IndexForm> list = new ArrayList<IndexForm>();

		try (Connection conn = Util.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			
			while (rs.next()) {
				IndexForm m = new IndexForm(rs.getString("title"), rs.getString("priority"), rs.getDate("limit"));
				list.add(m);
			}
			return list;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return Collections.emptyList();
		}
	}
}
