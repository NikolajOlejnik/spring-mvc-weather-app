<%@page session="false"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Current weather</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

    <script>
        $(document).ready(function($) {
            $("#search-form").submit(function(event) {
                event.preventDefault();
                searchViaAjax();
            });
        });

        function searchViaAjax() {
            var city = $("#city").val();
            $.ajax({
                type : "GET",
                contentType : "application/x-www-form-urlencoded; charset=UTF-8",
                url : "http://api.openweathermap.org/data/2.5/weather?q="+city+"&APPID=18941878d8bee31166d6201ef9886fb2",
                data : JSON.stringify(city),
                dataType : 'json',
                timeout : 100000,
                success : function(data) {
                    console.log("SUCCESS: ", data);
                    sendToSpringController(data);
                },
                error : function(e) {
                    console.log("ERROR: ", e);
                    display(e);
                },
            });
        }
        function sendToSpringController(data) {
            var json = JSON.stringify(data);
            $.ajax({
                type : "POST",
                contentType : "application/json",
                url : "/getWeather",
                data : json,
                dataType : 'json',
                timeout : 100000,
                success : function(data) {
                    console.log("SUCCESS: ", data);
                    display(data);
                },
                error : function(e) {
                    console.log("ERROR: ", e);
                },
            });
        }
        function display(data) {
            var temp = JSON.stringify(data.temperature);
            $('#temp-feedback').text(temp.replace(/\"/g, ""));
        }
    </script>
</head>
<body>
<div class="container" style="min-height: 200px">

        <h3>Search current weather</h3>
        <br>

    <div id="temp">Current temperature: </div> <div id="temp-feedback"></div>

        <form class="form-horizontal" id="search-form">

            <div class="form-group">

                <label class="col-sm-2 control-label">City</label>

                <div class="col-sm-10">
                    <input type=text class="form-control" id="city">
                </div>

            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" id="bth-search"
                            class="btn btn-primary btn-lg">Search</button>
                </div>
            </div>
        </form>
</div>

Technologies: OpenJDK 8, Spring MVC 4.2.5, Ajax, JSON, jQuery 1.12.0, Twitter Bootstrap 3.3.6, JUnit 4.12. <br/>
Weather Source: <a href="http://openweathermap.org/">OpenWeatherMap API</a> <br/>
Author: <a href = "https://github.com/NikolajOlejnik"> Nikolaj Olejnik </a>

</body>

</html>
