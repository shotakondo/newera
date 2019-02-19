/*--------------------新規登録---------------------*/
function check_shinkisubmit_addnew()
{
   var c = window.document.createuser;         

   if(c.firstname.value=='')
   {
      alert('姓未入力です。');
      document.forms['createuser'].firstname.focus();           
      return false;
   }
    else if(c.lastname.value=='')
   {
      alert('名未入力です。');
      document.forms['createuser'].lastname.focus();           
      return false;
   }
     else if(c.email.value=='')
   {
      alert('イメール未入力です。');
      document.forms['createuser'].email.focus();           
      return false;
   }
	else if(c.email1.value=='')
   {
      alert('確認イメール未入力です。');
      document.forms['createuser'].email1.focus();           
      return false;
   }
   else if(c.email.value != c.email1.value)
   {
      alert('確認イメールできないです。');           
      return false;
   }
   else if(c.postcode.value=='')
   {
      alert('郵便番号未入力です。');
      document.forms['createuser'].postcode.focus();           
      return false;
   }
   else if(c.address.value=='')
   {
      alert('住所未入力です。');
      document.forms['createuser'].address.focus();           
      return false;
   }
      else if(c.tel.value=='')
   {
      alert('電話番号未入力です。');
      document.forms['createuser'].tel.focus();           
      return false;
   }
    else if(c.pass.value=='')
   {
      alert('パスワード未入力です。');
      document.forms['createuser'].pass.focus();           
      return false;
   }
      else if(c.pass1.value=='')
   {
      alert('確認パスワード未入力です。');
      document.forms['createuser'].pass1.focus();           
      return false;
   }
   else if(c.pass.value != c.pass1.value)
   {
      alert('確認パスワード合ってないよー');         
      return false;
   }
   else                       
      return true;   
}
/*--------------------editUser---------------------*/
function check_submit_addnew()
{
   var anh = window.document.edituser;         

   if(anh.firstname.value=='')
   {
      alert('姓入力してください');
      document.forms['edituser'].firstname.focus();           
      return false;
   }
    else if(anh.lastname.value=='')
   {
      alert('名入力してください');
      document.forms['edituser'].lastname.focus();           
      return false;
   }
   else if(anh.postcode.value=='')
   {
      alert('郵便番号入力してください');
      document.forms['edituser'].postcode.focus();           
      return false;
   }
   else if(anh.address.value=='')
   {
      alert('住所入力してください');
      document.forms['edituser'].address.focus();           
      return false;
   }
      else if(anh.tel.value=='')
   {
      alert('電話番号入力してください');
      document.forms['edituser'].tel.focus();           
      return false;
   }
    
   
   else                       
      return true;   
}

/*--------------------退会---------------------*/
function confirmAction() {
        return confirm("本当に退会してよろしいですか？")
}

/*--------------------パスワード変更---------------------*/
function check_passsubmit_addnew(){
   var anh = window.document.check;         

   if(anh.email.value=='')
   {
      alert('イメール未入力です。');
      document.forms['check'].email.focus();           
      return false;
   }
    else if(anh.oldpass.value=='')
   {
      alert('パスワード未入力です。');
      document.forms['check'].oldpass.focus();           
      return false;
   }
   else if(anh.pass.value=='')
   {
      alert('新しいパスワード未入力です。');
      document.forms['check'].pass.focus();           
      return false;
   }
   else if(anh.newpass.value=='')
   {
      alert('確認新しいパスワード未入力です。');
      document.forms['check'].newpass.focus();           
      return false;
   }
   else if(anh.pass.value != anh.newpass.value)
   {
      alert('確認パスワード合ってないよー');         
      return false;
   }

   else                       
      return true;   
}
/*--------------------イメール変更---------------------*/
function check_emailsubmit_addnew()
{
   var anh = window.document.check;         

   if(anh.oldemail.value=='')
   {
      alert('イメール未入力です。');
      document.forms['check'].oldemail.focus();           
      return false;
   }
    else if(anh.pass.value=='')
   {
      alert('パスワード未入力です。');
      document.forms['check'].pass.focus();           
      return false;
   }
   else if(anh.email.value=='')
   {
      alert('新しいイメール未入力です。');
      document.forms['check'].email.focus();           
      return false;
   }
   else if(anh.newemail.value=='')
   {
      alert('確認新しいイメール未入力です。');
      document.forms['check'].newemail.focus();           
      return false;
   }
   else if(anh.email.value != anh.newemail.value)
   {
      alert('確認イメール合ってないよー');         
      return false;
   }

   else                       
      return true;   
}

/*-----------------Checkemail---------*/
function checkEmail() {

        var email 		= document.getElementById('email');
        var pass 		= document.getElementById("pass");
        var newemail	= document.getElementById("newemail");
        var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
        if (pass.value=='') {
            
			document.getElementById("errpass").innerHTML = "パスワード未入力です。";
			pass.style.background = "red";
            return false;
       }
       else if (email.value=='') {
            
			document.getElementById("erremail").innerHTML = "email未入力です。";
			email.style.background = "red";
            return false;
       }
        else
        return true;
    }

/*-----------------by グエンテ　アイン　２ねんせい(H29 2017-2019)情報処理科---------*/