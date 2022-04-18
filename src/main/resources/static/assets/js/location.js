/**
 *
 */

$('document').ready(function() {

	$('.table #editbtn').on('click',function(event){
		event.preventDefault();
		var href= $(this).attr('href');
		$.get(href, function(location, status){
			$('#idEdit').val(location.id);
			$('#cityEdit').val(location.city);
			$('#descriptionEdi').val(location.description);
			$('#adressEdit').val(location.adress);
			$('#ddlCountryEdit').val(location.countryid);
			$('#ddlStateEdit').val(location.stateid);
			$('#detailsEdit').val(location.details);
		});
		$('#editModal').modal('show');
	});

	$('.table #detailsbtn').on('click',function(event) {
		event.preventDefault();
		var href= $(this).attr('href');
		$.get(href, function(location, status){
			$('#idDetails').val(location.id);
			$('#cityDetails').val(location.city);
			$('#descriptionDetails').val(location.description);
			$('#addressDetails').val(location.adress);
			$('#ddlCountryDetails').val(location.countryid);
			$('#ddlStateDetails').val(location.stateid);
			$('#detailsDetails').val(location.details);
			$('#lastModifiedByDetails').val(location.lastModifiedBy);
			$('#lastModifiedDateDetails').val(location.lastModifiedDate.substr(0,19).replace("T", " "));
		});
		$('#detailsModal').modal('show');
	});

	/*$('.table #deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href', href);
		$('#deleteModal').modal();
	});*/
	$('table #deletebtn').on('click',function(event) {
		event.preventDefault();
		var href= $(this).attr('href');
		$('#confirmDeleteButton').attr('href',href);
		$('#deleteModal').modal('show');
	});
});