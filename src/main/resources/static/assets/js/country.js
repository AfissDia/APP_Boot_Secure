
$('document').ready(function() {
	
	$('table #editbtn').on('click',function(event){
		event.preventDefault();
		var href= $(this).attr('href');		
		$.get(href, function(country, status){
			$('#idEdit').val(country.id);
			$('#descriptionEdit').val(country.description);
			$('#codeEdit').val(country.code);
			$('#continentEdit').val(country.continent);
			$('#capitalEdit').val(country.capital);
			$('#nationalityEdit').val(country.nationality);
		});
		$('#editModal').modal('show');
	});

	$('table #deletebtn').on('click',function(event) {
		event.preventDefault();
		$('#deleteModal').modal();
	});
});