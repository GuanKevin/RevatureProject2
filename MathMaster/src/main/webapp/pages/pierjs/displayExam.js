$(document).ready(function() {
	console.log("HEY");
	$('body').on('click', 'li.exams', function() {
		$("body").addClass("loading");
		var examId = $(this).data('id');
		
		$.ajax("http://localhost:7001/MathMaster/Exam/" + examId + "/index", {
			method : 'GET',
			dataType : 'JSON',
			success : function(response) {
				displayQues(response);
			},
			complete: function() {
				$("body").removeClass("loading");
			}
		})

		function displayQues(questions) {
			var html = $('<div>').attr({'class' : 'quesContainer'});
			$.each(questions, function( index, question) {
				var wrapper = $('<div>').attr({'class' : 'question panel-primary'});
				wrapper.append($('<div>').attr({'class' : 'panel-heading questions', 'data-id' : question.questionId}).append($('<h5>').attr({'class' : 'panel-title', 'id' : 'question' + question.questionId }).text(question.question)));				
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
				html.append(wrapper);

			});
			html.append($('<div>').attr({'class' : 'text-center'}).append($('<button>').attr({'id' : 'enter-exam', 'class' : 'btn btn-primary'}).text('Submit')));
			$('#mainBody').html(html);
		}
	})
});
