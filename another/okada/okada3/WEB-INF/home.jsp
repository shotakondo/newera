<%@ page language="java" contentType="text/html;charset=windows-31J"
	pageEncoding="windows-31J"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ja"><head>
	
	<title>ニューエラ/New Era公式オンラインストア |ホームページ</title>
<meta http-equiv="content-style-type" content="text/css">

<link rel="stylesheet" type="text/css" href="css/style.css" media="all">
<link rel="stylesheet" type="text/css" href="css/display_switch.css">
<link rel="stylesheet" href="css/jquery-ui.min.css">
<meta http-equiv="content-script-type" content="text/javascript">
<script type="text/javascript" async="" src="js/rule"></script>
<script type="text/javascript" async="" src="js/rule(1)"></script>
    <script type="text/javascript" async="" src="js/script.js"></script>
    <script async="" src="js/tag.js"></script>
    <script type="text/javascript" async="" src="js/beaver.js"></script>
    <script async="" src="js/gtm.js"></script>
    <script src="js/jquery.min.js"></script>
<script src="js/jquery-ui.min.js"></script>
<script language="JavaScript" type="text/javascript" src="js/jquery.balloon.js"></script>
<script language="JavaScript" type="text/javascript" src="js/jquery.tile.min.js"></script>
<script language="JavaScript" type="text/javascript" src="js/common.js"></script>
<script language="JavaScript" type="text/javascript" src="js/search_suggest.js"></script>
<script language="JavaScript" type="text/javascript" src="js/setting.js"></script><!--zoom -->
<link rel="SHORTCUT ICON" href="img/favicon.ico">
<!-- etm meta -->



<script type="text/javascript" src="js/sna.js"></script>

	<script type="text/javascript" src="js/goods_ajax_cart.js"></script>
	<script type="text/javascript" src="js/goods_ajax_bookmark.js"></script>
	<script type="text/javascript" src="js/goods_ajax_quickview.js"></script>
	<link rel="stylesheet" type="text/css" href="css/core.css">
	<link rel="stylesheet" type="text/css" href="css/skin.css">
</head>
<body cz-shortcut-listen="true" class="" style="padding-top: 0px;">



<div class="wrapper_">
	<div id="header" style="top: auto;">
	
			<div id="head_top"><div class="header_inner_">
	<h1 id="tagline">ニューエラ公式オンラインストア</h1>
	<ul class="links">
	<c:if test="${sessionScope.u == null}">
			 <li class="link_mypage"><a href="jumplogin">ログイン/新規会員登録</a></li>
		</c:if>
		
		<c:if test="${sessionScope.u != null}">
			 <li class="link_mypage"><a href="mypage">マイページ</a></li>
			 <li class="link_logout"><a href="logout">ログアウト</a></li>
		</c:if>
	</ul>
</div></div>

			
				<div id="head_main">
	<div class="clearfix header_inner_">
		<p id="logo"><a href="home"><img src="img/logo.svg" alt="NEWERA"></a></p>

		<div class="info">
			<div class="search">
				<!--<form name="" method="post" action="productssearch">
					<input type="hidden" value="" name="productword">
					<p class="keyword"><input type="text" value="" size="8" tabindex="1" id="topkeyword" class="keyword_" name="productwordtop" autocomplete="off" placeholder="キーワードを入力">
					<div class="np-keyword-suggest" style="display: none; left: 677px; top: 50px;"></div><div class="np-item-suggest" style="display: none; left: 677px; top: 50px;"></div></p>
					<p class="btn"><input type="submit" tabindex="1" id="" value="検索" src="img/go.png" onclick=""></p>
				</form>-->
				<form method="post" action="productssearch">
			<input type="text" name="productword" placeholder="商品名のキーワードを入力">
			<p class="keyword"><input type="hidden" value="" size="8" tabindex="1" id="topkeyword" class="keyword_" name="productwordtop">
			<div class="np-keyword-suggest" style="display: none; left: 677px; top: 50px;"></div><div class="np-item-suggest" style="display: none; left: 677px; top: 50px;"></div></p>
			<p class="btn"><input type="submit" value="検索" tabindex="1" ></p>
		</form>
			</div>
			<p class="btn_favorite"><a href="">お気に入り</a></p>
			<p class="btn_cart"><a href="">カート<span id="jscart_count_">0</span></a></p>
		</div>
	</div>
</div>

	</div>
	
<div id="contents">
<ul id="bread-crumb-list" class="wrap clearfix">
<li itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb">
  <a href="" itemprop="url" class="topicpath_home_">
    <span itemprop="title">トップ</span>
  </a>
</li>
<li itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb" itemprop="child">
　&gt;　<a href="" itemprop="url"><span itemprop="title"><strong>キャップ</strong></span></a>
</li>

</ul>

</div>
<div id="cat_title_group">
			<h2 class="title"><img src="img/10.jpg" alt="キャップ"></h2>
		</div>

		
		<p><a href="cartdisplay">カート</a></p>
		
		<select name="sortparameter" form="productssort">
			<option value="name">名前順</option>
			<option value="cheap">安い順</option>
			<option value="expensive">高い順</option>
		</select><br>
		
		<form method="post" action="productssort" id="productssort">
			<input type="submit" value="ソート">
		</form>

		
		<table border="1">
			<tr><th>ID</th><th>画像</th><th>商品名</th><th>価格</th></tr>
			<c:forEach var="product" items="${sessionScope.productlist}">
				<tr><td>${product.pid}</td><td><a href="productdetaildisplay?pid=${product.pid}"><img src="<c:url value='${product.path}' />" alt="${product.name}" width="180px" height="150px"></a></td><td>${product.name}</td><td>${product.price}</td></tr>
			</c:forEach>
		</table>


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