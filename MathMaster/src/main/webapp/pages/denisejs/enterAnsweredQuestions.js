$(document).ready(function() {
	
	function AnsweredQuestionObj(answerChoosen) {
		this.answerChoosen = answerChoosen;
	}
	
	function TakenExam(score, timeTaken) {
		this.score = score;
		this.timeTaken = timeTaken;
	}

	
	$("#mainBody").on("click", "#enter-exam", function() {
		var score = 90;      				// hard coded
		var timeTaken = 1490543129564;      // hard coded
		var studentUsername = "Student001"; // hard coded
		
		var examId = $(this).attr('id');    // the exam that has been choosen
		var takenExamId;
		
		// create taken exam and return the id
		
		var takenExam = new takenExam(score, timeTaken);
		$.ajax("http://localhost:7001/MathMaster/TakenExam/" + studentUsername + examId, {
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
					// question ID
					var quesID = $(question).data('id');	
					// answer choosen
					var radioValue = $("input[name='optionsRadios"+ quesID +"']:checked").val();
				
					var answeredQues = new AnsweredQuestionObj(radioValue);
						
					// going through each answered question and adding 
					// the object to the list before sending it to the database
					// with the corresponding question and taken exam id
					$.ajax("http://localhost:7001/MathMaster/TansweredQuestion/new/" + takenExamId + quesID, {
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
					})
					
				})// end of for each
				
				// this ajax call will enter the list of answered questions 
				// in the controller to the database
				$.ajax("http://localhost:7001/MathMaster/TansweredQuestion/submit", {
					method : "POST",
					success : function() {
						console.log("answered questions have been inserted to the DB");
					}
				})
			
			},
			error : function() {
				console.log("error");
			}
		})	
				
	})// end of event listener
	
});
