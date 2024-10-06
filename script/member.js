/**
 * 
 */
function loginOK() {
	var frm = document.frm;
	var userEmail 	= frm.userEmail.value;
	var pwd 		= frm.pwd.value;
	var result = false;
	if (userEmail.length == 0) {
		alert("Email을 입력해주세요.");
	} else if(pwd.length == 0){
		alert("비밀번호를 입력해주세요.");
	} else {
		result = true;
	}
	return result;
}
function updateChk() {
	var frm = document.frm;
	var userEmail 	= frm.userEmail.value;
	var pwd 		= frm.pwd.value;
	var result = false;
	if (userEmail == "") {
		alert("Email을 입력해주세요")
	}else if (pwd == "") {
		alert("비밀번호를 입력해주세요")
	}else if (pwd != frm.pwd_chk.value) {
		alert("비밀번호가 일치하지 않습니다.")
	}else {
		result = true;
	}
	return result;
	
	
}