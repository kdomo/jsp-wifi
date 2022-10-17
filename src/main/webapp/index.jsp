<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>JSP - Hello World</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <style>
        #wifi-table{
            width: 100%;
        }
    </style>
</head>
<body>
<h1 class="align-items-center center">와이파이 정보 구하기</h1>
<a>홈</a> | <a>위치 히스토리 목록</a> | <a href="./wifi/test">Open API 와이파이 정보 가져오기</a>
<form method="get">
    LAT :<input type="text" value="0.0">, LNT :<input type="text" value="0.0">
    <button type="button" class="btn btn-primary">내 위치 가져오기</button>
    <button type="button" class="btn btn-primary">근처 WIFI 정보 가져오기</button>
</form>
<table id="wifi-table" class="table-success">
    <thead>
        <th>
            <td>거리(Km)</td>
            <td>관리번호</td>
            <td>자치구</td>
            <td>와이파이명</td>
            <td>도로명주소</td>
            <td>상세주소</td>
            <td>설치위치(층)</td>
            <td>설치유형</td>
            <td>설치기관</td>
            <td>서비스구분</td>
            <td>망종류</td>
            <td>설치년도</td>
            <td>실내외구분</td>
            <td>WIFI접속환경</td>
            <td>X좌표</td>
            <td>Y좌표</td>
            <td>작업일자</td>
        </th>
    </thead>
    <tbody id="wifi-body">
        <tr>
        </tr>
    </tbody>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js"
        integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk"
        crossorigin="anonymous"></script>
</body>
</html>