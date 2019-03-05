<%@ page import="beans.User" %>
<%@ page import="context.*" %>
<%@ page language="java" contentType="text/html;charset=windows-31J"
	pageEncoding="windows-31J"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ja"><head>
	
	<title>ニューエラ/New Era公式オンラインストア |会員登録</title>
<meta http-equiv="content-style-type" content="text/css">

<link rel="stylesheet" type="text/css" href="css/style.css" media="all">
<link rel="stylesheet" type="text/css" href="css/display_switch.css">
<link rel="stylesheet" href="css/jquery-ui.min.css">
<meta http-equiv="content-script-type" content="text/javascript">
<script async="" src="js/tag.js"></script><script async="" src="js/gtm.js"></script><script src="js/jquery.min.js"></script><style></style>
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
<div class="customer_ col1_">

<div class="navitopicpath_">
<a href="home" class="home">ホーム</a>&gt;<a href="javascript:history.go(-1);">マイページ</a>&gt;<a href="">会員情報変更</a>
</div>


<h1 class="common_headline1_">会員情報変更</h1>
<% User u = (User)session.getAttribute("userBean"); %>

<div class="customer_status_">
<div class="loginname_"><%= u.getFirstName() %><%= u.getLastName() %> 様</div>

</div>



<form id="frmCustomer" name="adduser" method="post" action="edituser" novalidate="" onsubmit="return check_submit_addnew()">

<p class="message_">会員情報登録・修正を行います。<img src="//d3iuyfi32mtj8g.cloudfront.net/img/sys/check.gif" alt="必須">マークの箇所は、必ず入力してください。</p>



<table class="formdetail_ customer_">
	<tbody><tr>
		<th><img class="must_" src="img/check.gif" alt="必須">氏名</th>
		<td class="valign_m_">
			<span class="efo checktype_name  is_required">
				［姓］<input value="<%= u.getFirstName() %>" size="20" type="text" name="firstname" id="firstname" maxlength="10" onblur="ecUtil.strConvert(this, true); " title="姓	" placeholder="姓	" class="classrequired">
			</span>
			<span class="efo checktype_name is_required">
				［名］<input value="<%= u.getLastName() %>" size="20" type="text" name="lastname" id="lastname" maxlength="10" onblur="ecUtil.strConvert(this, true); " title="名	" placeholder="名	" class="classrequired"> 
			</span>
			
			
		</td>
	</tr>
  
	<tr>
		<th>メールアドレス</th>
		<td><%= u.getEmail() %>
  
		<a href="jumpemailchange"><span class="small_">（変更はこちら）</span></a>
		</td>
  
	</tr>
  
  <tr>
		<th><img class="must_" src="img/check.gif" alt="必須">郵便番号</th>
		<td>
			<span class="efo checktype_mail is_required">
				<input value="<%= u.getPostcode() %>" size="40" type="text" name="postcode" maxlength="100" id="mail" onblur="ecUtil.strConvert(this, false);" title="(例)111-2222	" placeholder="(例)111-2222	" class="classrequired">
			</span>
		
		<p class="small_">※「.@ (@の前にドット)」、「.. (ドット2つ)」を含むメールアドレスはご利用いただけません</p>
		</td>
	</tr>
	
	<tr>
		<th><img class="must_" src="img/check.gif" alt="必須">住所</th>
		<td>
		<span class="efo checktype_addr  is_required">
			<input value="<%= u.getAddress() %>" size="40" type="text" name="address" maxlength="40" id="addr" onblur="ecUtil.strConvert(this, true); " title="(例)渋谷区神宮前○ー○ー○xxxxxビル　１０１号室	" placeholder="(例)渋谷区神宮前○ー○ー○xxxxxビル　１０１号室	" class="classrequired">
		</span>
		
		</td>
	</tr>

  
	<tr>
		<th><img class="must_" src="img/check.gif" alt="必須">連絡先電話番号</th>
		<td>
		<span class="efo checktype_tel  is_required">
			<input value="<%= u.getTel() %>" size="20" type="text" name="tel" maxlength="13" onblur="ecUtil.strConvert(this, false); " placeholder="(例)09012345678	" class="classrequired classerror" title="(例)09012345678	">
		</span><!--<img id="isErrorIcon_tel" src="img/input_okimg/input_error.gif" alt="入力内容に誤りがあります。">-->
		
		
		</td>
	</tr>
</tbody></table>

