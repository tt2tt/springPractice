//管理者用フォームと一般ユーザーフォームの出しわけ
let userForms = document.getElementsByClassName("userOnly");
let adminAuthority = document.getElementById("authority1");
let userAuthority = document.getElementById("authority2");

if(userAuthority){
  if(userAuthority.checked){
    for(let userForm of userForms){
      userForm.classList.replace("hidden","display");
    }
  }
}

function authorityChange(){
  adminAuthority = document.getElementById("authority1");
  userAuthority = document.getElementById("authority2");
  if(userAuthority.checked && userForms[0].classList.contains( "hidden" )){
      for(let userForm of userForms){
        userForm.classList.replace("hidden","display");
      }
  }else if(adminAuthority.checked && userForms[0].classList.contains( "display" )){
      for(let userForm of userForms){
        userForm.classList.replace("display","hidden");
      }
  }
}

//表示文字数制限
let limits = document.getElementsByClassName("limit");
let len = 10;

for(let limit of limits){
  let str = limit.textContent;
  if (str.length > len) {
    limit.textContent = str.substring(0, len) + "…";
  }
}

//いいね処理
$(".good").click(function() {
  var token = $("meta[name='_csrf']").attr("content");
  var header = $("meta[name='_csrf_header']").attr("content");
  $(document).ajaxSend(function(e, xhr, options){
    xhr.setRequestHeader(header, token);
  });

  var id = $(this).attr("id");
  var target = "form" + id;
  var user = $("#" + "name" + id);
  var form = $("#" + target).serialize();

  if(user.val() == ""){
    location = "/login";
  };

  $.ajax({
    url: "goodCreate",
    type: "POST",
    data: form
  }).done(function(data){
    var nextCount = $("#" + "goodsCount" + id).text();
    $("#" + "goodsCount" + id).text(Number(nextCount) + 1);
  }).fail(function(XMLHttpRequest, textStatus, errorThrown) {
  })
});
