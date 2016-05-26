var myApp = angular.module('myApp',['ngRoute']);

myApp.config(function($routeProvider){
    $routeProvider
        .when('/',{
            templateUrl: 'home.html',
            controller: 'homeController'
        })
        .otherwise({ redirectTo: '/' });

});

myApp.controller('homeController', function ($scope, $http) {

    $scope.selectedAuthorsList = null;
    $scope.AuthorsList = [];

    $scope.selectedCategoryList = null;
    $scope.CategoryList = [];

    $scope.selectedYearList = null;
    $scope.YearList = [];

    $http.get("http://localhost:8085/BooksOntology/AuthorsList/AuthorsList").success(function(data) {
        resultArray1 = data.Authors;
        $scope.AuthorsList = resultArray1;
    })

    $http.get("http://localhost:8085/BooksOntology/CategoryList/CategoryList").success(function(data) {
        resultArray2 = data.Category;
        $scope.CategoryList = resultArray2;
    })

    $http.get("http://localhost:8085/BooksOntology/YearList/YearList").success(function(data) {
        resultArray3 = data.Year;
        $scope.YearList = resultArray3;
    })

    $scope.Results = function(){
        var authors = null;
        var category = null;
        var year = null;
        authors = $scope.selectedAuthorsList;
        category = $scope.selectedCategoryList;
        year = $scope.selectedYearList;

        if(authors == null){
            authors = "none";
        }

        if(category == null){
            category = "none";
        }

        if(year == null){
            year = "none";
        }


        var url = "http://localhost:8085/BooksOntology/GetBooksDetails/GetBooksDetails?authors=" + authors
        + "&year=" + year + "&category=" + category;
        $http.get(url).success(function(data) {
            resultArray = data.results;
            var l = resultArray.length;

            if(l==1){
                $scope.number = l + " Book found...";
            }
            else{
                $scope.number = l + " Books found...";
            }

            if(l==0){
                document.getElementById('noResults').style.display = 'block';
                document.getElementById('results').style.display = 'none';
            }
            else{
                document.getElementById('results').style.display = 'block';
                document.getElementById('noResults').style.display = 'none';
                $scope.itemsList = resultArray;
            }

        })
    }
    });