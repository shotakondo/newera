<%@ page import="beans.User" %>
<%@ page import="context.*" %>
<%@ page language="java" contentType="text/html;charset=windows-31J"
	pageEncoding="windows-31J"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ja"><head>
	
	<title>�j���[�G��/New Era�����I�����C���X�g�A |�}�C�y�[�W</title>
	
	
	


<meta http-equiv="content-style-type" content="text/css">

<link rel="stylesheet" type="text/css" href="css/style.css" media="all">

<link rel="stylesheet" type="text/css" href="css/display_switch.css"><!--hien thi-->
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
	<c:if test="${sessionScope.userBean == null}">
			
			<li class="link_login"><a href="login">���O�C��/�V�K����o�^</a></li>
		</c:if>
		
		<c:if test="${sessionScope.userBean != null}">
			<li class="link_mypage"><a href="jumpmypage">�}�C�y�[�W</a></li>
			<li class="link_logout"><a href="logout">���O�A�E�g</a></li>
		</c:if>
</div></div>

			
				<div id="head_main">
	<div class="clearfix header_inner_">
		<p id="logo"><a href="home"><img src="img/logo.svg" alt="NEWERA"></a></p>

		<div class="info">
			<div class="search">
				<form name="frmSearch" method="get" action="">
					<input type="hidden" value="x" name="search">
					<p class="keyword"><input type="text" value="" size="8" tabindex="1" id="topkeyword" class="keyword_" name="keyword" autocomplete="off" placeholder="�L�[���[�h�����"><div class="np-keyword-suggest" style="display: none; left: 677px; top: 50px;"></div><div class="np-item-suggest" style="display: none; left: 677px; top: 50px;"></div></p>
					<p class="btn"><input type="submit" tabindex="1" name="image" id="topsearch_btn" value="����" src="img/go.png" onclick=""></p>
				</form>
			</div>
			<p class="btn_favorite"><a href="">���C�ɓ���</a></p>
			<p class="btn_cart"><a href="">�J�[�g<span id="jscart_count_">0</span></a></p>
		</div>
	</div>
</div>

	</div>
	<% User u = (User)session.getAttribute("userBean"); %>
<div id="contents">


<div class="customer_ col1_">
  <div class="navitopicpath_"><a href="home" class="topicpath_home_">�z�[��</a>&gt;<a href="">�}�C�y�[�W</a></div>
  <h1 class="common_headline1_"><strong><img src="img/my_page1.png" alt="Mypage"></strong><span>�}�C�y�[�W</span></h1>
  
  <div class="customer_status_">
  <div class="loginname_"> <%= u.getFirstName() %><%= u.getLastName() %> �l</div>

  
  </div>
  
  
  
  <div class="mymenu_">
    <div class="mymenu_item_"> 
      <div class="img_"><a href="home"><img src="img/mypage_icon_shop.png" alt="���i�y�[�W������"></a></div>
      <div class="desc_">
      <h2 id="mymenu_top"> <a href="home">���i�y�[�W������</a> </h2>
      <p>���i�y�[�W�ֈړ����܂��B</p>
      </div>
       </div>
    <div class="mymenu_item_">
    <div class="img_"><a href="jumphistory"><img src="img/mypage_icon_hsty.png" alt="�w������"></a></div>
    <div class="desc_">
      <h2 id="mymenu_history"> <a href="jumphistory">�w������</a> </h2>
      <p>���݂̂������̏󋵂ƍ��܂ł̂������̗����ł��B</p>
      </div>
    </div>
    
    <div class="mymenu_item_">
    <div class="img_"><a href="jumpedituser"><img src="img/mypage_icon_info.png" alt="������ύX"></a></div>
    <div class="desc_">
      <h2 id="mymenu_customer"> <a href="jumpedituser">������ύX</a> </h2>
      <p>�o�^����Ă���������ύX���邱�Ƃ��ł��܂��B</p>
      </div>
    </div>
    
    
    <div class="mymenu_item_">
    
<div class="img_"><a href="jumpemailchange"><img src="img/mypage_icon_mlcg.png" alt="���[���A�h���X�ύX"></a></div>
    <div class="desc_">
      <h2 id="mymenu_mailchange"><a href="jumpemailchange">���[���A�h���X�ύX</a></h2>

      <p>�o�^����Ă��郁�[���A�h���X��ύX���邱�Ƃ��ł��܂��B</p>
      </div>
    </div>
   
    <div class="mymenu_item_">
    <div class="img_"><a href="jumppasschange"><img src="img/mypage_icon_pwrd.png" alt="�p�X���[�h�̕ύX"></a></div>
    <div class="desc_">
      <h2 id="mymenu_passchange"> <a href="jumppasschange">�p�X���[�h�̕ύX</a> </h2>
      <p>���ݎg�p���Ă���p�X���[�h�̕ύX���ł��܂��B</p>
    </div>
    </div>
    
    
    <div class="mymenu_item_">
    <div class="img_"><a href="favoritedisplay"><img src="img/mypage_icon_fblt.png" alt="���C�ɓ���"></a></div>
    <div class="desc_">
      <h2 id="mymenu_bookmark"> <a href="favoritedisplay">���C�ɓ���</a> </h2>
      <p>���C�ɓ��菤�i���X�g�ł��B</p>
    </div>
    </div>
    
    <div class="mymenu_item_">
    <div class="img_"><a href="jumptaikai"><img src="img/mypage_icon_wdwl.png" alt="�މ�"></a></div>
    <div class="desc_">
      <h2 id="mymenu_withdrawal"> <a href="jumptaikai">�މ�</a> </h2>
      <p>��������폜���đމ�܂��B</p>
    </div>
    </div>
    <div class="mymenu_item_">
    <div class="img_"><a href="logout"><img src="img/mypage_icon_lout.png" alt="���O�A�E�g"></a></div>
    <div class="desc_">
      <h2 id="mymenu_logout"> <a href="logout">���O�A�E�g</a> </h2>
  
    </div>
    </div>
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
	<p id="copyright">COPYRIGHT�� New Era Japan GK. ALL RIGHTS RESERVED.</p>
</div></div>
			
	</div>
</div>




<div class="selection_bubble_root" style="display: none;"></div></body></html>