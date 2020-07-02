$(document).ready(function() {
	$(".btn-star").click(function(){
		var id=$(this).closest("div").attr("data-id");
		
		$.ajax({
			url:"/cart/add/"+id,
			success: function(response){
				alert(response)
			}
		})
	});
	$("btn-cart").click(function(){
		var id=id=$(this).closest("div").attr("data-id");
	});
	
	
}
		
);