
<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="ja"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><script type="text/javascript" async="" src="js/script.js"></script>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<title>ニューエラ/New Era公式オンラインストア |マイページ</title>
	<meta name="description" content="メジャーリーグベースボール唯一の公式キャップであるニューエラの直営オンラインスストア。公式通販では、キャップだけでなく、ゴルフ向け帽子やTシャツ・パーカーなどのアパレル商品、バッグなど幅広い商品を取りニューエラキャップ　NEW ERA CAP ニューエラ">

<meta http-equiv="content-style-type" content="text/css">

<link rel="stylesheet" type="text/css" href="css/style.css" media="all">
<link rel="stylesheet" type="text/css" href="css/display_switch.css">
<link rel="stylesheet" href="css/jquery-ui.min.css">
<meta http-equiv="content-script-type" content="text/javascript">
 <script src="js/jquery.min.js"></script>
<script src="js/jquery-ui.min.js"></script>
<script language="JavaScript" type="text/javascript" src="js/common.js"></script>
<script language="JavaScript" type="text/javascript" src="js/search_suggest.js"></script>
<script language="JavaScript" type="text/javascript" src="js/setting.js"></script>
<link rel="SHORTCUT ICON" href="img/favicon.ico">
<!-- etm meta -->
<meta property="etm:device" content="desktop">
<meta property="etm:page_type" content="">
<meta property="etm:cart_item" content="[]"

</head>
<body cz-shortcut-listen="true" class="" style="padding-top: 0px;">



<div class="wrapper_">
	<div id="header" style="top: auto;">
	
			<div id="head_top"><div class="header_inner_">
	<h1 id="tagline">ニューエラ公式オンラインストア</h1>
	<ul class="links"><!--
			<c:if test="${sessionScope.u == null}">
		--><li class="link_login"><a href="jumplogin">ログイン／新規会員登録</a></li><!--
		</c:if>
		<c:if test="${sessionScope.u != null}">
			 <li class="link_mypage"><a href="mypage">マイページ</a></li>
			 <li class="link_logout"><a href="logout">ログアウト</a></li>
		</c:if>
	--></ul>
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
	
<div class="login_ col1_">
<h1 class="common_headline1_"><strong><img src="img/login1.png" alt="LOGIN"></strong><span>ログイン</span></h1>
<span id="err"></span>



<div class="login_wrapper_">
    <div class="login_col_left_">
        <div class="loginform_">
           <h2 class="common_headline2_area_" style="border-bottom: none;">
             <img class="icon_" src="img/icon_login_customer.png" alt="会員のお客様"><span>会員のお客様</span>
           
           </h2>
           
           <hr class="title_ bottom_">
           <div class="login_col_inner">
             <div class="login_col_section">
               <div class="form_text_">メールアドレスとパスワードを入力してログインしてください。</div>
             </div>
             <form method="post" action="login" name="check" id="submit">
             <table class="loginform_">
             <tbody><tr>
             <th class="uid_">メールアドレス：</th>
             <td>
	
               <input class="login_uid_mail_" type="text" name="email" value="" id="email" size="30" maxlength="100" tabindex="1" autocomplete="off"></td>

             </tr><br>
             <tr>
             <th class="pwd_">パスワード：</th>
             <td><input class="login_pwd_" type="password" name="pass" value="" id="pass" size="30" maxlength="20" tabindex="1" autocomplete="off"></td>
             </tr>
             <tr>
             <th></th>
	
             
             </tr> 
             
             

             </tbody></table>
             <div class="inputimage_"><input type="image" id="submit" src="img/login.gif" value="1" alt="ログインする" tabindex="3"></div>
             
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
    inputs[i].style.margin = '0 60 0 0';
        
    }
   }
  
   if(errors == false)
   return !errors;
  }
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
         this.style.color = 'red';
      valid();
     }
    }
   }</script>
             <div class="askpass_"><a href="jumpremind">パスワードをお忘れの方はこちら</a></div>
           </div>
        </div>
    </div>

    <div class="login_col_right_">
      <div class="loginform_">
        <h2 class="common_headline2_area_"><img class="icon_" src="img/icon_login_guest.png" alt="初めてご利用の方・会員以外の方"><span>初めてご利用の方・会員以外の方</span></h2>
        <hr class="title_ bottom_">
        <div class="login_col_inner">
          <div class="login_col_section">
            <div class="form_text_">初めてご利用のお客様は、こちらから会員登録を行って下さい。<br>メールアドレスとパスワードを登録しておくと便利にお買い物ができるようになります。<br>お買い物時に住所やご連絡先の入力が不要です。<br><br><br></div>

            <form method="post" action="jumpagree">

              <div class="inputimage_"><input type="image" src="img/member_quickentry.gif" alt="新規会員登録" tabindex="3"></div>

            </form>

          </div>


        </div>
      </div>
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

</body></html>