<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/frameset.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<STYLE type=text/css>
	BODY {
		FONT-SIZE: 12px; COLOR: #ffffff; FONT-FAMILY: 宋体
	}
	TD {
		FONT-SIZE: 12px; COLOR: #ffffff; FONT-FAMILY: 宋体
	}
	form a{text-decoration: none;}
	form a:link {color: #FFF;}
	form a:hover {color: #F40;}
</STYLE>

<META content="MSHTML 6.00.6000.16809" name=GENERATOR>
<script type="text/javascript">
	window.onload=function(){
		if(window.parent != window){// 如果是在框架中
			//就让框架页面跳转到登陆页面
			window.parent.location.href = "${pageContext.request.contextPath}/login.jsp";
		}	
	};
	function SavePassword(){
		if(document.getElementById("savePassword").checked){
			var user_code = $("#user_code").val();
			var user_password = $("user_password").val();
			windows.sessionStorage.user_code = user_code;
			windows.sessionStorage.user_password = user_password;
			localStorage.rmbPassword = true;
		}else{
			localStorage.rmbPassword = false;
		}
	}
	 //切换验证码
	function change(){
		 alert(12);
	}
	var countdown=10;        //初始值
	function regain(val){
		settime(val);
		var xmlHttp = new XMLHttpRequest();
		if(xmlHttp == null){
			alert("无法初始化xmlHttp对象");
		}
		phoneNumber = document.getElementById("txtPhone").value;
		if(phoneNumber == null || phoneNumber == ""){
			alert("请填写手机号码，用于接收验证码!");
			return;
		}
		url = "VerificationCodeAction_execute?" + "phoneNumber=" + phoneNumber;
		xmlHttp.open("GET",url,true);
		xmlHttp.onreadystatechange = function (){
			if(xmlHttp.readyState == 4){
				alert("验证码已发送，请检查设备获得验证码！");
			}
		}
		xmlHttp.send();
	}
	function settime(val) {
	    if (countdown == 0) {
            val.removeAttribute("disabled");
            val.value="获取验证码";
            countdown = 10;
        } else {
	        val.setAttribute("disabled", true);
            val.value="重新发送(" + countdown + ")";
            countdown--;
            setTimeout(function(){
            	settime(val);
            },1000);
        }   
    }

</script>

</HEAD>
<BODY>
<FORM id=form1 name=form1 action="${pageContext.request.contextPath}/UserAction_login"  method=post>

<DIV id=UpdatePanel1>
<DIV id=div1 
style="LEFT: 0px; POSITION: absolute; TOP: 0px; BACKGROUND-COLOR: #0066ff"></DIV>
<DIV id=div2 
style="LEFT: 0px; POSITION: absolute; TOP: 0px; BACKGROUND-COLOR: #0066ff"></DIV>


<DIV>&nbsp;&nbsp; </DIV>
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width=900 align=center border=0>
  <TBODY>
  <TR>
    <TD style="HEIGHT: 105px"><IMG src="images/login_1.gif" 
  border=0></TD></TR>
  <TR>
    <TD background=images/login_2.jpg height=300>
      <TABLE height=300 cellPadding=0 width=900 border=0>
        <TBODY>
        <TR>
          <TD colSpan=2 height=35></TD></TR>
        <TR>
          <TD width=360></TD>
          <TD>
            <TABLE cellSpacing=0 cellPadding=2 border=0>
              <TBODY>
              <TR>
                <TD style="HEIGHT: 28px" width=80>登 录 名：</TD>
                <TD style="HEIGHT: 28px" width=150><INPUT id=txtName 
                  style="WIDTH: 130px" name="user_code" placeholder="请输入登录名"></TD>
                <TD style="HEIGHT: 28px" width=370><SPAN 
                  id=RequiredFieldValidator3 
                  style="FONT-WEIGHT: bold; VISIBILITY: hidden; COLOR: white" >请输入登录名</SPAN></TD></TR>
              <TR>
                <TD style="HEIGHT: 28px">登录密码：</TD>
                <TD style="HEIGHT: 28px"><INPUT id=txtPwd style="WIDTH: 130px" 
                  type=password name="user_password" placeholder="请输入登录密码"></TD>
                <TD style="HEIGHT: 28px"><SPAN id=RequiredFieldValidator4 
                  style="FONT-WEIGHT: bold; VISIBILITY: hidden; COLOR: white">请输入密码</SPAN>
                 </TD>
              </TR>
              <TR>
                <TD style="HEIGHT: 28px">手机号码：</TD>
                <TD style="HEIGHT: 28px"><INPUT id=txtPhone style="WIDTH: 130px" 
                  type="text" name="user_phone" placeholder="请输入手机号码"></TD>
                <TD style="HEIGHT: 28px"><SPAN id=RequiredFieldValidator4 
                  style="FONT-WEIGHT: bold; VISIBILITY: hidden; COLOR: white">请输入手机号码</SPAN>
                 </TD>
              </TR>
              <TR>
                <TD style="HEIGHT: 28px">验证码：</TD>
                <TD style="HEIGHT: 28px">
                  <input id = "v" type="text" style="WIDTH: 130px" id="checkcode" name="checkcode" placeholder="验证码"/>
                </TD>
                <td>
				  <!--  
				  <a href="javascript:void(0);" onclick="change()">重新获取验证码</a>
				  -->
				  <input id="btn_change" type="button" value="获取验证码" onclick="regain(this)" />
				</td>
              </TR>
              <tr>
              	<td colspan="2">
              		<input type="checkbox" name="savePassword" id="savePassword" onclick="SavePassword()">&nbsp;记住密码
              	</td>
              </tr>
              <TR>
                <TD style="HEIGHT: 18px" colspan="2" ><font color="red" ><s:property value="exception.message" /> </font></TD>
                <TD style="HEIGHT: 18px"></TD>
              </TR>
              <TR>
                <TD colspan="2">
                  <INPUT id="btn" type=image src="images/login_button.gif" name="btn"
                  style="BORDER-TOP-WIDTH: 0px; BORDER-LEFT-WIDTH: 0px;
                  BORDER-BOTTOM-WIDTH: 0px;BORDER-RIGHT-WIDTH: 0px" 
                  />
                  <img  src="images/regist_button.png" style="cursor: pointer;" onclick="window.location.href='${pageContext.request.contextPath}/regist.jsp'">
              </TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE></TD></TR>
  <TR>
    <TD><IMG src="images/login_3.jpg" 
border=0></TD></TR></TBODY></TABLE></DIV></DIV>


</FORM>
<s:debug></s:debug>
</BODY></HTML>
