$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resource/features/LoginValidation.feature");
formatter.feature({
  "line": 1,
  "name": "Login Related Hybris API",
  "description": "",
  "id": "login-related-hybris-api",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "HEAD-103, HEAD-785 - Create registered user with optin",
  "description": "",
  "id": "login-related-hybris-api;head-103,-head-785---create-registered-user-with-optin",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@HEAD-103"
    },
    {
      "line": 3,
      "name": "@HEAD-785"
    },
    {
      "line": 3,
      "name": "@HEAD-356"
    },
    {
      "line": 3,
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "User generates anon auth token for \"\u003cLocale\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User creates registered user with optin for \"\u003cLocale\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "User creates registered user with invalid mailid for \"\u003cLocale\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "User creates registered user with same mailid and password for \"\u003cLocale\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "User login using the new registered mailID for \"\u003cLocale\u003e\"",
  "keyword": "Then "
});
formatter.examples({
  "line": 10,
  "name": "",
  "description": "",
  "id": "login-related-hybris-api;head-103,-head-785---create-registered-user-with-optin;",
  "rows": [
    {
      "cells": [
        "Locale"
      ],
      "line": 11,
      "id": "login-related-hybris-api;head-103,-head-785---create-registered-user-with-optin;;1"
    },
    {
      "cells": [
        "US"
      ],
      "line": 12,
      "id": "login-related-hybris-api;head-103,-head-785---create-registered-user-with-optin;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 12,
  "name": "HEAD-103, HEAD-785 - Create registered user with optin",
  "description": "",
  "id": "login-related-hybris-api;head-103,-head-785---create-registered-user-with-optin;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@Regression"
    },
    {
      "line": 3,
      "name": "@HEAD-103"
    },
    {
      "line": 3,
      "name": "@HEAD-785"
    },
    {
      "line": 3,
      "name": "@HEAD-356"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "User generates anon auth token for \"US\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User creates registered user with optin for \"US\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "User creates registered user with invalid mailid for \"US\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "User creates registered user with same mailid and password for \"US\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "User login using the new registered mailID for \"US\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "US",
      "offset": 36
    }
  ],
  "location": "LoginValidationSteps.generateAnonAuth(String)"
});
formatter.result({
  "duration": 4995626094,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "US",
      "offset": 45
    }
  ],
  "location": "LoginValidationSteps.createRegUserWithOptIn(String)"
});
formatter.result({
  "duration": 3078267006,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "US",
      "offset": 54
    }
  ],
  "location": "LoginValidationSteps.createRegUserWithInvalidMailID(String)"
});
formatter.result({
  "duration": 1513780597,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "US",
      "offset": 64
    }
  ],
  "location": "LoginValidationSteps.createRegUserWithSameIDPWD(String)"
});
formatter.result({
  "duration": 1563328745,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "US",
      "offset": 48
    }
  ],
  "location": "LoginValidationSteps.loginUsingNewmailID(String)"
});
formatter.result({
  "duration": 1617516993,
  "status": "passed"
});
formatter.after({
  "duration": 2766904140,
  "status": "passed"
});
formatter.scenarioOutline({
  "comments": [
    {
      "line": 13,
      "value": "# |GB|"
    }
  ],
  "line": 17,
  "name": "[Hybris] - Employee Registration - Login and Post processor",
  "description": "",
  "id": "login-related-hybris-api;[hybris]---employee-registration---login-and-post-processor",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 16,
      "name": "@HEAD-750"
    },
    {
      "line": 16,
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "line": 18,
  "name": "User generates anon auth token for \"\u003cLocale\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 19,
  "name": "Validate successful Employee log in for \"\u003cLocale\u003e\"",
  "keyword": "Then "
});
formatter.examples({
  "line": 20,
  "name": "",
  "description": "",
  "id": "login-related-hybris-api;[hybris]---employee-registration---login-and-post-processor;",
  "rows": [
    {
      "cells": [
        "Locale"
      ],
      "line": 21,
      "id": "login-related-hybris-api;[hybris]---employee-registration---login-and-post-processor;;1"
    },
    {
      "comments": [
        {
          "line": 22,
          "value": "# |GB|"
        }
      ],
      "cells": [
        "US"
      ],
      "line": 23,
      "id": "login-related-hybris-api;[hybris]---employee-registration---login-and-post-processor;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "comments": [
    {
      "line": 22,
      "value": "# |GB|"
    }
  ],
  "line": 23,
  "name": "[Hybris] - Employee Registration - Login and Post processor",
  "description": "",
  "id": "login-related-hybris-api;[hybris]---employee-registration---login-and-post-processor;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 16,
      "name": "@Regression"
    },
    {
      "line": 16,
      "name": "@HEAD-750"
    }
  ]
});
formatter.step({
  "line": 18,
  "name": "User generates anon auth token for \"US\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 19,
  "name": "Validate successful Employee log in for \"US\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "US",
      "offset": 36
    }
  ],
  "location": "LoginValidationSteps.generateAnonAuth(String)"
});
formatter.result({
  "duration": 1672217997,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "US",
      "offset": 41
    }
  ],
  "location": "LoginValidationSteps.empLogin(String)"
});
formatter.result({
  "duration": 1593048572,
  "status": "passed"
});
formatter.after({
  "duration": 1355498759,
  "status": "passed"
});
});