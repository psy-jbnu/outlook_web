/**
 * 
 */

function activeAddGroup(){
	if (document.frm.groupId.value =="-1"){
		document.frm.newGroup.type ="text";
	}else{
		document.frm.newGroup.type ="hidden";
	}
}
function groupEdit(number){
		
	if (document.frm.edit.type == "button") {
		document.frm.newGroup.type = "text";
		document.frm.edit.onclick = "return groupOk()";
		document.frm.edit.type = "submit";
	}
}
function groupOk(){
	if (document.frm.newGroup.value.length == 0) {
		alert("그룹을 입력해주세요")
		return false
	}
	return true;s
}

	