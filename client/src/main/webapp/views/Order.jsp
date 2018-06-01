<%@page import="Hotel.entity.Room" %>
<%@page import="java.util.List" %>
<%@ include file="/jspf/page.jspf" %>
<%@ include file="/jspf/taglib.jspf" %>
<html lang="ru">
<%@ include file="/jspf/head.jspf" %>
<body>
<%@ include file="/jspf/header.jspf" %>
<div class="container catalog_p">
    <div class="row">
        <p class="welcome"><span class="H_W">Y</span>our order</p>
    </div>
</div>
<form action="" method="">
    <div class="container">
        <div class="row">
            <table border="1" class="table_catalog">
                <tr>
                    <th style="width: 20%">USER NAME</th>
                    <th style="width: 20%">NUMBER</th>
                    <th style="width: 20%">DATA START</th>
                    <th style="width: 20%">DATA END</th>
                    <th style="width: 20%">PRICE</th>
                </tr>
                <c:forEach var="room" items="${sessionScope.dataSelectRoom}" varStatus="status">
                    <tr>
                        <td>${user.UName}</td>
                        <td>${room.roomNum}</td>
                        <td>${Attr_DateStart}</td>
                        <td>${Attr_DateEnd}</td>
                        <td>${room.rate}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="row">
            <div class="col-lg-11"></div>
            <div class="col-lg-1">
                <button type="submit" class="btn btn-primary button_add">Print<i
                        class="fa fa-print  fa-lg icon_sign_up"></i></button>
            </div>
        </div>
    </div>
</form>
<div class="container">
    <div class="row">
        <p class="welcome"><span class="H_W">T</span>hank you for choosing us</p>
    </div>
</div>
<%@ include file="/jspf/footerFixed.jspf" %>
<%
    List<Room> orderRooms = (List) request.getSession().getAttribute("dataSelectRoom");
    orderRooms.clear();
%>
</body>
</html>