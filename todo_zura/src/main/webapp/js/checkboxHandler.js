//HTMLがすべて読み込まれてから実行される。jsのインポート場所に依存せず最後に実行される。
document.addEventListener("DOMContentLoaded", () => {
	
	//最初に指定クラスのチェックボックスをすべて取得する。
	// それに対して以下の変更時の行動などを定義する。
	document.querySelectorAll(".check-item").forEach((checkbox) => {
		//チェックボックスの状態が変更された際に呼び出される。
		checkbox.addEventListener("change", function() {
			const todoId = this.dataset.id;//data-idにの値を取得
			const isChecked = this.checked;//checkedの記載があるかboolean

			//AJAX開始。
			// ページ全体を再読み込みせずに、バックグラウンドサーバーと通信し、
			// 一部だけを取得更新できる仕組み。
			fetch("UpdateCheckServlet", {
				method: "POST",
				//hedderの形式でbodyの変数を送りますと4いう記載。
				headers: {
					"Content-Type": "application/x-www-form-urlencoded",
				},
				body: `id=${encodeURIComponent(todoId)}&done=${isChecked}`
			})
				.then(response => { //サーバーからのレスポンスを受け取る。
					if (!response.ok) throw new Error("通信エラー");
					//次のthenに値が渡される。
					return response.text();
				})
				.then(result => {
					console.log("更新結果:", result);
					// 必要ならDOM更新処理など
					
					
				})
				.catch(error => {
					console.error("通信エラー:", error);
					alert("更新に失敗しました。");
				});
		});
	});
});
