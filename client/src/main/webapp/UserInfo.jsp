<%@ include file="jspf/page.jspf"%>
<%@ include file="jspf/taglib.jspf"%>
<html lang="ru">
    <%@ include file="jspf/head.jspf"%>
    <body>
        <%@ include file="jspf/header.jspf"%>
        <div class="container log_up">
            <div class="row">
                <p class="welcome"><span class="H_W">P</span>lease enter your personal details</p>
            </div>
        </div>
        <div class="container-fluid">
            <div class="row ">
                <div class="col-lg-4"></div>
                <div class="col-lg-4">
                    <div class="details">
                        <form class="form-horizontal" action="Controller" method="POST">
                            <input type="hidden" name="command" value="MakeOrder" />
                            <div class="form-group">
                                <label  class="col-sm-3 control-label check">Full Name:</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" name="UserName" placeholder="Full Name">
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
                            <button type="submit" class="btn btn-primary button_order" name="bMakeOrderInfo">Make order<i class="fa fa-pencil-square-o fa-lg icon_sign_up"></i></button>
                        </form>
                    </div>
                </div>
                <div class="col-lg-4"></div>
            </div>
        </div>
        <%@ include file="jspf/footerFixed.jspf"%>
    </body>
</html>
