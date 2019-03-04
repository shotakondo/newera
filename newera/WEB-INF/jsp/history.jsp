<%@ page import="beans.User" %>
<%@ page import="context.*" %>
<%@ page language="java" contentType="text/html;charset=windows-31J"
	pageEncoding="windows-31J"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ja"><head>
	
	<title>ニューエラ/New Era公式オンラインストア |購入履歴</title>

<meta http-equiv="content-style-type" content="text/css">

<link rel="stylesheet" type="text/css" href="css/style.css" media="all">
<link rel="stylesheet" type="text/css" href="css/display_switch.css"><!-- hien thi-->
<link rel="stylesheet" href="css/jquery-ui.min.css">
<meta http-equiv="content-script-type" content="text/javascript">
<script async="" src="js/tag.js"></script><script async="" src="js/gtm.js"></script><script src="js/jquery.min.js"></script><style></style>
<script src="js/jquery-ui.min.js"></script>
<script language="JavaScript" type="text/javascript" src="js/jquery.balloon.js"></script>
<script language="JavaScript" type="text/javascript" src="js/jquery.tile.min.js"></script>
<script language="JavaScript" type="text/javascript" src="js/common.js"></script>
<script language="JavaScript" type="text/javascript" src="js/search_suggest.js"></script>
<script language="JavaScript" type="text/javascript" src="js/setting.js"></script><!--scroll menu-->
<link rel="SHORTCUT ICON" href="img/favicon.ico">
<!-- etm meta -->
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
	<ul class="links"><!--
		  --><li class="link_mypage"><a href="jumpmypage">マイページ</a></li><!--
        --><li class="link_logout"><a href="logout">ログアウト</a></li><!--
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
			<div class="np-keyword-suggest" style="display: none; left: 677px; top: 50px;"></div><div class="np-item-suggest" style="display: none; left: 677px; top: 50px;"></div></p>
			<input name="image" type="submit" value="検索" tabindex="1" src="img/go.png"  >
		</form>
			</div>
			<p class="btn_favorite"><a href="favoritedisplay">お気に入り</a></p>
			<p class="btn_cart"><a href="cartdisplay">カート</a></p>
		</div>
	</div>
</div>

	</div>
	<% User u = (User)session.getAttribute("userBean"); %>
<div class="customer_ col1_">
<div class="navitopicpath_"><a href="home" class="topicpath_home_">ホーム</a>&gt;<a href="jumpmypage">マイページ</a>&gt;<a href="">購入履歴</a></div>
<h1 class="common_headline1_">購入履歴一覧</h1>


<div class="customer_status_">
<div class="loginname_">${userBean.getFirstName()} ${userBean.getLastName()} 様</div>

</div>


<table class="formlist_ history_">
<tbody><tr>
<th>注文日</th>
<th>オーダーＩＤ</th>

<th>注文内容</th>
<th>注文金額合計</th>
<th>支払方法</th>
<th>処理状態</th>
</tr>
    <c:forEach var="orders" items="${data}">
<tr>
	<td class="order_dt_">${orders.date}</td>
	<td class="order_id_"><a href="cartdisplay">${orders.oid}</a></td>
	
	<td class="order_detail_"><ul>
<c:forEach var="products" items="${orders.products}">
<li><div class="name_"><div class="name1_">${products.name}</div>

</div></li>
</c:forEach>
</ul>

<p class="order_again_">
</td>
	<td class="total_">￥${orders.total}</td>
	<td class="method_">${orders.method}</td>
	<td class="status_"><a href=""><img src="//d3iuyfi32mtj8g.cloudfront.net/img/sys/status/ship2.gif" class="process_" alt="処理状態"></a></td>
</tr>
</c:forEach>
</tbody></table>

<div class="submit_">
<a href="javascript:history.go(-1);"><img src="//d3iuyfi32mtj8g.cloudfront.net/img/sys/button/back.gif" alt="戻る"></a>
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