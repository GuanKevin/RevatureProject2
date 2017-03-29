$(document).ready(function() {
	$('body').on('click', 'li.exams', function() {
		var examId = $(this).attr('id');
		$.ajax("http://localhost:7001/MathMaster/Exam/" + examId + "/index", {
			method : 'GET',
			dataType : 'json',
			success : function(response) {
				displayQues(response);
			},
		})
		
		function displayQues(questions) {
			var html = $('<div>').attr({'class' : 'row'});
			var quesCon = $('<div>').attr({'class' : 'container quesContainer'});
			$.each(questions, function( index, question) {
				var wrapper = $('<div>').attr({'class' : 'col-md-10 col-md-offset-1 question panel-primary'});
				wrapper.append($('<div>').attr({'class' : 'panel-heading'}).append($('<h5>').attr({'class' : 'panel-title', 'id' : 'question' + question.questionId }).text(question.question)));
				
				var choiceHtml = $('<div>').attr({'class' : 'radio'});
				
				var input = $('<input>').attr({'type' : 'radio', 'name' : 'optionsRadios' + question.questionId, 'value' : question.choiceOne});
				choiceHtml.append($('<label>').append(input).append(question.choiceOne));
				var input = $('<input>').attr({'type' : 'radio', 'name' : 'optionsRadios' + question.questionId, 'value' : question.choiceTwo});
				choiceHtml.append($('<label>').append(input).append(question.choiceTwo));
				var input = $('<input>').attr({'type' : 'radio', 'name' : 'optionsRadios' + question.questionId, 'value' : question.choiceThree});
				choiceHtml.append($('<label>').append(input).append(question.choiceThree));
				var input = $('<input>').attr({'type' : 'radio', 'name' : 'optionsRadios' + question.questionId, 'value' : question.answer});
				choiceHtml.append($('<label>').append(input).append(question.answer));

				wrapper.append(choiceHtml);
				quesCon.append(wrapper);
				html.append(quesCon);
			});
			$('#mainBody').html(html);
		}
	})
});
