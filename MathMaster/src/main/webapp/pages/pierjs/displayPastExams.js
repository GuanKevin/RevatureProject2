$(document).ready(function() {
	$('body').on('click', '#all-exams', function() {
		$('body').addClass('loading');
		$.ajax('http://localhost:7001/MathMaster/Student/' + data.userName, {
			method : 'GET',
			dataType : 'JSON',
			success : function(response) {
				var container = $('<div>');
				displayExams(response.takenExams, container);
			},
			complete: function(){
				$('body').removeClass('loading');
			}
		})
	})
	
	function displayExams(exams, container) {
		$('#mainbody').html()
		
		var table = $('<table>').attr({'class' : 'table'});
		var thead = $('<thead>');
		var theadtr = $('<tr>').append($('<th>').text('Score'))
								.append($('<th>').text('Name'))
								.append($('<th>').text('Time Taken'))
		table.append(thead.append(theadtr));
		
		var tbody = $('<tbody>');
		$.each(exams, function(index, exam) {
			var tbodytr = $('<tr>');
			var date = new Date(exam.timeTaken);
			var options = {  
			    weekday: "long", year: "numeric", month: "short",  
			    day: "numeric", hour: "2-digit", minute: "2-digit"  
			};  
			tbodytr.append($('<td>').text(exam.score))
					.append($('<td>').text(exam.takenExam.name))
					// where to convert
					.append($('<td>').text(date.toLocaleTimeString("en-us", options)));	
			tbody.append(tbodytr);
		});
		
		table.append(tbody);
		container.append(table);	
		$('#mainBody').html(container);
	}
})