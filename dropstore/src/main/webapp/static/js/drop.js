$(document).ready(function() {
	$("tr[data-id] input").on("input",function(){

		var id=$(this).closest("tr").attr("data-id");

		var price=$(this).closest("tr").attr("data-price");
		
		var discount=$(this).closest("tr").attr("data-discount");

		var qty=$(this).val();
		
		$.ajax({
			url:`/cart/update/${id}/${qty}`,
			success: function(response) {
				$("#cart-cnt").html(response[0]);
				$("#cart-amt").html(response[1].toLocaleString());

			}
			
			
		});
		var amt=qty*price*(1-0.01*discount);
		$(this).closest("tr").find(".amt").html(amt.toLocaleString());
	});
	
	$(".btn-cart-remove").click(function(){

		var id=$(this).closest("tr").attr("data-id");
		$.ajax({
			url:"/cart/remove/"+id,
			success: function(response) {
				
				$("#cart-cnt").html(response[0]);
				$("#cart-amt").html(response[1]);

			}
			
			
		});

		$(this).closest("tr").remove();
	});
	
	$(".btn-cart-clear").click(function(){
		$.ajax({
			url:"/cart/clear/",
			success: function(response) {
				
				$("#cart-cnt").html(response[0]);
				$("#cart-amt").html(response[0]);
				$("table>tbody").html("");
			}
			
			
		});
	});
	$(".btn-cart").click(function(){
		var id=$(this).closest("div").attr("data-id");
		$.ajax({
			url:"/cart/add/"+id,
			success: function(response) {
				
				$("#cart-cnt").html(response[0]);
				$("#cart-amt").html(response[1].toLocaleString());
			
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