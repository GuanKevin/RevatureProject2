$(document).ready(function() {
	
	function getExam(exam) {
		var html = "";
		html += "<div>Name: " + exam.name + "</div>"
				+ "<div>Start: " +  new Date(exam.start) + "</div>"
				+ "<div>End: " + new Date(exam.end) + "</div>"
				+ "<div>Questions:</div>";
		html += "<ol>"
		$.each(exam.questionSet, function(index, temp) {
			html += "<li>"
					+"<div>Level: " + temp.level + "</div>"
					+"<div>Question : " + temp.question + "</div>"
					+"<div>Answer : " + temp.answer + "</div>"
					+"<div>Choice 1: " + temp.choiceOne + "</div>"
					+"<div>Choice 2: " + temp.choiceTwo + "</div>"
					+"<div>Choice 3: " + temp.choiceThree + "</div>"
					+"</li>";
		});
		html += "</ol>";
		$("#body").append(html);
	}
	
	
	function insertClasses(allCourses){
		var courseCon = $("#sidebarMenu");
		var html = "";
		
		$.each(allCourses, function(index, course) {
			var exams = course.exams;
			html += "<li class='list-group-item'>";				
			html += "<div class='panel-heading courses' data-toggle='collapse' data-target='#course" + index + "'>";
			html += "<h4>" + course.courseName + "</h4>";
			html += "</div>";
			html += "<div class='collapse' id='course" + index + "'>";
			if(exams != undefined) {
				html += "<ul class='list-group'>";
				$.each(exams, function(index, exam) {
					html += "<li class='list-group-item exams' id='" + exam.id + "'>" + exam.name + "</li>";
				});
				html += "</ul>";
			}
			html += "</div>";
			html += "</li>";
			})	
		$(courseCon).append(html);
	};
		
	
	function displayExam(exam){
		$("mainBody").append(exam.name);
	}
	
		var studentUsername = "Student001";
		$.ajax("http://localhost:7001/MathMaster/Student/"+ studentUsername, {
		    method : 'GET',
		    dataType : 'json',
		    success : function(response) {
		      $("#id").append("<p>" + response + "</p>");
		      $("#displayUser h4").text(response.firstName + " " + response.lastName)
		      var allCourses = response.courseSet;
		      var allTakenExams = response.takenExams;
			
		      insertClasses(allCourses);
		      
		      $('body').on('click', 'li.exams', function() {
		    	var examId = $(this).attr('id');
		  		$.each(allCourses, function(index, course) {
		  			$.each(course.exams, function(index, exam) {
		  				if(exam.id == examId) {
		  					$('#mainBody').html(examId);
		  				}
		  			})
		  		} )
		  	  });
		      console.log(response);
		    }
		});
	
	
//	function Question(level,question, answer, choiceOne, choiceTwo, choiceThree) {
//		this.level = level;
//		this.question = question;
//		this.answer = answer;
//		this.choiceOne = choiceOne;
//		this.choiceTwo = choiceTwo;
//		this.choiceThree = choiceThree;
//	}
//	
//	$("#add").click(function(e) {
//		e.preventDefault();
//		
//		$("#add").prop("disabled", true);
//		var level = "12"
//		var question = "How are you?";
//		var answer = "Good";
//		var choiceOne = "Bad";
//		var choiceTwo = "Sad";
//		var choiceThree = "chad";
//		
//		var questionCreated = new Question(level, question, answer, choiceOne, choiceTwo, choiceThree);
//		$.ajax("http://localhost:7001/MathMaster/question/new/121", {/* 54 is the exam ID */
//			method : "POST",
//			dataType : 'json',
//			data : JSON.stringify(questionCreated),
//			contentType: "application/json",
//			success : function(response) {
//				console.log("Hey");
//			},
//		});
//	});
})