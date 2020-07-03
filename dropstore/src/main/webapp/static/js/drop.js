$(document).ready(function() {
	$(".btn-cart").click(function(){
		var id=$(this).closest("div").attr("data-id");
		$.ajax({
			url:"/cart/add/"+id,
			success: function(response) {
				$("#cart-cnt").html(response[0]);

				$("#cart-amt").html(response[1]);
				alert(response)
			}
			
			
		});
		
		
	});
	
	
	$(".btn-star").click(function(){
		var id=$(this).closest("div").attr("data-id");
		
		$.ajax({
			url:"/product/add-to-favo/"+id,
			success: function(response){
				if(response) alert("Thêm thành công")
				else alert("Đã có sẵn")
			}
		})
	})	
}
	
);