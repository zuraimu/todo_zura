package todo;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class InputError{
	
	//形式が正確かを判定して、だめならエラーリストに代入。結果としてlimitのDate型を返す。
	public Date inputError(List<String> errorAry, String title, String priority, String limitStr){
		
		if (isEmp(title)) {
			errorAry.add("タイトルは入力必須です。");
		}
		
		if(isEmp(priority)) {
			errorAry.add("重要度の入力をわすれてないか？");
		}
		
		Date limit = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date utilDate = sdf.parse(limitStr);
			limit = new Date(utilDate.getTime());
		} catch (ParseException e) {
			errorAry.add("yyyy-MM-ddの形式で入力してください。");
		}
		
		return limit;
	}
	
	private static boolean isEmp(String str) {
		return (str == null || str.isEmpty());
	}
}