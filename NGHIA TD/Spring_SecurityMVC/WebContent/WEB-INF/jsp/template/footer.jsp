<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script src="<c:url value="/themes/assets/js/vendor/jquery-2.1.4.min.js"/>"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"></script>
    <script src="<c:url value="/themes/assets/js/plugins.js"/>"></script>
    <script src="<c:url value="/themes/assets/js/main.js"/>"></script>


    <script src="<c:url value="/themes/assets/js/lib/chart-js/Chart.bundle.js"/>"></script>
    <script src="<c:url value="/themes/assets/js/dashboard.js"/>"></script>
    <script src="<c:url value="/themes/assets/js/widgets.js"/>"></script>
    <script src="<c:url value="/themes/assets/js/lib/vector-map/jquery.vmap.js"/>"></script>
    <script src="<c:url value="/themes/assets/js/lib/vector-map/jquery.vmap.min.js"/>/"></script>
    <script src="<c:url value="/themes/assets/js/lib/vector-map/jquery.vmap.sampledata.js"/>"></script>
    <script src="<c:url value="/themes/assets/js/lib/vector-map/country/jquery.vmap.world.js"/>"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    
    <script>
        ( function ( $ ) {
            "use strict";
            jQuery( '#vmap' ).vectorMap( {
                map: 'world_en',
                backgroundColor: null,
                color: '#ffffff',
                hoverOpacity: 0.7,
                selectedColor: '#1de9b6',
                enableZoom: true,
                showTooltip: true,
                values: sample_data,
                scaleColors: [ '#1de9b6', '#03a9f5' ],
                normalizeFunction: 'polynomial'
            } );
        } )( jQuery );
    </script>
    
    <script type="text/javascript">
			function readURL(input) {
				if (input.files && input.files[0]) {
					var reader = new FileReader();
					reader.onload = function(e) {
						$('#img').attr('src', e.target.result);
					}
					reader.readAsDataURL(input.files[0]);
				}
			}
			$("#imgUrl").change(function() {
				readURL(this);
			});
		</script>
    </body>
</html>
