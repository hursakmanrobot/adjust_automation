$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("API.feature");
formatter.feature({
  "line": 1,
  "name": "Check API Responses",
  "description": "",
  "id": "check-api-responses",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Create Pet And Check",
  "description": "",
  "id": "check-api-responses;create-pet-and-check",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@api"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "Create New Pet",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Check Pet Created",
  "keyword": "Then "
});
formatter.match({
  "location": "APIPageStep.createNewPet()"
});
formatter.result({
  "duration": 2588403000,
  "status": "passed"
});
formatter.match({
  "location": "APIPageStep.checkPetCreated()"
});
formatter.result({
  "duration": 1316983600,
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "Update Pet And Check",
  "description": "",
  "id": "check-api-responses;update-pet-and-check",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 8,
      "name": "@api"
    }
  ]
});
formatter.step({
  "line": 10,
  "name": "Create New Pet",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "Update Pet And Check",
  "keyword": "And "
});
formatter.match({
  "location": "APIPageStep.createNewPet()"
});
formatter.result({
  "duration": 749671300,
  "status": "passed"
});
formatter.match({
  "location": "APIPageStep.updatePetAndCheck()"
});
formatter.result({
  "duration": 733278800,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Create Order",
  "description": "",
  "id": "check-api-responses;create-order",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 13,
      "name": "@api"
    }
  ]
});
formatter.step({
  "line": 15,
  "name": "Create New Pet",
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "Order Created Pet",
  "keyword": "And "
});
formatter.match({
  "location": "APIPageStep.createNewPet()"
});
formatter.result({
  "duration": 741392700,
  "status": "passed"
});
formatter.match({
  "location": "APIPageStep.orderCreatedPet()"
});
formatter.result({
  "duration": 779080000,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "Create New User And Check",
  "description": "",
  "id": "check-api-responses;create-new-user-and-check",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 18,
      "name": "@api"
    }
  ]
});
formatter.step({
  "line": 20,
  "name": "Create New User And Check",
  "keyword": "Given "
});
formatter.match({
  "location": "APIPageStep.createNewUserAndCheck()"
});
formatter.result({
  "duration": 750291700,
  "status": "passed"
});
formatter.scenario({
  "line": 23,
  "name": "Login With Existing User",
  "description": "",
  "id": "check-api-responses;login-with-existing-user",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 22,
      "name": "@api"
    }
  ]
});
formatter.step({
  "line": 24,
  "name": "Create New User",
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "Login With Existing User And Check",
  "keyword": "Given "
});
formatter.match({
  "location": "APIPageStep.createNewUser()"
});
formatter.result({
  "duration": 759283500,
  "status": "passed"
});
formatter.match({
  "location": "APIPageStep.loginWithExistingUserAndCheck()"
});
formatter.result({
  "duration": 752508200,
  "status": "passed"
});
formatter.uri("UI.feature");
formatter.feature({
  "line": 2,
  "name": "Search Item",
  "description": "",
  "id": "search-item",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@browser"
    }
  ]
});
formatter.before({
  "duration": 2379497400,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "Navigate to Wikipedia Search Page",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "Navigate to HomePage",
  "keyword": "Given "
});
formatter.match({
  "location": "HomePageStep.navigateTooHomePage()"
});
formatter.result({
  "duration": 21667455100,
  "status": "passed"
});
formatter.scenario({
  "line": 8,
  "name": "Wikipedia Logo Check",
  "description": "",
  "id": "search-item;wikipedia-logo-check",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 7,
      "name": "@logo_check"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "Check Wikipedia Logo",
  "keyword": "Then "
});
formatter.match({
  "location": "HomePageStep.checkWikipediaLogo()"
});
formatter.result({
  "duration": 94839400,
  "status": "passed"
});
formatter.after({
  "duration": 103433500,
  "status": "passed"
});
formatter.before({
  "duration": 1963064300,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "Navigate to Wikipedia Search Page",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "Navigate to HomePage",
  "keyword": "Given "
});
formatter.match({
  "location": "HomePageStep.navigateTooHomePage()"
});
formatter.result({
  "duration": 21801242100,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Wikipedia Search Text And Check",
  "description": "",
  "id": "search-item;wikipedia-search-text-and-check",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 11,
      "name": "@check_search_result"
    }
  ]
});
formatter.step({
  "line": 13,
  "name": "I want to search \"Opeth\" text on Wikipedia search page and check",
  "keyword": "When "
});
formatter.match({
  "arguments": [
    {
      "val": "Opeth",
      "offset": 18
    }
  ],
  "location": "HomePageStep.iWantToSearchTextOnWikipediaSearchPage(String)"
});
formatter.result({
  "duration": 1281371200,
  "status": "passed"
});
formatter.after({
  "duration": 89117700,
  "status": "passed"
});
formatter.before({
  "duration": 1940227500,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "Navigate to Wikipedia Search Page",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "Navigate to HomePage",
  "keyword": "Given "
});
formatter.match({
  "location": "HomePageStep.navigateTooHomePage()"
});
formatter.result({
  "duration": 21946494000,
  "status": "passed"
});
formatter.scenario({
  "line": 16,
  "name": "Search Any Text Which Is Does Not Exists And Check",
  "description": "",
  "id": "search-item;search-any-text-which-is-does-not-exists-and-check",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 15,
      "name": "@check_search_result"
    }
  ]
});
formatter.step({
  "line": 17,
  "name": "I want to search \"Asdasdwsxwsx\" text on Wikipedia search page and check it is does not exists",
  "keyword": "When "
});
formatter.match({
  "arguments": [
    {
      "val": "Asdasdwsxwsx",
      "offset": 18
    }
  ],
  "location": "HomePageStep.iWantToSearchTextOnWikipediaSearchPageAndCheckItIsDoesNotExists(String)"
});
formatter.result({
  "duration": 1169173900,
  "status": "passed"
});
formatter.after({
  "duration": 135977300,
  "status": "passed"
});
formatter.before({
  "duration": 1979638600,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "Navigate to Wikipedia Search Page",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "Navigate to HomePage",
  "keyword": "Given "
});
formatter.match({
  "location": "HomePageStep.navigateTooHomePage()"
});
formatter.result({
  "duration": 21873708100,
  "status": "passed"
});
formatter.scenario({
  "line": 20,
  "name": "Complex Regular Expression Message Check",
  "description": "",
  "id": "search-item;complex-regular-expression-message-check",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 19,
      "name": "@check_search_result"
    }
  ]
});
formatter.step({
  "line": 21,
  "name": "I want to search Complex Regular Expression text on Wikipedia search page and check",
  "keyword": "When "
});
formatter.match({
  "location": "HomePageStep.iWantToSearchComplexRegularExpressionTextOnWikipediaSearchPageAndCheck()"
});
formatter.result({
  "duration": 2161999400,
  "status": "passed"
});
formatter.after({
  "duration": 70176800,
  "status": "passed"
});
});