<%@ page import="beans.User" %>
<%@ page import="context.*" %>
<%@ page language="java" contentType="text/html;charset=windows-31J"
	pageEncoding="windows-31J"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ja"><head>
	
	<title>ニューエラ/New Era公式オンラインストア |イメール変更</title>

<meta http-equiv="content-style-type" content="text/css">

<link rel="stylesheet" type="text/css" href="css/style.css" media="all">
<link rel="stylesheet" type="text/css" href="css/display_switch.css">
<link rel="stylesheet" href="css/jquery-ui.min.css">
<meta http-equiv="content-script-type" content="text/javascript">
<script async="" src="js/tag.js"></script><script async="" src="js/gtm.js"></script><script src="js/jquery.min.js"></script><style></style>
<script src="js/jquery-ui.min.js"></script>
<script language="JavaScript" type="text/javascript" src="js/jquery.balloon.js"></script>
<script language="JavaScript" type="text/javascript" src="js/jquery.tile.min.js"></script>
<script language="JavaScript" type="text/javascript" src="js/common.js"></script>
<script language="JavaScript" type="text/javascript" src="js/search_suggest.js"></script>
<script language="JavaScript" type="text/javascript" src="js/setting.js"></script>

<link rel="SHORTCUT ICON" href="img/favicon.ico">

<meta property="etm:device" content="desktop">
<meta property="etm:page_type" content="">
<meta property="etm:cart_item" content="[]">



	<link rel="stylesheet" type="text/css" href="css/core.css">
	<link rel="stylesheet" type="text/css" href="css/skin.css">


</head>
<body cz-shortcut-listen="true" class="" style="padding-top: 0px;">



<div class="wrapper_">
	<div id="header" style="top: auto;">
	
			<div id="head_top"><div class="header_inner_">
	<h1 id="tagline">ニューエラ公式オンラインストア</h1>
	<ul class="links">
        <c:if test="${sessionScope.userBean.id == null}">
					<li class="link_login"><a href="jumplogin">ログイン／新規会員登録</a></li>
		</c:if>
		<c:if test="${sessionScope.userBean.id != null}">
					<li class="link_mypage"><a href="jumpmypage">マイページ</a></li>
				 	<li class="link_logout"><a href="logout">ログアウト</a></li>
		</c:if>
	</ul>
</div></div>

			
				<div id="head_main">
	<div class="clearfix header_inner_">
		<p id="logo"><a href="home"><img src="img/logo.svg" alt="NEWERA"></a></p>
		<div class="info">
			<div class="search">
				<form method="post" action="productssearch">
			<input type="hidden" name="" >
			<p class="keyword"><input type="text" value="" size="8" tabindex="1" id="topkeyword" class="keyword_" name="productword" placeholder="商品名のキーワード入力">
			<div class="np-keyword-suggest" style="display: none;"></div><div class="np-item-suggest" style="display: none;"></div></p>
			<p class="btn"><input type="submit" tabindex="1" name="image" id="topsearch_btn" value="検索" src="//d3iuyfi32mtj8g.cloudfront.net/img/usr/common/go.png"></p>
		</form>
            
			</div>
			<p class="btn_favorite"><a href="favoritedisplay">お気に入り</a></p>
			<p class="btn_cart"><a href="cartdisplay">カート</a></p>
		</div>
	</div>
</div>

	</div>
	<% User u = (User)session.getAttribute("userBean"); %>
<div id="contents">
<div class="customer_ col1_">
<div class="navitopicpath_">
<a href="home" class="topicpath_home_">ホーム</a>&gt;<a href="jumpmypage">マイページ</a>&gt;

<a href="">メールアドレス変更</a>

</div>
<h1 class="common_headline1_">メールアドレス変更</h1>

<div class="customer_status_">
<div class="loginname_"><%= u.getFirstName() %><%= u.getLastName() %> 様</div>

</div>
<script>
function check_emailsubmit_addnew()
{
   var anh = window.document.check;         
		if(anh.pass.value=='')
   {
      alert('パスワード未入力です。');
                
      return false;
   }
   else if(anh.email.value=='')
   {
      alert('新しいイメール未入力です。');
                
      return false;
   }
   else if(anh.newemail.value=='')
   {
      alert('確認新しいイメール未入力です。');
                
      return false;
   }
   else if(anh.email.value != anh.newemail.value)
   {
      alert('確認イメール合ってないよー');         
      return false;
   }

   else                       
      return true;   
}
</script>
<form method="post" id="submit" name="check" action="emailchange" onsubmit="return check_emailsubmit_addnew();">
<table class="formdetail_ mailchange_">
<tbody><tr>
<th><img class="must_" src="img/check.gif" alt="必須">メールアドレス</th>
<td>
<%= u.getEmail() %>
</td>
</tr>
<tr>
<th><img class="must_" src="img/check.gif" alt="必須">パスワード</th>
<td>
<input type="password" name="pass" id="pass" value="" size="20" maxlength="20" tabindex="1" autocomplete="off"><br />
<span id="errpass"></span>
</td>
</tr>
<tr>
<th><img class="must_" src="img/check.gif" alt="必須">新しいメールアドレス</th>
<td>
<input type="text" name="email" id="email" value="" size="40" maxlength="100"><br />
<span id="erremail"></span>
<p class="small_">（半角@を含むアドレスを100文字以内で入力してください）</p>
<p class="small_">※「.@ (@の前にドット)」、「.. (ドット2つ)」を含むメールアドレスはご利用いただけません</p>

