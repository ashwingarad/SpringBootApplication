$(function() {

	$("#userProfileForm").validate({
		rules: {
			firstName: "required",
			lastName: "required",
			username: {
				required: true,
				minlength: 4
			},
			emailId: {
				required: true,
				email: true
			},
			mobile: {
				required: true,
				minlength: 10,
				maxlength: 14
			},
			password1: {
				required: true,
				minlength: 4
			},
			password: {
				equalTo: "#password1"
			}
		},
		messages: {
			firstName: "Please Enter Valid name",
			lastName: "Please Enter Valid name",
			emailId: "Please Enter Valid email id",
			password: "Both password should match",
			username: {
				required: "Enter username",
				minlength: "Username should be minimum 4 character"
			},
			mobile: {
				required: "Please Enter contact number",
				minlength: "Your contact number must be 10 or more digits",
				maxlength: "Your contact number should not be more than 14 digits"
			},
			password1: {
				required: "Enter password",
				minlength: "Password length should be min 4 characters"
			}
		},
		submitHandler: function(form) {
			form.action = "./registerUser";
			form.submit();
		}
	});

	$("#userLoginForm").validate({
		rules: {
			username: {
				required: true,
				minlength: 4
			},
			password: "required"
		},
		messages: {
			username: {
				required: "Username required",
				minlength: "Username should be minimum 4 character"
			},
			password: "Password should not empty"
		},
		submitHandler(form) {
			form.action = "./doLogin";
			form.submit();
		}
	});

	$("#btnSignUp").click(function() {
		document.location.href = "/user/signup";
	});

});