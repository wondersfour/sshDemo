<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
out.print(basePath);

	
	
	java.text.SimpleDateFormat sdf3 = new java.text.SimpleDateFormat("yyyy");
	String uploaded = (String)request.getParameter("uploaded");
	if(uploaded!=null && !"".equals(uploaded)){
	%>
	<script type="text/javascript">
		alert("上传成功");
	</script>
<% 
	}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  		<!--  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE"/>
		<link rel="stylesheet" type="text/css" href="css/all.css"/>
		<link rel="stylesheet" type="text/css" href="css/pop.css"/>
		<link rel="stylesheet" type="text/css" href="css/main.css"/>-->
    <base href="<%=basePath%>">
    
    <title>文件上传demo</title>
    
	
  </head>
  
 <body style="background: #e1e9eb;">
		<form id="mainForm" method="post" enctype="multipart/form-data" action="<%=basePath %>fileUpload.do">
			<div class="right">
				<!-- <div class="current">当前位置：<a href="###">导入/导出</a> &gt; 导入Excel</div> -->
				<div class="rightCont">
					<p class="g_title fix">导入</p>
					<table class="tab1" width="100%">
						<tbody>
							<tr>
							<td >选择数据来源<font color="red">*</font>：</td>
								<td >
									<select id="upLoadNf" name="upLoadNf">
										<option value ="">请选择</option>
										<%for(int i=0;i<=4;i++){%>
										<option value ="<%=Integer.parseInt(sdf3.format(new Date()))-i%>"><%=Integer.parseInt(sdf3.format(new Date()))-i%>年</option>
										<%}%>
									</select>
									<select id="selectTime" name ="selectTime">
										<option>请选择</option>
										<%for(int i=1;i<=12;i++){%>
										<option value="<%=i%>"><%=i%>月</option>
										<%}%>
									</select>
								</td>
							<!--<td width="30%">
								<input id="title" name="title" class="allInput" style="width:100%;" type="text"/>
							</td>-->
							<td>选择附件类型<font color="red">*</font>：</td>
							<td>
								<select id="selectId" name ="select">
									<option></option>
									<option value ="unSatisfied">不满意件</option>
									<option value="unSolved">未解决件</option>
									<option value="unFirstConnected">未先行联系件</option>
								</select>
								
							</td>
							<td align="left" width="10%">选择文件<font color="red">*</font>：</td>
							<td align="left" width="30%">
								<input type="file" name="excel" style="width:100%;" id ="excelId"/>
							</td>
						</tr>
					</tbody></table>
					<div style="text-align: center; margin-top: 30px;">
						<input class="tabSub" value="导 入" onclick="formSubmit()" type="button" />
					</div>
				</div>
			</div>
			<input type="hidden" id ="select" name="select"/>
			<input type="hidden" id ="selectTimeValue" name="selectTimeValue"/>
			<input type="hidden" id ="selectNfTimeValue" name="selectNfTimeValue"/>
		</form>
	</body>
	<script type="text/javascript">
		function formSubmit(){
			var selectValue =document.getElementById("selectId").value;
			var excelValue=document.getElementById('excelId').value;
			var selectTime=document.getElementById('selectTime').value;
			var upLoadNf=document.getElementById('upLoadNf').value;
			//alert(selectTime);
			if(selectValue !="" && excelValue !="" && selectTime!="" && upLoadNf!=""){
				document.getElementById('select').value =selectValue;
				document.getElementById('selectTimeValue').value =selectTime;
				document.getElementById('selectNfTimeValue').value =upLoadNf;
				document.getElementById('mainForm').submit();
			}else{
				alert("请将信息补充完整！");
				return false;
			}
			
			
		}
	</script>
</html>
