<%@ include file="/jspf/page.jspf" %>
<%@ include file="/jspf/taglib.jspf" %>
<html lang="ru">
<%@ include file="/jspf/head.jspf" %>
<body>
<%@ include file="/jspf/header.jspf" %>
<div class="container catalog_p">
    <div class="row">
        <p class="welcome_2"><span class="H_W">Y</span>our personal information</p>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-lg-3"></div>
        <div class="col-lg-6">
            <table border="1" class="table_catalog">
                <tr>
                    <th>USER LOGIN</th>
                    <td>${user.ULogin}</td>
                </tr>
                <tr>
                    <th>USER NAME</th>
                    <td>${user.UName}</td>
                </tr>
                <tr>
                    <th>USER PHONE</th>
                    <td>${user.UPhone}</td>
                </tr>
                <tr>
                    <th>USER MAIL</th>
                    <td>${user.UMail}</td>
                </tr>

            </table>
        </div>
        <div class="col-lg-3"></div>
    </div>
</div>
<div class="container catalog_p">
    <div class="row">
        <p class="welcome"><span class="H_W">H</span>istory of orders</p>
    </div>
</div>
<c:if test="${list_roomHistory.size() > 0}">
    <div class="container">
        <div class="row">
            <table border="1" class="table_catalog">
                <tr>
                    <th style="width: 10%">NUMBER</th>
                    <th style="width: 10%">DATA START</th>
                    <th style="width: 10%">DATA END</th>
                    <th style="width: 10%">PRICE</th>
                    <th style="width: 10%">STATUS</th>

                </tr>
                <c:forEach var="rooms" items="${list_roomHistory}">
                    <tr>
                        <td>${rooms.roomNumber}</td>
                        <td>${rooms.dateStart}</td>
                        <td>${rooms.dateEnd}</td>
                        <td>${rooms.price}</td>
                        <td>${rooms.status}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</c:if>
<c:if test="${list_roomHistory.size() == 0}">
    <div class="container">
        <div class="row">
            <div class="alert alert-info alert_catalog">
                <strong>Info!</strong> Your order history is empty.
            </div>
        </div>
    </div>
</c:if>
<%@ include file="/jspf/footer.jspf" %>
</body>
</html>
