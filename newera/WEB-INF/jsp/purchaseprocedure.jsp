<%@ page language="java" contentType="text/html;charset=windows-31J"
	pageEncoding="windows-31J"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ja"><head>
	
	<title>�j���[�G��/New Era�����I�����C���X�g�A | ${cart.product.name}</title>
<!-- purchaseprodure.jsp -->
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
	<h1 id="tagline">�j���[�G�������I�����C���X�g�A</h1>
	<ul class="links">
	<c:if test="${sessionScope.userBean.id == null}">
			 <li class="link_mypage"><a href="jumplogin">���O�C��/�V�K����o�^</a></li>
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
			<p class="btn_cart"><a href="cartadd?pid=${data.pid}">�J�[�g<span id="jscart_count_">0</span></a></p>
		</div>
	</div>
</div>

	</div>
<div class="order_ order_col1_">
<div class="order_flow_">
<h1><img src="img/order_step2.png" alt="STEP2 ���������@�̎w��"></h1>
</div>
<form method="post" action="orderconfirm" novalidate="" onsubmit="" name="frmMethod" id="frmMethod">
<input type="image" value="submit" src="" name="submit" alt="����" class="hiddenEnter_" tabindex="1">



<div class="method_address_" id="address">
<h2 class="common_headline2_">���͂���</h2>


<div class="addresslist_">

<div class="address_item_">
  <div class="address_title_"><input type="radio" name="dest" value="0" id="dest_r0" checked=""><label for="dest_r0"><strong> ${userBean.getFirstName()} ${userBean.getLastName()} </strong></label></div>
    <address>
      �� ${userBean.getPostcode()}<br>
      ${userBean.getAddress()}<br>
      ${userBean.getFirstName()} ${userBean.getLastName()} �l
    </address>
    
  </div>

</div>


<script>
	jQuery(document).ready(function(){
		jQuery('input:radio[name=dest]').on('change', function() {
			ecUtil.RewriteDateSpec(jQuery('input[name=dest]:checked').val());
		});
	});
</script>


<div class="destgoodslist_">
  <table class="formlist_ destgoodslist_">
  <tbody><tr>
    <th class="method_goodsname_" colspan="2">���i��</th>
    <th class="method_qty_">���b�s���O</th>
    <th class="method_qty_">����</th>
    <th class="method_sales_detail_append_">���l</th>
  </tr>
  <c:forEach var="product" items="${sessionScope.userBean.cart.products}">
  <tr>
    <td class="method_img_">
      <img class="img_" src="<c:url value='${product.path}' />"  alt="${product.name}">
    </td>
    <td class="method_goodsname_">
       ${product.name}
    </td>
    <td>
       ${product.price}
    </td>
    <td>
       ${product.num}
    </td>
    <td class="method_wrapping_">
      ��<input value="��" type="hidden" name="wrapping1">
    </td>
    <td class="method_qty_">
      <input value="1" type="hidden" name="qty1">
    </td>
    
    <td class="method_sales_detail_append_">
    
    
    </td>
    </c:forEach>
  </tr>
  
  
  </tbody></table>

  <input type="image" src="//d3iuyfi32mtj8g.cloudfront.net/img/sys/spacer.gif" name="update" alt="" class="hiddenEnter_" tabindex="1">
  <input type="hidden" name="refresh" value="true">
</div>

</div>

<h2 class="common_headline2_">�z�����@</h2>
<div class="method_box_" id="method_date">
  <h3>�z����]�����w��</h3>
  <div class="method_box_content_">
  
    <dl><dt>�z����]���F</dt><dd><select name="deliverydate"><option value="��]�Ȃ�" selected="">��]�Ȃ�</option><option value="����">����</option><option value="�x��">�x��</option></select></dd><dd><span class="small_">���݌ɏ󋵂⏔����ɂ��A����]�ɓY���Ȃ��ꍇ���������܂��B</span></dd></dl>
    
  
  
    <dl><dt>�z����]���ԁF</dt><dd>
        <input name="deliverytime" type="radio" id="time_spec_00" value="00" checked="">
        <label for="time_spec_00">��]�Ȃ�</label>
        <input name="deliverytime" type="radio" id="time_spec_01" value="01"><label for="time_spec_01">8:00-12:00�i�ߑO���j</label>
        <input name="deliverytime" type="radio" id="time_spec_12" value="12"><label for="time_spec_12">12:00-14:00</label>
        <input name="deliverytime" type="radio" id="time_spec_14" value="14"><label for="time_spec_14">14:00-16:00</label>
        <input name="deliverytime" type="radio" id="time_spec_16" value="16">
        <label for="time_spec_16">16:00-18:00</label>
        <input name="deliverytime" type="radio" id="time_spec_18" value="18"><label for="time_spec_18">18:00-20:00</label>
        <input name="deliverytime" type="radio" id="time_spec_19" value="19">
        <label for="time_spec_19">19:00-21:00�i���ꌧ��20:00-21:00)</label></dd></dl>
  
  

  </div>
