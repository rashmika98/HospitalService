/**
 * 
 */



$(document).ready(function() {
	$("#alertSuccess").hide();
	$("#alertError").hide();
});















//SAVE ============================================
$(document).on("click", "#btnSave", function(event) {

	// Clear alerts---------------------
	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");
	$("#alertError").hide();

	// Form validation-------------------
	var status = validateHospitalForm();

	if (status != true) {
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}

	// If valid------------------------
	var type = ($("#hidItemIDSave").val() == "") ? "POST" : "PUT";

	$.ajax({
		url : "HospitalsAPI",
		type : type,
		data : $("#formHospital").serialize(),
		dataType : "text",
		complete : function(response, status) {
			onItemSaveComplete(response.responseText, status);
			/*alert(response.responseText);*/
		}
	});
	

});

function onItemSaveComplete(response, status) {
	
	
	if (status == "success") {
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success") {
			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show();
			$("#divItemsGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error") {
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error") {
		$("#alertError").text("Error while saving.");
		$("#alertError").show();
	} else {
		$("#alertError").text("Unknown error while saving..");
		$("#alertError").show();
	}
	$("#hidItemIDSave").val("");
	$("#formHospital")[0].reset();

}

//UPDATE==========================================
$(document).on(	"click",".btnUpdate",function(event) {

			$("#hidItemIDSave").val($(this).closest("tr").find('#hidItemIDUpdate').val());
			$("#HRegID").val($(this).closest("tr").find('td:eq(0)').text());
			$("#HName").val($(this).closest("tr").find('td:eq(1)').text());
			$("#HAddress").val($(this).closest("tr").find('td:eq(2)').text());
			$("#HCity").val($(this).closest("tr").find('td:eq(3)').text());
			$("#HDestrict").val($(this).closest("tr").find('td:eq(4)').text());
			$("#HProvince").val($(this).closest("tr").find('td:eq(5)').text());
			$("#HEmail").val($(this).closest("tr").find('td:eq(6)').text());
			$("#HContactNum").val($(this).closest("tr").find('td:eq(7)').text());
			$("#HUsername").val($(this).closest("tr").find('td:eq(8)').text());
			$("#HPassword").val($(this).closest("tr").find('td:eq(9)').text());
			
		});





























$(document).on("click", ".btnRemove", function(event) {
	$.ajax({
		url : "HospitalsAPI",
		type : "DELETE",
		data : "HRegID=" + $(this).data("hospitalid"),
		dataType : "text",
		complete : function(response, status) {
			onItemDeleteComplete(response.responseText, status);
			/*alert(response);*/
		}
	});
});

function onItemDeleteComplete(response, status) {
	if (status == "success") {
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success") {
			$("#alertSuccess").text("Successfully deleted.");
			$("#alertSuccess").show();
			$("#divItemsGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error") {
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error") {
		$("#alertError").text("Error while deleting.");
		$("#alertError").show();
	} else {
		$("#alertError").text("Unknown error while deleting..");
		$("#alertError").show();
	}
	
}














//CLIENTMODEL=========================================================================
function validateHospitalForm() {

	// LAB REGISTRATION NUMBER--------------------------
	if ($("#HRegID").val().trim() == "") {
		return "Insert Hospital Registration Number.";
	}

	// LAB NAME------------------------------
	if ($("#HName").val().trim() == "") {
		return "Insert Hospital Name.";
	}

	// ADDRRESS-------------------------------
	if ($("#HAddress").val().trim() == "") {
		return "Insert Address.";
	}
	
	// CITY-------------------------------
	if ($("#HCity").val().trim() == "") {
		return "Insert City.";
	}
	
	// DESTRICT-------------------------------
	if ($("#HDestrict").val().trim() == "") {
		return "Insert Destrict.";
	}
	
	// PROVINCE-----------------------------------
	if ($("#HProvince").val().trim() == "") {
		return "Insert Province.";
	}

	// EMAIL-------------------------------
	if ($("#HEmail").val().trim() == "") {
		return "Insert Email.";
	}
	
	// CONTACT NUMBER-------------------------------
	if ($("#HContactNum").val().trim() == "") {
		return "Insert Contact Number.";
	}
	
	// USERNAME-------------------------------
	if ($("#HUsername").val().trim() == "") {
		return "Insert User Name.";
	}

	// PASSWORD------------------------
	if ($("#HPassword").val().trim() == "") {
		return "Insert Password.";
	}
	
	

	return true;
}