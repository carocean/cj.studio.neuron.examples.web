print('widget welcome');
exports.doWidget=function(frame,circuit,plug,ctx){
	var text=ctx.resourceText('/readme.txt');
	circuit.content().writeBytes(text.getBytes());
}