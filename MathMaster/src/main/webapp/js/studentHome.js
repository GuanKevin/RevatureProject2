$(document).ready(
		function() {
			
			function insertClasses(allCourses){
				$(classesContainer).append("<ul class='list-group'>");
				for(var i = 0; i < allCourses.length; i++){
					var allCourseExams = allCourses[i].exams;
					var classContainer = $("<li class='list-group'>" + allCourses[i].courseName + "</li>");
					classContainer.append(insertExams(allCourses[i].exams));
					$(classesContainer).append(classContainer);
				}
				$(classesContainer).append("</ul>");
			};
			
			function insertExams(allExams){
				$(examsContainer).append("<ul class='list-group'>");
				for(var i = 0; i < allExams.length; i++){
					var allCourseExams = allExams[i].exams;
					var examContainer = $("<li class='list-group'>" + allExams[i].name + "</li>");
					$(examsContainer).append(examContainer);
				}
				$(examsContainer).append("</ul>");
			};
			
			var classesContainer = $("#classes");
			var examsContainer = $("#exams");
			
			var studentUsername = "Student001";
			$.ajax("http://localhost:7001/MathMaster/Student/"
					+ studentUsername, {
				method : 'GET',
				dataType : 'json',
				success : function(response) {
					console.log(response);
					var allCourses = response.courseSet;
					var allTakenExams = response.takenExams;
					
					insertClasses(allCourses);
					
					console.log(response.courseSet);
					console.log(response.courseSet[0].exams);
					console.log(response.takenExams);

				}
			});

		})
