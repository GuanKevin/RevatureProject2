$(document).ready(function() {
	$('body').on('click', 'li.exams', function() {
		var examId = $(this).attr('id');
		$.ajax("http://localhost:7001/MathMaster/Exam/" + examId + "/index", {
			method : 'GET',
			dataType : 'JSON',
			success : function(response) {
				console.log(response);
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
//$('div').attr({'class' : 'panel-body'}).append(
//		$.each(courses, function(index, course) {
//				$.each(course.exams, function(index, exam) {
//					if (exam.id == examId) {
//						var html = $('<div>').attr({'class' : 'row'});
//						var quesCon = $('<div>').attr({'class' : 'container quesContainer'});
//						$.each(exam.questionSet, function( index, question) {
//							console.log("HEY");
//							var wrapper = $('<div>').attr({'class' : 'col col-md-10 col-md-offset-1 question panel-primary'});
//							wrapper.append($('<div>').attr({'class' : 'panel-heading'}).append($('<h5>').attr({'class' : 'panel-title', 'id' : 'question' + question.questionId }).text(question.question)));
//							var choiceHtml = $('div').attr({'class' : 'panel-body'}).append($('<div>').attr({'class' : 'radio'}).append($('<label>')))
//							var choiceInput = $('<input>').attr({'type' : 'radio', 'name' : 'optionsRadios' + question.questionId, 'id' : 'optionsRadios' + question.questionId + '_' + index++});
//							choiceHtml.append(choiceInput.text(question.choiceOne));
//							choiceHtml.append(choiceInput.text(question.choiceTwo));
//							choiceHtml.append(choiceInput.text(question.choiceThree));
//							choiceHtml.append(choiceInput.text(question.answer));
//							wrapper.append(choiceHtml);
//							quesCon.append(wrapper);
//							console.log(quesCon);
//							html.append(quesCon);
//						});
//						console.log(quesCon);
//					}
//				});
//		});
//		});