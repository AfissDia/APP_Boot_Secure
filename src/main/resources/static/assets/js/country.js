
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

		var href= $(this).attr('href');

		$('#confirmDeleteButton').attr('href',href);

		$('#deleteModal').modal('show');
	});

	$('table #detailsButton').on('click',function(event) {
		event.preventDefault();
		var href= $(this).attr('href');
		$.get(href, function(country, status){
			$('#idDetails').val(country.id);
			$('#descriptionDetails').val(country.description);
			$('#codeDetails').val(country.code);
			$('#lastModifiedByDetails').val(country.lastModifiedBy);
			$('#lastModifiedDateDetails').val(country.lastModifiedDate.substr(0,19).replace("T", " "));
		});
		$('#detailsModal').modal('show');
	});
});