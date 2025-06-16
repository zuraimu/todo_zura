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

		try (Connection conn = Util.getTodoConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				IndexForm m = new IndexForm(rs.getString("title"), rs.getString("priority"), rs.getDate("limit_date"),rs.getString("check"));
				list.add(m);
			}
			return list;

		} catch (SQLException e) {

			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	//レコードを追加
	public void register(InsertForm form) {
		String sql = "Insert into todo(title,priority,limit_date) values(?,?,?)";

		try (Connection conn = Util.getTodoConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, form.getTitle());
			ps.setString(2, form.getPriority());
			ps.setDate(3, form.getLimit());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(UpdateForm form) {
		String sql = "UPDATE todo SET title=?,priority=?,limit_date=? WHERE id = (SELECT id FROM (SELECT id FROM todo ORDER BY id ASC LIMIT 1 OFFSET ?) AS sub)";

		try (
				Connection conn = Util.getTodoConnection();
				PreparedStatement ps = conn.prepareStatement(sql);) {

			
			ps.setString(1, form.getTitle());
			ps.setString(2, form.getPriority());
			ps.setDate(3, form.getLimit());
			ps.setInt(4, form.getIndex()-1);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void destroy(int index) {
		String sql = "DELETE FROM todo WHERE id = (SELECT id FROM (SELECT id FROM todo ORDER BY id ASC LIMIT 1 OFFSET ?) AS sub)";
		try (Connection conn = Util.getTodoConnection();
				PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, index - 1);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
