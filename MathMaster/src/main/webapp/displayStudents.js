$(document).ready(function() {
	// Ask Pier what li.exam refer to and if I can
	// do li.students to refer to the list of studnts
	$('body').on('click', 'li.students', function() {
		var courseId = $(this).attr('id');
		$.ajax("http://localhost:7001/MathMaster/Course/" + courseId, {
			method : 'GET',
			dataType : 'json',
			success : function(response) {
				console.log(response);
				displayStudentsOnCourseId(response);
			},
		})
	
		function displayStudentsOnCourseId(courseId) {
			var html = $('<div>').attr({'class' : 'row'});
			var stuCon = $('<div>').attr({'class' : 'container stuContainer'});
			$.each(courseId, function( index, courseId) {
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
				stuCon.append(wrapper);
				html.append(stuCon);
			});
			$('#mainBody').html(html);
		}
	})
});