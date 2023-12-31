//管理者用フォームと一般ユーザーフォームの出しわけ
let userForms = document.getElementsByClassName("userOnly");
let formCount = userForms.length;

function authorityChange(){
  for (let i = 0; i < formCount; i++) {
    userForms[i].classList.toggle("hidden");
  }
};