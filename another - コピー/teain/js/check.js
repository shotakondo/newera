/*--------------------�V�K�o�^---------------------*/
function check_shinkisubmit_addnew()
{
   var anh = window.document.createuser;         

   if(anh.firstname.value=='')
   {
      alert('�����͂��Ă�������');
      document.forms['createuser'].firstname.focus();           
      return false;
   }
    else if(anh.lastname.value=='')
   {
      alert('�����͂��Ă�������');
      document.forms['createuser'].lastname.focus();           
      return false;
   }
   else if(anh.postcode.value=='')
   {
      alert('�X�֔ԍ�');
      document.forms['createuser'].postcode.focus();           
      return false;
   }
   else if(anh.address.value=='')
   {
      alert('�Z�����͂��Ă�������');
      document.forms['createuser'].address.focus();           
      return false;
   }
      else if(anh.tel.value=='')
   {
      alert('�d�b�ԍ����͂��Ă�������');
      document.forms['createuser'].tel.focus();           
      return false;
   }
    else if(anh.pass.value=='' != anh.pass1.value=='')
   {
      alert('�p�X���[�h�m�F�ł��Ȃ�');
      document.forms['createuser'].tel.focus();           
      return false;
   }
   
   else                       
      return true;   
}
/*--------------------editUser---------------------*/
function check_submit_addnew()
{
   var anh = window.document.adduser;         

   if(anh.firstname.value=='')
   {
      alert('�����͂��Ă�������');
      document.forms['adduser'].firstname.focus();           
      return false;
   }
    else if(anh.lastname.value=='')
   {
      alert('�����͂��Ă�������');
      document.forms['adduser'].lastname.focus();           
      return false;
   }
   else if(anh.postcode.value=='')
   {
      alert('�X�֔ԍ�');
      document.forms['adduser'].postcode.focus();           
      return false;
   }
   else if(anh.address.value=='')
   {
      alert('�Z�����͂��Ă�������');
      document.forms['adduser'].address.focus();           
      return false;
   }
      else if(anh.tel.value=='')
   {
      alert('�d�b�ԍ����͂��Ă�������');
      document.forms['adduser'].tel.focus();           
      return false;
   }
    
   
   else                       
      return true;   
}

/*--------------------�މ�---------------------*/
function confirmAction() {
        return confirm("�{���ɑމ�Ă�낵���ł����H")
}

/*--------------------�p�X���[�h�ύX---------------------*/
function check_passsubmit_addnew(){
   var anh = window.document.check;         

   if(anh.email.value=='')
   {
      alert('�C���[�������͂ł��B');
      document.forms['check'].email.focus();           
      return false;
   }
    else if(anh.oldpass.value=='')
   {
      alert('�p�X���[�h�����͂ł��B');
      document.forms['check'].oldpass.focus();           
      return false;
   }
   else if(anh.pass.value=='')
   {
      alert('�V�����p�X���[�h�����͂ł��B');
      document.forms['check'].pass.focus();           
      return false;
   }
   else if(anh.newpass.value=='')
   {
      alert('�m�F�V�����p�X���[�h�����͂ł��B');
      document.forms['check'].newpass.focus();           
      return false;
   }
   else if(anh.pass.value != anh.newpass.value)
   {
      alert('�m�F�p�X���[�h�����ĂȂ���[');         
      return false;
   }

   else                       
      return true;   
}
/*--------------------�C���[���ύX---------------------*/
function check_emailsubmit_addnew()
{
   var anh = window.document.check;         

   if(anh.oldemail.value=='')
   {
      alert('�C���[�������͂ł��B');
      document.forms['check'].oldemail.focus();           
      return false;
   }
    else if(anh.pass.value=='')
   {
      alert('�p�X���[�h�����͂ł��B');
      document.forms['check'].pass.focus();           
      return false;
   }
   else if(anh.email.value=='')
   {
      alert('�V�����C���[�������͂ł��B');
      document.forms['check'].email.focus();           
      return false;
   }
   else if(anh.newemail.value=='')
   {
      alert('�m�F�V�����C���[�������͂ł��B');
      document.forms['check'].newemail.focus();           
      return false;
   }
   else if(anh.email.value != anh.newemail.value)
   {
      alert('�m�F�C���[�������ĂȂ���[');         
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
            
			document.getElementById("errpass").innerHTML = "�p�X���[�h�����͂ł��B";
			pass.style.background = "red";
            return false;
       }
       else if (email.value=='') {
            
			document.getElementById("erremail").innerHTML = "email�����͂ł��B";
			email.style.background = "red";
            return false;
       }
        else
        return true;
    }

/*-----------------by �O�G���e�@�A�C���@�Q�˂񂹂�(H29 2017-2019)��񏈗���---------*/