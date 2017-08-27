<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
<title>Insert title here</title>
<link rel="stylesheet" href="https://js.arcgis.com/3.21/dijit/themes/claro/claro.css">
<link rel="stylesheet" href="https://js.arcgis.com/3.21/esri/css/esri.css">
<link rel="stylesheet" href="/resources/css/layout.css" />
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
	var toolbar;
	var queryTask;
	dojo.require("esri.map");
	dojo.require("esri.toolbars.draw");
	dojo.require("esri.symbols.SimpleFillSymbol")
	dojo.require("esri.tasks.query");
	dojo.addOnLoad(init);
	
	function init(){
		 map = new esri.Map("map");
		 toolbar = new esri.toolbars.Draw(map);
		 dojo.connect(toolbar, "onDrawEnd", function(geometry){
			 console.log("완료");
			 var symbol = new esri.symbol.SimpleFillSymbol(esri.symbol.SimpleFillSymbol.STYLE_SOLID,
					  new esri.symbol.SimpleLineSymbol(esri.symbol.SimpleLineSymbol.STYLE_DASHDOT,
					  new esri.Color([255,0,0]), 2),new esri.Color([255,255,0,0.25]));
			 var graphic = new esri.Graphic(geometry, symbol);
			 map.graphics.add(graphic); 
		 });
		 var dynamicMSLayer = new esri.layers.ArcGISTiledMapServiceLayer("http://gis.edumac.kr:6080/arcgis/rest/services/EDUMAC/EDU_CACHEDMAP_LAYER/MapServer");
		 map.addLayer(dynamicMSLayer);
		 
		
	}
	
	function runQuery() {
		queryTask = new esri.tasks.QueryTask(
				"http://gis.edumac.kr:6080/arcgis/rest/services/SCHEVAL_2016/EDU_DLAYER_SCHEVAL/MapServer");
		var query = new esri.tasks.Query();
			query.where = "SCH_CLS = '대학교'";
			query.outSpatialReference = {
				wkid : 102100
			};
			query.returnGeometry = true;
			query.outFields = [ "SCH_CLS" ];
			queryTask.execute(query, graphic);
	}

	function addLayer() {
		var scheval = new esri.layers.ArcGISDynamicMapServiceLayer(
				"http://gis.edumac.kr:6080/arcgis/rest/services/SCHEVAL_2016/EDU_DLAYER_SCHEVAL/MapServer");
		map.addLayer(scheval);
	}

	function drawStart() {
		toolbar.activate(esri.toolbars.Draw.POLYGON);

	}

	function drawEnd() {
		toolbar.deactivate();
	}
</script>
</head>
<body class="claro">
	<a href="javascript:addLayer()">레이어 추가</a>
	<a href="javascript:drawStart()">그리기 시작</a>
	<a href="javascript:drawEnd()">그리기 완료</a>
	<a href="javascript:runQuery()">쿼리실행</a>
  <div id="map"></div>
</body>
</html>