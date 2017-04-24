//根据不同浏览器创建request对象
function createXMLHttpRequest(){
	try{
		return new XMLHttpRequest();
	}catch(e){
		try{
			return new ActiveXObject("Msxml2.XMLHTTP");
		}catch(e){
			try{
				return new ActiveXObject("Microsoft.XMLHTTP");
			}catch(e){
				alert("不能识别浏览器");
				throw e;
			}
		}
	}
};
//ajax函数
//option对象
	/*请求方式  method*/
	/*请求的url url*/
	/*是否异步 asyn*/
	/*请求体 params*/
	/*回调方法 callback*/
	/*服务器响应的数据转换成什么类型的 type*/

function ajax(option){

	//1、得到xmlHttp
	var xmlHttp = createXMLHttpRequest();

	//2、打开连接
	//设置默认的请求方式为GET
	if(!option.method){
		option.method = "GET";
	}
	//设置默认为异步请求
	if(option.asyn == undefined){
		option.asyn = true;
	}
	xmlHttp.open(option.method,option.url,option.asyn);
	//判断是否为POST请求
	if(option.method == "POST"){
		xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	}

	//3、发送请求
	xmlHttp.send(option.params);

	//4、注册监听
	xmlHttp.onreadystatechange = function(){

		//双重判断
		if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
			var data;
			//获取服务器响应的数据
			if(!option.type){
				data = xmlHttp.responseText;
			}else if(option.type == "text"){
				data = xmlHttp.responseText;
			}else if(option.type == "xml"){
				data = xmlHttp.responseXML;
			}else if(option.type == "json"){
				var text = xmlHttp.responseText;
				data = eval("("+text+")");
			}
			//调用回调方法
			option.callback(data);
		}
	};
};
