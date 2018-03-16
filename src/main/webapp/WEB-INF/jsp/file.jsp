<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="/static/uploadify.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/static/jquery-2-2.0.js"></script>
<script type="text/javascript" src="/static/jquery.uploadify.js"></script>
<style type="text/css">
#bg {
	display: none;
	position: absolute;
	top: 0%;
	left: 0%;
	width: 100%;
	height: 100%;
	background-color: black;
	z-index: 1001;
	-moz-opacity: 0.7;
	opacity: .70;
	filter: alpha(opacity = 70);
}

#show {
	display: none;
	position: absolute;
	top: 25%;
	left: 22%;
	width: 53%;
	height: 49%;
	padding: 8px;
	border: 8px solid #E8E9F7;
	background-color: white;
	z-index: 1002;
	overflow: auto;
}
</style>
</head>
<body>

	<form action="/uploadFile/uploadFile.do" method="post"
		enctype="multipart/form-data">
		<input type="file" name="file" size="50" /><input type="submit"
			value="UPLOAD">
	</form>
	<input type="hidden" id="sessionId"
		value="<%=request.getSession().getId()%>" />
	<input type="hidden" id="ctx" value="<%=request.getHeader("host")%>" />
	<table>
		<tr>
			<td><label> 上传课件：</label></td>
			<td><label><input type="file" name="upload"
					id="uploadify" multiple="true" /></label>&nbsp;&nbsp;</td>
			<td><div id="fileQueue"></div></td>
		</tr>
	</table>
	<script type="text/javascript">
		$(function() {
			var ctx = "http://" + document.getElementById("ctx").value;
			$("#uploadify")
					.uploadify(
							{
								'debug' : false,
								'uploader' : '/uploadFile/uploadFile.do;jsessionid='
										+ $("#sessionId").val(),
								'cancelImg' : '/static/uploadify-cancel.png',
								'queueID' : 'fileQueue',
								'auto' : true,
								'buttonText' : 'select',
								'method' : 'post',
								'fileObjName' : 'upload',
								'multi' : true,
								'sizeLimit' : 1073741824,
								'simUploadLimit' : 1,
								'queueSizeLimit' : 1,
								'fileExt' : '*.jpg;*.gif;*.jpeg;*.png;*.bmp;*.zip;*.rar;*.mp4',
								onComplete : function(event, queueID, fileObj,
										response, data) {
									//转换为json对象
									var dataObj = eval("(" + response + ")");
									saveFile(dataObj);
								},
								onSelect : function() {

								},
								onError : function(event, queueID, fileObj) {
									alert("文件:" + fileObj.name + "上传失败");
								},
								onUploadSuccess : function(file, data, response) {
									if (data == "success") {
										document.getElementById("bg").style.display = "block";
										document.getElementById("show").style.display = "block";
									}
								}
							});

		});
		function hidediv() {
			document.getElementById("bg").style.display = 'none';
			document.getElementById("show").style.display = 'none';
		}
	</script>
	<div id="bg"></div>
	<div id="show">
		上传成功 <input id="btnclose" type="button" value="Close"
			onclick="hidediv();" />
	</div>
</body>
</html>