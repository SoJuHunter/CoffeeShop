/**
 * 
 */
 
 function getAllUpload(qno, uploadItems) {
	$.getJSON("/qna/"+qno+"/uploadall", function(data){
		for(let i=0; i<data.length; i++) {
			let filename = data[i];
			let str = makeUploadItemTagForRead(filename);
			
			uploadItems.append(str);
		}
		
	});
}


function getAllReply(qno, replies) {
	$.getJSON("/qna/" + qno + "/replyall", function(data) {
		for(let i=0; i<data.length; i++) {
			let replyText = data[i].replyText;
			let rno = data[i].rno;
			console.log(rno);
			
			let str = makeTagForReply(qno, replyText, rno);
			
			replies.append(str);
		}
	});
}

function makeTagForReply(qno, replyText, rno) {
	let str = `
		<div>
			<p style="display:none;">${qno}</p>
			<p style="display:none;">rno : ${rno}</p>
			<p>${replyText}</p>
			<a href="#">수정</a>
			<a href="#">삭제</a>
			
			<hr>
		</div>
	`;
	
	return str;
}




function makeUploadItemTagForRead(filename) {
	
	let imgSrc = "";
	if(isImg(filename)) {
		imgSrc = "/displayfile?filename=" + filename;
	}else {
		imgSrc = "/resources/img/일반파일.jpg";
	}
	
	
	let aHref = "";
	if(isImg(filename)) {
		aHref = "/displayfile?filename=" + getImgFilePath(filename); 
	}else {
		aHref = "/displayfile?filename=" + filename;
	}
	
	let pText = getOrgName(filename);
	
	let btnDataFilename = filename;
	
	let str = `
		<div>
			<a href="${aHref}" target="_blank">
				<img src="${imgSrc}" alt="업로드한 파일의 썸네일">
			</a>
			<div>
				<p>${pText}</p>
			</div>
		</div>
	`;
	
	return str;
}

function isImg(filename) {
	let idx = filename.lastIndexOf(".") + 1;
	
	let formatName = filename.substring(idx).toLowerCase();
	
	if(formatName == "png" || formatName == "gif" || formatName == "jpg" || formatName == "jpeg") {
		return true;
	}else {
		return false;
	}
}

function getImgFilePath(filename) {
	let prefix = filename.substring(0, 12);
	let suffix = filename.substring(14);
	
	return prefix + suffix;
}

function getOrgName(filename) {
	let orgName = "";
	
	let idx = -1;
	
	if(isImg(filename)) {
		idx = filename.indexOf("_", 14) + 1;
	}else {
		idx = filename.indexOf("_") + 1;
	}
	
	orgName = filename.substring(idx);
	
	return orgName;
}