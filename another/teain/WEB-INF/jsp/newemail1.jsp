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
		alert('�C���[�����͂��Ă�������');
}
else if(pass ==''|| pass1 ==''){
		alert('�V�����p�X���[�h���͂��Ă�������');
}
else if(pass != pass1){
		alert('�m�F�p�X���[�h�����ĂȂ���[');
}

else{
        alert('�����Ă�');
        return true;
    }
 
    return false;
}

</script>

<body>

<h1>�p�X���[�h�ύX</h1>
<form method="post" action="" onsubmit="return validateForm()">
           �C���[���F <input type="text" name="email" id="email" value=""/> <br/><br/>
            �V�����p�X���[�h�F <input type="pass" name="pass" id="pass" value=""/> <br/><br/>
            �m�F�p�X���[�h�F <input type="pass1" name="pass1" id="pass1" value=""/> <br/><br/>
            <input type="submit" name="login" value="�ύX����"/>
        </form>
</body>
</html>




