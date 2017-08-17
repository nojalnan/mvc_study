<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
<title>Insert title here</title>
<link rel="stylesheet" href="https://js.arcgis.com/3.21/esri/css/esri.css">
<style>
  html, body, #map {
    height: 100%;
    padding: 0;
    margin: 0;
  }
</style>
<script src="https://js.arcgis.com/3.21/"></script>
<script>
	var map;
	
  	require(["esri/map",
  	         "esri/layers/ArcGISDynamicMapServiceLayer",
  	         "esri/layers/ImageParameters"
  	         ], function(
  	        		 Map, ArcGISDynamicMapServiceLayer, ImageParameters) {
    					// code to create the map and add a basemap will go here
    					map = new Map("map", {
    					sliderOrientation : "horizontal"
    					});
    
    					var imageParameters = new ImageParameters();
    					imageParameters.format = "PNG";
    
    					var dynamicMapServiceLayer = new ArcGISDynamicMapServiceLayer("http://gis.edumac.kr:6080/arcgis/rest/services/EDUMAC/EDU_CACHEDMAP_LAYER/MapServer", {
        					"opacity" : 0.5,
        					"imageParameters" : imageParameters
  							});
    
    						map.addLayer(dynamicMapServiceLayer);
						});
    
</script>
</head>
<body class="claro">
  <div id="map"></div>
</body>
</html>