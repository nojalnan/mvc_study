function updateCheck() {
	// /main/delete.do?no=${item.no}

	if( $("#title").val() == "" ) {
		alert("제목을 입력해주세요");
		$("#title").focus();
		return;
	}

	if( $("#content").val() == "" ) {
		alert("내용을 입력해주세요");
		$("#content").focus();
		return;
	}
	
	if( confirm("현재 상태로 글을 작성하시겠습니까?") ) {
		$("form").submit();
//		location.href = "/main/delete.do?no="+ $("#no").val();
	};
}