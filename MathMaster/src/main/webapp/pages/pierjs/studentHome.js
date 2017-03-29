$(document).ready(function() {
			$('.username').text(data.firstName + " " + data.lastName);
			var stu = data.userName;
			var coursesLi = $('<li>').attr('class', 'list-group-item').append(
					$('<div>').attr({
						'id' : 'courseList',
						'class' : 'panel-heading courses'
					}).append($('<h4>').text('Courses')));
			var cliDivDiv = $('<ul>').attr({
				'class' : 'list-group'
			});
			$("#sidebarMenu").append(coursesLi.append(cliDivDiv));
			$('body').on('click', 'div#courseList', function() {
				$.ajax('http://localhost:7001/MathMaster/Student/' + stu + '/Course', {
					method: 'GET',
					dataType : 'JSON',
					success : function(response) {
						console.log(response);
						displayCourses(response);
					}
				})
			})
			function displayCourses(stuCourses) {
				$.each(stuCourses, function(index, course) {
				var li = $('<li>').attr('class', 'list-group-item').append(
						$('<div>').attr({
							'class' : 'panel-heading courses',
							'data-toggle' : 'collapse',
							'data-target' : '#course' + index
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
					console.log(exam)
				})
				li.append(liDivDiv);
				cliDivDiv.append(li);
				})
			}
//			$.each(stuCourses, function(index, course) {
//				var li = $('<li>').attr('class', 'list-group-item').append(
//						$('<div>').attr({
//							'class' : 'panel-heading courses',
//							'data-toggle' : 'collapse',
//							'data-target' : '#course' + index
//						}).append($('<h4>').text(course.courseName)));
//				
//				
//				var liDivDiv = $('<div>').attr({
//					'class' : 'collapse',
//					'id' : 'course' + index
//				}).append($('<ul>').attr({
//					'class' : 'list-group'
//				}));
//				$.each(course.exams, function(index, exam) {
//					liDivDiv.append($('<li>').attr({
//						'class' : 'list-group-item exams',
//						'id' : exam.id
//					}).text(exam.name));
//				})
				//li.append(liDivDiv);
				
//			})
		})