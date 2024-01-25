
Feature: FlowChartMaker TestCases



#Supported shapes:circle,rectangle,Diamond,RoundRectangle,Process,Hexagon

@TC_1
Scenario Outline: Creating flowchat based on process Start > Read A > Read B > Calculate C + A = B > Print C > End
Given the user opens flowchart application 
When the user draw a flowchart by picking up <shape_1> and <shape_2> and <shape_3> and <shape_4> and <shape_5> and <shape_6>
And the user enter <text_1> inside <shape_1> and <text_2> inside <shape_2> and <text_3> inside <shape_3> and <text_4> inside <shape_4> and <text_5> inside <shape_5> finally <text_6> inside <shape_6>
Then the user verify flowchart is created 
And the user delete flowchart and verify flowchat is available 

Examples:
|shape_1|shape_2|shape_3|shape_4|shape_5|shape_6|text_1|text_2|text_3|text_4|text_5|text_6|
|circle|rectangle|Diamond|RoundRectangle|Process|Hexagon|Start|Read A|Read B|Calculate C + A = B|Print C|End|


