	$(document).ready(function() {
		refresh();
		
		//here change it with my new html and css stuff
/*		$("#new-exam").click(function() {
			$('#mainBody').append(
					'<h4>Enter a new question</h4>'+
					'<form action="#">'+
					'<input type="text" id="level" placeholder="LEVEL">'+
					'<input type="text" id="question" placeholder="QUESTION">'+ '<br/>'+
					'<input type="text" id="answer" placeholder="ANSWER">'+
					'<input type="text" id="choiceOne" placeholder="CHOICE ONE">'+
					'<input type="text" id="choiceTwo" placeholder="CHOICE TWO">'+
					'<input type="text" id="choiceThree" placeholder="CHOICE THREE">'+
					'<button id="add-question">Add</button></form>'+
					'<div class="col-md-6"><table class="table table-striped">'+
					'<thead><tr><th>Level</th><th>Question</th><th>Answer</th>'+
					'<th>Choice One</th><th>Choice Two</th><th>Choice Three</th>'+
					'</tr></thead><tbody></tbody></table></div>'+
					'<button id="submit-exam">Submit</button>');
		})*/	
		
		
		$("#new-exam").click(function() {
			$('#mainBody').append(
					'');
		})
		
	
		function QuestionObj(level,question, answer, choiceOne, choiceTwo, choiceThree) {
			this.level = level;
			this.question = question;
			this.answer = answer;
			this.choiceOne = choiceOne;
			this.choiceTwo = choiceTwo;
			this.choiceThree = choiceThree;
		}
		
	/*  HERE CHANGE IT TO CLEAR THE VIEW AND LOAD THE COURSES VIEW */
	    $("#submit-exam").click(function(){
	    
			$.ajax("http://localhost:7001/MathMaster/question/create", {
				method : "POST",
				success : function() {
					tablewipe();
					/* should clear view */
					console.log("good job denise");
				}
			});
		}) 
		
		// when add is clicked it will add a question to the list in the controller
		$("#add-question").click(function() {
		    $("#add-question").prop("disabled", true); 
			var level = $("#level").val();
			var question = $("#question").val();
			var answer = $("#answer").val();
			var choiceOne = $("#choiceOne").val();
			var choiceTwo = $("#choiceTwo").val();
			var choiceThree = $("#choiceThree").val();
			
			var questionCreated = new QuestionObj(level, question, answer, choiceOne, choiceTwo, choiceThree);
	
			$.ajax("http://localhost:7001/MathMaster/question/new/141", {/* 87 is the exam ID */
				method : "POST",
				data : JSON.stringify(questionCreated),
				headers : {
					/* "Accept" : "application/json", */
					"Content-Type" : "application/json"
				},
				success : function(response) {
				    $(".alert-success").text(response);
					$(".alert-success").fadeIn();
					window.setTimeout(function(response) {
						$(".alert-success").fadeOut();
						$("#add").prop("disabled", false);
					}, 3000);
					$("form")[0].reset(); //reset form fields in the form
					refresh();
				},
				error: function() {
					$(".alert-danger").fadeIn();
					window.setTimeout(function(response) {
						$(".alert-danger").fadeOut();
						$("#add").prop("disabled", false);
					}, 3000);
				}
			});
		    return false; 
		});
		
 		function refresh() {
			$.ajax("http://localhost:7001/MathMaster/question/all", {
				method : "GET",
				headers : {
					"Accept" : "application/json"
				},
/* 				dataType : "json",
 */				success : function(response) {
					console.log(response);
					tablewipe();
					tableload(response);
				}
			});
		} 
		
		// clears table body.. to reload with the new data
		function tablewipe() {
			$(".table tbody").empty();
		}
		function tableload(response) {
			$.each(response, function(index, temp) {
				$(".table tbody").append("<tr>");
				$(".table tbody").append("<td>" + temp.level + "</td>");
				$(".table tbody").append("<td>" + temp.question + "</td>");
				$(".table tbody").append("<td>" + temp.answer + "</td>");
				$(".table tbody").append("<td>" + temp.choiceOne + "</td>");
				$(".table tbody").append("<td>" + temp.choiceTwo + "</td>");
				$(".table tbody").append("<td>" + temp.choiceThree + "</td>");
				$(".table tbody").append("</tr>");
			});
		}
	});