$(document).ready(function() {
	
	window.data;
	function UserInfo(username, password, role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	$('body').on('click', '#loginBtn', function(e) {
		e.preventDefault();
		
		$('body').addClass('loading');
		var role = $("input[name='role']:checked").val();
		var username = $('#username').val();
		var password = $('#password').val();

		var userinfo = new UserInfo(username, password, role);

		$.ajax('http://localhost:7001/MathMaster/login', {
			method : "POST",
			data : JSON.stringify([username, password, role]),
			headers : {
				"Accept" : "application/json",
				"Content-Type" : "application/json"
			},
			success : function(response) {
				window.data = response;
				console.log(response);
				$('#app').load('./pages/pierstudenthome.html', function(){
					$('.username').text(data.firstName + " " + data.lastName);
					var stu = data.userName;
					var stuCourses = data.courseSet;
					
					displayCourses(stuCourses);
				});
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
	})
	
	function displayCourses(stuCourses){
		var coursesLi = $('<li>').attr('class', 'list-group-item').append(
				$('<div>').attr({
					'id' : 'courseList',
					'class' : 'panel-heading courses'
				}).append($('<h4>').text('Courses')));
		var cliDivDiv = $('<ul>').attr({
			'class' : 'list-group'
		});
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
					'data-id' : exam.id,
				}).text(exam.name));
			})
			li.append(liDivDiv);
			cliDivDiv.append(li);
			})
		$("#sidebarMenu").append(coursesLi.append(cliDivDiv));
	}
})
