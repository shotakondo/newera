document.forms['adduser'].name.focus();
function set_focus()
{
   document.forms['adduser'].name.focus();
}
function check_submit_addnew()
{
   var frm = window.document.adduser;         
   /*if(frm.email.value=='')
   {
      alert('�C���[�����͂��Ă�������');           
      document.forms['adduser'].email.focus();
      return false;
   }*/
   if(frm.firstname.value=='')
   {
      alert('�����͂��Ă�������');
      document.forms['adduser'].firstname.focus();           
      return false;
   }
    else if(frm.lastname.value=='')
   {
      alert('�����͂��Ă�������');
      document.forms['adduser'].lastname.focus();           
      return false;
   }
   else if(frm.tel.value=='')
   {
      alert('�d�b�ԍ����͂��Ă�������');
      document.forms['adduser'].tel.focus();           
      return false;
   }
   /* else if(frm.id.value=='')
   {
      alert('ID���͂��Ă�������');
      document.forms['adduser'].id.focus();           
      return false;
   }
  else if(frm.birthday.value=='')
   {
      alert('���N�����͂��Ă�������');
      document.forms['adduser'].birthday.focus();           
      return false;
   }*/

   else if(frm.postcode.value=='')
   {
      alert('�X�֔ԍ�');
      document.forms['adduser'].postcode.focus();           
      return false;
   }
   
   /*else if(frm.sex.value=='')
   {
      alert('���ʓ��͂��Ă�������');
      document.forms['adduser'].sex.focus();           
      return false;
   }
   else if(frm.pass.value=='')
   {
      alert('�p�X���[�h����');
      document.forms['adduser'].pass.focus();           
      return false;
   }/*
   else if(frm.address.value=='')
   {
      alert('�Z�����͂��Ă�������');
      document.forms['adduser'].address.focus();           
      return false;
   }
   
   else                       
      return true;   
}
