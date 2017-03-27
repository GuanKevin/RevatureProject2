$(document).ready(function() {

/**
 * sidebarMenu
 *  - li class list group item
 *   - div class="panel-heading" data-toggle="collapse" data-target="#classes1"
 *    - h4 class name
 *   - div class="collapse" id="classes1">
 */
	function insertClasses(allCourses){
		var courseCon = $("#sidebarMenu");
		var html = "";
		for(var i = 0; i < allCourses.length; i++){
			var allCourseExams = allCourses[i].exams;
			html += "<li class='list-group-item'>";				
			html += "<div class='panel-heading' data-toggle='collapse' data-target='#course" + i + "'>";
			html += "<h4>" + allCourses[i].courseName + "</h4>";
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
	};
		
	var studentUsername = "Student001";
	  $.ajax("http://localhost:8081/MathMaster/Student/"+ studentUsername, {
	    method : 'GET',
	    dataType : 'json',
	    success : function(response) {
	      $("#id").append("<p>" + response + "</p>");

	      var allCourses = response.courseSet;
	      var allTakenExams = response.takenExams;
		
	      insertClasses(allCourses);
		
	      console.log(response.courseSet);
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