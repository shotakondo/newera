<%@ page language="java" contentType="text/html;charset=windows-31J"
	pageEncoding="windows-31J"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ja"><head>
	
	<title>�j���[�G��/New Era�����I�����C���X�g�A |�z�[���y�[�W</title>
	
	
	


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
	<h1 id="tagline">�j���[�G�������I�����C���X�g�A</h1>
	<ul class="links"><!--
	<c:if test="${sessionScope.ub == null}">
			 --><li class="link_mypage"><a href="jumplogin">���O�C��/�V�K����o�^</a></li><!--
		</c:if>
		
		<c:if test="${sessionScope.ub != null}">
			 --><li class="link_mypage"><a href="mypage">�}�C�y�[�W</a></li><!--
			 --><li class="link_logout"><a href="logout">���O�A�E�g</a></li><!--
		</c:if>
	--></ul>
</div></div>

			
				<div id="head_main">
	<div class="clearfix header_inner_">
		<p id="logo"><a href="home"><img src="img/logo.svg" alt="NEWERA"></a></p>

		<div class="info">
			<div class="search"><!--
				--><form name="" method="post" action="productssearch"><!--
					--><input type="hidden" value="" name="productword"><!--
					--><p class="keyword"><input type="text" value="" size="8" tabindex="1" id="topkeyword" class="keyword_" name="keyword" autocomplete="off" placeholder="�L�[���[�h�����"><div class="np-keyword-suggest" style="display: none; left: 677px; top: 50px;"></div><div class="np-item-suggest" style="display: none; left: 677px; top: 50px;"></div></p><!--
					--><p class="btn"><input type="submit" tabindex="1" name="image" id="topsearch_btn" value="����" src="img/go.png" onclick=""></p><!--
				--></form><!--
			--></div><!--
			--><p class="btn_favorite"><a href="">���C�ɓ���</a></p><!--
			--><p class="btn_cart"><a href="">�J�[�g<span id="jscart_count_">0</span></a></p><!--
		--></div>
	</div>
</div>

	</div>
<div class="cartlist_ order_col1_">
<h1 class="common_headline1_"><strong><img src="img/shopping_cart1.png" alt="SHOPPING CART"></strong><span>�V���b�s���O�J�[�g</span></h1>
<div class="order_flow_"><center><img src="img/order_step1.png" alt="STEP1 ����������"></div></center>

<form method="POST" action="purchaseprocedure" name="form">






<input type="image" src="img/spacer.gif" name="update" alt="�Čv�Z" class="calc_" tabindex="1">
<input type="hidden" name="refresh" value="true">
<table class="formlist_ cartlist_">
<tbody><tr class="title_cartlist" >
	<th class="" style="background-color:black;color: azure" colspan="2" >�A�C�e���� / ���i�ԍ�</th>
	<th class="qty_cartlist" style="background-color:black;color: azure">����</th>
	<th class="money_cartlist" style="background-color:black;color: azure">���z</th>
	<th class="" style="background-color:black;color: azure"></th>
</tr>
<c:forEach var="product" items="${sessionScope.cb.products}">
<tr>
	<td class="img_">

		<a href="productdetaildisplay?pid=${product.pid}" title="${product.name}" style="padding: 30px"><img src="<c:url value='${product.path}' />" style="height:30%;width:30%" alt="${product.name}"></a>
	</td>
	<td class="name_">
		<div class="name_">
		
		<div class="name1_"><a href="" title="${product.name}">${product.name}</a><p>�i57.7 - 61.5cm�j</p></div>
		
		
<div class=""></div>

		
		</div>
		
		<p class="price_">��${product.price}</p>
	</td>
	<td class="qty_">
		<img src="" onclick="">
		<input type="text" name="num" value="${product.num}" size="2" maxlength="2" tabindex="1">
		<img src="" onclick="">
		
	</td>
	<td class="money_">
		<span class="price_">��${product.price}</span>
	</td>
	<td class="button_">
		<a href="cartdelete?pid=${product.pid}" ><img src="img/delete_s.gif" name="" alt="�폜"></a>
	</td>
</tr>



<tr class="total_line_">
<td colspan="3" class="total_">���v(�ō�)</td>
<td class="money_"><span class="price_">��${product.price}</span>
</td>
<td class="button_"><input type="image" name="update" src="img/recount.gif" alt="�Čv�Z" tabindex="1"></td>
</tr>

</tbody></table>
<table border="0"><tr>
        
<td><a href="javascript:history.go(-1);" style="padding: 250px"><img src="img/cart_back.gif" alt="�߂�i���������𑱂���j" style=""></a></td>
        <td><input type="image" name="submit" src="img/cart_next.gif" alt="���ցi�w���葱���ցj" tabindex="1"></td></tr>
</table>

</c:forEach>
</div>
</form>

<p style="font-size:1.3em;margin: 50px">
���������̑O�ɁA�����p�K��E�����p�K�C�h�����ǂ݂��������B<br>
�����w���葱���ɐi�ޑO�ɂ���]�̏��i�E�T�C�Y��������x���m�F���������B<br>
�@�������m���̃L�����Z���₲�������e�̕ύX�͏����Ă���܂���B<br>
���J�[�g�ɓ��ꂽ�����ł͍݌ɂ͊m�ۂ���܂���̂ł����ӂ��������B</p>

</div>
	<div id="footer">
			
					
<p id="pagetop" style="position: fixed; bottom: 20px; display: none; opacity: 1;"><a href="#header">PAGE TOP</a></p>
<div id="foot_main"><div class="footer_inner_">
	
	<dl class="follow"><!--
		--><dt>FOLLOW US</dt><!--
		--><dd><!--
			--><ul><!--
				--><li><a href="https://www.facebook.com/newerajapan" target="_blank"><img src="img/foot_sns_fb.png" alt="facebook"></a></li><!--
				--><li><a href="https://twitter.com/newera_japan" target="_blank"><img src="img/foot_sns_tw.png" alt="twitter"></a></li><!--
				--><li><a href="http://www.neweracap.jp/news/line/" target="_blank"><img src="img/foot_sns_gplus.png" alt="Google Plus"></a></li><!--
				--><li><a href="https://www.instagram.com/newerajapan/" target="_blank"><img src="img/foot_sns_instagram.png" alt="Instagram"></a></li><!--
			--></ul><!--
		--></dd><!--
	--></dl>
</div></div>
<div id="foot_btm"><div class="footer_inner_">
	<p id="copyright">COPYRIGHT�� New Era Japan GK. ALL RIGHTS RESERVED.</p>
</div></div>
			
	</div>
</div>




<div class="selection_bubble_root" style="display: none;"></div></body></html>