<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>dialog对话框</title>
		
	<link rel="stylesheet" type="text/css"href="../js/jquery-easyui-1.4/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css"href="../js/jquery-easyui-1.4/themes/icon.css">
	<script type="text/javascript"src="../js/jquery-easyui-1.4/jquery.min.js"></script>
	<script type="text/javascript"src="../js/jquery-easyui-1.4/jquery.easyui.min.js"></script>
	<script type="text/javascript"src="../js/jquery-easyui-1.4/locale/easyui-lang-zh_CN.js"></script>
	<!-- $(function(){});相当于window.onload-->	
	<script type="text/javascript">
	
			$(function(){
				$("#dd").dialog({
					title:'我的对话框',
					collapsible:true,
					maximizable:true,
					toolbar:[
						{
							text:'新增',
							iconCls:'icon-add', 
							handler:function(){
								alert("bbb");
							} 
						},
						{
							text:'修改',
							iconCls:'icon-edit', 
							handler:function(){
								alert("ccc");
							} 
						}
					],
					buttons:[
						{
							text:'确认',
							iconCls:'icon-ok', 
							handler:function(){
								alert("dd");
							} 
						},
						{
							text:'取消',
							iconCls:'icon-cancel', 
							handler:function(){
								alert("ee");
							} 
						}
					]	  
					
				});
				//单击按钮时候弹出对话框 
				$("#btn").click(function(){
					$("#dialog").dialog('open');
				});
				
			});
			
			
			
			
		</script>	
		

  </head>
  
  <body>
      <div id="dialog" class="easyui-window" style="width: 600px; height: 400px;" closed=true>
    	Dialog Content.
    </div>
    <!-- 对话框 -->
    <!-- <div id="dd" title="My Dialog" fit=true style="width:400px;height:200px;"title="对话框", 
   	collapsible=true,minimizable=true closed=false
   	>   
    	myDialog11
    </div>-->
    
    <div id ="btn" class ="easyui-linkbutton" >单击</div>
  </body>
</html>










