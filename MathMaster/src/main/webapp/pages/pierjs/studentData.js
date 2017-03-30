$(document).ready(function() {
	var studentUsername = "Student001";
	window.data;
	$.ajax("http://localhost:7001/MathMaster/Student/" + studentUsername, {
		method : 'GET',
		dataType : 'json',
		success : function(response) {
			window.data = response;
		},
		async: false
	})
	return window.data;
})