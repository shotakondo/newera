<%@ page import="beans.User" %>
<%@ page import="context.*" %>
<%@ page language="java" contentType="text/html;charset=windows-31J"
	pageEncoding="windows-31J"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ja"><head>
	
<!-- taikai.jsp -->
	<title>�j���[�G��/New Era�����I�����C���X�g�A | �މ�</title>
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
<script language="JavaScript" type="text/javascript" src="js/check.js"></script>
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
		</ul>
</div></div>

			
				<div id="head_main">
	<div class="clearfix header_inner_">
		<p id="logo"><a href=""><img src="img/logo.svg" alt="NEWERA"></a></p>

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
	
<div id="contents">

<div class="customer_ col1_">
<div class="navitopicpath_">
<a href="home" class="topicpath_home_">�z�[��</a>&gt;<a href="jumpmypage">�}�C�y�[�W</a>&gt;<a href="">�މ�</a></div>
<h1 class="common_headline1_">�މ�</h1>

<div class="customer_status_">
<div class="loginname_">�s�������� �`���� �l</div>

</div>
<% User u = (User)session.getAttribute("userBean"); %>

<p class="message_">
���݂̃��[���A�h���X�ƃp�X���[�h����͂��A�u�މ��v�{�^���������Ă��������B
</p>
<form method="post" action="delete" onSubmit="return confirmAction()">


<table class="formdetail_ withdrawal_">
<tbody><tr>
<th><img class="must_" src="//d3iuyfi32mtj8g.cloudfront.net/img/sys/check.gif" alt="�K�{">���[���A�h���X</th>
<td>
<input value="<%= u.getEmail() %>" size="40" type="text" name="uid" maxlength="100">

</td>
</tr>
<tr>
<th><img class="must_" src="//d3iuyfi32mtj8g.cloudfront.net/img/sys/check.gif" alt="�K�{">�p�X���[�h</th>
<td>
<input value="<%= u.getPass() %>" size="20" type="password" name="pass" maxlength="20" autocomplete="off">

</td>
</tr>
</tbody></table>
<div class="submit_">
<a href=""><img src="img/back.gif" alt="�߂�"></a>
<input type="image" name="submit" src="img/withdrawal.gif" alt="�މ��" onclick="return confirmAction();">
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
	<p id="copyright">COPYRIGHT? New Era Japan GK. ALL RIGHTS RESERVED.</p>
</div></div>
			
	</div>
</div>




<div class="selection_bubble_root" style="display: none;"></div></body></html>