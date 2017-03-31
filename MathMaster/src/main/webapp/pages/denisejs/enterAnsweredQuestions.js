$(document).ready(function(){
	console.log('HO');
	function AnsweredQuestionObj(answerChoosen) {
		this.answerChoosen = answerChoosen;
	}
	function TakenExam(score, timeTaken) {
		this.score = score;
		this.timeTaken = timeTaken;
	}
	$("#mainBody").on("click", "#enter-exam", function() {
		$("body").addClass("loading");
		var score = 0;      				// hard coded
		var timeTaken = new Date().getTime();      // hard coded
		var studentUsername = "Student001"; // hard coded
		console.log("BOOOOOOO");
		var examId = $('li.exams').data('id');    // the exam that has been choosen
		console.log(examId);
		var examId = 121;
		var takenExamId;
		
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
				$('#mainBody').html('');
			}, complete: function() {
				$("body").removeClass("loading");
			}, error : function() {
				console.log("error");
			}
		})	
				
	})// end of event listener
})