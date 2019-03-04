var GN={
	ww:'',
	wh:'',
	dh:'',
	st:'',
	hh:'',
	picsel:'',
	c_picsel:'',
	ua:''
};

jQuery(function($){

	GN={
		ww:function(){ var v=(window.innerWidth)?window.innerWidth:$(window).width(); return v; },
		wh:function(){ var v=(window.innerHeight)?window.innerHeight:$(window).height(); return v; },
		dh:function(){
			var v=Math.max.apply(null,[document.body.clientHeight,document.body.scrollHeight,document.documentElement.scrollHeight,document.documentElement.clientHeight]);
			return v;
		},
		st:function(){ var v=$(window).scrollTop(); return v; },
		hh:function(){ var v=$('#header').innerHeight(); return v; },
		sthh:56,
		picsel:function(num){ var v=Math.floor((num*GN.ww())/640); return v; },
		c_picsel:function(a,b,c){ var v=Math.floor((a*c)/b); return v; },
		ua:navigator.userAgent
	};

	$.fn.extend({
		// ページ内スクロール
		pageScroll:function(options){
			var defaults={
				speed:600
			};
			var op=$.extend(defaults,options);
			var $t=$(this);
			$t.on('click',function(){
				var Hash=$(this).attr('href');
				if($(Hash).length){
					var HashOffset=(Hash!='#header')?$(Hash).offset().top-GN.sthh:0;
					$('html:not(:animated),body:not(:animated)').animate({ scrollTop:HashOffset+'px' },op.speed);
				};
				return false;
			});
		},
		// ホバーアクション
		hoverAction:function(options){
			var defaults={
				speed:100
			};
			var op=$.extend(defaults,options);
			var $t=$(this);
			var type=$t.attr('type');
			var $img=(type=='image')?$t:$t.find('img');
			var src=$img.attr('src');
			if(src){
				var src_on=src.replace(/^([\d\D]+)\.(jpg|gif|png)/,'$1_on.$2');
				$('<img src="'+src_on+'">').on('load',function(){
					if(type=='image') $img.css({ 'transition':'none' });
					$t.on({
						'mouseenter':function(){
							$img.animate({ opacity:0 },op.speed,function(){
								$(this).attr('src',src_on).animate({ opacity:1 },op.speed);
							});
						},
						'mouseleave':function(){
							$img.stop(true).animate({ opacity:1 },op.speed).attr('src',src);
						}
					});
				});
			};
		},
		// 開閉イベント
		toggleEvent:function(options){
			var defaults={
				trigger:'dt',
				target:'dd',
				close:'',
				speed:300
			};
			var op=$.extend(defaults,options);
			var $t=$(this);
			var $trigger=$t.find(op.trigger);
			var $target=$t.find(op.target);
			var toggleClose=function(){
				$trigger.removeClass('on');
				$target.slideUp(op.speed);
			};

			$trigger.off('click');
			$trigger.on('click',function(){
				if($target.is(':hidden')){
					$(this).addClass('on');
					$target.slideDown(op.speed);
				}else{
					toggleClose();
				};
				return false;
			});

		},
		// タブリンク
		tabLink:function(options){
			var defaults={
				trigger:'',
				target:'',
				speed:400
			};
			var op=$.extend(defaults,options);
			var $t=$(this);
			var $trigger=$t.find(op.trigger);
			var $target=$t.find(op.target);
			var $first_trigger=$trigger.eq(0);
			for(var i=0;i<$trigger.length;i++){
				if($trigger.eq(i).hasClass('on')){
					$first_trigger=$trigger.eq(i);
					break;
				};
			};
			var $first_id=$($first_trigger.attr('href'));

			$first_trigger.addClass('on');
			$first_id.show();

			$trigger.each(function(){
				var $id=$($(this).attr('href'));
				$(this).off('click');
				$(this).on('click',function(){
					if($id.is(':hidden')){
						$trigger.removeClass('on');
						$(this).addClass('on');
						$target.not($id).hide();
						$id.fadeIn(op.speed);
					};
					return false;
				});
			});
		},
		// 一覧表示
		listShow:function(options){
			var defaults={
				trigger:'',
				target:'',
				num:1,
				speed:200
			};
			var op=$.extend(defaults,options);
			var $t=$(this);
			var $trigger=$t.find(op.trigger);
			var $target=$t.find(op.target);
			var len=$target.length;
			var num=op.num;
			var index=1;
			var per=Math.ceil(len/num);

			$target.hide();
			for(var i=0;i<num;i++){
				$target.eq(i).show();
			};

			if(len>num){
				$trigger.show();
				$trigger.find('a').off('click');
				$trigger.find('a').on('click',function(){
					for(var i=0;i<num;i++){
						$target.eq(i+(num*index)).fadeIn(op.speed);
					};
					index=index+1;
					if(index==per) $trigger.hide();
					return false;
				});
			};

		},
		// アイテム上部面合わせ
		itemTopSet:function(options){
			var defaults={
				target:'> li',
				line:4
			};
			var op=$.extend(defaults,options);
			var $t=$(this);
			var $target=$t.find(op.target);
			var len=$target.length;
			var num=Math.ceil(len/op.line);
			var set=function(){
				for(var i=0;i<num;i++){
					var line=op.line*i;
					var h_arr=[];
					var h_max=0;
					for(var j=line;j<op.line*(i+1);j++){
						var $this=$target.eq(j);
						var $icon=$this.find('.icon');
						if($icon.find('img').length){
							var h=$icon.innerHeight();
							h_arr.push(h);
						};
					};
					h_max=(h_arr.length)?Math.max.apply(null,h_arr):0;
					for(var j=line;j<op.line*(i+1);j++){
						var $this=$target.eq(j);
						var $icon=$this.find('.icon');
						if(!$icon.find('img').length){
							$this.css({ paddingTop:h_max+'px' });
						};
					};
				};
			};

			set();

			$(window).on({
				'load resize':function(){ set(); }
			});

		},
		// ヘッダー固定
		headerFixed:function(options){
			var defaults={
				speed:200
			};
			var op=$.extend(defaults,options);
			var $t=$(this);
			var top=0;
			var h=0;
			var bool_scroll=true;
			var bool_load=false;
			var scrollFixed=function(){
				var limit=top+GN.hh()+40;
				if(GN.st()>limit&&bool_scroll){
					bool_scroll=false;
					$('body').addClass('fix_header').css({ paddingTop:h+'px' });
					$t.css({ top:'-'+GN.hh()+'px' }).stop(true).animate({ top:0 },op.speed);
				}else if(GN.st()<=limit&&!bool_scroll){
					$('body').removeClass('fix_header').css({ paddingTop:0 });
					$t.css({ top:'auto' });
					bool_scroll=true;
				};
			};

			$(window).on({
				'load':function(){
					top=$t.offset().top;
					h=GN.hh();
					scrollFixed();
					bool_load=true;
				},
				'scroll':function(){ if(bool_load) scrollFixed(); }
			});
		},
		// サブナビゲーション
		subNavigation:function(options){
			var defaults={
				speed:300
			};
			var op=$.extend(defaults,options);
			var $t=$(this);
			var $a=$t.find('a');
			var $trigger=$t.find('a[href^=#]');
			var $t_target=$trigger.eq(0);
			var id=$t_target.attr('href');
			var $target=$(id);
			var $item_links=$('#head_item_links');
			var $hover=$item_links.find('a[data-hover]');
			var $photo=$item_links.find('.photo');
			// 開く
			var openNav=function(){
				$target=$(id);
				$t_target=$('a[href^="'+id+'"]');
				$('body').addClass('snav_open');
				$target.stop(true).fadeIn(op.speed);
				$trigger.removeClass('on');
				$t_target.addClass('on');
			};
			// 閉じる
			var closeNav=function(){
				$('body').removeClass('snav_open');
				$target.stop(true).fadeOut(op.speed);
				$trigger.removeClass('on');
			};
			// ホバー後に写真切り替え
			var hoverPhoto=function($t_hover){
				var href=$t_hover.attr('href');
				var src=$t_hover.data('hover');
				$photo.find('a').attr('href',href).find('img').attr('src',src);
			};

			// #付きメニュー
			$trigger.each(function(){
				$(this).on({
					'mouseenter':function(){ id=$(this).attr('href'); id=(id)?id:$(this).attr('href'); openNav(); },
					'mouseleave':function(){ closeNav(); }
				});
			});

			// 全リンクメニュー
			$a.not($trigger).each(function(){ $(this).on('mouseenter',closeNav()); });

			// ターゲット
			$target.on({
				'mouseenter':function(){ openNav(); },
				'mouseleave':function(){ closeNav(); }
			});

			$hover.each(function(){
				$(this).on('mouseenter',function(){ hoverPhoto($(this)); });
			});

		},
		// ページトップ表示
		pageTop:function(options){
			var defaults={
				top:100,
				speed:200
			};
			var op=$.extend(defaults,options);
			var $t=$(this);
			var $foot=$('#foot_btm');
			var bool={
				scrolling:true
			};
			var set=function(){
				var st_h=GN.st()+GN.wh();
				if(st_h>$foot.offset().top){
					$t.show().css({ position:'absolute',bottom:($foot.innerHeight()+20)+'px' });
					bool.scrolling=true;
				}else if(GN.st()>=op.top&&bool.scrolling){
					bool.scrolling=false;
					$t.css({ position:'fixed',bottom:'20px' }).stop(false,false).fadeIn(op.speed);
				}else if(GN.st()<op.top&&!bool.scrolling){
					$t.stop(false,false).fadeOut(op.speed,function(){
						bool.scrolling=true;
					});
				};
			};
			set();
			$(window).on({
				'load scroll':function(){ set(); }
			});
		},
		// 商品一覧サイド絞り込み
		productSideSort:function(options){
			var defaults={
				speed:200
			};
			var op=$.extend(defaults,options);
			var $t=$(this);
			var $links=$t.find('.links');
			var $link=$links.find('li');
			var $color_links=$t.find('.color_links');
			var $color_link=$color_links.find('li');
			var $size_links=$t.find('.size_links');
			var $size_link=$size_links.find('li');
			var $release=$t.find('.release');
			var $rest_btn=$t.find('.rest_btn');
			var check='check';
			var linkChecked=function($trigger,$parent){
				if($trigger.hasClass(check)){
					$trigger.removeClass(check);
				}else{
					$parent.find('> li > .'+check).removeClass(check);
					$trigger.addClass(check);
				};
			};

			// 初期表示
			$links.each(function(){
				var $check=$(this).find('.'+check);
				if($check.length){
					$check.next('ul').show().next('.rest_btn').show();
					$check.closest('ul').show();
					$(this).show();
				};
			});

			// 残り表示
			$rest_btn.each(function(){
				var $btn=$(this);
				var $a=$btn.find('a');
				var $rest=$btn.next('.rest_child');
				$a.off('click');
				$a.on('click',function(){
					if($rest.is(':hidden')){
						$(this).addClass('on');
						$rest.slideDown(op.speed);
					}else{
						$(this).removeClass('on');
						$rest.slideUp(op.speed);
					};
					return false;
				});
			});

			// 通常リンク
			/*
			$link.each(function(){
				var $li=$(this);
				var $parent=$li.closest('ul')
				var $a=$li.find('> a');
				var $hash=$li.find('> a[href^="#"]');
				$hash.next('ul').show();
				$a.off('click');
				$a.on('click',function(){
					linkChecked($a,$parent);
					return false;
				});
			});
			*/

			// カラーリンク
			/*
			$color_link.each(function(){
				var $li=$(this);
				var $parent=$li.closest('ul')
				var $a=$li.find('> a');
				$a.off('click');
				$a.on('click',function(){
					linkChecked($a,$parent);
					return false;
				});
			});
			*/

			// サイズリンク
			/*
			$size_link.each(function(){
				var $li=$(this);
				var $parent=$li.closest('ul')
				var $a=$li.find('> a');
				$a.off('click');
				$a.on('click',function(){
					linkChecked($a,$parent);
					return false;
				});
			});
			*/

			// 選択解除
			/*
			$release.each(function(){
				var $p=$(this);
				var $a=$p.find('a');
				var $links=$p.next('.links');
				$a.off('click');
				$a.on('click',function(){
					$links.find('> li > .'+check).removeClass(check);
					return false;
				});
			});
			*/

		},
		// 商品詳細
		productDetail:function(options){
			var defaults={
				speed:200
			};
			var op=$.extend(defaults,options);
			var $t=$(this);
			var $cart=$t.find('.cart_');
			var $change=$t.find('.goodsimg_');

			// カートに入れる
			$cart.each(function(){
				var $input=$(this).find('input');
				var $add=$(this).find('.add_cart');
				var $close=$('<a class="close" href="#">CLOSE</a>');
				var closeBalloon=function(){
					$add.fadeOut(op.speed);
				};

				$add.append($close);

				$input.off('click');
				$input.on('click',function(){
					if($add.is(':hidden')){
						$cart.find('.add_cart').not($add).fadeOut(op.speed);
						$add.fadeIn(op.speed);
					}else{
						closeBalloon();
					};
					return false;
				});

				$close.off('click');
				$close.on('click',function(){
					closeBalloon();
					return false;
				});

				$add.find('.btn_shopping a').off('click');
				$add.find('.btn_shopping a').on('click',function(){
					closeBalloon();
					return false;
				});

				// 画面外をクリックで非表示
				$('body').on('click',function(){ closeBalloon(); });

				// パブリングを中止
				$add.on('click',function(e){ e.stopPropagation(); });

			});

			// 写真切り替え
			$change.find('.thumb li').each(function(){
				$(this).find('span').off('click');
				$(this).find('span').on('click',function(){
					var src=$(this).find('img').attr('src');
					if(!$(this).hasClass('on')){
						$change.find('.thumb li .on').removeClass('on')
						$(this).addClass('on')
						$change.find('.photo img').attr('src',src);
						/*
						$change.find('.photo .zoom').attr('href',src);
						$change.find('.photo').photoExpand({ src:$change.find('.zoom').attr('href') });
						*/
					};
					return false;
				});
			});

			/*
			$change.find('.zoom').off('click');
			$change.find('.zoom').on('click',function(){ return false; });
			*/
			$change.find('.photo').photoExpand({ src:$change.find('img').attr('src') });

		},
		// 写真拡大
		photoExpand:function(options){
			var defaults={
				normal:{
					w:600,
					h:400
				},
				mag:2,
				src:''
			};
			var op=$.extend(defaults,options);
			var $t=$(this);
			var $expand=$('<div class="expand" />');
			// 拡大率
			var large={
				w:op.normal.w*op.mag,
				h:op.normal.h*op.mag
			};
			var frame={
				w:large.w-op.normal.w,
				h:large.h-op.normal.h
			};
			
			// 初期設定
			$t.append($expand);

			var bool=false;
			var pos={
				top:function(){ var posTop=$t.offset().top; return Math.floor(posTop); },
				left:function(){ var posLeft=$t.offset().left; return Math.floor(posLeft); }
			};
			// 位置情報保存用変数
			var static_m={
				ex_top:0,
				ex_left:0
			};
			// 初期位置
			var startPos=function(target){
				$expand.fadeOut(200,function(){
					$(this).removeClass('start_expand');
					bool=false;
				});
			};
			// 拡大位置
			var expandPos=function(x,y){
				var point={
					y:(y-pos.top()),
					x:(x-pos.left())
				};

				// 拡大移動
				var ex_top=-(point.y*frame.h/op.normal.h);
				var ex_left=-(point.x*frame.w/op.normal.w);

				$expand.find('img').css({ position:'absolute',top:ex_top+'px',left:ex_left+'px' });

			};
			$expand.hide().append('<img src="'+op.src+'" />').find('img').width(large.w);
			$t.on({
				'mouseenter':function(e){ // 拡大開始
					if(!bool){
						$expand.fadeIn(200,function(){
							$(this).addClass('start_expand');
						});
						expandPos(e.pageX,e.pageY);
						bool=true;
					};
				},
				'mouseleave':function(e){ // 拡大終了
					if(bool) startPos(op.target);
				},
				'mousemove':function(e){ // 拡大移動
					if(bool) expandPos(e.pageX,e.pageY);
				}
			});
		}
	});

	$('a[href^="#"]').pageScroll();
	if($('.hv').length) $('.hv').each(function(){ $(this).hoverAction(); });
	if($('#header').length) $('#header').headerFixed();
	if($('#gnav').length) $('#gnav').subNavigation();
	if($('#pagetop').length) $('#pagetop').pageTop();
	if($('#side_sort_search').length) $('#side_sort_search').productSideSort();
	if($('#product_detail').length) $('#product_detail').productDetail();
	if($('.item_list1').length){
		$('.item_list1').each(function(){
			var line=$(this).data('item-line');
			if(line) $(this).itemTopSet({ line:line });
		});
	};
	if($('.login_col_section input[name="guest"]').length) $('.login_col_section input[name="guest"]').hoverAction();
	if($('div.cart_submit_ div.back_ a').length) $('div.cart_submit_ div.back_ a').hoverAction();

	$(window).on({
		'load':function(){
			// ハッシュタグがある場合
			if(location.hash){
				var Hash=$(location.hash);
				if($(Hash).length){
					var HashOffset=$(Hash).offset().top;
					HashOffset=(HashOffset===0)?0:HashOffset-GN.sthh;
					$('html,body').animate({ scrollTop:HashOffset+'px' },100);
				};
			};
		}
	});

});