<p class="message_">以下についてもお答えください。</p>
<table class="formdetail_ customer_">

	<tbody><tr>
		<th><img class="must_" src="img/check.gif" alt="必須">性別</th>
		<td>
			<span class="efo ">
			<select name="sex"><option value="<%= u.getSex() %>" selected="">男性</option><option value="<%= u.getSex() %>">女性</option>
			</span>
		
		</td>
	</tr>


	<tr>
		<th><img class="must_" src="img/check.gif" alt="必須">生年月</th>
		<td>
		<span class="efo  checktype_date">
			<select name="birthday"><option value="<%= u.getBirthday() %>"></option><option value="2020">2020</option><option value="2019" selected="">2019</option><option value="2018">2018</option><option value="2017">2017</option><option value="2016">2016</option><option value="2015">2015</option><option value="2014">2014</option><option value="2013">2013</option><option value="2012">2012</option><option value="2011">2011</option><option value="2010">2010</option><option value="2009">2009</option><option value="2008">2008</option><option value="2007">2007</option><option value="2006">2006</option><option value="2005">2005</option><option value="2004">2004</option><option value="2003">2003</option><option value="2002">2002</option><option value="2001">2001</option><option value="2000">2000</option><option value="1999">1999</option><option value="1998">1998</option><option value="1997">1997</option><option value="1996">1996</option><option value="1995">1995</option><option value="1994">1994</option><option value="1993">1993</option><option value="1992">1992</option><option value="1991">1991</option><option value="1990">1990</option><option value="1989">1989</option><option value="1988">1988</option><option value="1987">1987</option><option value="1986">1986</option><option value="1985">1985</option><option value="1984">1984</option><option value="1983">1983</option><option value="1982">1982</option><option value="1981">1981</option><option value="1980">1980</option><option value="1979">1979</option><option value="1978">1978</option><option value="1977">1977</option><option value="1976">1976</option><option value="1975">1975</option><option value="1974">1974</option><option value="1973">1973</option><option value="1972">1972</option><option value="1971">1971</option><option value="1970">1970</option><option value="1969">1969</option><option value="1968">1968</option><option value="1967">1967</option><option value="1966">1966</option><option value="1965">1965</option><option value="1964">1964</option><option value="1963">1963</option><option value="1962">1962</option><option value="1961">1961</option><option value="1960">1960</option><option value="1959">1959</option><option value="1958">1958</option><option value="1957">1957</option><option value="1956">1956</option><option value="1955">1955</option><option value="1954">1954</option><option value="1953">1953</option><option value="1952">1952</option><option value="1951">1951</option><option value="1950">1950</option><option value="1949">1949</option><option value="1948">1948</option><option value="1947">1947</option><option value="1946">1946</option><option value="1945">1945</option><option value="1944">1944</option><option value="1943">1943</option><option value="1942">1942</option><option value="1941">1941</option><option value="1940">1940</option><option value="1939">1939</option><option value="1938">1938</option><option value="1937">1937</option><option value="1936">1936</option><option value="1935">1935</option><option value="1934">1934</option><option value="1933">1933</option><option value="1932">1932</option><option value="1931">1931</option><option value="1930">1930</option><option value="1929">1929</option><option value="1928">1928</option><option value="1927">1927</option><option value="1926">1926</option><option value="1925">1925</option><option value="1924">1924</option><option value="1923">1923</option><option value="1922">1922</option><option value="1921">1921</option><option value="1920">1920</option><option value="1919">1919</option><option value="1918">1918</option><option value="1917">1917</option><option value="1916">1916</option><option value="1915">1915</option><option value="1914">1914</option><option value="1913">1913</option><option value="1912">1912</option></select>年<select name="birthday"><option value="<%= u.getBirthday() %>"></option><option value="01" selected="">01</option><option value="02">02</option><option value="03">03</option><option value="04">04</option><option value="05">05</option><option value="06">06</option><option value="07">07</option><option value="08">08</option><option value="09">09</option><option value="10">10</option><option value="11">11</option><option value="12">12</option></select>月
		</span>
		<input type="hidden" value="<%= u.getBirthday() %>" name="birthday" value="01">
		
		</td>
	</tr>

</tbody></table>

<p class="message_">※パスワードの変更は<strong><a href="jumppasschange">こちら</a></strong>から</p>







<div class="submit_">

<a href="javascript:history.go(-1);"><img src="img/back.gif" alt="戻る"></a>

<input type="image" name="confirm" src="img/enter.gif" alt="確認">
<input type="hidden" name="agree.x" value="">

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
	<p id="copyright">COPYRIGHT☆ New Era Japan GK. ALL RIGHTS RESERVED.</p>
</div></div>
			
	</div>
</div>




<div class="selection_bubble_root" style="display: none;"></div></body></html>