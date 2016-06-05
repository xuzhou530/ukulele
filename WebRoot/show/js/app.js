+function($){
	
	
	var ShowPopover = function(element,option){
   	 this.$element = $(element);
   	 this.elemtn = element;
   	 this.option =  $.extend({},ShowPopover.DEFAULT,option);
   	 this.show();
    };
    
    ShowPopover.DEFAULT={
  		"content":"",
		"placement":"top",
  	 };
    
    
    ShowPopover.prototype.show=function(){
   	 this.$element.popover(this.option);
   	 this.$element.popover("show");
   	 var that = this;
   	 setTimeout(function(){
   		 that.$element.popover("hide");
   		 that.$element.popover("destroy"); 
   	 }, 1400);
    };
    
    var Plugin = function(option){
   	 this.each(function(){
   		 if( typeof option==  "string"){
   			 new ShowPopover(this,{content:option});
   		 }else{
   			 new ShowPopover(this,option);
   		 };
   	 });
    };
    
    $.fn.showPopover = Plugin;
    
    $.fn.showPopover.Constructor = ShowPopover;
    
    var odd = $.fn.showPopover;
    
    $.fn.showPopover.noConflict=function(){
    	
    	return odd;
    	
    };
    
}(jQuery)


var BufferString = function(){
	this.array=[];
};
BufferString.prototype.append = function(str){
	this.array.push(str);
	return this;
};
BufferString.prototype.toString=function(){
	return this.array.join("");
};

var dateConverter=function(date){
	
	var a = new Date(date.replace("T", " ").replace("-","/"));
	
	a = isNaN(a.getDay())? new Date(date):a;
	
	var current = new Date();
	var times = current.getTime()-a.getTime();
	var hours = times / 1000 / 3600;                //相差小时数
    if( hours<1 ){
   	 var mins = times / 1000 / 60; //相差分钟数
   	 return Math.floor(mins)+"分钟前";
   }
    if( hours<24 )
	{
    	return Math.floor(hours)+"小时前";
	}
    
    return isNaN(a)?date:a.toLocaleDateString();
}
