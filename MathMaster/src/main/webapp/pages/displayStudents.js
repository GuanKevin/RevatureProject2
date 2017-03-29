
$(document).ready(function() {
	$('body').click(function(){
	})     

	$('body').on('click', 'li>.courses', function() {
		$("body").addClass("loading");

		var courseId = $(this).attr('data-courseid');
		console.log($(this).attr('data-courseid'));
		$.ajax("http://localhost:7001/MathMaster/Course/" + courseId + "/students", {
			method : 'GET',
			dataType : 'json',
			success : function(response) {
				console.log(response);
				displayStudentsOnCourseId(response);
			},
			error : function() {
				console.log("Error");
			}
		}).always(function(){
			$("body").removeClass("loading");
		})
	
		function displayStudentsOnCourseId(studentList) {
			$.each(studentList, function(index, stuList) {
				$(".table tbody").append("<tr>");
				$(".table tbody").append("<td>" + stuList.firstName + "</td>");
				$(".table tbody").append("<td>" + stuList.lastName + "</td>");
				$(".table tbody").append("<td>" + stuList.email + "</td>");
				$(".table tbody").append("</tr>");
			});
		}
	})
});