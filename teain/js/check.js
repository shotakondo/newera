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
      alert('イメール入力してください');           
      document.forms['adduser'].email.focus();
      return false;
   }*/
   if(frm.firstname.value=='')
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
   /* else if(frm.id.value=='')
   {
      alert('ID入力してください');
      document.forms['adduser'].id.focus();           
      return false;
   }
  else if(frm.birthday.value=='')
   {
      alert('生年月入力してください');
      document.forms['adduser'].birthday.focus();           
      return false;
   }*/

   else if(frm.postcode.value=='')
   {
      alert('郵便番号');
      document.forms['adduser'].postcode.focus();           
      return false;
   }
   
   /*else if(frm.sex.value=='')
   {
      alert('性別入力してください');
      document.forms['adduser'].sex.focus();           
      return false;
   }
   else if(frm.pass.value=='')
   {
      alert('パスワード入力');
      document.forms['adduser'].pass.focus();           
      return false;
   }/*
   else if(frm.address.value=='')
   {
      alert('住所入力してください');
      document.forms['adduser'].address.focus();           
      return false;
   }
   
   else                       
      return true;   
}
