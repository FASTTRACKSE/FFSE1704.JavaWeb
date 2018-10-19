
document.addEventListener("DOMContentLoaded", function(){

	var menubottom = document.querySelector('.menubottom')
	window.addEventListener('scroll', function(){
		var vitri = window.pageYOffset;
		if (vitri>150) {
			menubottom.classList.add('hienlen1');
		} else {
			menubottom.classList.remove('hienlen1');
			
		}
	
 })
})
 new WOW().init();
$(function(){
	$(".nutscrolltop").click(function() {
  $("html, body").animate({ scrollTop: 0 }, "2000");
  return false;
});})
$(function(){
	$(window).scroll(function(event) {
		var menucon = $('body,html').scrollTop();
		if (menucon >= 350) {
			$('.listmenuproduce').addClass('black');
		}else{$('.listmenuproduce').removeClass('black');}
		
	});
})
