/**
 * @license Copyright (c) 2003-2015, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
    // Define changes to default configuration here. For example:
    // config.language = 'fr';
    config.uiColor = '#f1f1f1';
    /*配置fullbar内容*/
    config.toolbar = 'Full';
    config.toolbar_Full = [
        //['Source','-','NewPage','Preview','-','Templates'],
       // ['Undo','Redo','-','Find','Replace','-','SelectAll','RemoveFormat'],
      //  ['Bold','Italic','Underline','-','Subscript','Superscript'],
       // '/',


       // ['Link','Unlink','Anchor'],
        ['Smiley','HorizontalRule','Image'/*,'Flash'*/,'Table','SpecialChar'/*,'PageBreak'*/],
       // ['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock'],
        ['-','Outdent','Indent'],
        ['Cut','-','Copy','Paste','PasteText','-', 'SpellChecker'],
        ['Styles','Format','Font'/*,'FontSize'*/],
       // ['TextColor','BGColor'],
        //全屏           显示区块
        ['Maximize'/*, 'ShowBlocks'*/,'-']
    ];
    //是否在选择颜色时显示“其它颜色”选项 plugins/colorbutton/plugin.js
    config.colorButton_enableMore = false;
    config.height=100;
    //设置快捷键
    config.keystrokes = [
        [ CKEDITOR.ALT + 121 /*F10*/, 'toolbarFocus' ],  //获取焦点
        [ CKEDITOR.ALT + 122 /*F11*/, 'elementsPathFocus' ],  //元素焦点
        [ CKEDITOR.SHIFT + 121 /*F10*/, 'contextMenu' ],  //文本菜单
        [ CKEDITOR.CTRL + 90 /*Z*/, 'undo' ],  //撤销
        [ CKEDITOR.CTRL + 89 /*Y*/, 'redo' ],  //重做
        [ CKEDITOR.CTRL + CKEDITOR.SHIFT + 90 /*Z*/, 'redo' ],  //
        [ CKEDITOR.CTRL + 76 /*L*/, 'link' ],  //链接
        [ CKEDITOR.CTRL + 66 /*B*/, 'bold' ],  //粗体
        [ CKEDITOR.CTRL + 73 /*I*/, 'italic' ],  //斜体
        [ CKEDITOR.CTRL + 85 /*U*/, 'underline' ],  //下划线
        [ CKEDITOR.ALT + 109 /*-*/, 'toolbarCollapse' ]
    ];
//载入时，是否显示框体的边框 plugins/showblocks/plugin.js
    config.startupOutlineBlocks = false;

    //以下两部可以去除 最下方的有一个固定高的状态栏 使其变为一条直线
    //去除最下方状态栏
    config.removePlugins = 'elementspath';
    //去除大小拖拽改变功能
    config.resize_enabled = false;
    //使用搜索时的高亮色 plugins/find/plugin.js
    config.find_highlight = {
        element : 'span',
        styles : { 'background-color' : '#ff0', 'color' : '#00f' }
    };

    //在清除图片属性框中的链接属性时 是否同时清除两边的<a>标签 plugins/image/plugin.js
    config.image_removeLinkByEmptyURL = true;

    //对应的表情图片 plugins/smiley/plugin.js
   /* config.smiley_images = [
        'regular_smile.gif','sad_smile.gif','wink_smile.gif','teeth_smile.gif','confused_smile.gif','tounge_smile.gif',
        'embaressed_smile.gif','omg_smile.gif','whatchutalkingabout_smile.gif','angry_smile.gif','angel_smile.gif','shades_smile.gif',
        'devil_smile.gif','cry_smile.gif','lightbulb.gif','thumbs_down.gif','thumbs_up.gif','heart.gif',
        'broken_heart.gif','kiss.gif','envelope.gif'];*/
    //表情的地址 plugins/smiley/plugin.js
    /*config.smiley_path = 'plugins/smiley/images/';*/

};
