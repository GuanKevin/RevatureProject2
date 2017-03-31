$(document).ready(function(){
	function AnsweredQuestionObj(answerChoosen) {
		this.answerChoosen = answerChoosen;
	}
	function TakenExam(score, timeTaken) {
		this.score = score;
		this.timeTaken = timeTaken;
	}
	$("#mainBody").on("click", "#enter-exam", function() {
		$("body").addClass("loading");
		
		console.log(check);
		var score = 0;      			
		var timeTaken = new Date().getTime();
		var studentUsername = data.userName;
		console.log("BOOOOOOO");
		var examId = $('li.exams').data('id');    // the exam that has been choosen
		console.log(examId);
		var takenExamId;
		
		var numOfQuestions = 0; // keep track of number of questions
		var correct = 0; // keep track of correct answers
		
		// create taken exam and return the id
		
		var takenExam = new TakenExam(score, timeTaken);
		$.ajax("http://localhost:7001/MathMaster/TakenExam/" + studentUsername + "/" + examId, {
			method : "POST",
			data : JSON.stringify(takenExam),
			headers : {
				"Accept" : "application/json", 
				"Content-Type" : "application/json"
			},
			success : function(response) {
				console.log("response: " + response);
				takenExamId = response;
				console.log("Taken Exam Id: " + takenExamId);
				
				var questionID = $('.questions');
				$.each(questionID,function(index, question){
					// increment number of questions count
					numOfQuestions++;
					// question ID
					var quesID = $(question).data('id');	
					// answer choosen
					var radioValue = $("input[name='optionsRadios"+ quesID +"']:checked").val();
					// increment correct count if correct answer chosen
					if($("input[name='optionsRadios"+ quesID +"']:checked").data('id') === true) {
						correct++;
					}
					
					var answeredQues = new AnsweredQuestionObj(radioValue);
						
					// going through each answered question and adding 
					// enter the answered question to the DB
					$.ajax("http://localhost:7001/MathMaster/answeredQuestion/new/" + takenExamId + "/" + quesID, {
						method : "POST",
						data : JSON.stringify(answeredQues),
						headers : {
							"Content-Type" : "application/json"
						},
						success : function(response) {
							console.log(response);
						},
						error : function() {
							console.log("error");
						}
					})// end of ajax
					
				})// end of for each
				$.ajax("http://localhost:7001/MathMaster/TakenExam/" + takenExamId + "/" + Math.floor(correct * 100/numOfQuestions), {
					method : "GET",
					success : function(response) {
						console.log(response);
					},
					error : function() {
						console.log("error");
					}
				}) // end of ajax
				$('#mainBody').html('');
			}, complete: function() {
				$("body").removeClass("loading");
			}, error : function() {
				console.log("error");
			}
		})	
				
	})// end of event listener
})