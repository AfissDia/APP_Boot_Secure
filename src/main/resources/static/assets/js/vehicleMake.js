$('document').ready(function() {
	
	$('.table #editbtn').on('click',function(event){
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(vehicleMake, status){
			$('#idEdit').val(vehicleMake.id);
			$('#descriptionEdit').val(vehicleMake.description);
			$('#detailsEdit').val(vehicleMake.details);
		});			
		$('#editModal').modal('show');
	});
	
	$('.table #detailsbtn').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(vehicleMake, status){
			$('#idDetails').val(vehicleMake.id);
			$('#descriptionDetails').val(vehicleMake.description);
			$('#detailsDetails').val(vehicleMake.details);
			$('#lastModifiedByDetails').val(vehicleMake.lastModifiedBy);
			$('#lastModifiedDateDetails').val(vehicleMake.lastModifiedDate.substr(0,19).replace("T", " "));
		});			
		$('#detailsModal').modal('show');
	});	
	
	$('.table #deletebtn').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href', href);
		$('#deleteModal').modal('show');
	});	
});