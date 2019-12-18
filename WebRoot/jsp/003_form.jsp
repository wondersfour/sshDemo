<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>My JSP '003_form.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	
	<link rel="stylesheet" type="text/css"href="../js/jquery-easyui-1.4/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css"href="../js/jquery-easyui-1.4/themes/icon.css">
	<script type="text/javascript"src="../js/jquery-easyui-1.4/jquery.min.js"></script>
	<script type="text/javascript"src="../js/jquery-easyui-1.4/jquery.easyui.min.js"></script>
	<script type="text/javascript"src="../js/jquery-easyui-1.4/locale/easyui-lang-zh_CN.js"></script>
	
	<script type="text/javascript">
		/**
		* form表单提交的三种方式
		* 1>异步ajax提交
		* 2> EasyUI form表单中调用 form方法 手动或者自动提交 
			
		*/
		$(function(){
			$.extend($.fn.validatebox.defaults.rules, { 
				minLength: {   
        			 validator: function(value, param){   
            			 return value.length >= param[0];   
      				  },   
         			message: '请输入至少5个字符！'  
    		 	} 
    		 	/*,valAge:{
    		 		
    		 	} 多个验证用逗号隔开，这里相当于一个json数组 */
    		 	
    		 	
    		 	
    		 	
			});
			/*numberbox用于检验数字时很好用 */
			
			$("#age").numberbox({
				  min:0,
				  max:120,
				  required:true,
				  missingMessage:'年龄必填'  ,
				  precision:0
				  
				});
				
			$("#birthday").datebox({
				 required:true,
				 missingMessage:'生日必填！',
				 editable:false//继承自combo用于禁止手动填写 
				 /*formatter:function(date){
				 	return 
				 }*/
				 
			});
			
			//存在的问题找不到获取数据的路径！！！
			$("#city").combobox({
				 url:'CityServlet?method=getCity', 
				 valueField:'id', 
				 textField:'text'  
				  
			});
			
			
			$("#beginTime").datetimebox({
				required:true,
				editable:false
				//showSeconds:false
				  
			});
			
			
		});
		
	</script>
	
  </head>
  
  <body>
   	
   	<div id ="myDiv" class="easyui-dialog" fit=true style="width:500px;height:300px" title="用户新增">
   		<form id ="myfrom" method="post">
	   			<table>
	   				<tr>
	   					<td>姓名：</td>
	   					<td><input type="text" id="username" class="easyui-validatebox" required=true validType="minLength[5]" missingMessage="用户名必填！" value=""/></td>
	   				</tr>
	   				<tr>
	   					<td>性别：</td>
	   					<td><input type="radio" id="sex" checked=checked value="男"/>男
	   						<input type="radio" id="sex" value="女"/>女
	   					</td>
	   				</tr>
	   				<tr>
	   					<td>薪水：</td>
	   					<td><input type="text" id="salary" value=""/></td>
	   				</tr>
	   				<tr>
	   					<td>年龄：</td>
	   					<td><input type="text" id="age"class="easyui-validatebox" value="" required=true/></td>
	   				</tr>
	   				<tr>
	   					<td>出生日期：</td>
	   					<td><input type="text" id="birthday"/></td>
	   				</tr>
	   				<tr>
	   					<td>所属城市：</td>
	   					<td><input type="text" id="city"/></td>
	   				</tr>
	   				<tr>
	   					<td>开始时间：</td>
	   					<td><input type="text" id="beginTime"/></td>
	   				</tr>
	   				<tr align="center">
	   					<td colspan="2">
	   						<a id="btn" class="easyui-linkbutton">新增</a>
	   					</td>
	   				</tr>
	   			</table>
	   	</form>
   	</div>
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	

  </body>
</html>
