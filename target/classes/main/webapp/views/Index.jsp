<!DOCTYPE html>
<%@ include file="/jspf/page.jspf"%>
<%@ include file="/jspf/taglib.jspf"%>
<html lang="ru">
    <%@ include file="/jspf/head.jspf"%>
    <body>
        <%@ include file="/jspf/header.jspf"%>
        <div id="carousel" class="carousel slide">
            <ol class="carousel-indicators">
                <li class="active" data-target="#carousel" data-slide-to="0"></li>
                <li  data-target="#carousel" data-slide-to="1"></li>
                <li   data-target="#carousel" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
                <div class="item active">
                    <img class="images_for_slider" src="images/8.jpg">
                    <div class="carousel-caption">
                        <p class="header_slide">hight level</p>
                    </div>
                </div>
                <div class="item">
                    <img class="images_for_slider" src="images/2.jpg">
                    <div class="carousel-caption">
                        <p class="header_slide">good service</p>
                    </div>
                </div>
                <div class="item">
                    <img class="images_for_slider" src="images/3.jpg">
                    <div class="carousel-caption">
                        <p class="header_slide_scenery">beautiful scenery</p>
                    </div>
                </div>
            </div>

            <a href="#carousel" class="left carousel-control" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left"></span>
            </a>
            <a href="#carousel" class="right carousel-control" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right"></span>
            </a>
        </div>
        <div class="container">
            <div class="row">
                <p class="welcome"><span class="H_W">W</span>elcome</p>
            </div>
        </div>
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-4 text_about_hotel">
                    <p>Hotel �Lighthouse� - the perfect choice for a comfortable and economical accommodation in Odessa.
                        The new 14-storey building of Odessa hotel �Lighthouse�, located away from busy main roads,
                        located in a beautiful area and has breathtaking views of the sea, has X spacious rooms of different
                        categories equipped with all the necessary for the modern man.</p>
                </div>
                <div class="col-lg-4 text_about_hotel">
                    <p>Its convenient location will allow you to easily for unloaded tracks
                        to get to the most important economic and cultural centers of the city. </p>
                    <p> Reasonable prices and flexible payment system, the high level of the number of rooms and a great location,
                        make the hotel  �Lighthouse� is equally attractive for both tourists and businessmen. </p>
                    <p> No matter where you are - on a business trip or just a trip - a private hotel �Lighthouse� a worthy choice for you! </p>
                </div>
                <div class="col-lg-4 text_about_hotel"><img class="image_mhotel" src="images/4.jpg"></div>
            </div>
        </div>
        <div class="container-fluid rooms">
            <div class="row ">
                <div class="col-lg-6">
                    <img class="pict" src="images/9.jpg" />
                    <div class="container-fluid">
                        <div class="row ">
                            <div class="col-lg-3"></div>
                            <div class="col-lg-6">
                                <div class="for_pict">
                                    <p id="text_for_pict" class="text_for_pict">Economy cosy double </br> room</p>
                                </div>
                            </div>
                            <div class="col-lg-3"></div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <img class="pict" src="images/10.jpg" />
                    <div class="container-fluid">
                        <div class="row ">
                            <div class="col-lg-3"></div>
                            <div class="col-lg-6">
                                <div class="for_pict">
                                    <p id="text_for_pict" class="text_for_pict">Classic Lovely comfortable room</p>
                                </div>
                            </div>
                            <div class="col-lg-3"></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6">
                    <img class="pict" src="images/11.jpg" />
                    <div class="container-fluid">
                        <div class="row ">
                            <div class="col-lg-3"></div>
                            <div class="col-lg-6">
                                <div class="for_pict">
                                    <p id="text_for_pict" class="text_for_pict">Junior Suite Two-room suite with decor</p>
                                </div>
                            </div>
                            <div class="col-lg-3"></div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <img class="pict" src="images/12.jpg" />
                    <div class="container-fluid">
                        <div class="row ">
                            <div class="col-lg-3"></div>
                            <div class="col-lg-6">
                                <div class="for_pict">
                                    <p id="text_for_pict" class="text_for_pict">Apartments A Luxurios two-room suite</p>
                                </div>
                            </div>
                            <div class="col-lg-3"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="container">
            <h1 class="why rooms_2">Why us</h1>
            <h5>let?s get acquainted</h5>
            <div class="row rooms">
                <div class="col-lg-4">
                    <img class="why_pict" src="images/13.jpg" />
                    <h5 class="text_why">The entire summer season the hotel offers children and adult animation, evening shows.</h5>
                </div>
                <div class="col-lg-4">
                    <img class="why_pict" src="images/14.jpg" />
                    <h5 class="text_why">Inside the hotel there are children's and adult swimming pools with heated seawater, saunas, tennis courts.</h5>
                </div>
                <div class="col-lg-4">
                    <img class="why_pict" src="images/15.jpg" />
                    <h5 class="text_why">In the main building of the hotel is the cultural and Exhibition Center with its own concert hall for 500 persons.</h5>
                </div>
            </div>
            <h4 class="why rooms"><a href="">Read more</a></h4>
        </div>

        <div class="container-fluid  booking rooms_2">
            <div class="row ">
                <img class="images_for_slider" src="images/20.jpg">
                <p class="book">ready to book?</p>
                <div class="col-lg-4"></div>
                <div class="col-lg-4">
                    <div class="bron">
                        <form class="form-horizontal" action="Controller" method="POST">
                            <input type="hidden" name="command" value="HotelCatalog" />
                            <div class="form-group">
                                <p class="header_book">MAKE A RESERVATION</p>
                                <label  class="col-sm-3 control-label check">Check in:</label>
                                <div class="col-sm-9">
                                    <input type="text" name="Date_start" class="form-control" id="datepicker" placeholder="16.04.2017">
                                </div>
                            </div>
                            <div class="form-group inputs">
                                <label  class="col-sm-3 control-label check">Check out:</label>
                                <div class="col-sm-9">
                                    <input name="Date_end" type="text"  class="form-control" id="inputCheckOut" placeholder="19.04.2017">
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-3 control-label check">Type:</label>
                                <div class="col-sm-9">
                                    <select  id="select_type" name="ID_room_type">
                                        <c:forEach var="room" items="${dataRoomType}">
                                            <option value="${room.id}">${room.roomType}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <button type="submit" id="submit" name="submit_date" class="btn btn-default btn-block">Check availability</button>
                        </form>
                    </div>
                </div>
                <div class="col-lg-4"></div>
            </div>
        </div>
        <div class="container rooms">
            <h1 class="why rooms">Latest news</h1>
            <h5>Sed loreet aliquam leotellus</h5>
            <div class="row rooms">
                <div class="col-lg-2">
                    <img class="news_pict img-circle" src="images/16.jpg" />
                    <h6 class="text_news">20 min ago</h6>
                        <h5 class="text_news">Modern therapeutic medical center began its work at the hotel</h5>
                </div>
                <div class="col-lg-2">
                    <img class="news_pict img-circle" src="images/24.jpg" />
                    <h5 class="text_news">50 min ago</h5>
                        <h5 class="text_news">Take a break from the hustle and bustle of weekdays and spend good weekend</h5>
                </div>
                <div class="col-lg-2">
                    <img class="news_pict img-circle" src="images/18.jpg" />
                    <h5 class="text_news">1 day ago</h5>
                        <h5 class="text_news">Book a room through the site and be guaranteed to get the best price</h5>
                </div>
                <div class="col-lg-2">
                    <img class="news_pict img-circle" src="images/19.jpg" />
                    <h5 class="text_news">3 days ago</h5>
                        <h5 class="text_news">We invite you to spend International women's day and meet spring at the hotel</h5>
                </div>
                <div class="col-lg-2">
                    <img class="news_pict img-circle" src="images/22.jpg" />
                    <h5 class="text_news">6 days ago</h5>
                        <h5 class="text_news">Our chef has prepared a special menu for a special evening</h5>
                </div>
                <div class="col-lg-2">
                    <img class="news_pict img-circle" src="images/23.jpg" />
                    <h5 class="text_news">1 week ago</h5>
                        <h5 class="text_news">When performing complex activities at the hotel, get discounts</h5>
                </div>
            </div>
        </div>
        <div class="container-fluid rooms_2">
            <div class="row ">
                <div class="col-lg-6">
                </div>
            </div>
        </div>

        <%@ include file="/jspf/footer.jspf"%>
    </body>
</html>
