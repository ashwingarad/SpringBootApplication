$(function() {

	$("#employeeForm").validate({
		rules : {
			ename : "required",
			salary : {
				required : true,
				minlength : 5
			}
		},
		messages : {
			ename : "Please Enter Valid name",
			salary : {
				required : "Please Enter salary",
				minlength : "Your salary must be 5 or more digits"
			}
		},
		submitHandler : function(form) {
			form.action = "./save";
			form.submit();
		}
	})

});

function editEmp(id) {
	document.location.href = "./home?id=" + encodeURIComponent('#/@:=/#' + id);
}

function deleteEmp(id) {
	if (confirm('Do you wanna delete this record?')) {
		document.location.href = "./delete?id=" + encodeURIComponent('#/@:=/#' + id);
	}
}