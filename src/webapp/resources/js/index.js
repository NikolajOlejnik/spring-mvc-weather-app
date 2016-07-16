$(document).ready(function($) {

    $("#search-form").submit(function(event) {
        event.preventDefault();
        sendWeatherRequest();
    });
});

function sendWeatherRequest() {
    var city = $("#city").val();
    $.ajax({
        type : "POST",
        contentType : "application/x-www-form-urlencoded; charset=UTF-8",
        url : "/weather/".concat(city),
        data : JSON.stringify(city),
        dataType : 'json',
        timeout : 100000,
        success : function(data) {
            renderResponse(data);
        },
        error : function(e) {
            displayError(e);
        }
    });
}
function renderResponse(data) {

    var temp = JSON.stringify(data.temperature).concat(" °C");
    var location = "Current weather in " + JSON.stringify(data.city);
    var description = JSON.stringify(data.description);
    var wind = JSON.stringify(data.wind);

    $('#hide-area').show();
    $('#error-field').text('');
    $('#temp').text(temp.replace(/"/g, ""));
    $('#description').text(description.replace(/"/g, ""));
    $('#city-name').text(location.replace(/"/g, ""));
    $('#wind').text(wind.replace(/"/g, ""));
}


function displayError() {
    $('#error-field').text("Enter correct city").css('color','red');
}

