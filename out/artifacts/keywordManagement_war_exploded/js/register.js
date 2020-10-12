/*$(document).ready(function () {
    $("tr:odd").attr("bgColor","#DD1C73");
    $("tr:even").attr("bgColor","#875BE6");
    //失去焦点事件
    $("#user").blur(checkUsername);
    $("#pwd").blur(checkPassword);
    $("#repwd").blur(rPassword);
    $("#email").blur(checkEmail);
    $("#mobile").blur(checktel);
    $("#birth").blur(checkbir);

    //提交事件
    $("#myform").submit(function () {

    });

});*/

$(function () {
    $.ajaxSetup({
        async: false
    });
    $("tr:odd").attr("bgColor","#DD1C73");
    $("tr:even").attr("bgColor","#875BE6");
    $("#name").blur(nn);
    $("#date").blur(dd);
    $("#add").submit(function () {
        var flag=true;
        alert(nn());
        alert(dd());

         if (!nn()){
             flag=false;
         }
        if (!dd()){
            flag=false;
        }
         return flag;
    });
});

function nn() {
    var flag=false;
    var keyname = $("#name").val();
   $.post("/keywordManagement/findAllServlet",{"comm":"nn","keyname":keyname},function (date) {
       var mname = $("#mname");
       if(date.keyExsit){
          //重复
          mname.css("color","black");
          mname.html(date.msg);
          flag=false;
      }else{
          //不重复
           mname.css("color","green");
           mname.html(date.msg);
           flag=true;
      }
   },"json");
   return flag;
}
//时间
function dd() {
    var name= $("#date").val();
    //正则表达式
    var reg=/^[1-9]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/;

    if(name==""||name==null){

        $("#mdate").html("时间不能为空！！");
        return false;
    }
    if(!reg.test(name)){
        $("#mdate").html("日期格式不正确，正确格式为：2014-01-01");
        return false;
    }
    $("#mdate").html("");
    return true;
}
