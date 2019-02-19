function countLength(input_id, min_length, max_length, target_id) {
    var current_length = jQuery('#' + input_id).val().length;
    if ((min_length - current_length) <= 0) {
        jQuery('#' + target_id).css('color', '#6666FF').html('あと' + (max_length - current_length).toString() + '文字入力可能です。');
    } else {
        jQuery('#' + target_id).css('color', '#FF6666').html('あと' + (min_length - current_length).toString() + '文字以上入力してください');
    }
}

function countPWDLength(pwd_minlength, pwd_maxlength) {
    if (jQuery("input[name='pwd']").length == 0) return;
    countLength('pwd', pwd_minlength, pwd_maxlength, 'pwd_count_msg');
}

function countUIDLength(uid_minlength, uid_maxlength) {
    if (jQuery("input[name='uid']").length == 0) return;
    countLength('uid', uid_minlength, uid_maxlength, 'uid_count_msg');
}