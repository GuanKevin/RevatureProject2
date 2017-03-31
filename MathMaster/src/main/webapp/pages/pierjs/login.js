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
		$('#mainBody').empty();
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
	
	function displayStudents(course, container){
		console.log(course);
		container.append($('<h1>').text(course.courseName));
		var table = $('<table>').attr({'class' : 'table'});
		var thead = $('<thead>');
		var theadtr = $('<tr>').append($('<th>').text('ID'))
								.append($('<th>').text('First Name'))
								.append($('<th>').text('Last Name'))
								.append($('<th>').text('E-mail'))
								.append($('<th>').text('Username'));
		table.append(thead.append(theadtr));
		
		var tbody = $('<tbody>');
		var tbodytr = $('<tr>');
		$.each(course.students, function(index, student) {
			tbodytr.append($('<td>').text(student.studentId))
					.append($('<td>').text(student.firstName))
					.append($('<td>').text(student.lastName))
					.append($('<td>').text(student.email))
					.append($('<td>').text(student.userName));
		})
		table.append(tbody.append(tbodytr));
		container.append(table);	
		$('#mainBody').html(container);
	};
	function displayCourses(courses){
		var container = $('<div>');
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
			if(role == 'teacher') { displayStudents(course, container); }
			var li = $('<li>').attr({'class' : 'list-group-item course', 'data-id' : course.courseId}).append(
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
					'data-id' : exam.id,
				}).text(exam.name));
			})
			li.append(liDivDiv);
			cliDivDiv.append(li);
			})
		$("#sidebarMenu").append(coursesLi.append(cliDivDiv));
	}
})
