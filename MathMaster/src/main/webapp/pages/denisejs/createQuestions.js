$(document).ready(function() {
	function Exam(name, start, end) {
		this.name = name;
		this.start = start;
		this.end = end;
	}
	//here change it with my new html and css stuff
	var courseId;
	console.log(courseId + " SDF");
	$("#mainBody").on('click', '.new-exam', function() {
		courseId = $(this).data('id');
		console.log(courseId + " SDFDD");
		$('#mainBody').html(
			'<div class="exam-con col-md-8 col-md-offset-2">' + 
    			'<h4 class="text-center">Create a New Exam</h4>'+
    			'<div class="form-group">' +
    				'<label for="name">Exam Name</label>' +
    				'<input type="text" id="name" placeholder="Name" class="form-control">'+
    			'</div>' +
    			'<div class="form-group">' +
    				'<label for="start">Start Date and Time</label>' +
    				'<input type="datetime-local" id="start" class="form-control">'+
    			'</div>' + 
    			'<div class="form-group">' +
    				'<label for="end">Exam Name</label>' +
    				'<input type="datetime-local" id="end" class="form-control">'+
    			'</div>' + 
    			'<div class="form-group text-center">' + 
    				'<button id="create-exam" class="btn">Submit</button>');
				'</div>'
			'</div>';
		})

	$("#mainBody").on("click", "#create-exam", function(){
		$("body").addClass("loading");
		console.log("CourseID" + courseId);
		console.log("name: " + $("#name").val());
		console.log("start: " + new Date($("#start").val()).getTime());
		console.log("end: " + new Date($("#end").val()).getTime());
		var exam = new Exam($("#name").val(), new Date($("#start").val()).getTime(),new Date($("#end").val()).getTime());
		console.log(exam);
		$.ajax("http://localhost:7001/MathMaster/Exam/create/" + courseId, {
			method : "POST",
			data : JSON.stringify(exam),
			headers : {
				"Accept" : "application/json", 
				"Content-Type" : "application/json"
			},
			success : function(response) {
				console.log("response: " + response);
				examId = response;
				console.log("examId: " + examId);
				$('#mainBody').html(
						'<h4>Enter a new question</h4>'+
						'<form action="#">'+
						'<input size = 5 type="text" id="level" placeholder="LEVEL">'+
						'<input type="text" id="question" placeholder="QUESTION">'+
						'<input type="text" id="answer" placeholder="ANSWER">'+
						'<input type="text" id="choiceOne" placeholder="CHOICE ONE">'+
						'<input type="text" id="choiceTwo" placeholder="CHOICE TWO">'+
						'<input type="text" id="choiceThree" placeholder="CHOICE THREE">'+
						'<button id="add-question">Add</button></form>'+
						'<div class="col-md-12"><table class="table table-striped">'+
						'<thead><tr><th>Level</th><th>Question</th><th>Answer</th>'+
						'<th>Choice One</th><th>Choice Two</th><th>Choice Three</th>'+
						'</tr></thead><tbody></tbody></table></div>'+
						'<button id="submit-exam">Submit</button>');
			},
			complete: function() {
				$("body").removeClass("loading");
			},
			error : function() {
				console.log("error");
			}
		})
	})
	
	function QuestionObj(level,question, answer, choiceOne, choiceTwo, choiceThree) {
		this.level = level;
		this.question = question;
		this.answer = answer;
		this.choiceOne = choiceOne;
		this.choiceTwo = choiceTwo
		this.choiceThree = choiceThree;
	}
	
	/*  HERE CHANGE IT TO CLEAR THE VIEW AND LOAD THE COURSES VIEW */
    $("#mainBody").on("click", "#submit-exam", function(){
    	$("body").addClass("loading");
    	console.log("submit");
		$.ajax("http://localhost:7001/MathMaster/question/create", {
			method : "POST",
			success : function() {
				tablewipe();
				/* should clear view */
				console.log("good job denise");
			},
			complete: function() {
				$("#mainBody").html('');
				$("body").removeClass("loading");
			}
		});
	}) 
	
	// when add is clicked it will add a question to the list in the controller
	$("#mainBody").on("click", "#add-question", function() {
		$("body").addClass("loading");
		console.log("added question");
		console.log("examId: " + examId);
	    $("#add-question").prop("disabled", true); 
		var level = $("#level").val();
		var question = $("#question").val();
		var answer = $("#answer").val();
		var choiceOne = $("#choiceOne").val();
		var choiceTwo = $("#choiceTwo").val();
		var choiceThree = $("#choiceThree").val();
		
		var questionCreated = new QuestionObj(level, question, answer, choiceOne, choiceTwo, choiceThree);
		
		$.ajax("http://localhost:7001/MathMaster/question/new/" + examId, {/* 87 is the exam ID */
			method : "POST",
			data : JSON.stringify(questionCreated),
			headers : {
				"Content-Type" : "application/json"
			},
			success : function(response) {
			    $(".alert-success").text(response);
				$(".alert-success").fadeIn();
				window.setTimeout(function(response) {
					$(".alert-success").fadeOut();
					$("#add-question").prop("disabled", false);
				}, 3000);
				$("form")[0].reset(); //reset form fields in the form
				refresh();
			},
			error: function() {
				$(".alert-danger").fadeIn();
				window.setTimeout(function(response) {
					$(".alert-danger").fadeOut();
					$("#add-question").prop("disabled", false);
				}, 3000);
			},
			complete: function() {
				$("body").removeClass("loading");
			}
		});
	    return false; 
	});
	
	function refresh() {
		$("body").addClass("loading");
		$.ajax("http://localhost:7001/MathMaster/question/all", {
			method : "GET",
			headers : {
				"Accept" : "application/json"
			},
 				//dataType : "json",
 				success : function(response) {
				console.log(response);
				tablewipe();
				tableload(response);
			},complete: function() {
				$("body").removeClass("loading");
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