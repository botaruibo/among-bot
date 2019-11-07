var old_window_height = 0;
function setWind(){
  var win = $(window).height();
  console.log(Math.abs(old_window_height - win))
  if(Math.abs(old_window_height - win) < 20){
      console.log("canc")
      return;
    };
  old_window_height = win;
  var head = $('.head').height();
  var foot = $('.footer').height();
  $('.chat').animate({height:win-head-foot-10},"fast");
  var scrollHeight = $('.chat').prop("scrollHeight");
  $('.chat').animate({scrollTop:scrollHeight},"fast");

}
$('body').bind('ready',setWind);
//$('.chat').bind('DOMNodeInserted',setWind);
//主要解决微信内输入法上推窗口，导致窗口数据不对的问题
$(window).bind('resize',setWind);

function appendLocalMsg(msg) {  
  var mydate = new Date();
  var t = mydate.toLocaleString();
  $(".chat").append('<div class="row conv_right"><div class="col-md-4 col-6 conv bubble"><p>'+ msg + '<small class="time">' + t + '</small></p><span class="bot_right"></span><span class="top_right"></span></div><div class="col-md-1 col-2 head_img_div_right"><img class="head_img" src="img/user.png"></img></div></div>');
  $(".msg").val("");
  var scrollHeight = $('.chat').prop("scrollHeight"); 
//  $('.chat').scrollTop(scrollHeight+200);
 $('.chat').animate({scrollTop:scrollHeight+200},"slow");
}
function appendRemoteMsg(msg){
  var mydate = new Date();
  var t = mydate.toLocaleString();
  $(".chat").append('<div class="row conv_left"><div class="col-md-1 col-2 head_img_div_left"><img class="head_img" src="img/among-bot.png"></img> </div><div class="col-md-4 col-6 conv bubble"><p>'+ msg + '<small class="time">' + t + '</small></p><span class="bot_left"></span><span class="top_left"></span></div></div>');
  var scrollHeight = $('.chat').prop("scrollHeight"); 
 // $('.chat').scrollTop(scrollHeight+200);
  $('.chat').animate({scrollTop:scrollHeight+200},"slow");
}
function handleRequestMsg(msg){
  var req = {
      words: msg
  }
  console.log(req);
  $.ajax({
    //请求方式
    type : "POST",
    timeout: 1000,
     //请求的媒体类型
    contentType:"application/json;charset=UTF-8",
     //请求地址
     url : "api/chat",
     //数据，json字符串
      data: JSON.stringify(req),
     dataType : "json",
     success : function(data) {
      console.log(data);
	  appendRemoteMsg(data.words);
     },
     error : function(e){
      console.log(e.status);
      appendRemoteMsg("阿芒正在忙碌中，请稍后再联系.....")
     }
   });
}
function handleInput() {
    $('#msg').focus();
  var msg = $(".msg").val();
  if(msg.trim().length == 0) {
    return;
  }; 
  appendLocalMsg(msg);
  setWind();
  handleRequestMsg(msg);
}
$("#send_msg").on("click", handleInput);
$('#msg').bind('keypress',function(event){
   if(event.keyCode == "13"){
     handleInput();
   }
 });