
/* frame */
const header = document.getElementsByTagName('header');
const aside = document.getElementsByTagName('aside');
const body = document.getElementsByTagName('body');
let frameSet;
let opentAsideButton;

/* login & join */
const idCheck = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
const pwCheck = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[`~!@$!%*#^?&\\(\\)\\-_=+])(?!.*[^a-zA-z0-9`~!@$!%*#^?&\\(\\)\\-_=+]).{8,16}$/i;
let joinForm;
let userId;
let userPw;

function moveMain(){
	location.href = '/board';
}

/* aside */
function openAside(){
	opentAsideButton = document.getElementById('Open_Aside_Button');
	frameSet = document.getElementById('Frame_Set');
	
	aside[0].style.display = 'block';
	opentAsideButton.style.display = 'none';
	
	if(screen.width >= 992){
		frameSet.style.width = '76%';
		aside[0].style.borderLeft = '1px solid';
		aside[0].style.borderRight = '1px solid';
	}
	else{
		header[0].style.border = 'none';
		aside[0].style.border = '1px solid';
		frameSet.style.width = '100%';
	}
}
function closeAside(){
	opentAsideButton = document.getElementById('Open_Aside_Button');
	
	header[0].style.borderBottom = '1px solid';
	opentAsideButton.style.display = 'block';
	aside[0].style.display = 'none';
}

/* login & join */
function lengthCheck(x, n){	
	if(n == '1' && x.value.length > 24){
		x.value = x.value.substring(0, 24);
		alert('メールアドレスは24字以内で書いてください。');
	}
	if(n == '2' && x.value.length > 16){
		x.value = x.value.substring(0, 16);
	}
}

/* login */
function loginCheck(){
	loginForm = document.getElementById('Login_Join_Form');
	userId = document.getElementsByName('userId')[0];
	userPw = document.getElementsByName('userPw')[0];
	
	if(idCheck.test(userId.value) && pwCheck.test(userPw.value)){
		alert('');
		joinForm.action = '/board/login';
		joinForm.method = 'post';
	}
	else{
		alert('メールアドレスまたはパスワードに間違いがあります。\nもう一度やり直してください。');
		joinForm.action = 'redirect:/board/login';
		joinForm.method = 'get';
		if(userId.value == '')
			userId.style.border = '1px solid red';
		if(userId.value != '')
			userId.style.border = '1px solid';
		if(userPw.value == '')
			userPw.style.border = '1px solid red';
		if(userPw.value != '')
			userPw.style.border = '1px solid';
	}
}

/* join */
function joinCheck(){
	joinForm = document.getElementById('Login_Join_Form');
	userId = document.getElementsByName('userId')[0];
	userPw = document.getElementsByName('userPw')[0];
	
	if(idCheck.test(userId.value) && pwCheck.test(userPw.value)){
		alert('上記のメールアドレスにメールをお送ります。\n確認の上メール内の認証ボタンをクリックしてください。');
		joinForm.action = '/board/join';
		joinForm.method = 'post';
	}
	else{
		alert('メールアドレスまたはパスワードに間違いがあります。\nもう一度やり直してください。');
		joinForm.action = 'redirect:/board/join';
		joinForm.method = 'get';
		if(userId.value == '')
			userId.style.border = '1px solid red';
		if(userId.value != '')
			userId.style.border = '1px solid';
		if(userPw.value == '')
			userPw.style.border = '1px solid red';
		if(userPw.value != '')
			userPw.style.border = '1px solid';
	}
}

/* board */
function limiteBoardTitle(inputTag){
	var boardTitle = inputTag.value;       
	if(boardTitle.length > 20) {
		inputTag.value = inputTag.value.substring(0, 20);
		alert('タイトルは20字以内で書いてください。');
	}
}
function limiteBoardContent(areaTag){
	var boardContent = areaTag.value;       
	if(boardContent.length > 100) {
		areaTag.value = areaTag.value.substring(0, 100);
		alert('内容は100字以内で書いてください。');
	}
}