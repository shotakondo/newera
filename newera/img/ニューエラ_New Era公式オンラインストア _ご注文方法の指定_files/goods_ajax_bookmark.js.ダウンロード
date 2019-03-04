jQuery(document).ready(function() {
    var $btn_bookmark = jQuery(".btn_bookmark_");
    $btn_bookmark.unbind("click");
    $btn_bookmark.bind("click", function(e) {
        var loadStart = function(elem) {
            var src = jQuery(elem).attr("src");
            var re = new RegExp("^(.+)(\.png|\.gif)$");
            var matches = src.match(re);
            var loadingsrc = "";
            if (matches.length == 3) {
                loadingsrc = matches[1] + "_loading" + matches[2];
            }
            jQuery(elem).attr({
                src: loadingsrc,
                alt: ""
            });
            return elem;
        };
        var loadEnd = function(elem, iserror, msg) {
            var src = jQuery(elem).attr("src");
            src = src.replace("_loading.", ".");
            if (!iserror) {
                jQuery(elem).showBalloon({
                    contents: msg,
                    classname: "balloons",
                    hideAnimation: function(d) {
                        this.slideUp(d);
                    },
                    offsetX: 0,
                    css: {
                        fontWeight: "bold",
                        backgroundColor: "#000000",
                        color: "#fff",
                        opacity: "0.7"
                    }
                });
                setTimeout(function() {
                    jQuery(elem).hideBalloon();
                    jQuery(elem).attr({
                        src: src,
                        alt: ""
                    }); 
                /* バルーン表示時間 */
                }, 2000);
            } else {
                jQuery(elem).attr({
                    src: src,
                    alt: ""
                });
            }
        };
        var addBookmark = function(b, g) {
            var o = loadStart(b);
            jQuery.ajax({
                async: true,
                type: "POST",
                url: EC_WWW_ROOT + "/shop/customer/bookmarkajax.aspx",
                data: {
                    "goods": g,
                    "crsirefo_hidden": add_crsirefo
                },
                cache: false,
                ifModified: false,
                dataType: "json",
                success: function(msg) {
                    setTimeout(function() {
                        loadEnd(o, false, msg);
                    }, 400);
                },
                error: function(xhr, status, thrown) {
                    loadEnd(o, true);
                    alert("セッションの有効期間がきれました。\n" + "誠に恐れ入りますが再度トップページよりのアクセスをお願いいたします。\n\n" + "※当サイトではお客様の情報保護のため、一定時間経過後に接続情報を解除させていただいております。");
                    return false;
                }
            });
            return true;
        };
        if (jQuery(this).attr("src").indexOf("_loading.") != -1) {
            return false;
        }
        var href = jQuery(this).parent().attr("href");
        var re = new RegExp("goods=([0-9A-Za-z_\-]+)");
        var matches = href.match(re);
        var goods = "";
        if (matches && matches.length == 2) {
            goods = matches[1];
        } else {
            return true;
        }
        addBookmark(this, goods);
        return false;
    });
});