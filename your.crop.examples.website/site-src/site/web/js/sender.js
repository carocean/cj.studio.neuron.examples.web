function sendit() {
	var text = document.getElementById("text");
	// var
	var cookie = document.getElementById("cookie");
	var frame = 'command=read\r\nurl=/\r\nprotocol=do/1.1\r\nCookie='+cookie.value+'\r\n\r\n\r\n'
	+ text.value;
	//var frame = text.value;
	$.cj.socket.send(frame);
}
function read2txt() {
	var text = document.getElementById("text");
	var cookie = document.getElementById("cookie");
	var frame = 'command=read\r\nurl=/read/\r\nprotocol=do/1.1\r\nCookie='+cookie.value+'\r\n\r\n\r\n'
			+ text.value;
	// var frame=text.value;
	$.cj.socket.send(frame);
}