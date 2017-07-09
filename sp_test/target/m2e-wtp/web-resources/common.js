/**
 * 
 */

function pageMove(param) {
	if (param) {
		document.getElementById("urlStr").value = param;
		$("#urlForm").submit();
	} else {
		alert("url을 입력해주세요.");
	}
}

function urlSubmit(f) {
	return true;
}

var AjaxUtil = function(url, params, type, dataType) {
	if (!url) {
		alert("url정보가 없습니다.");
		return null;
	}
	this.url = "/spring4/" + url;
	var initData = {}
	initData["projectName"] = "spring4";

	this.param = JSON.stringify(initData);
	if (params) {
		var paramArr = params.split(",");

		var data = {};
		for (var i = 0, max = paramArr.length; i < max; i++) {
			data[paramArr[i]] = $("input[name=" + paramArr[i] + "]").val();
		}
		this.param = JSON.stringify(data);
	}
	this.type = type ? type : "POST";
	this.dataType = dataType ? dataType : "json";
	this.callbackSuccess = function(json) {
		var url = json.url;
		var data = json.data;
		var msg = json.msg;
		if (msg) {
			alert(msg);
		}
		if (url) {
			pageMove(url);
		}
	}

	this.setCallbackSuccess = function(callback) {
		this.callbackSuccess = callback;
	}

	this.send = function() {
		$.ajax({
			type : this.type,
			url : this.url,
			dataType : this.dataType,
			beforeSend : function(xhr) {
				xhr.setRequestHeader("Accept", "application/json");
				xhr.setRequestHeader("Content-Type", "application/json");
			},
			data : this.param,
			success : this.callbackSuccess,
			error : function(xhr, status, e) {
				alert("에러 : " + e);
			},
			done : function(e) {
			}
		});
	}
}

function mdel(mid) {
	if (confirm("삭제하시겠습니까?")) {
		$("#mode").val("del");
		$("#userid").val(mid);
		var au = new AjaxUtil("/spring4/user/userlistaction", "mode,userid");
		au.setCallbackSuccess(returnDel);
		au.send();
	}
}
function returnDel(list) {
	var url = list.url;
	var data = list.data;
	var msg = list.msg;
	alert(msg);
	pageMove(url);
}
function sess_chg(ids, vals) {
	if (confirm("권한을 설정하시겠습니까?")) {
		$("#userid").val(ids);
		$("#role").val(vals);
		var au = new AjaxUtil("/spring4/user/sessionRegi", "userid,role");
		au.setCallbackSuccess(returnSession);
		au.send();
	}
}
function returnSession(result) {
	var url = result.url;
	alert("설정되었습니다.");
	pageMove(url);
}
