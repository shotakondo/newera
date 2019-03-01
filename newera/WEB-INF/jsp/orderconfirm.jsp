<%@ page language="java" contentType="text/html;charset=windows-31J"
	pageEncoding="windows-31J"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ja"><head>
	
	<title>�j���[�G��/New Era�����I�����C���X�g�A |�C���[���ύX</title>
<!-- orderconfirm.jsp -->
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
	<h1 id="tagline">�j���[�G�������I�����C���X�g�A</h1>
	<ul class="links">
		<c:if test="${sessionScope.userBean.id == null}">
			<li class="link_login"><a href="jumplogin">���O�C���^�V�K����o�^</a></li>
		</c:if>
		<c:if test="${sessionScope.userBean.id != null}">
				<li class="link_mypage"><a href="jumpmypage">�}�C�y�[�W</a></li>
			 	<li class="link_logout"><a href="logout">���O�A�E�g</a></li>
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
			<p class="keyword"><input type="text" value="" size="8" tabindex="1" id="topkeyword" class="keyword_" name="productword" placeholder="���i���̃L�[���[�h����">
			<div class="np-keyword-suggest" style="display: none; left: 677px; top: 50px;"></div><div class="np-item-suggest" style="display: none; left: 677px; top: 50px;"></div></p>
			<input name="image" type="submit" value="����" tabindex="1" src="img/go.png"  >
		</form>
			</div>
			<p class="btn_favorite"><a href="">���C�ɓ���</a></p>
			<p class="btn_cart"><a href="cartdisplay">�J�[�g</a></p>
		</div>
	</div>
</div>

	</div>
<div class="order_ order_col1_">
<div class="order_flow_">
<h1><img src="img/order_step3.png" alt="STEP3 ���������e�̊m�F"></h1>
</div>




<div class="spandual_">



<h2 class="common_headline2_">�������̏��i</h2>

    <div class="leftfloat_">
      <table class="formlist_ goodslist_">
<tbody><tr>
<th class="name_" colspan="2">���i��</th>
<th class="qty_">����</th>
<th class="amt_">���v(�ō�)</th>
</tr>
<c:forEach var="product" items="${sessionScope.userBean.cart.products}">
<tr>
<td class="goods_"><img class="img_" src="<c:url value='${product.path}' />"></td>
<td class="name_">${product.name}
<div class="name2_">�i56.8 - 60.6cm�j</div>
(12031699-OSFA)</td>
<td class="qty_">&nbsp;${product.num}</td>
<td class="amt_">&nbsp;${product.price}</td>
</tr>
    </c:forEach>
</tbody></table>

    </div>
    <div class="rightfloat_">
      <table class="formdetail_ estimate_ sales_">
        <tbody><tr>
          <th>���i���z���v(�ō�)</th>
          <td>��${product.price}</td>
        </tr>


        <tr>
          <th>����</th>
          <td>��540
          </td>
        </tr>


        <tr>
          <th>�x���萔��</th>
          <td>��324</td>
        </tr>







        <tr>
          <th>�������z���v(�ō�)</th>
          <td>��${product.price}</td>
        </tr>
      </tbody></table>

    </div>
</div>
<!--<form id="frmSales" action="ordercomplete" method="post" onsubmit="">-->



<div class="spandual_">
<h2 class="common_headline2_">�z�����</h2>
    <div class="leftfloat_">
      <table class="formlist_ estimate_ host_">
        <tbody><tr><th class="host_">��������</th></tr>
        <tr>
          <td>

          �� ${userBean.getPostcode()} ${userBean.getAddress()}<br>
            ${userBean.getFirstName()}${userBean.getLastName()} �l<br>
          TEL: ${userBean.getTel()}

          </td>
        </tr>
      </tbody></table>

    </div>
    <div class="rightfloat_">
<table class="formdetail_ estimate_method_">

  <tbody><tr>
    <th class="datedetailspec_">�z����]����</th>
    <td>${sessionScope.payb.deliverydate}</td>
  </tr>


  <tr>
    <th class="timespec_">�z����]���ԑ�</th>
    <td>${sessionScope.payb.deliverytime} </td>
  </tr>


  <tr>
    <th class="estimate_method_">�x�����@</th>
    <td>${sessionScope.payb.method}</td>
  </tr>


</tbody></table>


<div class="small_">���݌ɏ󋵂⏔����ɂ��A����]�ɓY���Ȃ��ꍇ���������܂��B</div>

</div>
</div>

<div class="method_address_">
<h2 class="common_headline2_">���͂���</h2>
<div class="method_addr_">
�� ${userBean.getPostcode()}
${userBean.getAddress()}<br>
  ${userBean.getFirstName()}${userBean.getLastName()} �l<br>
TEL: ${userBean.getTel()}
</div>
<div class="destgoodslist_">
<table class="formlist_ estimate_ destgoodslist_">
<tbody><tr>
<th class="dest_goodsname_" colspan="2">���i��</th>
<th class="dest_qty_">����</th>
<th class="dest_comment_">�������׊g��</th>

</tr>
<c:forEach var="product" items="${sessionScope.userBean.cart.products}">
<tr>
<td class="method_img_"><img class="img_" src="<c:url value='${product.path}' />"></td>
<td class="dest_goodsname_">${product.name}
<div class="name2_">�i56.8 - 60.6cm�j</div>
</td>
<td class="dest_qty_">${product.num}</td>
<td class="dest_comment_"><div style="white-space: pre-wrap;"></div></td>

</tr>
    </c:forEach>
</tbody></table>

</div>

</div>





	<div class="wrapping_">
		<h2 class="common_headline2_">���b�s���O</h2>
		��]�Ȃ�
	</div>


<hr class="hidden_">
��L�A���������e�Œ������m�肵�܂��B<br>
<strong>�u�������m�肷��v�{�^�����N���b�N����ƒ������m�肵�܂��B</strong><br>
<input type="hidden" name="" value="">



<input name="crsirefo_hidden" type="hidden" value="">

<div class="submit_">
    <a href="ordercomplete"><img src="//d3iuyfi32mtj8g.cloudfront.net/img/sys/button/order.gif" alt="������"></a>

  <!--<input type="image" name="submit" src="//d3iuyfi32mtj8g.cloudfront.net/img/sys/button/order.gif" alt="������" tabindex="1" class="button_" >-->
  

  <div class="back_ button_">
  <a href="">���������@�̎w��ɖ߂�</a>
  </div>
</div>
</form>



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
	<p id="copyright">COPYRIGHT�� New Era Japan GK. ALL RIGHTS RESERVED.</p>
</div></div>
			
	</div>
</div>

<div class="selection_bubble_root" style="display: none;"></div></body></html>