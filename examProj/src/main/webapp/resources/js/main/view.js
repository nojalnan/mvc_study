function deleteCheck() {
	// /main/delete.do?no=${item.no}
	if( confirm("삭제하시겠습니까?") ) {
		location.href = "/main/delete.do?binum="+ $("#binum").val();
	};
}