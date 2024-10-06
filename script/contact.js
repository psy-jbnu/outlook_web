/**
 * 
 */

function telCheck() {
	var tel = document.frm.tel;
	if(tel.value == "") {
		alert('전화번호를 입력해 주세요');
		tel.focus();
		return;
	}
	if (typeof(document.frm.oldTel)!="undefined") {
		if(document.frm.oldTel.value == tel.value){
			document.frm.retel.value = tel.value;
			return;
		}	
	}
	if(document.frm.tel.value.length != 11) {
		alert("전화번호를 11자 입력하세요");
		document.frm.tel.value="";
		document.frm.tel.focus();
		return; // false : submit 하지 마라 
	}
	
	
	var url = "telCheck.do?tel=" + tel.value;
	window.open(url, "_blank_1", 
			"toolbar=no scrollbars=yes resizable=no, width=450 heigth=200");
}

function telOk() {
	opener.document.frm.tel.value 	= document.frm.tel.value;  
	opener.document.frm.retel.value = document.frm.tel.value;  
	self.close(); 
	
}

function regiCheck() {
	if(document.frm.contactName.value.length == 0) {
		alert("이름을 입력하세요");
		document.frm.contactName.focus();
		return false;  
		
	}

	if(document.frm.tel.value.length == 0) {
		alert("전화번호를 입력하세요");
		document.frm.tel.focus();
		return false; // false : submit 하지 마라 
	}

	if(document.frm.tel.value.length != 11) {
		alert("전화번호를 11자 입력하세요");
		document.frm.tel.value="";
		document.frm.tel.focus();
		return false; // false : submit 하지 마라 
	}
	
	if(document.frm.retel.value == 0) {
		if (document.frm.tel.value == document.frm.oldTel.value) {
			return true;
		}
		alert("중복체크를 하지 않았습니다");
		document.frm.tel.focus();
		return false;
	}
	if(document.frm.groupId.value == -1){
		if(document.frm.newGroup.value.length == 0){
			alert("그룹을 기재하여주세요");
			return false;
		}
		return true;
	}
	return true;
}