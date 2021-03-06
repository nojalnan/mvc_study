<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
<title>Insert title here</title>
<link rel="stylesheet" href="https://js.arcgis.com/3.21/dijit/themes/claro/claro.css">
<link rel="stylesheet" href="https://js.arcgis.com/3.21/esri/css/esri.css">
<link rel="stylesheet" href="/resources/css/layout.css" />
<script src="<c:url value="/resources/js/jquery/jquery-3.2.1.min.js" />"></script>
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
	var toolbar, geometryService;
	dojo.require("esri.map");
	dojo.require("esri.toolbars.draw");
	dojo.require("esri.symbols.SimpleFillSymbol")
	dojo.require("esri.tasks.query");
	dojo.require("esri.tasks.AreasAndLengthsParameters");
	dojo.require("esri.tasks.geometry");
	dojo.require("esri.dijit.editing.editOperation");
	dojo.addOnLoad(init);
	
	function init(){
		geometryService = new esri.tasks.GeometryService("http://gis.edumac.kr:6080/arcgis/rest/services/Utilities/Geometry/GeometryServer");
		 map = new esri.Map("map");
		 toolbar = new esri.toolbars.Draw(map);
		 dojo.connect(toolbar, "onDrawEnd", function(geometry){
			 
			 var graphic = new esri.Graphic(geometry, getPolygonSymbol());
			 map.graphics.add(graphic);
			 
			 /*lengths(geometry, function(result) {
				 console.log("result", result);
			 });*/
			 
			 // 거리와 면적 계산

			 //areasAndLength(geometry);
			 //union(geometry);
			 
			 // 학교 영역 검색
			 getSchoolBoundary(geometry, function(result) {
				 console.log("result", result);
				 var geometryAry = [];
				 for( var i=0;i<result.features.length;i++ ) {
					 geometryAry.push( result.features[i].geometry );
					//result.features[i].symbol = getPolygonSymbol();
						//map.graphics.add(result.features[i]);
				  }
				  union(geometryAry);
				  buffer(geometry);
			 })
			 
			
			 
			 /*
			 var query = new Query();
			  var queryTask = new QueryTask( ... );
			  query.where = "STATE_NAME = 'Washington'";
			  query.outSpatialReference = {wkid:102100}; 
			  query.returnGeometry = true;
			  query.outFields = ["CITY_NAME"];
			  queryTask.execute(query, addPointsToMap);
			  */
		 });
		 var dynamicMSLayer = new esri.layers.ArcGISTiledMapServiceLayer("http://gis.edumac.kr:6080/arcgis/rest/services/EDUMAC/EDU_CACHEDMAP_LAYER/MapServer");
		 map.addLayer(dynamicMSLayer);
		
	}
	
	function getPolygonSymbol() {
		return new esri.symbol.SimpleFillSymbol(esri.symbol.SimpleFillSymbol.STYLE_SOLID,
				  new esri.symbol.SimpleLineSymbol(esri.symbol.SimpleLineSymbol.STYLE_DASHDOT,
				  new esri.Color([255,0,0]), 2),new esri.Color([255,255,0,0.25]));
	}
	
	function getPolygonSymbol2() {
		return new esri.symbol.SimpleFillSymbol(esri.symbol.SimpleFillSymbol.STYLE_SOLID,
				  new esri.symbol.SimpleLineSymbol(esri.symbol.SimpleLineSymbol.STYLE_DASHDOT,
				  new esri.Color([0,0,0]), 2),new esri.Color([255,255,0,0.25]));
	}
	
	function getPolylineSymbol() {
		return new esri.symbol.SimpleLineSymbol(esri.symbol.SimpleLineSymbol.STYLE_DASHDOT,
				  new esri.Color([255,0,0]), 2);
	}
	
	function addLayer() {
		var scheval = new esri.layers.ArcGISDynamicMapServiceLayer(
				"http://gis.edumac.kr:6080/arcgis/rest/services/SCHEVAL_2016/EDU_DLAYER_SCHEVAL/MapServer");
		map.addLayer(scheval);
	}

	function drawStart() {
		toolbar.activate(esri.toolbars.Draw.POLYGON);
		//toolbar.activate(esri.toolbars.Draw.POLYLINE);

	}

	function drawEnd() {
		toolbar.deactivate();
	}
	
	function sum() {
		//main/data/boardList.do
		//return a+b;
		
		//getData(1, boardList)
		getData(1, function(result) {
			console.log("result", result)
		});
		
	}
	
	function boardList(result) {
		console.log("result", result)
	}
	
	// 거리, 면적계산
	
	function getSchoolBoundary( geometry, func ) {
		var query = new esri.tasks.Query();
		var queryTask = new esri.tasks.QueryTask("http://gis.edumac.kr:6080/arcgis/rest/services/SCHEVAL_2016/EDU_DLAYER_SCHEVAL/MapServer/67");
		//query.where = "CITY_ID = '272'";
		//query.outSpatialReference = {wkid:102100};
		query.geometry = geometry;
		query.returnGeometry = true;
		query.outFields = ["*"];
		queryTask.execute(query, function(result) {
			  func.call( this, result );
		});
	}
	
	// union
	function union(geometrys) {
		geometryService.union(geometrys, function(geometry) {
			console.log("union", geometry);
			var graphic = new esri.Graphic(geometry, getPolygonSymbol2());
			map.graphics.add(graphic);
		});
		
	}
	
	function buffer(geometry) {
		var params = new esri.tasks.BufferParameters();
		params.geometries  = [ geometry ];

		params.distances = [ 100 ];
		params.unit = esri.tasks.GeometryService.UNIT_METER;
		geometryService.buffer(params,function(result){
			console.log("result", result);
			var graphic = new esri.Graphic(result[0], getPolygonSymbol2());
			map.graphics.add(graphic);
		});
	}
	
	// 길이계산
	/*function lengths(geometry) {
		var lengthParams = new esri.tasks.LengthsParameters();
		lengthParams.polylines = [geometry];
		lengthParams.lengthUnit = esri.tasks.GeometryService.UNIT_METER;
		lengthParams.geodesic = true;
		geometryService.lengths(lengthParams, function(result) {
			console.log("lengths", result);
		});
	}*/
	// 면적계산
	function areasAndLength(geometry) {
		var areasAndLengthParams = new esri.tasks.AreasAndLengthsParameters();
		areasAndLengthParams.lengthUnit = esri.tasks.GeometryService.UNIT_KILOMETER;
		areasAndLengthParams.areaUnit = esri.tasks.GeometryService.UNIT_KILOMETER;
		areasAndLengthParams.polygons = [geometry];
		geometryService.areasAndLengths(areasAndLengthParams, function(result) {
			console.log("areasAndLength", result);
		});
	}
	
	function doSearch() {
		// 1. 학교찾기
		// 2. 학교가 속한 학구도
		// 3. 학구도에 속한 학교
		var query = new esri.tasks.Query();
		var queryTask = new esri.tasks.QueryTask("http://gis.edumac.kr:6080/arcgis/rest/services/SCHEVAL_2016/EDU_DLAYER_SCHEVAL/MapServer/10");
		query.where = "SCH_NM LIKE '%" + $("#txtIpt").val() + "%'";
		//query.outSpatialReference = {wkid:102100};
		//query.geometry = geometry;
		query.returnGeometry = true;
		query.outFields = ["*"];
		queryTask.execute(query, function(result) {
			  console.log("result", result);
			  map.graphics.clear();
			  for( var i=0;i<result.features.length;i++ ) {
				  console.log("map", map)
				  result.features[i].symbol = getPolygonSymbol();
					map.graphics.add(result.features[i]);
			  }
			  console.log("A", map.graphics.graphics)
			  // zoomtolayer
				var zoomExtent = esri.graphicsExtent(map.graphics.graphics).expand(2);
				map.setExtent(zoomExtent);
		});
	}
</script>
</head>
<body class="claro">
	<a href="javascript:addLayer()">레이어 추가</a>
	<a href="javascript:drawStart()">그리기 시작</a>
	<a href="javascript:drawEnd()">그리기 완료</a>
	<a href="javascript:runQuery()">쿼리실행</a>
	<a href="javascript:sum()">테스트</a>
	<input type="text" id="txtIpt" />
	<a href="javascript:doSearch()">조회</a>
  <div id="map"></div>
</body>
</html>