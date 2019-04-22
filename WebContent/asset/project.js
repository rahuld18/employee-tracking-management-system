$(document).ready(function(){
$.getJSON("GetAllProjectJSON",{ajax:true},function(data){
	$('#project').empty();
 	$('#project').append($('<option>').text('-Running Projects-').val(""));
 	
	$.each(data,function(i,item){
 		$('#project').append($('<option>').text(item.PROJECTNAME).val(item.PROJECTNAME));	
 			
 	});
 });
});