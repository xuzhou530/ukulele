/**
 * @license Copyright (c) 2003-2015, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
    // Define changes to default configuration here. For example:
    // config.language = 'fr';
    config.uiColor = '#f1f1f1';
    /*����fullbar����*/
    config.toolbar = 'Full';
    config.toolbar_Full = [
        //['Source','-','NewPage','Preview','-','Templates'],
        //['Undo','Redo','-','Find','Replace','-','SelectAll','RemoveFormat'],
        //['Bold','Italic','Underline','-','Subscript','Superscript'],
       // '/',
        //['NumberedList','BulletedList','-','Outdent','Indent','Blockquote'],
        //['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock'],
       // ['Link','Unlink','Anchor'],
        ['Smiley','HorizontalRule','Image','Table','SpecialChar','PageBreak'],
        ['Cut','-','Copy','Paste','PasteText','-', 'SpellChecker'],
        ['Styles','Format','Font'/*,'FontSize'*/],
        ['TextColor','BGColor'],
        //ȫ��           ��ʾ���
        ['Maximize', 'ShowBlocks','-']
    ];
    //�Ƿ���ѡ����ɫʱ��ʾ��������ɫ��ѡ�� plugins/colorbutton/plugin.js
    config.colorButton_enableMore = false;
    config.height=100;
    //���ÿ�ݼ�
    config.keystrokes = [
        [ CKEDITOR.ALT + 121 /*F10*/, 'toolbarFocus' ],  //��ȡ����
        [ CKEDITOR.ALT + 122 /*F11*/, 'elementsPathFocus' ],  //Ԫ�ؽ���
        [ CKEDITOR.SHIFT + 121 /*F10*/, 'contextMenu' ],  //�ı��˵�
        [ CKEDITOR.CTRL + 90 /*Z*/, 'undo' ],  //����
        [ CKEDITOR.CTRL + 89 /*Y*/, 'redo' ],  //����
        [ CKEDITOR.CTRL + CKEDITOR.SHIFT + 90 /*Z*/, 'redo' ],  //
        [ CKEDITOR.CTRL + 76 /*L*/, 'link' ],  //����
        [ CKEDITOR.CTRL + 66 /*B*/, 'bold' ],  //����
        [ CKEDITOR.CTRL + 73 /*I*/, 'italic' ],  //б��
        [ CKEDITOR.CTRL + 85 /*U*/, 'underline' ],  //�»���
        [ CKEDITOR.ALT + 109 /*-*/, 'toolbarCollapse' ]
    ];
//����ʱ���Ƿ���ʾ����ı߿� plugins/showblocks/plugin.js
    config.startupOutlineBlocks = false;

    //������������ȥ�� ���·�����һ���̶��ߵ�״̬�� ʹ���Ϊһ��ֱ��
    //ȥ�����·�״̬��
    config.removePlugins = 'elementspath';
    //ȥ���С��ק�ı书��
    config.resize_enabled = false;
    //ʹ������ʱ�ĸ���ɫ plugins/find/plugin.js
    config.find_highlight = {
        element : 'span',
        styles : { 'background-color' : '#ff0', 'color' : '#00f' }
    };

    //�����ͼƬ���Կ��е���������ʱ �Ƿ�ͬʱ������ߵ�<a>��ǩ plugins/image/plugin.js
    config.image_removeLinkByEmptyURL = true;

    //��Ӧ�ı���ͼƬ plugins/smiley/plugin.js
   /* config.smiley_images = [
        'regular_smile.gif','sad_smile.gif','wink_smile.gif','teeth_smile.gif','confused_smile.gif','tounge_smile.gif',
        'embaressed_smile.gif','omg_smile.gif','whatchutalkingabout_smile.gif','angry_smile.gif','angel_smile.gif','shades_smile.gif',
        'devil_smile.gif','cry_smile.gif','lightbulb.gif','thumbs_down.gif','thumbs_up.gif','heart.gif',
        'broken_heart.gif','kiss.gif','envelope.gif'];*/
    //����ĵ�ַ plugins/smiley/plugin.js
    /*config.smiley_path = 'plugins/smiley/images/';*/

};
