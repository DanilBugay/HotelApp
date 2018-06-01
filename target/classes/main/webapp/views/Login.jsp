<%@ include file="/jspf/page.jspf"%>
<%@ include file="/jspf/taglib.jspf"%>
<html lang="ru">
    <%@ include file="/jspf/head.jspf"%>
    <body>
        <%@ include file="/jspf/header.jspf"%>
        <div class="container log_in">
            <div class="row">
                <p class="welcome"><span class="H_W">P</span>lease log in to your account</p>
            </div>
        </div>
        <div class="container-fluid rooms">
            <div class="row ">
                <div class="col-lg-4"></div>
                <div class="col-lg-4">
                    <div class="log">
                        <form class="form-horizontal" action="${pageContext.request.contextPath}/userLogin" method="Get">
                            <div class="form-group">
                                <label  class="col-sm-3 control-label check">Login:</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control"  name="UserLogin" placeholder="Login">
                                </div>
                            </div>
                            <div class="form-group inputs">
                                <label  class="col-sm-3 control-label check">Password:</label>
                                <div class="col-sm-9">
                                    <input type="password" class="form-control" name="UserPassword" placeholder="Password:">
                                </div>
                            </div>
                            <button type="submit" id="submit" name="submit_date" class="btn btn-default btn-block">Login</button>
                        </form>
                    </div>
                </div>
                <div class="col-lg-4"></div>
            </div>
        </div>
        <c:if test="${ERROR_ID == 0}">
            <p></p>
            <div class="container-fluid">
                <div class="row ">
                    <div class="col-lg-4"></div>
                    <div class="col-lg-4">
                        <div class="alert alert-danger  error">
                            Login error. Try again
                        </div>
                    </div>
                    <div class="col-lg-4"></div>
                </div>
            </div>
        </c:if>
        <%@ include file="/jspf/footerFixed.jspf"%>
    </body>
</html>
