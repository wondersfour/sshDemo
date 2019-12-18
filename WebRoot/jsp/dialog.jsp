<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <link rel="stylesheet" type="text/css"href="../js/jquery-easyui-1.4/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css"href="../js/jquery-easyui-1.4/themes/icon.css">
		<script type="text/javascript"src="../js/jquery-easyui-1.4/jquery.min.js"></script>
		<script type="text/javascript"src="../js/jquery-easyui-1.4/jquery.easyui.min.js"></script>
		<script type="text/javascript"src="../js/jquery-easyui-1.4/locale/easyui-lang-zh_CN.js"></script> 
  </head>
  
  <body>
   	<div id="dd" title="My Dialog" style="width:400px;height:200px;" title="对话框", 
   	collapsible=true,minimizable=true
   	>  
   		my dialog112
   	</div>
   	
   		<script type="text/javascript">
			$('#dd').dialog({
				modal:true   		
   			});   		
   		</script>
   	
  </body>
</html>