</div>



<h2 class="common_headline2_">���x�������</h2>

<div class="method_box_" id="method_cupon">
    <h3>�N�[�|�����p</h3>
    <div class="method_box_content_">
      �N�[�|���R�[�h : <input type="text" name="couponcode" value="" size="30" maxlength="20">
      
      <a class="open_available_coupon" href=""><img src="//d3iuyfi32mtj8g.cloudfront.net/img/sys/button/open_coupon.gif" alt="���p�\�ȃN�[�|����\��"></a>
      
      
      
    </div>
</div>


<script src="/lib/jquery.magnific-popup.custom.js"></script>
<link rel="stylesheet" type="text/css" href="/lib/jquery.magnific-popup.css">

<script type="text/javascript">
jQuery(document).ready(function() {
	
	// ���p�\�ȃN�[�|���ꗗ��\��
	jQuery('.open_available_coupon').magnificPopup({
		type: 'ajax',
		showCloseBtn: false,
		ajax: {
			settings: { cache: false },
			tError: '�\���ł��Ȃ��y�[�W�ł��B'
		},
		callbacks: {
			parseAjax: function(mfpResponse) {
				var existAvailableCoupon = jQuery(mfpResponse.data).wrap('<p>').parent().find('#available_coupon');
				if(!existAvailableCoupon[0]) {
					jQuery.magnificPopup.close();
					alert("�Z�b�V�������^�C���A�E�g���܂����B\r\n�ŏ������蒼���Ă��������B");
					location.reload();
				}
			}
		}
	});
	
	// �N�[�|���I��
	jQuery(document).on('click', '#available_coupon .select_coupon_', function(e) {
		e.preventDefault();
		e.stopPropagation();
		
		var coupon = jQuery(this).data('coupon');
		if (!coupon) return;
		
		jQuery('input[name=coupon]').val(coupon).css('color', '#000');
		jQuery.magnificPopup.close();
	});
	
	// �y�[�W���[
	jQuery(document).on('click', '#available_coupon .navipage_ a', function(e) {
		e.preventDefault();
		e.stopPropagation();
		
		var href = jQuery(this).attr('href');
		if (!href) return;
		
		var magnificPopup = jQuery.magnificPopup.instance;
		magnificPopup.open({ items :{ src: href, type: 'ajax' } });
	});
	
	// ����(�~)�{�^��
	jQuery(document).on('click', '#available_coupon .close_button_', function() {
		jQuery.magnificPopup.close();
	});
});
</script>




<div class="method_box_" id="method_promotion">
    <h3>�L�����y�[���K�p</h3>
    <div class="method_box_content_">
      �L�����y�[���R�[�h : <input type="text" name="campaigncode" value="" size="30" maxlength="20">
      
    </div>
</div>




<div class=" method_box_" id="method_pay">
  <h3>���x�������@</h3>
  <div class="method_box_content_">
  <ul id="method_radio"><li>
  <label for="method_r2">
    <input type="radio" id="method_r2" name="method" value="�������">
    �������
  </label>

</li>
<li>
  <label for="method_r7">
    <input type="radio" id="method_r7" name="method" value="�N���W�b�g�J�[�h">
    �N���W�b�g�J�[�h
  </label>

</li>
<li>
  <label for="method_rF">
    <input type="radio" id="method_rF" name="method" value="Amazon Pay">
    Amazon Pay
  </label>

</li>
<li>
  <label for="method_rI">
    <input type="radio" id="method_rI" name="method" value="Paidy��������(�R���r�j/��s)">
    Paidy��������(�R���r�j/��s)
  </label>

</li>
</ul>


<div id="AmazonPayButton" class="amazon_pay_button_method_" style="display: none;"><img class=" amazonpay-button-inner-image" style="cursor: pointer; max-height: 45px;" alt="AmazonPay" id="OffAmazonPaymentsWidgets0" src="https://d1oct1bdmx33tz.cloudfront.net/default/jp/live/lwa/gold/medium/PwA.png"></div>

<script type="text/javascript">
	var authRequest;
	OffAmazonPayments.Button("AmazonPayButton", "A38UMG07NMRVI7", {
		type: "PwA",
		color: "Gold",
		size: "medium",
		authorization: function() {
			loginOptions = {scope: "profile payments:widget payments:shipping_address", popup: true };
				authRequest = amazon.Login.authorize (loginOptions, "https://store.neweracap.jp/shop/order/method.aspx?" + jQuery('[name=frmMethod]').serialize() + "&posY=" + getScrollPosition());
			},
		onError: function(error) {
			if (error.getErrorCode() != "BuyerSessionExpired") {
				alert('Amazon�Ƃ̒ʐM���ɃG���[���������܂����B���萔�ł������������������蒼���A���̎x�����@�����I�����������B');
			}
		}
	});
</script>
<script type="text/javascript">
	function changeMethodAmazonPayment() {
		if (jQuery('[name=method]:checked').val() == "F") {
			var is_amazon_login = false;
			if (!is_amazon_login) {
				jQuery('#AmazonPayButton').show();
				jQuery('#checkerr_amazon_method').show();
				jQuery('[name=submit]').hide();
			} else {
				jQuery('#AmazonPayButton').hide();
				jQuery('#checkerr_amazon_method').hide();
				jQuery('[name=submit]').show();
			}
		}else{
			jQuery('#AmazonPayButton').hide();
			jQuery('#checkerr_amazon_method').hide();
			jQuery('[name=submit]').show();
		}
	}
	function changeMethodContents() {
		if (0 < jQuery('#method_amazon_label').size()) {
			jQuery('#method_radio').hide()
			jQuery('#AmazonPayButton').hide();
			jQuery('[name=submit]').show();
		}
	}
	jQuery(document).ready(function() {
		setScrollPosition();
		changeMethodAmazonPayment();
		changeMethodContents();
		jQuery('[name=method]').on("click", function() { changeMethodAmazonPayment(); });
	});
	function getScrollPosition() {
		var pos = document.documentElement.scrollTop || document.body.scrollTop;
		return pos;
	}
	function setScrollPosition() {
		var prm = getUrlParam(); 
		var pos = prm["posY"];
		if (pos != '' ) {
			window.scroll(0, pos);
		}
	}
	function getUrlParam(){ 
		var vars = [], param; 
		if(param = location.search){ 
			var parray = param.replace('?','').split('&'); 
			for(var i=0; i<parray.length; i++){ 
				var n = parray[i].split('='); 
				vars[n[0]] = n[1]; 
			} 
		} else { 
			return false; 
		} 
		return vars; 
	}
</script>

  </div>
</div>


<div class="method_box_" id="method_wrapping">
  <h3>���b�s���O</h3>
  <div class="method_box_content_">
  <input name="wrapping" type="radio" id="wrapping_0" value="0" checked=""><label for="wrapping_0">��]�Ȃ�</label><br><input name="wrapping" type="radio" id="wrapping_1" value="1"><label for="wrapping_1">��]����</label>
  <label>�i�L���F��324�j</label>

  </div>
  </div>



<div class="submit_">

  <input type="image" name="submit" src="//d3iuyfi32mtj8g.cloudfront.net/img/sys/button/ordernext.gif" alt="����" class="button_">

  <div class="back_ button_"><a href="javascript:history.go(-1);">�J�[�g��ʂɖ߂�</a></div>
</div>

</form>
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
	<p id="copyright">COPYRIGHT�� New Era Japan GK. ALL RIGHTS RESERVED.</p>
</div></div>
			
	</div>
</div>




<div class="selection_bubble_root" style="display: none;"></div></body></html>