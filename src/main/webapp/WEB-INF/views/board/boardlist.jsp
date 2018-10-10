<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>스프링테스트</title>
	<style>
		table{border-collapse:collapse;}
		table *{text-align:center;}
		td,th{padding:5px;}
		button{width:100px; height:25px;}
	</style>
</head>
<script>
window.addEventlistener('load',function(){
	var xhr = new XMLHttpRequest();
	xhr.open('GET','/board');
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4){
			if(xhr.status==200){
				var res = JSON.parse(xhr.responseText);
				var html = '';
				for(var bi of res){
					html += '<tr>';
					html += '<td>' + bi.binum+'</td>';
					html += '<td><input type="text" name="bititle'+bi.binum+'" value="'+ bi.bititle + '"></td>';
					html += '<td><input type="text" name="bitext'+bi.binum+'" value="'+ bi.bitext + '"></td>';
					html += '<td><input type="file" name="bifile" value="'+bi.bifile+'"</td>';
					html += '<td>'+bi.bicredate+'</td>';
					html += '<td>'+bi.bimoddat+'</td>';
					html += '<td>'+bi.bicnt+'</td>';
					html += '<td>'+bi.biactive+'</td>';
					html += '<button>수정</button><button>삭제</button>';
					html += '</tr>';
				}
				document.querySelctor("#biBody").insertAdjacentHTML('beforeend',html);
			}else{}
		}
	}
	xhr.send();
});
</script>
<body>
<table border="1" align="center">
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>파일</th>
			<th>만든날짜</th>
			<th>등록날짜</th>
			<th>조회수</th>
			<th>삭제여부</th>
			<th>게시자</th>
			<th>수정 / 삭제</th>
		</tr>
	</thead>
</table>
<button>추가</button>
<tbody id="biBody">

</tbody>
</body>
<script>
function add(){
	
}
</script>
</html>