function getFileInfo(fullName){
	var fileName, getLink, fileLink;
	fileLink = fullName.substr(12);
	getLink="/spring02/upload/displayFile?fileName=" + fullName;
	fileName=fileLink.substr(fileLink.indexOf("_")+1);
	return {fileName: fileName, getLink: getLink, fullName: fullName};
}