<%@ page language="java" contentType="text/html;charset=windows-31J"
	pageEncoding="windows-31J"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="ja">
	
	<head>
	
		<title>
			ニューエラ/New Era公式オンラインストア | ${data.name}
		</title>
		
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
		<script language="JavaScript" type="text/javascript" src="js/setting.js"></script>
		<link rel="SHORTCUT ICON" href="img/favicon.ico">
		<script type="text/javascript" src="js/sna.js"></script>
		<script type="text/javascript" src="js/goods_ajax_cart.js"></script>
		<script type="text/javascript" src="js/goods_ajax_bookmark.js"></script>
		<script type="text/javascript" src="js/goods_ajax_quickview.js"></script>
		<link rel="stylesheet" type="text/css" href="css/core.css">
		<link rel="stylesheet" type="text/css" href="css/skin.css">
	
	</head>
	<body cz-shortcut-listen="true">
		<div class="wrapper_">
			<div id="header">
				<div id="head_top">
					<div class="header_inner_">
						<h1 id="tagline">
							ニューエラ公式オンラインストア
						</h1>
						<ul class="links">
							<c:if test="${sessionScope.userBean.id == null}">
								<li class="link_login">
									<a href="jumplogin">
										ログイン／新規会員登録
									</a>
								</li>
							</c:if>
							<c:if test="${sessionScope.userBean.id != null}">
								<li class="link_mypage">
									<a href="jumpmypage">
										マイページ
									</a>
								</li>
								<li class="link_logout">
									<a href="logout">
										ログアウト
									</a>
								</li>
							</c:if>
						</ul>
					</div>
				</div>
				<div id="head_main">
					<div class="clearfix header_inner_">
						<p id="logo">
							<a href="">
								<img src="img/logo.svg" alt="NEWERA">
							</a>
						</p>
						<div class="info">
							<div class="search">
								<form name="frmSearch" method="get" action="">
									<input type="hidden" value="x" name="search">
									<p class="keyword">
										<input type="text" value="" size="8" tabindex="1" id="topkeyword" class="keyword_" name="keyword" autocomplete="off" placeholder="キーワードを入力">
										<div class="np-keyword-suggest" style="display: none; left: 677px; top: 50px;">
										</div>
										<div class="np-item-suggest" style="display: none; left: 677px; top: 50px;">
										</div>
									</p>
									<p class="btn">
										<input type="submit" tabindex="1" name="image" id="topsearch_btn" value="検索" src="img/go.png" onclick="">
									</p>
								</form>
							</div>
							<c:if test="${sessionScope.userBean.id == null}">
								<a href="jumplogin">
								</a>
							</c:if>
							<c:if test="${sessionScope.userBean.id != null}">
								<p class="btn_favorite">
									<a href="favoriteadd?pid=${data.pid}">
										お気に入り
									</a>
								</p>
							</c:if>
							<p class="btn_cart">
								<a href="cartadd?pid=${data.pid}">
									カート
									<span id="jscart_count_">0</span>
								</a>
							</p>
						</div>
					</div>
				</div>
			</div>
			<div id="contents">
				<div class="navitopicpath_">
					<ul id="bread-crumb-list" class="wrap clearfix">
						<li itemscope="" itemtype="" itemprop="" class="topicpath_home_">
							<a href="home">
								<span>トップ</span>
							</a>
						</li>
						<li itemscope="" itemtype="" itemprop="child">
							&gt;<a href="" itemprop="url">
								<span itemprop="title">${data.name}</span>
							</a>
						</li>
					</ul>
				</div>
				<div class="left" style="resize:50%;float:left;width: 800px;height: 500px;padding: 50px" >
					<div class="photo">
						<img src="<c:url value='${data.path}' />" alt="${data.name}">
					</div>
				</div>
				<div class="right" style="size:50%;">
					<div class="goodsspec_">
						<p class="icon_" style="margin:20px">
							<img src="img/new.gif" alt="">
						</p>
						<h2 class="goods_name_">${data.name}</h2>
					</div>
					<p class="goods_price_" style="margin: 30px">
						<span class="price" style="font-size: 2em">
							￥${data.price}
						</span>
					</p>
					
					</br></br></br> <hr> </br></br></br>
					
					<table border="0">
						<tr>
							<td>
								<span class="" style="font-size:1.3em;padding-right:70px">57.7 - 61.5cm</span>
							</td>
							<td>
								<a href="cartadd?pid=${data.pid}">
									<input id="" type="image" class="btn_add_cart_" src="img/prd_detail_cart_in.png" alt="">
								</a>
							</td>
						</tr>
					</table>
					
					</br></br></br> <hr>
					
				</div>
				<div id="footer" style="clear: left">
					<div id="foot_main">
						<div class="footer_inner_">
							<dl class="follow">
								<dt>
									FOLLOW US
								</dt>
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
							<p id="copyright">COPYRIGHT☆ New Era Japan GK. ALL RIGHTS RESERVED.</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>