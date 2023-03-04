@smoke
Feature: hoverCategories 

  Scenario: Selecting one main category randomly then select sub  category randomly
  
    When Select Random Category
    Then Assert On Actual Result