<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>JSP - Hello World</title>

</head>
<body>
    <h1><%= request.getAttribute("saveCount") %>개의 WIFI 정보를 정상적으로 저장하였습니다.</h1>
<a href="/">홈으로가기</a>
</body>
</html>