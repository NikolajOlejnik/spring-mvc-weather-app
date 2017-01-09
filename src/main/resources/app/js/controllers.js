/**
 * Created by nick on 1/8/17.
 */
(function (angular) {

    'use strict';

    var App = angular.module('App');

    App.controller('WeatherController', ['$scope', '$http', '$routeParams', '$rootScope',
        function ($scope, $http, $routeParams, $rootScope) {

            $scope.init = function () {

                if ($rootScope.city !== undefined) {
                    $scope.getWeather($rootScope.city);
                    return;
                } else if ($routeParams.city !== undefined) {
                    $rootScope.city = $routeParams.city;
                } else {
                    $rootScope.city = 'Kharkiv';
                }
                $scope.getWeather($rootScope.city);

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

    App.controller('NavBarController', ['$scope', '$location', '$rootScope',
        function ($scope, $location, $rootScope) {

            $scope.isActive = function (viewLocation) {
                return viewLocation === $location.path();
            };

            $scope.getWeather = function (city) {
                $rootScope.city = city;
                $location.path('/current-weather/' + city)
            };
        }]);


})(window.angular);