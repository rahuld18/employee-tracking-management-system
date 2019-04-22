$(document).ready(function(){
	
	$('#searchbtn').click(function(){
		htm="<caption><b><i >List Of Tasks Between "+$('#datefrom').val()+" and "+$('#dateto').val()+"</i></b></caption>";
		
	$.getJSON("CollapseButton",{ajax:true,eid:parseInt($('#eid').val()),datefrom:$('#datefrom').val(),dateto:$('#dateto').val()},function(data){
		
		
		$.each(data,function(i,item){
			
		var x = document.createElement("BUTTON");
		var t = document.createTextNode(item.DATE);
		  x.appendChild(t);
		  x.className="btn btn-primary btn-block";
		 x.setAttribute('id',i);
		 x.setAttribute('data-toggle',"collapse");
		 x.setAttribute('data-target',"#a"+i);
		 
		 // x.style.cssText="height:0px;overflow:hidden;";
		  var table=document.createElement("TABLE");
		 table.setAttribute('id', "a"+i);
		 table.setAttribute('class',"table collapse");
		  $.getJSON("DisplayByDateJSON",{ajax:true,date:item.DATE,eid:$('#eid').val()},function(datas){
			  //table.css("height","+=0");
			 
			  table.innerHTML = "<tr><th>Consume Time&nbsp;&nbsp;</th><th>Task</th><th>Project Name</th><th>Current Time</th></tr>";
				
			  $.each(datas,function(i,items){
		  
		  table.innerHTML+="<tr><td>"+items.CONSUMETIME+"</td><td>"+items.TASK+"</td><td>"+items.PROJECTNAME+"</td><td>"+items.CURRENTTIME+"</td></tr>";
				//table.className="table";
				 
				
				//table.style.cssText="height:0px;overflow:hidden;";
				//table.height(0);
				//table.cssHooks="height:0px;";
				
			  
			  })
				})
				
		  
		  
		document.body.appendChild(x);
		  document.body.appendChild(table);
		  $('#result').html(htm);
		})
		
			
			
		
		
		
	})
	
	})

})