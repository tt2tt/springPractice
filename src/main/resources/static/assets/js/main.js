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