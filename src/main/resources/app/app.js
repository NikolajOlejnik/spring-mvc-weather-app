/**
 * Created by nick on 1/7/17.
 */

(function (angular) {

    'use strict';

    angular.module('App', ['ngRoute', 'ngResource'])
        .config(['$routeProvider', function ($routeProvider) {
            $routeProvider
                .when('/current-weather', {
                    templateUrl: 'app/views/current-weather.html',
                    controller: 'WeatherController'
                })
                .when('/about', {
                    templateUrl: 'app/views/about.html'
                })
                .otherwise({
                    redirectTo: '/current-weather'
                });

        }])
})(window.angular);