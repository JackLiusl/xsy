<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<form action="http://127.0.0.1:8080/xxsystem/m/user/addUser.html" method="post">
    用户名：<input type="text" name="username" value="miaoZhou"/><br/>
    密码：<input type="text" name="password" value="21232f297a57a5a743894a0e4a801fc3"/><br/>
    <input type="submit" name="submit" value="提交"/>
</form>


<TABLE height="29" border="0" cellspacing="0" class=rollboder>
    <TBODY>
    <TR>
        <TD height="22" class=rollleft>
            <DIV class=rollTextMenus>
                <DIV id=rollTextMenu1 style="DISPLAY: block"><STRONG>　本站动态：</STRONG> <A
                        href="/" target="_blank">矢量网页栏目标题</A></DIV>
                <DIV id=rollTextMenu2 style="DISPLAY: none"><STRONG>　本站动态：</STRONG> <A
                        href="http://www.webdm.cn/" target="_blank">矢量律动条+箭头</A></DIV>
                <DIV id=rollTextMenu3 style="DISPLAY: none"><STRONG>　本站动态：</STRONG> <A
                        href="/" target="_blank">2008年北京奥运会会徽矢量</A></DIV>
                <DIV id=rollTextMenu4 style="DISPLAY: none"><STRONG>　本站动态：</STRONG> <A
                        href="/" target="_blank">2008北京奥运福娃AI矢量图</A></DIV>
                <DIV id=rollTextMenu5 style="DISPLAY: none"><STRONG>　本站动态：</STRONG> <A
                        href="/" target="_blank">矢量AI格式的红色飘带</A></DIV>
                <DIV id=rollTextMenu6 style="DISPLAY: none"><STRONG>　本站动态：</STRONG> <A
                        href="/" target="_blank">45个AI格式火矢量图</A></DIV>
            </DIV>
        </TD>
        <TD class=rollcenter id=pageShow>3/6</TD>
        <TD class=rollright><A title=上一条 href="javascript:rollText(-1);"><IMG
                src="http://www.webdm.cn/images/20100829/last.gif"
                alt=上一条 width="11" height="11" border="0"></A> <A title=下一条 href="javascript:rollText(1);"><IMG
                src="http://www.webdm.cn/images/20100829/next.gif"
                alt=下一条 width="11" height="11" border="0"></A></TD>
    </TR>
    </TBODY>
</TABLE>

<script type="text/javascript">
    var rollText_k = 6; //菜单总数
    var rollText_i = 1; //菜单默认值
    //setFocus1(0);
    rollText_tt = setInterval("rollText(1)", 8000);

    function rollText(a) {
        clearInterval(rollText_tt);
        rollText_tt = setInterval("rollText(1)", 8000);
        rollText_i += a;
        if (rollText_i > rollText_k) {
            rollText_i = 1;
        }
        if (rollText_i == 0) {
            rollText_i = rollText_k;
        }
        //alert(i)
        for (var j = 1; j <= rollText_k; j++) {
            document.getElementById("rollTextMenu" + j).style.display = "none";
        }
        document.getElementById("rollTextMenu" + rollText_i).style.display = "block";
        document.getElementById("pageShow").innerHTML = rollText_i + "/" + rollText_k;
    }
</script>
</body>
</html>