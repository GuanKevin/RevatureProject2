//$(document).ready(
//    function() {
//    	var courses = data.courseSet;
//$('body').on('click', 'li.exams', function() {
//		var examId = $(this).attr('id');
//		var html = "";
//		$.each(allCourses, function(index, course) {
//				$.each(course.exams, function(index, exam) {
//						if (exam.id == examId) {
//							html = $('<div>').attr({'class' : 'row'}).append($('<div>').attr({'class' : 'container quesContainer'}));
//							$.each(exam.questionSet, function( index, question) {
//								var wrapper = $('<div>').attr({'class' : 'col col-md-10 col-md-offset-1 question panel-primary'});
//								wrapper.append($('<div>').attr({'class' : 'panel-heading'}).append($('<h5>').attr({'class' : 'panel-title', 'id' : 'question' + question.questionId }).text(question.question)));
//								var choiceHtml = $('div').attr({'class' : 'panel-body'}).append($('<div>').attr({'class' : 'radio'}).append($('<label>')))
//								var choiceInput = $('<input>').attr({'type' : 'radio', 'name' : 'optionsRadios' + question.questionId, 'id' : 'optionsRadios' + question.questionId + '_' + index++});
//								choiceHtml.append(choiceInput.text(question.choiceOne));
//								choiceHtml.append(choiceInput.text(question.choiceTwo));
//								choiceHtml.append(choiceInput.text(question.choiceThree));
//								choiceHtml.append(choiceInput.text(question.answer));
//								wrapper.append(choiceHtml);
//									});
//								}
//							});
//						});
//					});
//})