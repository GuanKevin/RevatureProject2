$(document).ready(function() {
	
	window.data;
	
	$('body').on('click', '#loginBtn', function(e) {
		e.preventDefault();
		
		$('body').addClass('loading');
		role = $("input[name='role']:checked").val();
		username = $('#username').val();
		password = $('#password').val();

		$.ajax('http://localhost:7001/MathMaster/login', {
			method : "POST",
			data : JSON.stringify([username, password, role]),
			headers : {
				"Accept" : "application/json",
				"Content-Type" : "application/json"
			},
			success : function(response) {
				window.data = response;
				if (role == 'student' && response != null) {
					$('#app').load('./pages/pierstudenthome.html', function(){
						$('.username').text(data.firstName + " " + data.lastName);
							var stu = data.userName;
							var stuCourses = data.courseSet;
							displayCourses(stuCourses);
						});
				} else if (role == 'teacher' && response != null) {
					$('#app').load('./pages/teacherHome.html', function(){
						$('.username').text(data.firstName + " " + data.lastName);
							var teach = data.userName;
							var teachCourses = data.courses;
							displayCourses(teachCourses);
							console.log(response);
						})
				}
			},
			complete : function() {
				$('body').removeClass('loading');
				$.getScript("pages/denisejs/enterAnsweredQuestions.js");
				$.getScript("pages/denisejs/createQuestions.js");
			}
		})
	})
	
	
	$('body').on('click', 'div#courseList', function() {
		$("body").addClass("loading");
		$('#sidebarMenu').empty();
		if(role == 'student') {
			$.ajax('http://localhost:7001/MathMaster/Student/' + data.userName + '/Course', {
				method: 'GET',
				dataType : 'JSON',
				success : function(response) {
					displayCourses(response);
				},
				complete: function() {
					$("body").removeClass("loading");
				}
			})
		} else {
			$.ajax('http://localhost:7001/MathMaster/Teacher/Course/' + data.userName, {
				method: 'GET',
				dataType : 'JSON',
				success : function(response) {
					displayCourses(response);
				},
				complete: function() {
					$("body").removeClass("loading");
				}
			})
		}
	})
	function displayStudents(){};
	function displayCourses(courses){
		$('title').text('Home');
		var coursesLi = $('<li>').attr('class', 'list-group-item').append(
				$('<div>').attr({
					'id' : 'courseList',
					'class' : 'panel-heading courses'
				}).append($('<h4>').text('Courses')));
		var cliDivDiv = $('<ul>').attr({
			'class' : 'list-group'
		});
		$.each(courses, function(index, course) {
			var li = $('<li>').attr({'class' : 'list-group-item'}).append(
					$('<div>').attr({
						'class' : 'panel-heading courses',
						'data-toggle' : 'collapse',
						'data-id' : course.id,
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
					'data-id' : exam.id,
				}).text(exam.name));
			})
			li.append(liDivDiv);
			cliDivDiv.append(li);
			})
		$("#sidebarMenu").append(coursesLi.append(cliDivDiv));
	}
})
