/**
 * Created by nick on 1/8/17.
 */
(function (angular) {

    'use strict';

    var App = angular.module('App');

    App.controller('WeatherController', ['$scope', '$http', '$routeParams',
        function ($scope, $http, $routeParams) {
            
            $scope.init = function () {

                var city;

                if (!$scope.city) {
                    city = 'Kharkiv';
                } else {
                    city = $routeParams.city;
                }

                $scope.getWeather(city);
            };

            $scope.getWeather = function (city) {

                $http.get('/weather', {
                    params: {city: city}
                }).then(function (response) {
                    $scope.showError = false;
                    $scope.weather = response.data;
                    $scope.weatherAvailable = true;
                }, function (response) {
                    $scope.showError = true;
                })
            };

            $scope.init();

        }]);

    App.controller('NavBarController', ['$scope', '$location',
        function ($scope, $location) {

            $scope.isActive = function (viewLocation) {
                return viewLocation === $location.path();
            };

            $scope.getWeather = function (city) {
                $location.path('/current-weather/' + city)
            };
        }]);


})(window.angular);