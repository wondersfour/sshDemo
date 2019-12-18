<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//String bb=1;
%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Demo</title>
    
</head>
<body>

</body>

<script src="<%=basePath %>ueditor/ueditor.config.js"></script>
<script src="<%=basePath %>ueditor/ueditor.all.min.js"></script>
<script src="<%=basePath %>ueditor/lang/zh-cn/zh-cn.js"></script>


<script id="container" name="content" type="text/plain"></script>
<script type="text/javascript">
    var ue = UE.getEditor('container');
    ue.ready(function() {
    var lang = ue.getOpt('serverUrl'); //接口地址
    //alert(lang);
    
    /*ue.execCommand('serverparam', {
        'key1': 'value1',
        'key2': 'value2',
    });*/
});
    
</script>
</html>