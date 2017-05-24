<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/common.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<title>登陆界面</title>
<script type="text/javascript">
    $(function(){
        $("#showPwd").click(function(){
            console.log("click");
            if($(this).attr("checked")){
                $("#passWord").attr("type","text");
            }else{
                $("#passWord").attr("type","password");
            }
        });
    });
</script>
</head>
<body>
<div align="right">这是一个登陆页面！</div>
<form action="" method="post">
    <table align="center">
        <tr>
            <td>用户名：</td>
            <td><input type="text" id="userName" value="${pageContext.request.userName}"></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input type="password" id="passWord" value=""><input type="checkbox" id="showPwd">显示密码</td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="登陆" style="color:white;background-color:#00BFFF;border: none;">
            </td>
        <tr/>
    </table>
</form>
</body>
</html>
