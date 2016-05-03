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
        }
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
            showHideArea();
            display(data);
            $('#error-field').text('');
        },
        error : function() {
            displayError();
        }
    });
}
function display(data) {
    var temp = JSON.stringify(data.temperature).concat(" °C");
    var location = "Current weather in " + JSON.stringify(data.city);
    var description = JSON.stringify(data.description);
    var wind = JSON.stringify(data.wind);

    $('#temp').text(temp.replace(/"/g, ""));
    $('#description').text(description.replace(/"/g, ""));
    $('#city-name').text(location.replace(/"/g, ""));
    $('#wind').text(wind.replace(/"/g, ""));
}

function displayError() {
    $('#error-field').text("Enter correct city").css('color','red');
}

function showHideArea() {
    $('#hide-area').show();
}