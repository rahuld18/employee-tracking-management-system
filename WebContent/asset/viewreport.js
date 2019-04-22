$(document).ready(function(){
	
	$('#searchbtn').click(function(){
		
		$.getJSON("ViewReportJSON",{ajax:true,eid:$('#eid').val(),datefrom:$('#datefrom').val(),dateto:$('#dateto').val()},function(data){
			htm="<table class='table table-hover text-centered' border=1 cellspacing=3>"
				htm+="<caption><b><i>List Of Tasks Between "+$('#datefrom').val()+" and "+$('#dateto').val()+"</i></b></caption>";
				htm+="<tr><th>Time</th><th>Task</th><th>Project Name</th><th>Consume time</th><th>Date</th><th>Update</th></tr></tr>";
				$.each(data,function(i,item){
				htm+="<tr><td>"+item.CURRENTTIME+"</td><td>"+item.TASK+"</td><td>"+item.PROJECTNAME+"</td><td>"+item.CONSUMETIME+"</td><td>"+item.DATE+"</td><td><a href='DisplayTaskById?taskid="+item.TASKID+"&eid="+item.EMPLOYEEID+"'>Edit/Detete</a> </td></tr>";
				});htm+="</table>";
				
				/*$.getJSON("ConsumeTimeJSON",{ajax:true,eid:$('#eid').val(),dateto:$('#dateto').val()},function(data){
				
					time=addTimes(item.CONSUMETIME,item.CONSUMETIME);
						
					
					html="<p>Time:"+time+"</p>";
				});*/
		$('#result').html(htm);
		//$('#consum').html(html);
				
	})
})

})


