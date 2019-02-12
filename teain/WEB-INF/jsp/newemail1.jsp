<%@ page language="java" contentType="text/html;charset=Windows-31J"
	pageEncoding="Windows-31J"%>
<HTML>
<HEAD>
<script> 
function validateForm() {
var email = document.getElementById('email').value;
var pass = document.getElementById('pass').value;
var pass1 = document.getElementById('pass1').value;
if(email ==''){
		alert('イメール入力してください');
}
else if(pass ==''|| pass1 ==''){
		alert('新しいパスワード入力してください');
}
else if(pass != pass1){
		alert('確認パスワード合ってないよー');
}

else{
        alert('合ってる');
        return true;
    }
 
    return false;
}

</script>

<body>

<h1>パスワード変更</h1>
<form method="post" action="" onsubmit="return validateForm()">
           イメール： <input type="text" name="email" id="email" value=""/> <br/><br/>
            新しいパスワード： <input type="pass" name="pass" id="pass" value=""/> <br/><br/>
            確認パスワード： <input type="pass1" name="pass1" id="pass1" value=""/> <br/><br/>
            <input type="submit" name="login" value="変更する"/>
        </form>
</body>
</html>




