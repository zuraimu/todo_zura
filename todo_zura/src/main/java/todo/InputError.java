package todo;

import java.util.ArrayList;
import java.util.List;

public class InputError {
	public List<String> inputError(String title, String priority){
		
		List<String> errorAry = new ArrayList<>(); //エラー複数取得用
		
		if (isEmp(title)) {
			errorAry.add("タイトルは入力必須です。");
		}
		
		if(isEmp(priority)) {
			errorAry.add("重要度の入力をわすれてないか？");
		}
		
		return errorAry;
	}
	
	private static boolean isEmp(String str) {
		return (str == null || str.isEmpty());
	}
}
