$(document).ready(function() {
	var teacherUsername = "Code_Blooded_KG";
	window.teacherData;
	$.ajax("http://localhost:7001/MathMaster/Teacher/" + teacherUsername, {
		method : 'GET',
		dataType : 'json',
		success : function(response) {
			window.teacherData = response;
		},
		async: false
	})
	return window.teacherData;
})