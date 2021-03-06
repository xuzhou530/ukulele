var $data_bind = $('[data-bind="share"]');
var sHtml='<ul class="share-wrapper clearfix">'
    +'<li class="icn fl"><a href="#" class="share01" ></a> </li>'
    +'<li class="icn fl"><a href="#" class="share02" ></a> </li>'
    +'<li class="icn fl"><a href="#" class="share03" ></a> </li>'
    +'<li class="icn fl"><a href="#" class="share04" ></a> </li>'
    +'<li class="icn fl"><a href="#" class="share05" ></a> </li>'
    +'<li class="icn fl"><a href="#" class="share06" ></a> </li>'
    +'<li class="icn fl"><a href="#" class="share07" ></a> </li>'
    +'</ul>';
$data_bind.wrap("<div class='shareIMG' style=''></div>");

$(sHtml).appendTo($data_bind.parent())
    .wrap("<div class='commonsahre' style=''  ></div>");


$(".shareIMG").each(function(){
    var sTitle = $(this).find('[data-bind="share"]').attr("data-title");
    var sPic = $(this).find('[data-bind="share"]').attr("data-pic")||$(this).attr("src");
    var _source,_sourceUrl,_pic,_showcount,_desc,_summary,_site,
        _title = sTitle,
        _width = 600,
        _height = 600,
        _top = (screen.height-_height)/2,
        _left = (screen.width-_width)/2,
        _url,
        _pic = sPic ;
    $(this).on("click",".share01",shareToSinaWB);
    $(this).on("click",".share02",shareToQzone);
    $(this).on("click",".share03",shareToTieba);
    $(this).on("click",".share04",shareToDouban);
    $(this).on("click",".share05",shareToQQwb);
    $(this).on("click",".share06",shareToRenren);
    $(this).on("click",".share07",shareToKaixin);
//分享到新浪微博
    function shareToSinaWB(event){

        event.preventDefault();

        var _shareUrl = 'http://v.t.sina.com.cn/share/share.php?&appkey=895033136';     //真实的appkey，必选参数
        _shareUrl += '&url='+ encodeURIComponent(_url||document.location);     //参数url设置分享的内容链接|默认当前页location，可选参数
        _shareUrl += '&title=' + encodeURIComponent(_title||document.title);    //参数title设置分享的标题|默认当前页标题，可选参数
        _shareUrl += '&source=' + encodeURIComponent(_source||'');
        _shareUrl += '&sourceUrl=' + encodeURIComponent(_sourceUrl||'');
        _shareUrl += '&content=' + 'utf-8';   //参数content设置页面编码gb2312|utf-8，可选参数
        _shareUrl += '&pic=' + encodeURIComponent(_pic||'');  //参数pic设置图片链接|默认为空，可选参数
        window.open(_shareUrl,'_blank','width='+_width+',height='+_height+',top='+_top+',left='+_left+',toolbar=no,menubar=no,scrollbars=no, resizable=1,location=no,status=0');
    }

    //分享到QQ空间
    function shareToQzone(event){
        event.preventDefault();

        var _shareUrl = 'http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?';
        _shareUrl += 'url=' + encodeURIComponent(_url||document.location);   //参数url设置分享的内容链接|默认当前页location
        _shareUrl += '&showcount=' + _showcount||0;      //参数showcount是否显示分享总数,显示：'1'，不显示：'0'，默认不显示
        _shareUrl += '&desc=' + encodeURIComponent(_desc||'分享的描述');    //参数desc设置分享的描述，可选参数
        _shareUrl += '&summary=' + encodeURIComponent(_summary||'分享摘要');    //参数summary设置分享摘要，可选参数
        _shareUrl += '&title=' + encodeURIComponent(_title||document.title);    //参数title设置分享标题，可选参数
        _shareUrl += '&site=' + encodeURIComponent(_site||'');   //参数site设置分享来源，可选参数
        _shareUrl += '&pics=' + encodeURIComponent(_pic||'');   //参数pics设置分享图片的路径，多张图片以＂|＂隔开，可选参数
        window.open(_shareUrl,'_blank','width='+_width+',height='+_height+',top='+_top+',left='+_left+',toolbar=no,menubar=no,scrollbars=no,resizable=1,location=no,status=0');
    }

    //分享到百度贴吧
    function shareToTieba(event){
        event.preventDefault();

        var _shareUrl = 'http://tieba.baidu.com/f/commit/share/openShareApi?';
        _shareUrl += 'title=' + encodeURIComponent(_title||document.title);  //分享的标题
        _shareUrl += '&url=' + encodeURIComponent(_url||document.location);  //分享的链接
        _shareUrl += '&pic=' + encodeURIComponent(_pic||'');    //分享的图片
        window.open(_shareUrl,'_blank','width='+_width+',height='+_height+',left='+_left+',top='+_top+',toolbar=no,menubar=no,scrollbars=no,resizable=1,location=no,status=0');
    }

    //分享到豆瓣
    function shareToDouban(event){
        event.preventDefault();

        var _shareUrl = 'http://shuo.douban.com/!service/share?';
        _shareUrl += 'href=' + encodeURIComponent(_url||location.href);    //分享的链接
        _shareUrl += '&name=' + encodeURIComponent(_title||document.title);    //分享的标题
        _shareUrl += '&image=' + encodeURIComponent(_pic||'');    //分享的图片
        window.open(_shareUrl,'_blank','width='+_width+',height='+_height+',left='+_left+',top='+_top+',toolbar=no,menubar=no,scrollbars=no,resizable=1,location=no,status=0');
    }

    //分享到腾迅微博
    function shareToQQwb(event){
        event.preventDefault();

        var _shareUrl = 'http://v.t.qq.com/share/share.php?';
        _shareUrl += 'title=' + encodeURIComponent(_title||document.title);    //分享的标题
        _shareUrl += '&url=' + encodeURIComponent(_url||location.href);    //分享的链接
        _shareUrl += '&appkey=5bd32d6f1dff4725ba40338b233ff155';    //在腾迅微博平台创建应用获取微博AppKey
        _shareUrl += '&site=' + encodeURIComponent(_site||'');   //分享来源
        _shareUrl += '&pic=' + encodeURIComponent(_pic||'');    //分享的图片，如果是多张图片，则定义var _pic='图片url1|图片url2|图片url3....'
        window.open(_shareUrl,'_blank','width='+_width+',height='+_height+',left='+_left+',top='+_top+',toolbar=no,menubar=no,scrollbars=no,resizable=1,location=no,status=0');
    }

//分享到人人网
    function shareToRenren(event){
        event.preventDefault();

        var _shareUrl = 'http://share.renren.com/share/buttonshare.do?';
        _shareUrl += 'link=' + encodeURIComponent(_url||location.href);   //分享的链接
        _shareUrl += '&title=' + encodeURIComponent(_title||document.title);     //分享的标题
        window.open(_shareUrl,'_blank','width='+_width+',height='+_height+',left='+_left+',top='+_top+',toolbar=no,menubar=no,scrollbars=no,resizable=1,location=no,status=0');
    }

//分享到开心网
    function shareToKaixin(event){
        event.preventDefault();

        var _shareUrl = 'http://www.kaixin001.com/rest/records.php?';
        _shareUrl += 'url=' + encodeURIComponent(_url||location.href);    //分享的链接
        _shareUrl += '&content=' + encodeURIComponent('分享的文字');    //需要分享的文字，当文字为空时，自动抓取分享网址的title
        _shareUrl += '&pic=' + encodeURIComponent(_pic||'');     //分享的图片,多个使用半角逗号分隔
        _shareUrl += '&showcount=0';    //是否显示分享数，显示：'1'，不显示：'0'
        _shareUrl += '&style=11';      //显示的样式，必选参数
        _shareUrl += '&aid=' + encodeURIComponent(_site||'');    //显示分享来源
        window.open(_shareUrl,'_blank','width='+_width+',height='+_height+',left='+_left+',top='+_top+',toolbar=no,menubar=no,scrollbars=no,resizable=1,location=no,status=0');
    }

    function shareToKaixin2(event){
        event.preventDefault();

        var _shareUrl = 'http://www.kaixin001.com/repaste/share.php?';
        _shareUrl += 'rtitle=' + encodeURIComponent(_title||document.title);   //分享的标题
        window.open(_shareUrl,'_blank','width='+_width+',height='+_height+',left='+_left+',top='+_top+',toolbar=no,menubar=no,scrollbars=no,resizable=1,location=no,status=0');
    }

//分享到facebook
    function shareToFacebook(event){
        event.preventDefault();

        var _shareUrl = 'http://www.facebook.com/sharer/sharer.php?';
        _shareUrl += 'u=' + encodeURIComponent(_url||location.href);    //分享的链接
        _shareUrl += '&t=' + encodeURIComponent(_title||document.title);    //分享的标题
        window.open(_shareUrl,'_blank','width='+_width+',height='+_height+',left='+_left+',top='+_top+',toolbar=no,menubar=no,scrollbars=no,resizable=1,location=no,status=0');
    }


//分享到Twitter
    function shareToTwitter(event){
        event.preventDefault();

        var _shareUrl = 'http://twitter.com/intent/tweet?';
        _shareUrl += 'url=' + encodeURIComponent(_url||location.href);    //分享的链接
        _shareUrl += '&text=' + encodeURIComponent(_title||document.title);    //分享的标题
        window.open(_shareUrl,'_blank','width='+_width+',height='+_height+',left='+_left+',top='+_top+',toolbar=no,menubar=no,scrollbars=no,resizable=1,location=no,status=0');
    }
});