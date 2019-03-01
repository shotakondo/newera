/// <reference path="jquery.js"/>
jQuery.noConflict(); 
/*  global変数 */
var EC_WWW_ROOT = '';
/*  半角->全角変換の実行可否変数 */
var ENABLE_HanToZen = true; 
/*  全角->半角変換の実行可否変数 */
var ENABLE_ZenToHan = true;  
/*  default charsetの設定 */
jQuery.ajaxSetup({
    contentType: 'application/x-www-form-urlencoded; charset=utf-8'
}); 
/*  util */
function _ecUtil() { 
    /*  ダブルクリック禁止処理 */
    this.ignoreDblClickFlag = null; 
    /*  郵便番号検索 */
    var timerId_lookupzip_ = null;
    var zipcache_lookupzip_ = '';
    var timerId_zipcache_ = null; 
    /*  配送先自動化 */
    var timeId_RewriteDateSpec = null; 
    /*  全角半角変換 */
    this.hanMap = {};
    this.zenMap = {
        'ａ': 'a',
        'ｂ': 'b',
        'ｃ': 'c',
        'ｄ': 'd',
        'ｅ': 'e',
        'ｆ': 'f',
        'ｇ': 'g',
        'ｈ': 'h',
        'ｉ': 'i',
        'ｊ': 'j',
        'ｋ': 'k',
        'ｌ': 'l',
        'ｍ': 'm',
        'ｎ': 'n',
        'ｏ': 'o',
        'ｐ': 'p',
        'ｑ': 'q',
        'ｒ': 'r',
        'ｓ': 's',
        'ｔ': 't',
        'ｕ': 'u',
        'ｖ': 'v',
        'ｗ': 'w',
        'ｘ': 'x',
        'ｙ': 'y',
        'ｚ': 'z',
        'Ａ': 'A',
        'Ｂ': 'B',
        'Ｃ': 'C',
        'Ｄ': 'D',
        'Ｅ': 'E',
        'Ｆ': 'F',
        'Ｇ': 'G',
        'Ｈ': 'H',
        'Ｉ': 'I',
        'Ｊ': 'J',
        'Ｋ': 'K',
        'Ｌ': 'L',
        'Ｍ': 'M',
        'Ｎ': 'N',
        'Ｏ': 'O',
        'Ｐ': 'P',
        'Ｑ': 'Q',
        'Ｒ': 'R',
        'Ｓ': 'S',
        'Ｔ': 'T',
        'Ｕ': 'U',
        'Ｖ': 'V',
        'Ｗ': 'W',
        'Ｘ': 'X',
        'Ｙ': 'Y',
        'Ｚ': 'Z',
        '０': '0',
        '１': '1',
        '２': '2',
        '３': '3',
        '４': '4',
        '５': '5',
        '６': '6',
        '７': '7',
        '８': '8',
        '９': '9',
        '！': '!',
        '＠': '@',
        '＃': '#',
        '＄': '$',
        '％': '%',
        '＾': '^',
        '＆': '&',
        '＊': '*',
        '（': '(',
        '）': ')',
        '＿': '_',
        '＋': '+',
        '｜': '|',
        '￣': '~',
        '－': '-',
        '＝': '=',
        '￥': '\\',
        '｀': '`',
        '｛': '{',
        '｝': '}',
        '［': '[',
        '］': ']',
        '：': ':',
        '”': '"',
        '；': ';',
        '’': '\'',
        '＜': '<',
        '＞': '>',
        '？': '?',
        '，': ',',
        '．': '.',
        '／': '/',
        '。': '｡',
        '「': '｢',
        '」': '｣',
        '、': '､',
        '・': '･',
        'ヲ': 'ｦ',
        'ァ': 'ｧ',
        'ィ': 'ｨ',
        'ゥ': 'ｩ',
        'ェ': 'ｪ',
        'ォ': 'ｫ',
        'ャ': 'ｬ',
        'ュ': 'ｭ',
        'ョ': 'ｮ',
        'ッ': 'ｯ',
        'ー': 'ｰ',
        'ア': 'ｱ',
        'イ': 'ｲ',
        'ウ': 'ｳ',
        'エ': 'ｴ',
        'オ': 'ｵ',
        'カ': 'ｶ',
        'キ': 'ｷ',
        'ク': 'ｸ',
        'ケ': 'ｹ',
        'コ': 'ｺ',
        'サ': 'ｻ',
        'シ': 'ｼ',
        'ス': 'ｽ',
        'セ': 'ｾ',
        'ソ': 'ｿ',
        'タ': 'ﾀ',
        'チ': 'ﾁ',
        'ツ': 'ﾂ',
        'テ': 'ﾃ',
        'ト': 'ﾄ',
        'ナ': 'ﾅ',
        'ニ': 'ﾆ',
        'ヌ': 'ﾇ',
        'ネ': 'ﾈ',
        'ノ': 'ﾉ',
        'ハ': 'ﾊ',
        'ヒ': 'ﾋ',
        'フ': 'ﾌ',
        'ヘ': 'ﾍ',
        'ホ': 'ﾎ',
        'マ': 'ﾏ',
        'ミ': 'ﾐ',
        'ム': 'ﾑ',
        'メ': 'ﾒ',
        'モ': 'ﾓ',
        'ヤ': 'ﾔ',
        'ユ': 'ﾕ',
        'ヨ': 'ﾖ',
        'ラ': 'ﾗ',
        'リ': 'ﾘ',
        'ル': 'ﾙ',
        'レ': 'ﾚ',
        'ロ': 'ﾛ',
        'ワ': 'ﾜ',
        'ン': 'ﾝ',
        'ガ': 'ｶﾞ',
        'ギ': 'ｷﾞ',
        'グ': 'ｸﾞ',
        'ゲ': 'ｹﾞ',
        'ゴ': 'ｺﾞ',
        'ザ': 'ｻﾞ',
        'ジ': 'ｼﾞ',
        'ズ': 'ｽﾞ',
        'ゼ': 'ｾﾞ',
        'ゾ': 'ｿﾞ',
        'ダ': 'ﾀﾞ',
        'ヂ': 'ﾁﾞ',
        'ヅ': 'ﾂﾞ',
        'デ': 'ﾃﾞ',
        'ド': 'ﾄﾞ',
        'バ': 'ﾊﾞ',
        'パ': 'ﾊﾟ',
        'ビ': 'ﾋﾞ',
        'ピ': 'ﾋﾟ',
        'ブ': 'ﾌﾞ',
        'プ': 'ﾌﾟ',
        'ベ': 'ﾍﾞ',
        'ペ': 'ﾍﾟ',
        'ボ': 'ﾎﾞ',
        'ポ': 'ﾎﾟ',
        'ヴ': 'ｳﾞ',
        '゛': 'ﾞ',
        '゜': 'ﾟ',
        '　': ' '
    }; 
    /*  半角->全角マップ */
    for (var key in this.zenMap) {
        if (!this.hanMap[this.zenMap[key]]) {
            this.hanMap[this.zenMap[key]] = key;
        }
    } 
    /*  半角<->全角変換 */
    this.strConvert = function(obj, isHanToZen) {
        if (obj.value == obj.getAttribute("title")) {
            return true;
        }
        if ((isHanToZen == true) && (ENABLE_HanToZen == false)) {
            return true;
        }
        if ((isHanToZen == false) && (ENABLE_ZenToHan == false)) {
            return true;
        }
        var str = obj.value;
        var conv = '';
        var map = isHanToZen ? this.hanMap : this.zenMap;
        for (var i = 0; i < str.length; i++) {
            var tmp = '';
            if (i < str.length - 1) {
                tmp = str.substring(i, i + 2);
            }
            if (map[tmp]) {
                conv += map[tmp];
                i++;
                continue;
            } else {
                tmp = str.substring(i, i + 1);
                conv += map[tmp] ? map[tmp] : tmp;
            }
        }
        obj.value = conv;
        return true;
    }; 
    /*  ダブルクリック（連続ポスト）の制御 */
    this.ignoreDblClick = function() {
        if (this.ignoreDblClickFlag == null) {
            this.ignoreDblClickFlag = 1;
            return true;
        } else {
            return false;
        }
    }; 
    /*  htmlタグの置き換え */
    this.htmlspecialchars = function(str) {
        if (!str || str == '') {
            return '';
        }
        str = str.replace(/&/g, '&amp;');
        str = str.replace(/"/g, '&quot;');
        str = str.replace(/'/g, '&#039;');
        str = str.replace(/</g, '&lt;');
        str = str.replace(/>/g, '&gt;');
        return str;
    }; 
    /*  配送希望日自動切換え */
    this.RewriteDateSpec = function(dest) {
        dest = '#dest_r' + dest;
        var timerOffset = 300;
        clearTimeout(timeId_RewriteDateSpec);
        timeId_RewriteDateSpec = setTimeout(function() {
            if (!jQuery(dest).val().match(/^[0-9]+$/)) {
                return true;
            }
            jQuery.get('../order/destajax.aspx', {
                dest: jQuery(dest).val(),
                charset: 'shift_jis'
            }, function(data, status) {
                var val = jQuery('select[name=date_detail_spec] :selected').val();
                jQuery('select[name=date_detail_spec]').children().remove();
                jQuery('select[name=date_detail_spec]').html(data);
                jQuery('select[name=date_detail_spec]').val(val);
                if (jQuery('select[name=date_detail_spec] :selected').text() == '') {
                    jQuery('select[name=date_detail_spec]').val('');
                }
            }, 'html');
        }, timerOffset);
    }; 
    /*  配送希望日自動切換え(ゲスト)  */
    this.RewriteDateSpecGuest = function() {
        var chkself = '#chkself';
        var s_zip = '#s_zip';
        var d_zip = '#d_zip';
        var s_pref = '#s_pref';
        var d_pref = '#d_pref';
        var zip = '';
        var pref = '';
        var timerOffset = 300;
        clearTimeout(timeId_RewriteDateSpec);
        timeId_RewriteDateSpec = setTimeout(function() {
            if (!jQuery(chkself).prop('checked') && (jQuery(d_pref).val() != '' || jQuery(d_zip).val() != '')) {
                if (jQuery(d_zip).val() != '' && !jQuery(d_zip).val().match(/^[0-9]{3}[\-]{0,1}[0-9]{0,4}$/)) {
                    return true;
                }
                zip = jQuery(d_zip).val();
                pref = jQuery(d_pref).val();
            } else if (jQuery(chkself).prop('checked') && (jQuery(s_pref).val() != '' || jQuery(s_zip).val() != '')) {
                if (jQuery(s_zip).val() != '' && !jQuery(s_zip).val().match(/^[0-9]{3}[\-]{0,1}[0-9]{0,4}$/)) {
                    return true;
                }
                zip = jQuery(s_zip).val();
                pref = jQuery(s_pref).val();
            } else {
                zip = '';
                pref = '';
            }
            jQuery.get('../order/destajax.aspx', {
                d_zip: zip,
                d_pref: pref,
                charset: 'shift_jis'
            }, function(data, status) {
                var val = jQuery('select[name=date_detail_spec] :selected').val();
                jQuery('select[name=date_detail_spec]').children().remove();
                jQuery('select[name=date_detail_spec]').html(data);
                jQuery('select[name=date_detail_spec]').val(val);
                if (jQuery('select[name=date_detail_spec] :selected').text() == '') {
                    jQuery('select[name=date_detail_spec]').val('');
                }
            }, 'html');
        }, timerOffset);
    }; 
    /*  郵便番号検索 */
    this.lookupZipInit = function(zip, pref, addr, addr2, cnt, offset) {
        var defaultXOffset = 90;
        var timerOffset = 300;
        var zip_id = '#' + zip + cnt;
        var pref_id = '#' + pref + cnt;
        var addr_id = '#' + addr + cnt;
        var addr2_id = '#' + addr2 + cnt;
        offset = offset + defaultXOffset;
        jQuery(zip_id).bind('keyup paste', function() {
            jQuery('ul.ziplist_').remove();
            clearTimeout(timerId_zipcache_);
            timerId_zipcache_ = setTimeout(function() {
                if (zipcache_lookupzip_ == jQuery(zip_id).val()) {
                    zipcache_lookupzip_ = jQuery(zip_id).val();
                    return false;
                }
                zipcache_lookupzip_ = jQuery(zip_id).val();
            }, timerOffset);
            clearTimeout(timerId_lookupzip_);
            timerId_lookupzip_ = setTimeout(function() {
                if (!jQuery(zip_id).val().match(/^[0-9]{3}[\-]{0,1}[0-9]{0,4}$/)) {
                    return true;
                }
                jQuery.get('../search/lookupzipjson.aspx', {
                    zip: jQuery(zip_id).val(),
                    charset: 'UTF-8'
                }, function(data, status) {
                    var of = jQuery(zip_id).offset();
                    var ul = jQuery('<ul></ul>').addClass('ziplist_');
                    ul.css('top', of .top);
                    ul.css('left', of .left + offset);
                    var searchCount = 0;
                    var tempzip, temppref, tempaddr, tempaddr2;
                    jQuery.each(data, function(key, item) {
                        searchCount++;
                        tempzip = item.zip;
                        temppref = item.pref;
                        tempaddr = item.addr;
                        tempaddr2 = item.addr2;
                        var li = jQuery('<li>' + key + ' ' + item.pref + ' ' + item.addr + ' ' + item.addr2 + '</li>');
                        li.bind('click', function() {
                            jQuery(zip_id).val(item.zip);
                            jQuery(pref_id).val(item.pref);
                            jQuery(addr_id).val(item.addr);
                            jQuery(addr2_id).val(item.addr2);
                            jQuery('ul.ziplist_').remove();
                            jQuery(zip_id).blur();
                            jQuery(pref_id).change();
                            jQuery(addr_id).focus();
                            jQuery(addr2_id).blur().focus();
                            return false;
                        });
                        li.bind('mouseover', function() {
                            li.addClass('hover');
                        });
                        li.bind('mouseleave', function() {
                            li.removeClass('hover');
                        });
                        ul.append(li);
                    });
                    if ((searchCount == 1) && (zipcache_lookupzip_.replace("-", "").length == 7)) {
                        jQuery(zip_id).val(tempzip);
                        jQuery(pref_id).val(temppref);
                        jQuery(addr_id).val(tempaddr);
                        jQuery(addr2_id).val(tempaddr2);
                        jQuery('ul.ziplist_').remove();
                        jQuery(zip_id).blur();
                        jQuery(pref_id).change();
                        jQuery(addr_id).focus();
                        jQuery(addr2_id).blur().focus();
                        return false;
                    } else if (searchCount != 0) {
                        jQuery(document.body).append(ul);
                    }
                }, 'json');
            }, timerOffset);
        });
    }; 
    /*  汎用入力チェック */
    this.confirmInputCheck = function() { 
        /*  メールアドレスチェック */
        if (jQuery('#mail').size() == 1 && jQuery('#cmail').size() == 1) {
            if (jQuery('#mail').val() != jQuery('#cmail').val()) {
                alert('メールアドレスとメールアドレス（確認）が一致しません');
                ecUtil.ignoreDblClickFlag = false;
                return false;
            }
        } 
        /*  メールアドレスチェック２ */
        if (jQuery('#newmail1').size() == 1 && jQuery('#newmail2').size() == 1) {
            if (jQuery('#newmail1').val() != jQuery('#newmail2').val()) {
                alert('メールアドレスとメールアドレス（確認）が一致しません');
                ecUtil.ignoreDblClickFlag = false;
                return false;
            }
        } 
        /*  パスワードチェック */
        if (jQuery('#pwd').size() == 1 && jQuery('#cpwd').size() == 1) {
            if (jQuery('#pwd').val() != jQuery('#cpwd').val()) {
                alert('入力されたパスワードと確認用パスワードが一致しません');
                ecUtil.ignoreDblClickFlag = false;
                return false;
            }
        } 
        /*  パスワードチェック2 */
        if (jQuery('#npwd1').size() == 1 && jQuery('#npwd2').size() == 1) {
            if (jQuery('#npwd1').val() != jQuery('#npwd2').val()) {
                alert('入力されたパスワードと確認用パスワードが一致しません');
                ecUtil.ignoreDblClickFlag = false;
                return false;
            }
        } 
        /*  IDチェック */
        if (jQuery('#newid1').size() == 1 && jQuery('#newid2').size() == 1) {
            if (jQuery('#newid1').val() != jQuery('#newid2').val()) {
                alert('入力されたIDと確認用IDが一致しません');
                ecUtil.ignoreDblClickFlag = false;
                return false;
            }
        } 
        /*  IDとPASSの不一致確認 */
        if (jQuery('#uid').size() == 1 && jQuery('#pwd').size() == 1) {
            if (jQuery('#uid').val() != "" && jQuery('#pwd').val() != "") {
                if (jQuery('#uid').val() == jQuery('#pwd').val()) {
                    alert('会員IDとパスワードは別々のものを指定してください');
                    jQuery('#pwd').val('');
                    jQuery('#cpwd').val('');
                    ecUtil.ignoreDblClickFlag = false;
                    return false;
                }
            }
        }
        return true;
    }; 
    /*  名前の高さを行ごとにそろえる */
    this.tileGoodsList = function() { 
        /*  二重実行の防止 */
        var excuteKey = "goods_list_tiled";
        var tiled = jQuery(document).data(excuteKey);
        if (tiled) return;
        jQuery(document).data(excuteKey, true); 
        /*  対象のセレクタ */ 
        /*  一覧を包むフレーム */
        var frameSelector = ".tile_frame_"; 
        /*  行 */
        var lineSelector = ".tile_line_"; 
        /*  個々の商品 */
        var itemSelector = ".tile_item_"; 
        /*  高さを合わせる要素 */
        var elmSelector = ".tile_elm_"; 
        /*  一覧を包むフレームが見つからない場合は、処理を終了 */
        var frames = jQuery(frameSelector);
        if (frames.length < 1) return;
        frames.each(function() { 
            /*  対象の一覧 */
            var frame = jQuery(this); 
            /*  列の数を取得 */
            var maxColumn = frame.find(lineSelector + ":first").children(itemSelector).size(); 
            /*  指定要素の高さを揃える */
            if (maxColumn && maxColumn > 1) frame.find(elmSelector).tile(maxColumn);
        });
    };
}
var ecUtil = new _ecUtil();

function checkNumUse(checkstr) { 
	var count = 0;
	var allowed_chars = '0123456789'
		+ '０１２３４５６７８９'
		+ '〇一二三四五六七八九十百'
		+ '零壱弐参伍拾';
	var size= checkstr.length;
	for (var i = 0; i < size; i+=1 ){
		if(allowed_chars.indexOf(checkstr[i]) < 0){
		}else{
			count++;
		}
	}
	return count;
}

function checkAddr2() { 
	var result = true;

	var checkstr = jQuery('#addr2').val();
	if ( checkNumUse(checkstr) == 0 ){
		result = confirm("住所２に番地漏れの可能性がございます。\n"
		                +"このまま登録することも可能です。\n"
		                +"このまま登録してよろしいですか?");
	}
	return result;
}

function checkGeustOrderAddr2() { 
	chkself = document.frmMethod.chkself.checked;
	var result = true;

	var checkstr = jQuery('#s_addr2').val();
	if ( checkNumUse(checkstr) == 0 ){
		result = confirm("住所２に番地漏れの可能性がございます。\n"
		                +"このまま登録することも可能です。\n"
		                +"このまま登録してよろしいですか?");
	}else if( chkself == false ){
		checkstr = jQuery('#d_addr2').val();
		if ( checkNumUse(checkstr) == 0 ){
			result = confirm("住所２に番地漏れの可能性がございます。\n"
			                +"このまま登録することも可能です。\n"
			                +"このまま登録してよろしいですか?");
		}
	}
	return result;
}

