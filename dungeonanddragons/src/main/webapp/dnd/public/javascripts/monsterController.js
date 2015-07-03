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
            $scope.predicate = "MonsterName";

               angular.forEach($scope.monsterList, function (monster) {
               console.log(monster.MonsterName);
               console.log(monster.Challenge);
                if(!(angular.isNumber(monster.Challenge)) && (monster.Challenge) && (monster.Challenge.indexOf("/") > -1)){
                    var challengeArray = monster.Challenge.split("/");
                    var num = parseFloat(challengeArray[0]);
                    var dom = parseFloat(challengeArray[1]);
                    monster.Challenge = num/dom;
                }else{
                    monster.Challenge = parseFloat(monster.Challenge);
                }
               });

            $scope.monsterStats = null;
            $scope.order = function(predicate) {
                $scope.reverse = ($scope.predicate === predicate) ? !$scope.reverse : false;
                $scope.predicate = predicate;
            };

            $scope.filterNumber = function(node){
                console.log(node.MonsterName);
                console.log(node.Challenge);
                return !(isNaN(node.Challenge));
            }
        })
    }]);

monsterControllers.controller('MonsterDetailsController', ['$scope', '$routeParams', 'Monster',
  function($scope, $routeParams, Monster) {
Monster.success(function(data){
      console.log("entering success");
      console.log(data);
        $scope.monsterStats = data[0];
        $scope.templates = [
            {"href":"templates/monster/top-stats.html"},
            {"href":"templates/monster/creature-heading.html"},
            {"href":"templates/monster/abilities-block.html"},
            {"href":"templates/monster/abilities-block.html"},
            {"href":"templates/monster/property-block.html"},
            {"href":"templates/monster/property-line.html"},
            {"href":"templates/monster/stat-block.html"}
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