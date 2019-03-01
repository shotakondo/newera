<%@ page language="java" contentType="text/html;charset=Windows-31J"
	pageEncoding="Windows-31J"%>
	
<!DOCTYPE 新規>
<html lang="jp">
<head>
  <title>新規一覧</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <script>
document.forms['adduser'].name.focus();
function set_focus()
{
   document.forms['adduser'].name.focus();
}
function check_submit_addnew()
{
   var frm = window.document.adduser;         
   if(frm.email.value=='')
   {
      alert('イメール入力してください');           
      document.forms['adduser'].email.focus();
      return false;
   }
   else if(frm.firstname.value=='')
   {
      alert('性入力してください');
      document.forms['adduser'].firstname.focus();           
      return false;
   }
    else if(frm.lastname.value=='')
   {
      alert('名入力してください');
      document.forms['adduser'].lastname.focus();           
      return false;
   }
   else if(frm.tel.value=='')
   {
      alert('電話番号入力してください');
      document.forms['adduser'].tel.focus();           
      return false;
   }
    else if(frm.id.value=='')
   {
      alert('ID入力してください');
      document.forms['adduser'].id.focus();           
      return false;
   }
   <!--else if(frm.birthday.value=='')
   {
      alert('生年月入力してください');
      document.forms['adduser'].birthday.focus();           
      return false;
   }-->

   else if(frm.postcode.value=='')
   {
      alert('郵便番号');
      document.forms['adduser'].postcode.focus();           
      return false;
   }
   
   else if(frm.sex.value=='')
   {
      alert('性別入力してください');
      document.forms['adduser'].sex.focus();           
      return false;
   }
   else if(frm.address.value=='')
   {
      alert('住所入力してください');
      document.forms['adduser'].address.focus();           
      return false;
   }
   else if(frm.pass.value=='')
   {
      alert('パスワード入力');
      document.forms['adduser'].pass.focus();           
      return false;
   }
   else                       
      return true;   
}

