var monsterControllers = angular.module('monsterControllers', []);

monsterControllers.factory('MonsterList', ['$http',
    function($http){
        return $http.get('/monsters');
    }])

monsterControllers.factory('Monster', ['$http','$routeParams', function($http,$routeParams){
    console.log("entering factory");
    console.log("id " + $routeParams.monsterName)
    return $http.get('/monsters/' + $routeParams.monsterName);
}])

monsterControllers.controller("MonsterController", ['$scope', 'MonsterList',
    function($scope, MonsterList){
        MonsterList.success(function(data){
            $scope.monsterList = data;
            $scope.monsterStats = null;
        })
    }]);

monsterControllers.controller('MonsterDetailsController', ['$scope', '$routeParams', 'Monster',
  function($scope, $routeParams, Monster) {
Monster.success(function(data){
      console.log("entering success");
      console.log(data);
        $scope.monsterStats = data[0];
        $scope.templates = [
            {"href":"templates/top-stats.html"},
            {"href":"templates/creature-heading.html"},
            {"href":"templates/abilities-block.html"},
            {"href":"templates/abilities-block.html"},
            {"href":"templates/property-block.html"},
            {"href":"templates/property-line.html"},
            {"href":"templates/stat-block.html"}
        ];

        hideActions();
        hideTopStats();
        console.log($scope.templates);
        console.log(data[0]);

      }).error(function(data, status){
        console.log(data, status);
        $scope.monsterStats = [];
      });

      function hideActions(){
        if($scope.monsterStats.LegendaryActions.length == 0 ){
            hideElement( '#legendary' );
        }
        if($scope.monsterStats.Reactions.length == 0 ){
            hideElement( '#reactions' );
        }
      }

      function hideTopStats(){
        if($scope.monsterStats.DamageImmunities.length==0){
            hideElement('#damageImmunities');
        }
        if($scope.monsterStats.ConditionImmunities.length==0){
            hideElement('#conditionImmunities');
        }
        if($scope.monsterStats.Senses.length==0){
            hideElement('#senses');
        }
        if($scope.monsterStats.SavingThrows.length==0){
            hideElement('#savingThrows');
        }
        if($scope.monsterStats.Skills.length==0){
            hideElement('#skills');
        }
        if($scope.monsterStats.Languages.length==0){
            hideElement('#languages');
        }
        if($scope.monsterStats.DamageResistances.length==0){
            hideElement('#damageResistances');
        }
      }

      function hideElement(elementName){
           var element = angular.element(document.querySelector(elementName));
           element.toggleClass("ng-hide");
      }
  }]);