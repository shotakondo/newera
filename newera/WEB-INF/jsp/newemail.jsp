<%@ page language="java" contentType="text/html;charset=windows-31J"
	pageEncoding="windows-31J"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ja"><head>
	
	<title>ニューエラ/New Era公式オンラインストア |会員登録</title>
	
<meta http-equiv="content-style-type" content="text/css">

<link rel="stylesheet" type="text/css" href="css/style.css" media="all">
<link rel="stylesheet" type="text/css" href="css/display_switch.css">
<link rel="stylesheet" href="css/jquery-ui.min.css">
<meta http-equiv="content-script-type" content="text/javascript">
<script async="" src="js/tag.js"></script><script async="" src="js/gtm.js"></script>
<script src="js/jquery.min.js"></script>
<script src="js/jquery-ui.min.js"></script>
<script language="JavaScript" type="text/javascript" src="js/jquery.balloon.js"></script>
<script language="JavaScript" type="text/javascript" src="js/jquery.tile.min.js"></script>
<script language="JavaScript" type="text/javascript" src="js/common.js"></script>
<script language="JavaScript" type="text/javascript" src="js/search_suggest.js"></script>
<script language="JavaScript" type="text/javascript" src="js/setting.js"></script>
<script> 
function validateForm() {
var email = document.getElementById('email').value;
var pass = document.getElementById('pass').value;
var pass1 = document.getElementById('pass1').value;
if(email ==''){
		alert('イメール入力してください');
}
else if(pass ==''|| pass1 ==''){
		alert('新しいパスワード入力してください');
}
else if(pass != pass1){
		alert('確認パスワード合ってないよー');
}

else{
        alert('合ってる');
        return true;
    }
 
    return false;
}

</script>
<link rel="SHORTCUT ICON" href="img/favicon.ico">
 etm meta 
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
	
<div id="contents">

<div class="customer_ col1_">
<h1 class="common_headline1_">パスワード再設定</h1>


<div class="navigation_">
登録されているメールアドレスと新しいパスワードを入力して変更ボタンをクリックしてください。
</div>
<form method="post" action="passreplace" onsubmit="return validateForm()">
<table class="formdetail_ passchange_">
<tbody><tr>
<th>登録されているメールアドレス</th>
<td>
<input type="text" name="email" value="" size="40" maxlength="100" tabindex="1" id="oldid">

</td>
</tr>
<tr>
<th>新しいパスワード</th>
<td>
<input type="password" name="pass" value="" size="20" maxlength="20" id="npwd1" tabindex="1" autocomplete="off">
（半角英数字記号 6文字以上,20文字以内で入力してください。IDと同様のパスワードは入力できません。）

</td>
</tr>
<tr>
<th>新しいパスワード（確認）</th>
<td>
<input type="password" name="pass1" value="" size="20" maxlength="20" id="npwd2" tabindex="1" autocomplete="off" onpaste="alert('確認のためもう一度入力してください');return false">
（確認のためもう一度入力してください）

</td>
</tr>
</tbody></table>
変更ボタンをクリックすると、お客様の古いパスワードを新しいパスワードに変更させていただきます。<br>
<div class="submit_">
<input type="image" name="submit" src="img/change.gif" alt="変更する" tabindex="1" ></div>
</form>


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
	<p id="copyright">COPYRIGHT? New Era Japan GK. ALL RIGHTS RESERVED.</p>
</div></div>
			
	</div>
</div>




<div class="selection_bubble_root" style="display: none;"></div></body></html>