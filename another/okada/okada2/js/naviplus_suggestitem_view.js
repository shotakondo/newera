function NPSuggest_createItemList(items,title,options,info){var max_item_count=items.length>5?5:items.length;var MAX_DATA_COLUMNS=250;if(typeof title=="undefined"||title==null){var header_title="Recommended Items"}else{var header_title=title}var tl=document.createElement("div");tl.appendChild(document.createTextNode(header_title));if(NPSuggest.Util.selectorExists("."+options.itemListClass+" .title")){tl.className="title"}else{tl.style.fontSize="small";tl.style.fontWeight="bold";tl.style.fontFamily="Arial, Helvetica, sans-serif"}var contents=document.createElement("div");contents.appendChild(tl);if(!NPSuggest.Util.selectorExists("."+options.itemListClass+" div")){contents.style.color="#000000";contents.style.textAlign="center";contents.style.width="auto";contents.style.height="auto"}var itemlist=document.createElement("table");if(!NPSuggest.Util.selectorExists("."+options.itemListClass+" table")){itemlist.style.textAlign="center";itemlist.style.width="100%";itemlist.style.height="auto";itemlist.style.margin="0px"}for(var i=0;i<max_item_count;i++){var tr=document.createElement("tr");if(!NPSuggest.Util.selectorExists("."+options.itemListClass+" table tr")){itemlist.style.verticalAlign="top"}var url=items[i].url;if(typeof options.recommendItemUrlPrefix!="undefined"&&options.recommendItemUrlPrefix!=null){url=options.recommendItemUrlPrefix+url}var item_title="";if(typeof items[i].title!="undefined"){item_title=items[i].title}var colspan=2;if(items[i].image!=""){var image=items[i].image;if(typeof options.recommendImageUrlPrefix!="undefined"&&options.recommendImageUrlPrefix!=null){image=options.recommendImageUrlPrefix+image}var img=document.createElement("td");var t=document.createElement("a");var imgEl=document.createElement("img");imgEl.src=image;imgEl.alt=item_title;t.href=url;if(NPSuggest.Util.selectorExists("."+options.itemListClass+" .title")){img.className="image"}else{img.style.height="50px";img.style.border="0";imgEl.style.height="50px"}t.appendChild(imgEl);img.appendChild(t);imgEl.onerror=function(){if(typeof options.recommendImageAlternative=="string"&&options.recommendImageAlternative.length>0){if(this.alt=="no image"){return}if(typeof options.recommendImageUrlPrefix!="undefined"&&options.recommendImageUrlPrefix!=null){this.src=options.recommendImageUrlPrefix+options.recommendImageAlternative}else{this.src=options.recommendImageAlternative}this.alt="no image"}else{this.alt="";var w=0;for(var n=this.parentNode.parentNode.parentNode.childNodes.length-1;n>=0;n--){w+=NPSuggest.Util.getCurrentWidth(this.parentNode.parentNode.parentNode.childNodes[n])}this.parentNode.parentNode.parentNode.childNodes[1].style.width=w+"px";this.parentNode.parentNode.parentNode.childNodes[1].colSpan=2;this.parentNode.parentNode.parentNode.childNodes[1].childNodes[0].style.width=w+"px";this.parentNode.parentNode.parentNode.removeChild(this.parentNode.parentNode)}};colspan=1;tr.appendChild(img)}var tmp_item=document.createElement("td");tmp_item.colSpan=colspan;if(NPSuggest.Util.selectorExists("."+options.itemListClass+" .item")){var t1=document.createElement("a");t1.href=url;var tmp_tl=item_title.slice(0,50);if(item_title.slice(50)!==""){tmp_tl+="..."}if(options.recommendItemHtmlEnabled==true||options.recommendItemHtmlEnabled=="on"){t1.innerHTML=tmp_tl}else{t1.appendChild(document.createTextNode(tmp_tl))}t1.className="item_title";var t2=document.createElement("a");t2.href=url;var tmp_ds="";if(typeof items[i]!="undefined"&&typeof items[i]["desc"]!="undefined"){tmp_ds=items[i]["desc"].slice(0,100);if(items[i]["desc"].slice(100)!==""){tmp_ds+="..."}}else{for(var j=1;j<=MAX_DATA_COLUMNS;j++){var k="data"+j.toString();if(typeof items[i]!="undefined"&&typeof items[i][k]!="undefined"){tmp_ds=items[i][k].slice(0,100);if(items[i][k].slice(100)!==""){tmp_ds+="..."}break}}}if(options.recommendItemHtmlEnabled==true||options.recommendItemHtmlEnabled=="on"){t2.innerHTML=tmp_ds}else{t2.appendChild(document.createTextNode(tmp_ds))}t2.className="item_desc";tmp_item.className="item";tmp_item.appendChild(t1);tmp_item.appendChild(t2)}else{var t1=document.createElement("a");t1.href=url;var tmp_tl=item_title.slice(0,8);if(item_title.slice(8,13)!==""){tmp_tl+="<br/>"+item_title.slice(8,14)}if(item_title.slice(14)!==""){tmp_tl+="..."}t1.innerHTML=tmp_tl;t1.style.fontSize="small";tmp_item.appendChild(t1)}tr.appendChild(tmp_item);itemlist.appendChild(tr)}contents.appendChild(itemlist);if(NPSuggest.Util.selectorExists("."+options.itemListClass+" .hitnum")){if(typeof info.hitnum!="undefined"&&info.hitnum>0){var hn=document.createElement("div");hn.className="hitnum";var tmp_hitnum=document.createTextNode(info.hitnum);hn.appendChild(tmp_hitnum);contents.appendChild(hn)}}return contents}function NPSuggest_createItemList_html(keyword,fieldName,html,options,request,column){NPSuggest.currentRequest=request;NPSuggest.currentColumn=column;var header_title;if(typeof options.recommendItemAreaTitle=="undefined"||options.recommendItemAreaTitle==null){header_title="Recommended Items"}else{header_title=options.recommendItemAreaTitle}var tl=document.createElement("div");tl.appendChild(document.createTextNode(header_title));tl.className="title";var contents=document.createElement("div");contents.appendChild(tl);var itemList=document.createElement("div");itemList.className="upper";contents.appendChild(itemList);var recommendList=document.createElement("div");NPSuggest.currentRecommendList=recommendList;recommendList.className="lower";var recommendListDisplay=recommendList.style.display;recommendList.style.display="none";contents.appendChild(recommendList);itemList.innerHTML=html;if(column==null||typeof column.recommendBase=="undefined"||column.recommendBase==""||column.recommendBase=="none"){recommendList.style.display="none";return contents}var top_itemid="";for(i=0;i<itemList.childNodes.length;i++){var node=itemList.childNodes[i];if(typeof node.id!="undefined"&&node.id=="__npsuggest_first_itemid"){top_itemid=node.innerHTML;break}}if(top_itemid==""){recommendList.style.display="none";recommendList.innerHTML=""}else{if(column.recommendBase=="textmining"||column.recommendBase=="hybrid"||column.recommendBase=="item"){NPSuggest_callLower(top_itemid,column)}else{if(typeof request.search.sources.recommend!="undefined"){var reco_server=request.search.sources.recommend.server;var account=request.search.sources.recommend.accountID;request.search.createRecommendItemList(reco_server,account,keyword,column,function(){NPSuggest_drawLower(request,recommendList,keyword,"recommend")})}}}return contents}function NPSuggest_callLower(keyword,arg2){var request=NPSuggest.currentRequest;var recommendList=NPSuggest.currentRecommendList;if(typeof request!="object"||typeof recommendList!="object"){return}var column;if(typeof arg2=="string"){column=request.search.columns[arg2]}else if(typeof arg2=="object"){column=arg2}if(column==null||typeof column=="undefined"){return}if(column.recommendBase=="textmining"){request.search.createSuggestItemList(keyword,"","","itemid_html",function(){NPSuggest_drawLower(request,recommendList,keyword,"itemid_html")},"lower")}else if(column.recommendBase!=""){var reco_server=request.search.sources.recommend.server;var account=request.search.sources.recommend.accountID;request.search.createRecommendItemList(reco_server,account,keyword,column,function(){NPSuggest_drawLower(request,recommendList,keyword,"recommend")})}}function NPSuggest_drawLower(request,recommendList,keyword,type){var html=request.search.getSuggestItemList(keyword,"",type,"html");if(typeof html=="string"&&html.length>0){recommendList.style.display="block";recommendList.innerHTML=html;var hitnum=0;for(i=0;i<recommendList.childNodes.length;i++){var node=recommendList.childNodes[i];if(typeof node.id!="undefined"&&node.id=="__npsuggest_hitnum"){hitnum=node.innerHTML;break}}if(hitnum<=0){recommendList.style.display="none";recommendList.innerHTML=""}}else{recommendList.style.display="none";recommendList.innerHTML=""}}
