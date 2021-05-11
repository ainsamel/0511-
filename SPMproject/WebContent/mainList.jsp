<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<c:if test="${empty name }">
		<c:redirect url="login.jsp" />
	</c:if>
<!-- mainList.jsp -->
	
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>메인 홈화면</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
</head>

<body>

	<div id="hd">
	<div class="allc_wrapper">
		<div class="all_category cle">
        	<div class="all_title">ALL CATEGORY<div class="xbtn"><a href="javascript:all_view();">
        		<img src="https://cdn-naning9.bizhost.kr/img2/xbtn.png" alt="ALL CATEGORY 닫기"></a>
        		</div>
        		</div>
                <ul class="category_cell">
                
            	<div class="title">
            	<a href="/shop/list.php?cate=11">카테고리</a>
            	</div>
            	            	
            	<li><a href="/shop/list.php?cate=1102">아우터</a></li>
            	<li><a href="/shop/list.php?cate=1105">탑</a></li>
                <li><a href="/shop/list.php?cate=1101">바텀</a></li>
                <li><a href="/shop/list.php?cate=1104">드레스</a></li>
                <li><a href="/shop/list.php?cate=1103">구두</a></li>	
            </ul>
        </div>
        
        
    </div>
    
	<div class="hd_top_menu">        		
		<div class="hd_top_right">
			<ul>				
				<li><a href="/order/cart.php">CART</a></li>
				<li>
					<a href="/mypage/main.php">MYPAGE</a>
				</li>
				<li>
				    <a href="/member/join.php">JOIN</a>
				    <div id="joinpoint" style="top: 42px;">
						<a href="/member/join.php">
						</a>
					</div>
				</li>

				<li>
				    <a href="#none" onclick="toggleLayer('loginBox');">LOGIN</a>
				    <div id="loginBox" style="display: none;">
						<div class="loginbox_bg" onclick="toggleLayer('loginBox');"></div>
						<span class="icon_arr">
							<img src="https://cdn-naning9.bizhost.kr/before_img/web/icon_focus.png" alt="">
						</span>
						<span class="btn_close" onclick="toggleLayer('loginBox');">X</span>
						<h2 style="text-align:left;">MEMBER LOGIN</h2>
						<form name="loginform_main" id="loginform_main" action="https://www.naning9.com/login/loginpro.php" method="post">
							<fieldset>
								<legend>member login</legend>
								<ul>
									<li>
										<label style="text-align:left;">ID</label>
										<input type="text" class="MS_login_id txt-frm" id="id_main" name="id" maxlength="20" value="" onkeypress="javascript:if(event.keyCode == 13) { check_log() }" default="">
									</li>
									<li>
										<label style="text-align:left;">PASSWORD</label>
										<input type="password" class="MS_login_pw txt-frm" id="passwd_main" name="passwd" maxlength="20" value="" onkeypress="javascript:if(event.keyCode == 13) { check_log() }">
										<input type="hidden" name="passwd_enc" value="">
									</li>
								</ul>
                                
								<a href="javascript:check_log();" class="btn_login" style="background:#3b3b3b!important">LOGIN</a>
								
								
                            </fieldset>
						</form>
						</form>
						</div>
					</div>
			    </li>
			</ul>
		</div>
    </div>
 

	
		
	</div>

	<div id="footer" class="card-body"></div>
</body>
</html>
