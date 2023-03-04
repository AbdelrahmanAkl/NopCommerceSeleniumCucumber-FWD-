@smoke
Feature: display all products in the page with Euro sign

Scenario:    display all products int the home page with euro sign success.
   
Given     change currency to euro
When      scroll down to products
Then      check product in home page is diplayed with euro sign 

