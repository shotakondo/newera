<%@ page language="java" contentType="text/html;charset=Windows-31J"
	pageEncoding="Windows-31J"%>
	

<html>
<head>
	<title>�p�X���[�h�ύX</title>
	
	<script> 
		function validateForm() {
		var email = document.getElementById('email').value;
		var oldpass = document.getElementById('oldpass').value;
		var pass = document.getElementById('pass').value;
		var newpass = document.getElementById('newpass').value;

		if(email ==''){
				alert('Email����͂��Ă�������');
		}
		else if(oldpass == ''){
			alert('���̃p�X���[�h����͂��Ă�������')
		}
		else if(pass ==''|| newpass ==''){
				alert('�V�����p�X���[�h���͂��Ă�������');
		}
		else if(pass != newpass){
				alert('�m�F�p�X���[�h�����ĂȂ���[');
		}

		else{
				alert('�����Ă�');
				return true;
			}
		 
			return false;
		}
	</script>


</head>
<body>

<h1>�p�X���[�h�ύX</h1>
<form method='post' action='passchange' onsubmit="return validateForm()">

Email<input type="text" name="email" id="email" value=""/> <br/><br/>
���̃p�X���[�h<input type='text' name ="oldpass" id="oldpass" value=""/><br/></br/>

�V�����p�X���[�h<input type='text' name ="pass" id="pass" value=""/><br/></br/>
�m�F�p�X���[�h<input type='text' name ="newpass" id="newpass" value=""/><br/><br/>


	<input type='submit' value='�p�X���[�h�ύX'> <br />
<!--	<p><a href="jumpremind">�p�X���[�h��Y��܂������H</a></p> -->
</body>
</html>




