<%@ page language="java" contentType="text/html;charset=windows-31J"
	pageEncoding="windows-31J"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<html lang="ja">

	<head>
		
		<title>ニューエラ/New Era公式オンラインストア</title>
		
		<meta property="etm:device" content="desktop">
		<meta property="etm:page_type" content="">
		<meta property="etm:cart_item" content="[]">
		<meta http-equiv="content-script-type" content="text/javascript">
		<meta http-equiv="content-style-type" content="text/css">
		
		<link rel="stylesheet" type="text/css" href="css/style.css" media="all">
		<link rel="stylesheet" type="text/css" href="css/display_switch.css">
		<link rel="stylesheet" type="text/css" href="css/core.css">
		<link rel="stylesheet" type="text/css" href="css/skin.css">
		<link rel="stylesheet" href="css/jquery-ui.min.css">
		<link rel="SHORTCUT ICON" href="img/favicon.ico">
		
		<script async="" src="js/tag.js"></script>
		<script async="" src="js/gtm.js"></script>
		<script src="js/jquery.min.js"></script>
		<script src="js/jquery-ui.min.js"></script>
		<script language="JavaScript" type="text/javascript" src="js/jquery.balloon.js"></script>
		<script language="JavaScript" type="text/javascript" src="js/jquery.tile.min.js"></script>
		<script language="JavaScript" type="text/javascript" src="js/common.js"></script>
		<script language="JavaScript" type="text/javascript" src="js/search_suggest.js"></script>
		<script language="JavaScript" type="text/javascript" src="js/setting.js"></script>
		
	</head>
	
	<body cz-shortcut-listen="true" class="" style="padding-top: 0px;">
		<div class="wrapper_">
			<div id="header" style="top: auto;">
				<div id="head_top">
					<div class="header_inner_">
						<h1 id="tagline">ニューエラ公式オンラインストア</h1>
						<ul class="links">
							<c:if test="${sessionScope.ub == null}">
								<p><a href="loginjump">ログイン/新規会員登録</a></p>
							</c:if>
							<c:if test="${sessionScope.ub != null}">
								<p><a href="mypagejump">マイページ</a></p>
								<p><a href="logout">ログアウト</a></p>
							</c:if>
						</ul>
					</div>
				</div>
				<div id="head_main">
					<div class="clearfix header_inner_">
						<p id="logo">
							<a href="toppagejump">
								<img src="img/logo.svg" alt="NEWERA">
							</a>
						</p>
						<div class="info">
							<div class="search">
								<form name="frmSearch" method="post" action="productssearch">
									<p class="keyword">
										<input type="text" value="" size="8" tabindex="1" id="topkeyword" class="keyword_" name="keyword" autocomplete="off" placeholder="キーワードを入力">
									</p>
									<p class="btn">
										<input type="submit" tabindex="1" name="image" id="topsearch_btn" value="検索" src="img/go.png" onclick="">
									</p>
								</form>
							</div>
							<p class="btn_favorite">
								<a href="favoritedisplay">お気に入り</a>
							</p>
							<p class="btn_cart">
								<a href="cartdisplay">カート<span id="jscart_count_">0</span></a>
							</p>
						</div>
					</div>
				</div>
			</div>
			
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
				<c:forEach var="pl" items="${sessionScope.pl}">
					<tr><td>${pl.pid}</td><td><a href="productdisplay?pid=${pl.pid}"><img src="<c:url value='${pl.path}' />" alt="${pl.name}" width="180px" height="150px"></a></td><td>${pl.name}</td><td>${pl.price}</td></tr>
				</c:forEach>
			</table>
			
			<div id="footer">
				<p id="pagetop" style="position: fixed; bottom: 20px; display: none; opacity: 1;">
					<a href="#header">PAGE TOP</a>
				</p>
				<div id="foot_main">
					<div class="footer_inner_">
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
					</div>
				</div>
				<div id="foot_btm">
					<div class="footer_inner_">
						<p id="copyright">COPYRIGHT? New Era Japan GK. ALL RIGHTS RESERVED.</p>
					</div>
				</div>
			</div>
		</div>
		
	</body>
</html>