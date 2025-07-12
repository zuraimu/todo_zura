package todo.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import todo.form.AccountForm;
import todo.util.Util;

public class AccountService {
	//レコードを追加
	public void register(AccountForm form) {
		String sql = "Insert into account(user,pass) values(?,?)";

		try (Connection conn = Util.getTodoConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, form.getUser());
			ps.setString(2, form.getPass());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean collation(AccountForm form) {
		String sql = "SELECT count(*) FROM account WHERE user = ? AND pass = ?";
		try (Connection conn = Util.getTodoConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
						) {

			ps.setString(1,form.getUser());
			ps.setString(2,form.getPass());
			
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					int count = rs.getInt(1);
					if(count > 0) {
						return true;
					}
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}
		return false;
	}
}
