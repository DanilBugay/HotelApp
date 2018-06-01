<%@ include file="/jspf/page.jspf"%>
<%@ include file="/jspf/taglib.jspf"%>
<html lang="ru">
    <%@ include file="/jspf/head.jspf"%>
    <body>
        <%@ include file="/jspf/header.jspf"%>
        <div class="container log_up">
            <div class="row">
                <p class="welcome"><span class="H_W">P</span>lease create your account</p>
            </div>
        </div>
        <div class="container-fluid">
            <div class="row ">
                <div class="col-lg-4"></div>
                <div class="col-lg-4">
                    <div class="log_ups">
                        <form class="form-horizontal" action="Controller" method="POST">
                            <input type="hidden" name="command" value="HotelReg" />
                            <div class="form-group">
                                <label  class="col-sm-3 control-label check">Full Name:</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" name="UserName" placeholder="Full Name">
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-3 control-label check">Login:</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" name="UserLogin" placeholder="Login">
                                </div>
                            </div>
                            <div class="form-group inputs">
                                <label  class="col-sm-3 control-label check">Password:</label>
                                <div class="col-sm-9">
                                    <input type="password" class="form-control" name="UserPassword" placeholder="Password:">
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-3 control-label check">Mail:</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" name="UserMail" placeholder="Mail">
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-3 control-label check">Phone:</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" name="UserPhone" placeholder="Phone">
                                </div>
                            </div>

                            <button type="submit" id="submit" name="submit_date" class="btn btn-default btn-block">Create</button>
                        </form>
                    </div>
                </div>
                <div class="col-lg-4"></div>
            </div>
        </div>
        <c:if test="${sessionScope.ERROR_ID == 0}">
            <div class="container-fluid">
                <div class="row ">
                    <div class="col-lg-4"></div>
                    <div class="col-lg-4">
                        <div class="alert alert-danger  error">
                            Registration error. Try again
                        </div>
                    </div>
                    <div class="col-lg-4"></div>
                </div>
            </div>
        </c:if>
        <%
            session.setAttribute("ERROR_ID", 1);
        %>
        <%@ include file="/jspf/footerFixed.jspf"%>
    </body>
</html>
