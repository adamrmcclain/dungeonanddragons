'use strict';

/* App Module */

var dndApp = angular.module('dndApp', [
  'ngRoute',
  'monsterControllers'
]);

dndApp.config(['$routeProvider',
  function($routeProvider) {
  $routeProvider
    .when('/monster/:monsterName', {
        templateUrl: '/templates/monster/monster-details.html',
        controller: 'MonsterDetailsController'
    })
    .when('/monster', {
        templateUrl: '/templates/monster/monster-list.html',
        controller: 'MonsterController'
    }).otherwise({
        redirectTo: '/monster'
    });
  }]);

