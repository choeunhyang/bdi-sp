<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>스프링테스트</title>
	<style>
		table{border-collapse:collapse; width:700px; align:center;}
		table *{text-align:center;}
		td,th{padding:5px;}
		button{width:100px; height:25px;}
	</style>
</head>
<script>
	/* window.onload = function(){
		alert(document.querySelector('#jpBody'));
	}; */
	window.addEventListener('load',function(){
		var xhr = new XMLHttpRequest();
		xhr.open('GET','/japan');
		xhr.onreadystatechange = function(){
			if(xhr.readyState==4){
				if(xhr.status==200){
					var res = JSON.parse(xhr.responseText);
					var html = '';
					for(var j of res){
						/* var j = res[idx]; 
						console.log(j);*/
						html += '<tr>';
						html += '<td>' + j.jpnum + '</td>';
						html += '<td><input type="text" name="jpname' + j.jpnum + '" value="' + j.jpname + '"></td>';
						html += '<td><input type="text" name="jpdesc' + j.jpnum + '" value="' + j.jpdesc + '"></td>';
						html += '<td><button onclick="japanUpdate('+j.jpnum+')">수정</button>';
						html += ' <button onclick="japanDelete('+j.jpnum+')">삭제</button></td>';
						html += '</tr>';
					}
					document.querySelector("#jpBody").insertAdjacentHTML('beforeend',html);
				}else{
					
				}
			}
		}
		xhr.send();
		//alert(document.querySelector('#jpBody'));
	});
	/* window.addEventListener('load',function(){
		alert('내 가 만 든  온 로 드');
	}); */
</script>
<body>
<div id="body">
<table border="1">
	<thead>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>설명</th>
			<th>수정 / 삭제</th>
		</tr>
	</thead>
	<%--<tbody><%-- 
	<c:if test="${empty jList}">
		<tr>
			<td colspan="4">리스트가 없습니다.</td>
	</tr>
	</c:if> --%>
	<%--<c:forEach items="${jList}" var="j">
		<tr>
			<td>${j.jpnum}</td>
			<td><input type="text" name="jpname${j.jpnum}" value="${j.jpname}"></td>
			<td><input type="text" name="jpdesc${j.jpnum}" value="${j.jpdesc}"></td>
			<td><button onclick="japanUpdate(${j.jpnum})">수정</button> <button onclick="japanDelete(${j.jpnum})">삭제</button></td>
		</tr>
	</c:forEach> 
	<!-- 이사이에  insertAdjacentHTML 로 만든 tr부터 차례로 들어간다-->
	</tbody>--%>
	<tbody id="jpBody">
	
	</tbody>
</table>
<button onclick="japanAdd()">재팬추가</button>
</div>
</body>
<script>
	/* alert(document.querySelector('#jpBody')); */
	function japanUpdate(jpnum){
		var jpname = document.querySelector('input[name=jpname' + jpnum + ']').value;
		var jpdesc = document.querySelector('input[name=jpdesc' + jpnum + ']').value;
		// alert("수정 : " + jpnum + jpname + jpdesc);
		var param = {jpnum:jpnum,jpname:jpname,jpdesc:jpdesc};
		var xhr = new XMLHttpRequest();
		var url = "/japan";
		xhr.open('PUT', url);
		xhr.setRequestHeader('Content-Type','application/json;charset=urf-8');
		xhr.onreadystatechange = function(){
			if(xhr.readyState==4){
				if(xhr.status=200){
					if(xhr.responseText=='1'){
						alert('수정성공!');
						location.href='/uri/japan/list';
					}
				}else{
					alert('수정실패');
				}
			}
		}
		//alert(JSON.stringify(param));
		xhr.send(JSON.stringify(param));
	}
	function japanDelete(jpnum){
		var xhr = new XMLHttpRequest();
		var url = "/japan/" + jpnum;
		xhr.open('DELETE', url);
		xhr.onreadystatechange = function(){
			if(xhr.readyState==4){
				if(xhr.status=200){
					if(xhr.responseText=='1'){
						alert('삭제성공!');
						location.href='/uri/japan/list';
					}
				}else{
					alert('삭제실패');
				}
			}
		}
		xhr.send();
	}
	function japanAdd(jpnum){
		var html = '<tr>';
		html += '<td>&nbsp;</td>';
		html += '<td><input type="text" name="jpname"></td>';
		html += '<td><input type="text" name="jpdesc"></td>';
		html += '<td><button onclick="japanInsert()">저장</button></td>';
		html += '</tr>';
		document.querySelector("tbody").insertAdjacentHTML('beforeend',html);
	}
	function japanInsert(){
		var jpname = document.querySelector('input[name=jpname]').value;
		var jpdesc = document.querySelector('input[name=jpdesc]').value;
		// alert("수정 : " + jpnum + jpname + jpdesc);
		var param = {jpname:jpname,jpdesc:jpdesc};
		var xhr = new XMLHttpRequest();
		var url = "/japan";
		xhr.open('POST', url);
		xhr.setRequestHeader('Content-Type','application/json');
		xhr.onreadystatechange = function(){
			if(xhr.readyState==4){
				if(xhr.status=200){
					if(xhr.responseText=='1'){
						alert('저장성공!');
						location.href='/uri/japan/list';
					}
				}else{
					alert('저장실패');
				}
			}
		}
		xhr.send(JSON.stringify(param));
	}
</script>
</html>	