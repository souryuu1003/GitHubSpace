
const header = document.getElementsByTagName('header');
const aside = document.getElementsByTagName('aside');
const body = document.getElementsByTagName('body');
let frameSet;
let opentAsideButton;

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

/* board */
function limiteBoardTitle(inputTag){
	var boardTitle = inputTag.value;       
	if(boardTitle.length > 20) {
		inputTag.value = inputTag.value.substring(0, 20);
		alert("20 OVER");
	}
}
function limiteBoardContent(areaTag){
	var boardContent = areaTag.value;       
	if(boardContent.length > 100) {
		areaTag.value = areaTag.value.substring(0, 100);
		alert("100 OVER");
	}
}