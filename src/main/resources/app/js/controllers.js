/**
 * Created by nick on 1/8/17.
 */
(function (angular) {

    'use strict';

    var App = angular.module('App');

    App.controller('WeatherController', ['$scope', '$http',
        function ($scope, $http) {

            $scope.city = 'Kharkiv';

            $scope.init = function () {
                $scope.getWeather($scope.city);
            };

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
                })
            };

            $scope.init();

        }]);

        App.controller('NavBarController', ['$scope', '$location', function ($scope, $location) {
            $scope.isActive = function (viewLocation) {
                return viewLocation === $location.path();
            };
        }]);


})(window.angular);