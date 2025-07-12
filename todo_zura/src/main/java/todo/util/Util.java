package todo.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

	public static Connection getTodoConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/todolist_ezura", "root", "");
		return conn;
	}

	public static String toSha256(String input) {
		try {
			// ハッシュ関数のインスタンス取得（SHA-256）
			MessageDigest digest = MessageDigest.getInstance("SHA-256");

			// バイト配列に変換しハッシュ化
			byte[] hashBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));

			// ハッシュ値を16進数文字列に変換して返却
			return bytesToHex(hashBytes);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("SHA-256アルゴリズムがサポートされていません", e);
		}
	}

	// バイト配列を16進数文字列に変換
	private static String bytesToHex(byte[] bytes) {
		StringBuilder sb = new StringBuilder();
		for (byte b : bytes) {
			sb.append(String.format("%02x", b)); // 2桁16進数でフォーマット
		}
		return sb.toString();
	}
}
