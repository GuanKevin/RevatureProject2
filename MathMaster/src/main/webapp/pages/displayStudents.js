/*
$(document).on({
    ajaxStart: function() { $body.addClass("loading");    },
     ajaxStop: function() { $body.removeClass("loading"); }    
});
*/
$(document).ready(function() {
	$('body').click(function(){
	})     

	$('body').on('click', 'li>.courses', function() {
		$("body").addClass("loading");

		var courseId = $(this).attr('courseId');
		console.log($(this).attr('courseId'));
		$.ajax("http://localhost:7001/MathMaster/Course/" + courseId + "/students", {
			method : 'GET',
			dataType : 'json',
			success : function(response) {
				console.log(response);
				displayStudentsOnCourseId(response);
			},
			error : function() {
				console.log("Error");
			}
		}).always(function(){
			$("body").removeClass("loading");
		})
	
		function displayStudentsOnCourseId(studentList) {
			var html = $('<div>').attr({'class' : 'row'});
			var stuCon = $('<div>').attr({'class' : 'container stuContainer'});
			$.each(studentList, function(index, studentList) {
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