$(document).ready(function() {
	$("body").addClass("loading");
	console.log(teacherData);
	
			$('.username').text(teacherData.firstName + " " + teacherData.lastName);
			var teacherCourses = teacherData.courses;
			$.each(teacherCourses, function(index, course) {
				var li = $('<li>').attr('class', 'list-group-item').append(
						$('<div>').attr({
							'class' : 'panel-heading courses',
							'data-courseid' : course.courseId,
							'data-toggle' : 'collapse',
							'data-target' : '#course' + index,
						}).append($('<h4>').text(course.courseName)));
				var liDivDiv = $('<div>').attr({
					'class' : 'collapse',
					'id' : 'course' + index
				}).append($('<ul>').attr({
					'class' : 'list-group'
				}));
				$.each(course.exams, function(index, exam) {
					liDivDiv.append($('<li>').attr({
						'class' : 'list-group-item exams',
						'id' : exam.id
					}).text(exam.name));
				})
				li.append(liDivDiv);
				$("#sidebarMenu").append(li);
			})
			
		$("body").removeClass("loading");
		})