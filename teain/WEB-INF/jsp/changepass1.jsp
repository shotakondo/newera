<%@ page language="java" contentType="text/html;charset=Windows-31J"
	pageEncoding="Windows-31J"%>
	

<html>
<head>
	<title>パスワード変更</title>
	
	<script> 
		function validateForm() {
		var email = document.getElementById('email').value;
		var oldpass = document.getElementById('oldpass').value;
		var pass = document.getElementById('pass').value;
		var newpass = document.getElementById('newpass').value;

		if(email ==''){
				alert('Emailを入力してください');
		}
		else if(oldpass == ''){
			alert('今のパスワードを入力してください')
		}
		else if(pass ==''|| newpass ==''){
				alert('新しいパスワード入力してください');
		}
		else if(pass != newpass){
				alert('確認パスワード合ってないよー');
		}

		else{
				alert('合ってる');
				return true;
			}
		 
			return false;
		}
	</script>


</head>
<body>

<h1>パスワード変更</h1>
<form method='post' action='passchange' onsubmit="return validateForm()">

Email<input type="text" name="email" id="email" value=""/> <br/><br/>
今のパスワード<input type='text' name ="oldpass" id="oldpass" value=""/><br/></br/>

新しいパスワード<input type='text' name ="pass" id="pass" value=""/><br/></br/>
確認パスワード<input type='text' name ="newpass" id="newpass" value=""/><br/><br/>


	<input type='submit' value='パスワード変更'> <br />
<!--	<p><a href="jumpremind">パスワードを忘れましたか？</a></p> -->
</body>
</html>




