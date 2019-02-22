var searchSuggestFormSelector = ".withSuggestSearch_";
var searchSuggestAreaSelector = "#search_suggest_area_";
var searchSuggestPendingTime = 200;
var searchSuggestMinLength = 1;
var searchSuggestURL = '';
var searchSuggestAreaTmpl = '<div id="search_suggest_area_"></div>';
var searchSuggestTimer = null;
var searchSuggestCurrentForm = null; 
/*  初期化処理 */
jQuery(document).ready(function() { 
    /*  サジェストAjaxのURL生成 */
    searchSuggestURL = EC_WWW_ROOT + "/shop/search/searchsuggest.aspx"; 
    /*  キーワードを入力した、または、キーワードにフォーカスした場合のイベント */
    jQuery(searchSuggestFormSelector).on("keyup focus input", function(e) {
        triggerSearchSuggest(e, jQuery(this));
    });
    jQuery(searchSuggestFormSelector).on("keydown", function(e) {
        if (e.which == 40) {
            jQuery(searchSuggestAreaSelector).find('a:first').focus();
            e.preventDefault();
            e.stopPropagation();
        }
    });
    jQuery(document).on("keydown", searchSuggestAreaSelector, function(e) {
        if (e.which == 38) {
            var prevObj = jQuery(document.activeElement).parent().prev();
            var prevObjParent = jQuery(document.activeElement).parent().parent().prev();
            if (!prevObj[0] && !prevObjParent[0]) {
                jQuery(searchSuggestAreaSelector).find('a:last').focus();
            } else if (prevObj[0]) {
                prevObj.find('a:last').focus();
            } else if (prevObjParent[0]) {
                prevObjParent.children(':last').find('a:last').focus();
            }
            e.preventDefault();
            e.stopPropagation();
        }
        if (e.which == 40) {
            var nextObj = jQuery(document.activeElement).parent().next();
            var nextObjParent = jQuery(document.activeElement).parent().parent().next();
            if (!nextObj[0] && !nextObjParent[0]) {
                jQuery(searchSuggestAreaSelector).find('a:first').focus();
            } else if (nextObj[0]) {
                nextObj.find('a:first').focus();
            } else if (nextObjParent[0]) {
                nextObjParent.children(':first').find('a:first').focus();
            }
            e.preventDefault();
            e.stopPropagation();
        }
        if (e.which == 13) {
            return jQuery(document.activeElement).click();
        }
    });
    jQuery(document).on("focus", searchSuggestAreaSelector, function(e) {
        jQuery(searchSuggestAreaSelector).find('#suggest_keyword_list_').children('div.suggest_keyword_').css({
            'background-color': ''
        });
        jQuery(searchSuggestAreaSelector).find('#suggest_goods_list_').children().css({
            'background-color': ''
        });
        jQuery(e.target).parent().css({
            'background-color': '#dedede'
        });
    }); 
    /*  サジェストキーワードをクリックされた場合のイベント */
    jQuery(document).on("click", ".suggest_keyword_entry_", function() {
        selectSearchSuggestKeyword(jQuery(this));
        return false;
    }); 
    /*  サジェスト商品をクリックされた場合のイベント */
    jQuery(document).on("click", ".suggest_goods_", function() {
        selectSearchSuggestGoods(jQuery(this));
    }); 
    /*  サジェストエリア外をクリックされた場合のイベント */
    jQuery("body").on("click", function(e) {
        hideSearchSuggest(e);
    });
}); 
/*  サジェストキーワード選択時の処理 */
function selectSearchSuggestKeyword(entry) {
    jQuery(searchSuggestCurrentForm).val(entry.text());
    if (jQuery(searchSuggestCurrentForm).data("suggest-submit") == "on") { 
        /*  suggest-submitがonの時はformをsubmit */
        jQuery(searchSuggestCurrentForm).closest("form").submit();
    } else { 
        /*  suggest-submitがoffの時はサジェストエリアを閉じる */
        removeSearchSuggest();
    }
} 
/*  サジェスト商品選択時の処理 */
function selectSearchSuggestGoods(entry) {
    location.href = entry.find("a").attr("href");
} 
/*  キーワード入力後サジェスト表示タイマー開始処理 */
function triggerSearchSuggest(e, inputForm) {
    var inputKeyword = inputForm.val(); 
    /*  エンターの場合は中断 */
    if (e.keyCode == 13) {
        return false;
    } 
    /*  既に表示タイマーが開始されている場合は取り消し */
    if (searchSuggestTimer) {
        clearTimeout(searchSuggestTimer);
        searchSuggestTimer = null;
    } 
    /*  入力が空か最低入力文字数に満たない場合は中断 */
    if (inputKeyword == '' || inputKeyword.length < searchSuggestMinLength) {
        removeSearchSuggest();
        return false;
    } 
    /*  表示タイマーをセット */
    searchSuggestTimer = setTimeout(function() {
        searchSuggestTimer = null;
        requestSearchSuggest(inputForm, inputKeyword);
    }, searchSuggestPendingTime);
} 
/*  サジェスト表示タイマーがタイムアウト後の処理 */
function requestSearchSuggest(inputForm, inputKeyword) {
    jQuery.ajax({
        url: searchSuggestURL,
        type: "POST",
        dataType: "html",
        cache: false,
        data: {
            input_keyword: inputKeyword
        },
        success: function(responseHtml) { 
            /*  サジェストエリア消去 */
            removeSearchSuggest(); 
            /*  サジェストデータを受信したがキーワードがクリアされていた場合は中断 */
            if (inputForm.val() == '') {
                return;
            } 
            /*  サジェストデータが空（改行のみの場合を含む）の場合は中断 */
            if (responseHtml.replace(/\s+$/, "") == '') {
                return;
            } 
            /*  サジェストデータがセッション切れHTML等に置き換わっている場合は中断 */
            if (responseHtml.indexOf("suggest_keyword_list") == -1 && responseHtml.indexOf("suggest_goods_list") == -1) {
                return;
            } 
            /*  サジェストエリア表示 */
            showSearchSuggest(inputForm, responseHtml);
        }
    });
} 
/*  サジェストエリア表示処理 */
function showSearchSuggest(inputForm, responseHtml) { 
    /*  サジェストエリアのテンプレートを追加 */
    jQuery("body").append(searchSuggestAreaTmpl); 
    /*  サジェストエリアのHTMLをセット */
    var suggestArea = jQuery(searchSuggestAreaSelector);
    suggestArea.html(responseHtml); 
    /*  表示位置の調整 */
    var ctrl = inputForm;
    var ctrlOffset = ctrl.offset();
    var ctrlLeft = ctrlOffset.left;
    var ctrlTop = ctrlOffset.top + jQuery(ctrl).outerHeight(false);
    suggestArea.offset({
        top: ctrlTop,
        left: ctrlLeft
    });
    var paddingWidth = parseInt(suggestArea.css('margin-left')) + parseInt(suggestArea.css('margin-right')) + parseInt(suggestArea.css('padding-left')) + parseInt(suggestArea.css('padding-right'));
    var width = jQuery(ctrl).outerWidth(true) - paddingWidth;
    suggestArea.css("min-width", width); 
    /*  サジェストを表示したフォームを保持 */
    searchSuggestCurrentForm = inputForm; 
    /*  サジェストエリア表示 */
    suggestArea.show();
} 
/*  サジェストエリア非表示判定と非表示処理呼び出し */
function hideSearchSuggest(e) {
    var suggestArea = jQuery(searchSuggestAreaSelector);
    if (suggestArea.size()) {
        var x = e.clientX + jQuery(window).scrollLeft();
        var y = e.clientY + jQuery(window).scrollTop();
        var ctrlOffset = suggestArea.offset();
        var startX = ctrlOffset.left;
        var endX = startX + suggestArea.outerWidth(true);
        var startY = ctrlOffset.top;
        var endY = startY + suggestArea.outerHeight(true);
        if (x < startX || x > endX || y < startY || y > endY) {
            removeSearchSuggest();
        }
    }
} 
/*  サジェストエリア非表示処理 */
function removeSearchSuggest() {
    jQuery(searchSuggestAreaSelector).remove();
    searchSuggestCurrentForm = null;
}