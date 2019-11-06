$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("PDPValidation.feature");
formatter.feature({
  "line": 2,
  "name": "PDP related Hybris API",
  "description": "",
  "id": "pdp-related-hybris-api",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@Regression"
    }
  ]
});
formatter.scenarioOutline({
  "line": 29,
  "name": "Validate Product Swatches API - Mulesoft",
  "description": "",
  "id": "pdp-related-hybris-api;validate-product-swatches-api---mulesoft",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 28,
      "name": "@LMA"
    },
    {
      "line": 28,
      "name": "@LMA-196"
    }
  ]
});
formatter.step({
  "line": 30,
  "name": "User generates Mulesoft Auth Token for \"\u003cLocale\u003e\"",
  "keyword": "Given "
});
formatter.examples({
  "comments": [
    {
      "line": 31,
      "value": "#Given User validates product detail for \"\u003cLocale\u003e\""
    },
    {
      "line": 32,
      "value": "#And User checks the swatch data for \"\u003cLocale\u003e\""
    }
  ],
  "line": 33,
  "name": "",
  "description": "",
  "id": "pdp-related-hybris-api;validate-product-swatches-api---mulesoft;",
  "rows": [
    {
      "cells": [
        "Locale"
      ],
      "line": 34,
      "id": "pdp-related-hybris-api;validate-product-swatches-api---mulesoft;;1"
    },
    {
      "cells": [
        "US"
      ],
      "line": 35,
      "id": "pdp-related-hybris-api;validate-product-swatches-api---mulesoft;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 35,
  "name": "Validate Product Swatches API - Mulesoft",
  "description": "",
  "id": "pdp-related-hybris-api;validate-product-swatches-api---mulesoft;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 28,
      "name": "@LMA-196"
    },
    {
      "line": 1,
      "name": "@Regression"
    },
    {
      "line": 28,
      "name": "@LMA"
    }
  ]
});
formatter.step({
  "line": 30,
  "name": "User generates Mulesoft Auth Token for \"US\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "US",
      "offset": 40
    }
  ],
  "location": "LoginValidationSteps.generateMuleAuth(String)"
});
formatter.result({
  "duration": 4351901539,
  "status": "passed"
});
formatter.after({
  "duration": 2815396570,
  "status": "passed"
});
});