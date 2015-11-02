$(function(){
	$(".icon-arrow").click(function(){
		$(this).next("ul").slideToggle()
		$(this).toggleClass("open-arrow");
	});

	$(".sub-category").click(function(){
		$(this).show();
	});
})