<%@ page language="java" contentType="text/html;charset=windows-31J"
	pageEncoding="windows-31J"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ja"><head>
	
	<title>ニューエラ/New Era公式オンラインストア | ${cart.product.name}</title>

<meta http-equiv="content-style-type" content="text/css">

<link rel="stylesheet" type="text/css" href="css/style.css" media="all">
<link rel="stylesheet" type="text/css" href="css/display_switch.css">
<link rel="stylesheet" href="css/jquery-ui.min.css">
<meta http-equiv="content-script-type" content="text/javascript">
<script async="" src="js/tag.js"></script><script async="" src="js/gtm.js"></script>
<script src="js/jquery.min.js"></script><style></style>
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
			 <li class="link_mypage"><a href="jumplogin">ログイン/新規会員登録</a></li>
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
				<form name="" method="post" action="productssearch">
					<input type="hidden" value="" name="productword">
					<p class="keyword"><input type="text" value="" size="8" tabindex="1" id="topkeyword" class="keyword_" name="keyword" autocomplete="off" placeholder="キーワードを入力"><div class="np-keyword-suggest" style="display: none; left: 677px; top: 50px;"></div><div class="np-item-suggest" style="display: none; left: 677px; top: 50px;"></div></p>
					<p class="btn"><input type="submit" tabindex="1" name="image" id="topsearch_btn" value="検索" src="img/go.png" onclick=""></p>
				</form>
			</div>
			<p class="btn_favorite"><a href="">お気に入り</a></p>
			<p class="btn_cart"><a href="cartadd?pid=${data.pid}">カート<span id="jscart_count_">0</span></a></p>
		</div>
	</div>
</div>

	</div>
<div class="cartlist_ order_col1_">
<h1 class="common_headline1_"><strong><img src="img/shopping_cart1.png" alt="SHOPPING CART"></strong><span>ショッピングカート</span></h1>
<div class="order_flow_"><center><img src="img/order_step1.png" alt="STEP1 買い物かご"></div></center>

<form method="POST" action="purchaseprocedure" name="form">

<input type="image" src="img/spacer.gif" name="update" alt="再計算" class="calc_" tabindex="1">
<input type="hidden" name="refresh" value="true">
<table class="formlist_ cartlist_" style="width:1100px; height: 215px">
<tbody><tr class="">
	<th class="title_cartlist" style="background-color:black;color: azure" colspan="2" >アイテム名 / 商品番号</th>
	<th class="qty_cartlist" style="background-color:black;color: azure">数量</th>
	<th class="money_cartlist" style="background-color:black;color: azure">金額</th>
	<th class style="background-color:black;color: azure"></th>
</tr>
<c:forEach var="product" items="${sessionScope.userBean.cart.products}">
<tr>
	<td class="img_" style="width:200px;height:215px !important">

		<a href="productdetaildisplay?pid=${product.pid}" title="${product.name}" style=""><img src="<c:url value='${product.path}' />"  alt="${product.name}"></a>
	</td>
	<td class="name_">
		<div class="name_">
		
		<div class="name_"><a href="" title="${product.name}">${product.name}</a><p>（57.7 - 61.5cm）</p></div>
		
		</div>
		
		<p class="price_">￥${product.price}</p>
	</td>
    <script>function cong(){
var t = document.getElementById("${product.num}").value;
document.getElementById("${product.num}").value=parseInt(t)+1;
}
function tru(){
var t = document.getElementById("${product.num}").value;
if(parseInt(t) > 1){
document.getElementById("${product.num}").value=parseInt(t)-1;
}
}
</script>
	<td class="qty_">
		<img src="img/spinplus.png" onclick="cong()">
		<input type="text" name="num" value="${product.num}" size="1" maxlength="2" tabindex="10" id="${product.num}">
		<img src="img/spinminus.png" onclick="tru()">
		
	</td>
	<td class="money_">
		<span class="price_">￥${product.price}</span>
	</td>
	<td class="button_">
		<a href="cartdelete?pid=${product.pid}" ><img src="img/delete_s.gif" name="" alt="削除"></a>
	</td>
</tr>
</c:forEach>


<tr class="total_line_">
<td colspan="3" class="total_">小計(税込)</td>
<td class="money_"><span class="price_">￥${product.price}</span>
</td>
<td class="button_"><input type="image" name="update" src="img/recount.gif" alt="再計算" tabindex="1"></td>
</tr>

</tbody></table>
<table border="0"><tr>
        
<td><a href="javascript:history.go(-1);" style=""><img src="img/cart_back.gif" alt="戻る（お買い物を続ける）" style=""></a></td>
        <td><input type="image" name="submit" src="img/cart_next.gif" alt="次へ（購入手続きへ）" tabindex="1"></td></tr>
</table>


</div>
</form>

<p style="font-size:1.3em;margin: 50px">
◆ご注文の前に、ご利用規約・ご利用ガイドをお読みください。<br>
◆ご購入手続きに進む前にご希望の商品・サイズをもう一度ご確認ください。<br>
　ご注文確定後のキャンセルやご注文内容の変更は承っておりません。<br>
◆カートに入れただけでは在庫は確保されませんのでご注意ください。</p>

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





<div class="selection_bubble_root" style="display: none;"></div></body></html>