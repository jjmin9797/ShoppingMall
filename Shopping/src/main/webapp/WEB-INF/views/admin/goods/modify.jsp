<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Covid Mall</title>

<script src="/resources/jquery/jquery-3.3.1.min.js"></script>

<link rel="stylesheet" href="/resources/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="/resources/bootstrap/bootstrap-theme.min.css">
<script src="/resources/bootstrap/bootstrap.min.js"></script>

<style>
 body { font-family:'맑은 고딕', verdana; padding:0; margin:0; }
 ul { padding:0; margin:0; list-style:none;  }

 div#root { width:90%; margin:0 auto; }
 
 header#header { font-size:60px; padding:20px 0; }
 header#header h1 a { color:#000; font-weight:bold; }
 
 nav#nav { padding:10px; text-align:right; }
 nav#nav ul li { display:inline-block; margin-left:10px; }

   section#container { padding:20px 0; border-top:2px solid #eee; border-bottom:2px solid #eee; }
 section#container::after { content:""; display:block; clear:both; }
 aside { float:left; width:200px; }
 div#container_box { float:right; width:calc(100% - 200px - 20px); }
 
 aside ul li { text-align:center; margin-bottom:10px; }
 aside ul li a { display:block; width:100%; padding:10px 0;}
 aside ul li a:hover { background:#eee; }
 footer#footer { background:#f9f9f9; padding:20px; }
 footer#footer ul li { display:inline-block; margin-right:10px; }
</style>

<!-- 상품 등록 CSS -->
<style>
.inputArea { margin:10px 0; }
select { width:100px; }
label { display:inline-block; width:70px; padding:5px; }
label[for='gdsDes'] { display:block; }
input { width:150px; }
textarea#gdsDes { width:400px; height:180px; }
</style>


</head>
<body>
<div id="root">
   <header id="header">
      <div id="header_box">
         <%@ include file = "../include/header.jsp" %>
      </div>
   </header>
   
   <nav id="nav">
      <div id="nav_box">
         <%@ include file = "../include/nav.jsp" %>
      </div>
   </nav>
   
   
   
   <section id = "container">

      <aside>
         <%@ include file = "../include/aside.jsp" %>
      </aside>
      
      
      <div id="container_box">
         <h2>상품 수정</h2>
         
         <form role = "form" method="post" autocomplete="off">
         <input type="hidden" name="gdsNum" value="${goods.gdsNum}" />
         
         <div class = "inputArea">
            <label>1차 분류</label>
            <select class="category1">
               <option value = "">전체 </option>
            </select>
            
            <label>2차 분류</label>
            <select class = "category2" name = "cateCode">
               <option value="">전체 </option> 
            </select>
         </div>
         
         <div class = "inputArea">
            <label for = "gdsName">상품명</label>
            <input type="text" id = "gdsName" name = "gdsName" value="${goods.gdsName}"/>
         </div>
         
         <div class = "inputArea">
          <label for = "gdsPrice">상품가격</label>
          <input type="text" id = "gdsPrice" name = "gdsPrice" value="${goods.gdsPrice}"/>
         </div>
         
         <div class = "inputArea">
            <label for = "gdsStock">상품수량</label>
            <input type = "text" id = "gdsStock" name = "gdsStock" value="${goods.gdsStock}"/>
         </div>
         
         <div class = "inputArea">
            <label for = "gdsDes">상품소개</label>
            <textarea rows="5" cols="50" id = "gdsDes" name = "gdsDes">${goods.gdsDes}</textarea>
         </div>
         
         <div class = "inputArea">
            <button type = "submit" id = "register_btn" class = "btn btn-primary">완료</button>
            <button type = "submit" id = "register_btn" class = "btn btn-warning">취소</button>

						<script>
							$("#back_Btn").click(function() {
								//history.back();
								location.href = "/admin/goods/view?n=" + ${goods.gdsNum}; //브라우저 뒤로가기
							});
						</script>
					</div>
         </form>
      </div>
   </section>
   
   <footer id="footer">
      <div id="footer_box">
         <%@ include file = "../include/footer.jsp" %>
      </div>
   </footer>



</div>
<script>
var jsonData = JSON.parse('${category}');
console.log(jsonData);

var cate1Arr = new Array();
var cate1Obj = new Object();

for (var i = 0; i < jsonData.length; i++) {
   if (jsonData[i].level == "1") {
      cate1Obj = new Object();
      cate1Obj.cateCode = jsonData[i].cateCode;
      cate1Obj.cateName = jsonData[i].cateName;
      cate1Arr.push(cate1Obj);
   }
}

var cate1Select = $("select.category1")

for (var i = 0; i < cate1Arr.length; i++) {
   cate1Select.append("<option value='" + cate1Arr[i].cateCode + "'>" + cate1Arr[i].cateName + "</option>");
}

//클래스가 category1인 select변수의 값이 바뀌었을 때 실행
$(document).on("change", "select.category1", function(){

   
   // 필요한 배열과 오브젝트 변수를 생성
   var cate2Arr = new Array();
   var cate2Obj = new Object();
   
   // 2차 분류 셀렉트 박스에 삽입할 데이터 준비
   for(var i = 0; i < jsonData.length; i++) {
      
      if(jsonData[i].level == "2") {  // 레빌이 2인 데이터가 있다면
         cate2Obj = new Object();  // 초기화
         
         // cate2Obj에 cateCode, cateName, cateCodeRef를 저장
         cate2Obj.cateCode = jsonData[i].cateCode;
         cate2Obj.cateName = jsonData[i].cateName;
         cate2Obj.cateCodeRef = jsonData[i].cateCodeRef;
         
         // cate2Obj에 저장된 값을 cate1Arr 배열에 저장
         cate2Arr.push(cate2Obj);
      } 
   }
   
   var cate2Select = $("select.category2");
   
   /*
   for(var i = 0; i < cate2Arr.length; i++) {
         cate2Select.append("<option value='" + cate2Arr[i].cateCode + "'>"
                        + cate2Arr[i].cateName + "</option>");
   }
   */
   
   // cate2Select의 값을 제거함(초기화)
   cate2Select.children().remove();
 
   // cate1Select에서 선택한 값을 기준으로 cate2Select의 값을 조정
   $("option:selected", this).each(function(){
      
      var selectVal = $(this).val();  // 현재 선택한 cate1Select의 값을 저장
   
      cate2Select.append("<option value='" + selectVal + "'>전체</option>");  // cate2Select의 '전체'에 현재 선택한 cate1Select와 같은 값 부여
      
      // cate2Arr의 데이터를 cate2Select에 추가
      for(var i = 0; i < cate2Arr.length; i++) {
         
         // 현재 선택한 cate1Select의 값과 일치하는 cate2Arr의 데이터를 가져옴
         if(selectVal == cate2Arr[i].cateCodeRef) {
            cate2Select.append("<option value='" + cate2Arr[i].cateCode + "'>"
                           + cate2Arr[i].cateName + "</option>");
         }
      }      
   });
   
});

var select_cateCode = '${goods.cateCode}';
var select_cateCodeRef = '${goods.cateCodeRef}';
var select_cateName = '${goods.cateName}';
 
if(select_cateCodeRef != null && select_cateCodeRef != '') {
 $(".category1").val(select_cateCodeRef);
 $(".category2").val(select_cateCode); 
 $(".category2").children().remove();
 $(".category2").append("<option value='"
       + select_cateCode + "'>" + select_cateName + "</option>");
} else {
 $(".category1").val(select_cateCode);
 //$(".category2").val(select_cateCode);
 // select_cateCod가 부여되지 않는 현상이 있어서 아래 코드로 대체
 $(".category2").append("<option value="' + select_cateCode + '" selected='selected'>전체</option>");
}
</script>
</body>
</html>