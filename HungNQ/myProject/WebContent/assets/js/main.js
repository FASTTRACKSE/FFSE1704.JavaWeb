$(document).ready(function(){
	var owl = $('.slider-active');
owl.owlCarousel({
    items:5,
    loop:true,
    navText:['<i class="fa fa-angle-left"></i>','<i class="fa fa-angle-right"></i>'],
    autoplay:true,
    autoplayTimeout:2000,
    autoplayHoverPause:true
});
    
});