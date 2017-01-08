/**
 * Created by nick on 1/7/17.
 */
angular.module('app', [])
    .controller('WeatherController', function ($scope, $http) {

        $scope.getWeather = function (city) {
            debugger;
            $http.get('/weather', {
                params: {city: city}
            }).then(function (response) {
                //todo fix back-end
                if (!response.data.city) {
                    $scope.showError = true;
                    return;
                }
                $scope.showError = false;
                $scope.weather = response.data;
                $scope.weatherAvailable = true;
            }, function (response) {
                $scope.showError = true;
            });
        };
    });