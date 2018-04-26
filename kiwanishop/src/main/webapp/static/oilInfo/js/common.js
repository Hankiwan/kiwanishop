$(document).ready(function() {
	$(".ui-btn-left").on("click",function() {
		$(".ui-panel-dismiss").stop().animate({left:"85%"},"slow");
	});
	
	$(".ui-btn-right").on("click",function() {
		$(".ui-panel-dismiss").stop().animate({left:"0"},"slow");
	});
});