</script>
</head>
<img src="img/logo.png">
<body>
<!--<input type="text" name="search" placeholder="キーワードを入力">-->
<div class="container">
  <strong><center><img src="img/members1.png" alt="MEMBERS"></center></strong>
		<center><b>新規会員登録</center></b><br />
	<p>会員情報登録を行います。<img src="img/icon_hissu.gif">必須マークの箇所は、必ず入力してください。</p>
  <form name="adduser" action="create" method="post" onsubmit="return check_submit_addnew()">
  
		<div class="form-group">
      <label class="control-label col-sm-2" for="name">メールアドレス</label><img src="img/icon_hissu.gif">
      <div class="">
        <input type="text" class="" maxlength="30" id="email" name="email" placeholder="(例)sample@sample.jp">
      </div>
      <p>※「.@ (@の前にドット)」、「.. (ドット2つ)」を含むメールアドレスはご利用いただけません</p>
	</div>
	<!--<div class="form-group">
      <label class="control-label col-sm-2" for="name">メールアドレス(確認)</label><img src="img/icon_hissu.gif">
      <div class="">
        <input type="text" class="" maxlength="30" id="email" name="email1" placeholder="(例)sample@sample.jp">
      </div>
      <p>メールアドレス確認のため再度入力をお願いします</p>
	</div> -->
       
      <div class="form-group">
      <label class=" for="pwd">[姓]</label><img src="img/icon_hissu.gif">
      <div class="">          
        <input type="text" class="" id="pwd" name="firstname" placeholder="姓">
      </div>
    </div>
    <div class="form-group">
      <label class="" for="pwd">[名]</label><img src="img/icon_hissu.gif">
      <div class="">          
        <input type="text" class="" id="pwd" name="lastname" placeholder="名">
      </div>
    </div>
    <div class="form-group">
      <label class="" for="pwd">携帯電話</label><img src="img/icon_hissu.gif">
      <div class="">          
        <input type="text" class="" id="pwd" name="tel" placeholder="電話番号入力">
      </div>
    </div>
    <div class="form-group">
      <label class="" for="pwd">ID</label><img src="img/icon_hissu.gif">
      <div class="">          
        <input type="text" class="" id="pwd" name="id" placeholder="（例）aaa123">
      </div>
    </div>
    <table class="formdetail_ customer_">
	<div class="form-group">
	<label class="" for="pwd">生年月</label><img src="img/icon_hissu.gif">
			<select name="birthday"><option value=""></option><option value="2020">2020</option><option value="2019">2019</option><option value="2018">2018</option><option value="2017">2017</option><option value="2016">2016</option><option value="2015">2015</option><option value="2014">2014</option><option value="2013">2013</option><option value="2012">2012</option><option value="2011">2011</option><option value="2010">2010</option><option value="2009">2009</option><option value="2008">2008</option><option value="2007">2007</option><option value="2006">2006</option><option value="2005">2005</option><option value="2004">2004</option><option value="2003">2003</option><option value="2002">2002</option><option value="2001">2001</option><option value="2000">2000</option><option value="1999">1999</option><option value="1998">1998</option><option value="1997">1997</option><option value="1996">1996</option><option value="1995">1995</option><option value="1994">1994</option><option value="1993">1993</option><option value="1992">1992</option><option value="1991">1991</option><option value="1990">1990</option><option value="1989">1989</option><option value="1988">1988</option><option value="1987">1987</option><option value="1986">1986</option><option value="1985">1985</option><option value="1984">1984</option><option value="1983">1983</option><option value="1982">1982</option><option value="1981">1981</option><option value="1980">1980</option><option value="1979">1979</option><option value="1978">1978</option><option value="1977">1977</option><option value="1976">1976</option><option value="1975">1975</option><option value="1974">1974</option><option value="1973">1973</option><option value="1972">1972</option><option value="1971">1971</option><option value="1970">1970</option><option value="1969">1969</option><option value="1968">1968</option><option value="1967">1967</option><option value="1966">1966</option><option value="1965">1965</option><option value="1964">1964</option><option value="1963">1963</option><option value="1962">1962</option><option value="1961">1961</option><option value="1960">1960</option><option value="1959">1959</option><option value="1958">1958</option><option value="1957">1957</option><option value="1956">1956</option><option value="1955">1955</option><option value="1954">1954</option><option value="1953">1953</option><option value="1952">1952</option><option value="1951">1951</option><option value="1950">1950</option><option value="1949">1949</option><option value="1948">1948</option><option value="1947">1947</option><option value="1946">1946</option><option value="1945">1945</option><option value="1944">1944</option><option value="1943">1943</option><option value="1942">1942</option><option value="1941">1941</option><option value="1940">1940</option><option value="1939">1939</option><option value="1938">1938</option><option value="1937">1937</option><option value="1936">1936</option><option value="1935">1935</option><option value="1934">1934</option><option value="1933">1933</option><option value="1932">1932</option><option value="1931">1931</option><option value="1930">1930</option><option value="1929">1929</option><option value="1928">1928</option><option value="1927">1927</option><option value="1926">1926</option><option value="1925">1925</option><option value="1924">1924</option><option value="1923">1923</option><option value="1922">1922</option><option value="1921">1921</option><option value="1920">1920</option><option value="1919">1919</option><option value="1918">1918</option><option value="1917">1917</option><option value="1916">1916</option><option value="1915">1915</option><option value="1914">1914</option><option value="1913">1913</option><option value="1912">1912</option></select>年<select name="birthday"><option value=""></option><option value="01">01</option><option value="02">02</option><option value="03">03</option><option value="04">04</option><option value="05">05</option><option value="06">06</option><option value="07">07</option><option value="08">08</option><option value="09">09</option><option value="10">10</option><option value="11">11</option><option value="12">12</option></select>月
		</div>
		<div class="">
		<input type="hidden" name="birthday" >
	</div>
</tbody></table>
    <div class="form-group">
      <label class="" for="pwd">郵便番号</label><img src="img/icon_hissu.gif">
      <div class="">          
        <input type="text" class="" id="pwd" name="postcode" placeholder="111-2222">
      </div>
    </div>
    <div class="form-group">
      <label class="" for="pwd">性別</label><img src="img/icon_hissu.gif"><br />
      
<input name="sex" type="radio" value="0" />男性
<input name="sex" type="radio" value="1" />女性

      <div class="">          

      </div>
    </div>
    <div class="form-group">
      <label class="" for="pwd">住所</label><img src="img/icon_hissu.gif">
      <div class="">          
        <input type="text" class="" id="pwd" name="address" placeholder="１か２">
      </div>
    </div>
    <p>以上の項目でよろしければ、パスワードを入力してください。
メールアドレスとパスワードは、当店を今後も快適に利用する際に必要になります。
必ず忘れないものをご登録ください。</p>
<div class="form-group">
      <label class="" for="pwd">パスワード:</label><img src="img/icon_hissu.gif">
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="pass" name="pass" placeholder="パスワードを入力">
      </div>
     </div><p>（半角英数字記号 6文字以上,20文字以内で入力してください。IDと同様のパスワードは入力できません。）
あと11文字入力可能です。</p>
    <div class="form-group">        
      <div class="">
    <input type="image" name="confirm" src="img/back.gif" alt="確認">
        <input type="image" name="confirm" src="img/confirm.gif" alt="確認">
      </div>
    </div>
  </form>
</div>

</body>
</html>