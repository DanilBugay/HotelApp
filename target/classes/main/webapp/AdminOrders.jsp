<!DOCTYPE html>
<%@ include file="jspf/page.jspf"%>
<%@ include file="jspf/taglib.jspf"%>
<html lang="ru">
    <%@ include file="jspf/head.jspf"%>
    <body>
        <%@ include file="jspf/header.jspf"%>
        <div class="container catalog_p">
            <div class="row">
                <p class="welcome_2"><span class="H_W">P</span>lease select the hotel room</p>
            </div>
        </div>
        <c:if test="${sessionScope.aEMPTY_ORDER == 1}">
            <form action="Controller" method="POST">
                <input type="hidden" name="command" value="AdminConfirm" />
                <div class="container">
                    <div class="row">
                        <table border="1" class="table_catalog">
                            <tr>
                                <th style="width: 10%">NUMBER</th>
                                <th style="width: 10%">DATA START</th>
                                <th style="width: 10%">DATA END</th>
                                <th style="width: 10%">PRICE</th>
                                <th style="width: 20%">USER NAME</th>
                                <th style="width: 20%">USER PHONE</th>
                                <th style="width: 20%">SELECT</th>
                            </tr>
                            <c:forEach var="room" items="${sessionScope.dataRoomHistory}" varStatus="status">
                                <tr>
                                    <td>${room.roomNumber}</td>
                                    <td>${room.dateStart}</td>
                                    <td>${room.dateEnd}</td>
                                    <td>${room.price}</td>
                                    <td>${room.UName}</td>
                                    <td>${room.UPhone}</td>
                                    <td><input type="checkbox" name="selectroom" style="height: 50px; width: 50px;" value="${status.index}"></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                    <div class="row">
                        <div class="col-lg-8"></div>
                        <div class="col-lg-2">
                            <button type="submit" class="btn btn-primary button_add" name="bConfirm">Confirm<i class="fa fa-check-circle  fa-lg icon_sign_up"></i></button>
                        </div>
                        <div class="col-lg-2">
                            <button type="submit" class="btn btn-primary button_add" name="bRejec">Reject<i class="fa fa-times fa-lg icon_sign_up"></i></button>
                        </div>
                    </div>
                </div>
            </form>
        </c:if>
        <c:if test="${sessionScope.aEMPTY_ORDER == 0}">
            <div class="container">
                <div class="row">
                    <div class="alert alert-info alert_catalog">
                        <strong>Info!</strong> Now there is no new orders.
                    </div>
                </div>
            </div>
        </c:if>
        <%@ include file="jspf/footerFixed.jspf"%>
    </body>
</html>
