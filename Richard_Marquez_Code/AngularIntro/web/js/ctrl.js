app.controller('AboutController', function ($scope, $http, demoFactory) {

    $scope.results = demoFactory.getData(
        function(response) {
            console.log(response.data);
            $scope.result = response.data;
        }
    );

});
