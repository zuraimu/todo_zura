window.addEventListener("DOMContentLoaded", function () {
	if (!window.chartLabels || !window.chartValues) {
		console.error("chartLabels または chartValues が未定義です");
		return;
	}

	const ctx = document.getElementById('chart').getContext('2d');
	new Chart(ctx, {
		type: 'pie',
		data: {
			labels: chartLabels,
			datasets: [{
				data: chartValues,
				backgroundColor: [
					'rgba(255, 99, 132, 0.6)',
					'rgba(54, 162, 235, 0.6)',
					'rgba(255, 206, 86, 0.6)'
				]
			}]
		},
		options: {
			responsive: false,
			plugins: {
				legend: {
					position: 'bottom'
				}
			}
		}
	});
});