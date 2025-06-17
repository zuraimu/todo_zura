document.addEventListener("DOMContentLoaded", () =>{
	const filterSelect = document.getElementById("filter-select");
	const rows = document.querySelectorAll("tbody tr");
	
	const filterRows = (mode) => {
		rows.forEach(row => {
			const checkbox = row.querySelector(".check-item");
			const checked = checkbox?.checked;
			
			if(mode == "all"){
				row.style.display="";
			}else if(mode == "done"){
				row.style.display = checked ? "" : "none";
			}else if(mode == "undone"){
				row.style.display = !checked ? "" : "none";
			}
		});
	}
	
	
	filterSelect.addEventListener("change", () =>{
		filterRows(filterSelect.value);
	});
});