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
	<div id="product_detail">

<div class="navitopicpath_">

<ul id="bread-crumb-list" class="wrap clearfix">
<li itemscope="" itemtype="">
  <a href="home" itemprop="url" class="topicpath_home_">
    <span itemprop="title">トップ</span>
  </a>
</li>

<li itemscope="" itemtype="" itemprop="child">
　&gt;　<a href="" itemprop="url"><span itemprop="title">${data.name}</span></a>

</ul>


</div>
<div class="clear_"></div>



<input type="hidden" value="" id="hidden_variation_group">
<input type="hidden" value="0" id="variation_design_type">
<input type="hidden" value="" id="hidden_goods">
<div class="detail wrap clearfix goods_detail_">
	<div class="right_box box">
		<div class="goodsspec_">
			<p class="icon_">
				
				<img src="img/new.gif" alt="">
                <span class="icon1_"><img src="img/03limit.gif" alt="ニューエラストア限定"></span>
			</p>
			<h2 class="goods_name_">${data.name}</h2>
			<p class="goods_price_">
				
				<span class="goods_detail_price_">
				￥${data.price}
				</span>
				
			</p>
			<!--<dl class="explain">
				<dt>アイテム説明</dt>
				<dd class="top_comment_" id="spec_goods_comment">
					<p>アメリカの1ドル紙幣に使用されているデザイン要素をモチーフにしたシリーズです。</p>
				</dd>
			</dl>-->
			
		</div>
		<form name="frm" method="POST" action="">
		
		
		<div class="cartbox_">
			<div class="variationlist_">
			
<div class="sizes_">
	<table>
		<tbody>
<tr class="variation_noline_">
	<td class="size2_">
	
		
		
		<!--57.7 - 61.5cm-->
		
		
	
	</td>
	
        <td class="option_buttons_ clearfix">
			<li class="btn_favorite"><a href="favoriteadd?pid=${data.pid}">お気に入り追加</a></li>
			</td>
    <td class="cart_" id="" style="padding-left: 20px"><a href="cartadd?pid=${data.pid}"><img src="img/prd_detail_cart_in.png"</a>
		<!--
		<input id="" type="image" class="btn_add_cart_" src="img/prd_detail_cart_in.png" alt="">
		<div class="add_cart" href="cartadd?pid=${data.pid}"></div>-->
		
	</td>
</tr>

		</tbody>
	</table>
</div>

			
			
			</div>
			
		</div> 

		

		
		</form>

			
		<!--<td class="option_buttons_ clearfix">
			<li class="btn_favorite"><a href="favoriteadd?pid=${data.pid}">お気に入り追加</a></li>
			</td>-->
			
	</div>
	<div class="left_box box">
		<div class="goodsimg_">
            
			<div class="photo" style="height: 400px !important">
				<img src="<c:url value='${data.path}' />" alt="${data.name}">
				<a class="zoom" href="" target="_blank"></a>
			<div class="expand start_expand" style="display: block;"><img src="<c:url value='${data.path}' />" style="width: 50%; position: absolute; top: -180px; left: -280px;"></div><div class="expand start_expand" style="display: block; opacity: 0.013815;"><img src="<c:url value='${data.path}' />" style="width: 50%; position: absolute; top: -119px; left: -262px;"></div></div>
			<ul class="thumb clearfix">
                <c:forEach var="path" items="${data.paths}">
                    <li><span><img src="<c:url value='${path.path}' />" alt ="${data.name}"></span></li>
                </c:forEach>
				
			</ul>
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
    </div>
		</div>
	</body>
</html>