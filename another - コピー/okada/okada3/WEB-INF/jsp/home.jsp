<%@ page language="java" contentType="text/html;charset=windows-31J"
	pageEncoding="windows-31J"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="ja">
	
	<title>ニューエラ/New Era公式オンラインストア |キャップ</title>
	<link rel="canonical" href="">
	
	<link rel="next" href="">
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
<link rel="SHORTCUT ICON" href="https://store.neweracap.jp/favicon.ico">

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
			<input type="hidden" name="" placeholder="商品名のキーワードを入力">
			<p class="keyword"><input type="text" value="" size="8" tabindex="1" id="topkeyword" class="keyword_" name="productword">
			<div class="np-keyword-suggest" style="display: none; left: 677px; top: 50px;"></div><div class="np-item-suggest" style="display: none; left: 677px; top: 50px;"></div></p>
			<input name="image" type="submit" value="検索" tabindex="1" src="img/go.png"  >
		</form>
			</div>
			<p class="btn_favorite"><a href="">お気に入り</a></p>
			<p class="btn_cart"><a href="cartdisplay">カート<span id="jscart_count_">0</span></a></p>
		</div>
	</div>
</div>
	</div>
	
<div id="contents">
<ul id="bread-crumb-list" class="wrap clearfix">
<li itemscope="" itemtype="">
  <a href="home" itemprop="url" class="topicpath_home_">
    <span itemprop="title">トップ</span>
  </a>
</li>
<li itemscope="" itemtype="" itemprop="child">
　&gt;　<a href="" itemprop=""><span itemprop="title"><strong>キャップ</strong></span></a>
</li>

</ul>

</div>

		<div id="cat_title_group">
			<h2 class="title"><img src="img/10.jpg" alt="キャップ"></h2>
		</div>

<div class="container_">
<div class="mainframe_">
<div class="sort_style clearfix">
    
  <div class="">
        <dl class="">
      <dt>表示順：</dt>
      <select name="sortparameter" form="productssort">
			<option value="name">名前順</option>
			<option value="cheap">安い順</option>
			<option value="expensive">高い順</option>
		</select>
            <form method="post" action="productssort" id="productssort">
			<input type="submit" value="ソート">
		</form>
    </dl>



  </div>
</div>
<div id="product_list">
  <div class="autopagerize_page_element">
<table border="0">
    <tr>
        <td>
            <ul class="item_list1 clearfix" data-item-line="4">
                <c:forEach var="product" items="${sessionScope.productlist}">
                    <li>
                        <a href="productdetaildisplay?pid=${product.pid}">
	                        <p class="icon">
                                <img src="img/01new.gif" alt="">
                            </p>
                            <div class="photo">
                                <img src="<c:url value='${product.path}' />" alt="">
                            </div>
                            <div class="info">
                                <h3 class="name">
                                    ${product.name}
                                </h3>
                                <p class="price">\
                                    ${product.price}
                                </p>
                            </div>
                        </a>
                    </li>
                </c:forEach>
            </ul>
        </td>
    </tr>
</table>
    
  </div>
  <div class="pager clearfix top_"><p class="navipage_sum_">1-40件/1640件</p><div class="navipage_forward_">
<span class="navipage_now_">1</span>
<a href="https://store.neweracap.jp/shop/c/c10_p2/?fmt=xml&amp;path=%e3%82%ad%e3%83%a3%e3%83%83%e3%83%97&amp;limit=40&amp;sort=n&amp;s1=0&amp;s3=0">2</a>
<a href="https://store.neweracap.jp/shop/c/c10_p3/?fmt=xml&amp;path=%e3%82%ad%e3%83%a3%e3%83%83%e3%83%97&amp;limit=40&amp;sort=n&amp;s1=0&amp;s3=0">3</a>
<span class="space">…</span><a href="https://store.neweracap.jp/shop/c/c10_p41/?fmt=xml&amp;path=%e3%82%ad%e3%83%a3%e3%83%83%e3%83%97&amp;limit=40&amp;sort=n&amp;s1=0&amp;s3=0">41</a><span class="navipage_last_"><a href="https://store.neweracap.jp/shop/c/c10_p41/?fmt=xml&amp;path=%e3%82%ad%e3%83%a3%e3%83%83%e3%83%97&amp;limit=40&amp;sort=n&amp;s1=0&amp;s3=0">最後</a></span>

</div></div>
</div>



<input type="hidden" name="hquery" id="hquery" value="?fmt=xml&amp;path=キャップ&amp;limit=40&amp;sort=n&amp;s1=0&amp;s3=0">


</div>

</div>
	<div id="footer">

<p id="pagetop" style="position: fixed; bottom: 20px; display: none; opacity: 1;"><a href="#header">PAGE TOP</a></p>
<div id="foot_top"><div class="footer_inner_">
</div></div>
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

<script type="text/javascript" src="js/naviplus_suggestitem_view.js" charset="windows-31J"></script>
<script type="text/javascript" src="js/naviplus_suggest.js" charset="windows-31J"></script>
<link href="css/naviplus_suggest.css" rel="stylesheet" crossorigin="" type="text/css">
</body></html>