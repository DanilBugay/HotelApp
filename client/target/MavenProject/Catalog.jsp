<%@ include file="jspf/page.jspf"%>
<%@ include file="jspf/taglib.jspf"%>
<html lang="ru">
    <%@ include file="jspf/head.jspf"%>
    <body>
        <%@ include file="jspf/header.jspf"%>
        <div class="container catalog_p">
            <div class="row">
                <p class="welcome"><span class="H_W">P</span>lease select the hotel room</p>
            </div>
        </div>
        <%--     <div class="container">
                    <div class="row">
                        <form class="form-inline" role="form"  action="" method="">
                            <div class="form-group">
                                <label  class="control-label margin">Check in:</label>
                                <input type="text" class="form-control" id="inputCheckIn" placeholder="Check in">
                            </div>
                            <div class="form-group">
                                <label  class="control-label margin">Check out:</label>
                                <input type="text" class="form-control" id="inputCheckOut" placeholder="Check out:">
                                <label  class="control-label margin">Type:</label>
                            </div>
                            <div class="form-group">
                                <select  id="select_type_2">
                                    <c:forEach var="room" items="${sessionScope.dataRoomType}">
                                        <option value="${room.id}">${room.roomType}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <button type="submit" id="submit_2" name="submit_date" class="btn btn-default">Check availability</button>
                        </form>
                    </div>
                </div> --%>
        <c:if test="${sessionScope.aEMPTY_LIST == 1}">
            <form action="Controller" method="POST"> 
                <input type="hidden" name="command" value="CartAdd" />
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
                            <c:forEach var="room" items="${sessionScope.dataRoomCatalog}" varStatus="status">
                                <tr>
                                    <%--             <td>${room.roomNumber}</td>
                                                     <td class="description">${room.roomDesctiption}</td>
                                                     <td>${room.roomPrice}</td>
                                                     <td class="description"><img src="${room.roomPhoto}" class="img-rounded" style="height: 250px; width: 400px;"></td>
                                                     <td><input type="checkbox" name="selectroom" style="height: 100px; width: 100px;" value="${status.index}"></td>
                                                 
                                    --%>
                                    <td>${room.roomNum}</td>
                                    <td class="description">${room.descript}</td>
                                    <td>${room.rate}</td>
                                    <td class="description"><img src="${room.srcPhoto}" class="img-rounded" style="height: 250px; width: 400px;"></td>
                                    <td><input type="checkbox" name="selectroom" style="height: 100px; width: 100px;" value="${status.index}"></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
                <div class="container">
                    <div class="row">
                        <button type="submit" class="btn btn-primary button_add">Add to cart<i class="fa fa-cart-arrow-down fa-lg icon_sign_up"></i></button>
                    </div>
                </div>
            </form>
        </c:if> 
        <c:if test="${sessionScope.aEMPTY_LIST == 0}">
            <div class="container">
                <div class="row">
                    <div class="alert alert-info alert_catalog">
                        <strong>Info!</strong> No rooms available for the selected dates.
                    </div>
                </div>
            </div>
        </c:if>
        <%@ include file="jspf/footer.jspf"%>
    </body>
</html>