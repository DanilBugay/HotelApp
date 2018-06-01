<%@ include file="/jspf/page.jspf"%>
<%@ include file="/jspf/taglib.jspf"%>
<html lang="ru">
    <%@ include file="/jspf/head.jspf"%>
    <body>
        <%@ include file="/jspf/header.jspf"%>
        <div class="container catalog_p">
            <div class="row">
                <p class="welcome_2"><span class="H_W">Y</span>our  cart</p>
            </div>
        </div>
        <c:if test="${sessionScope.dataSelectRoom != null}">
            <form action="Controller" method="POST">
                <input type="hidden" name="command" value="MakeOrder" />
                <div class="container">
                    <div class="row">
                        <table border="1" class="table_catalog">
                            <tr>
                                <th style="width: 10%">NUMBER</th>
                                <th style="width: 40%">DESCRIPTION</th>
                                <th style="width: 10%">PRICE</th>
                                <th style="width: 30%">PHOTO</th>
                                <th style="width: 10%">SELECT</th>
                            </tr>
                            <c:forEach var="room" items="${sessionScope.dataSelectRoom}" varStatus="status">
                                <tr>
                                    <td>${room.roomNum}</td>
                                    <td class="description">${room.descript}</td>
                                    <td>${room.rate}</td>
                                    <td class="description"><img src="${room.srcPhoto}" class="img-rounded" style="height: 250px; width: 400px;"></td>
                                    <td><input type="checkbox" name="cart_select_room" style="height: 100px; width: 100px;" value="${status.index}"></td>

                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
                <div class="container" style="margin-bottom: 100px;">
                    <div class="row">
                        <div class="col-lg-9"></div>
                        <div class="col-lg-1">
                            <button type="submit" class="btn btn-primary  button_order" name="bDelete">Delete<i class="fa fa-trash fa-lg icon_sign_up"></i></button>
                        </div>
                        <div class="col-lg-2">
                            <button type="submit" class="btn btn-primary button_order" name="bMakeOrder">Make order<i class="fa fa-pencil-square-o fa-lg icon_sign_up"></i></button>
                        </div>
                    </div>
                </div>
            </form>
        </c:if>
        <c:if test="${sessionScope.dataSelectRoom == null}">
            <div class="container">
                <div class="row">
                    <div class="alert alert-info alert_catalog">
                        <strong>Info!</strong> Your cart is empty.
                    </div>
                </div>
            </div>
        </c:if>
        <%@ include file="/jspf/footerFixed.jspf"%>
    </body>
</html>