</td>
</tr>
<tr>
<th><img class="must_" src="img/check.gif" alt="必須">新しいメールアドレスを再入力</th>
<td>
<input type="text" name="newemail" id="newemail" value="" size="40" maxlength="100" tabindex="1" onpaste="alert('確認のためもう一度入力してください');return false">
<p class="small_">（確認のためもう一度入力して下さい）</p>

</td>
</tr>
</tbody></table>
<div class="submit_">
<a href="javascript:history.go(-1);"><img src="img/back.gif" alt="戻る"></a>
<input type="image" name="submit" id="submit" value="1" src="img/change.gif" alt="変更する" tabindex="1">
</div>
</form>
<script>
  var inputs = document.forms['check'].getElementsByTagName('input');
  var run_onchange = false;
  function valid(){
   var errors = false;
   var reg_mail = /^[A-Za-z0-9]+([_\.\-]?[A-Za-z0-9])*@[A-Za-z0-9]+([\.\-]?[A-Za-z0-9]+)*(\.[A-Za-z]+)+$/;
   for(var i=0; i<inputs.length; i++){
    var value = inputs[i].value;
    var id = inputs[i].getAttribute('id');
    var span = document.createElement('span');
    var p = inputs[i].parentNode;
    if(p.lastChild.nodeName == 'SPAN') {p.removeChild(p.lastChild);}
    if(value == ''){
     span.innerHTML ='';
    }else{
     if(id == 'email'){
      if(reg_mail.test(value) == false){ span.innerHTML ='無効なEメール ((例): sample@sample.jp)';}
      var email =value;
     }
     //if(id == 'confirm_email' && value != email){span.innerHTML ='確認Eメールできません';}
     if(id == 'pass'){
      if(value.length <6){span.innerHTML ='6文字以上入力してください';}
      var pass =value;
     }
    }
    if(span.innerHTML != ''){
     inputs[i].parentNode.appendChild(span);
     errors = true;
     run_onchange = true;
     inputs[i].style.border = '1px solid red';
     inputs[i].style.background = 'white';
     
    }
   }// end for
  
   if(errors == false)
   return !errors;
  }// end valid()
  var check = document.getElementById('submit');
  check.onclick = function(){
   return valid();
  }
   for(var i=0; i<inputs.length; i++){
    var id = inputs[i].getAttribute('id');
    inputs[i].onchange = function(){
     if(run_onchange == true){
      this.style.border = '1px solid #999';
      this.style.background = '#fff';
    
      valid();
     }
    }
   }
   </script>

</div>

</div>
</div>

		
	<div id="footer">
			
					
<p id="pagetop" style="position: fixed; bottom: 20px; display: none; opacity: 1;"><a href="#header">PAGE TOP</a></p>
<div id="foot_main"><div class="footer_inner_">
	
	<dl class="follow">
		<dt>FOLLOW US</dt>
		<dd>
			<ul>
				<li><a href="https://www.facebook.com/newerajapan" target="_blank"><img src="img/foot_sns_fb.png" alt="facebook"></a></li>
				<li><a href="https://twitter.com/newera_japan" target="_blank"><img src="img/foot_sns_tw.png" alt="twitter"></a></li>
				<li><a href="http://www.neweracap.jp/news/line/" target="_blank"><img src="img/foot_sns_gplus.png" alt="Google Plus"></a></li>
				<li><a href="https://www.instagram.com/newerajapan/" target="_blank"><img src="img/foot_sns_instagram.png" alt="Instagram"></a></li>
			</ul>
		</dd>
	</dl>
</div></div>
<div id="foot_btm"><div class="footer_inner_">
	<p id="copyright">COPYRIGHT☆ New Era Japan GK. ALL RIGHTS RESERVED.</p>
</div></div>
			
	</div>
</div>




<div class="selection_bubble_root" style="display: none;"></div></body></html>
function checkEmail() {

        var email 		= document.getElementById('email');
        var pass 		= document.getElementById("pass");
        var newemail	= document.getElementById("newemail");
        var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
        if (pass.value=='') {
            
			document.getElementById("errpass").innerHTML = "パスワード未入力です。";
			pass.style.background = "red";
            return false;
       }
       else if (email.value=='') {
            
			document.getElementById("erremail").innerHTML = "email未入力です。";
			email.style.background = "red";
            return false;
       }
        else
        return true;
    }