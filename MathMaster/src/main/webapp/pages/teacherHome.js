$(document).ready(function() {
	function displayTeacher(teacher) {
		var courseCon = $("#sidebarMenu");
		var html = "";
		
		console.log(teacher);
		
		for(var i = 0; i < teacher.courses.length; i++){
			var allCourseExams = teacher.courses[i].courseName;
			html += "<li class='list-group-item'>";				
			html += "<div class='panel-heading' data-toggle='collapse' data-target='#course" + i + "'>";
			html += "<h4>" + teacher.courses[i].courseName + "</h4>";
			html += "</div>";
			html += "<div class='collapse' id='course" + i + "'>";
			html += "<ul class='list-group'>";
			for(var j = 0; j < allCourseExams.length; j++){
				html += "<li class='list-group-item exams'>" + allCourseExams[j].name + "</li>";
			}
			html += "</ul>";
			html += "</div>";
			html += "</li>";
		}
		$(courseCon).append(html);
	}
	
	var teacherUsername = "Code_Blooded_KG";
	
	$.ajax("http://localhost:7001/MathMaster/Teacher/" + teacherUsername, {
		method: 'GET',
		dataType: 'json',
		success: function(response) {
		
		var firstName = response.firstName;
		var lastName = response.lastName;
			
		displayTeacher(response);		
		}
	}
			);
	
	
	
	
	$('[data-toggle="offcanvas"]').click(function() {
		$("#navigation").toggleClass("hidden-xs");
	});
});
