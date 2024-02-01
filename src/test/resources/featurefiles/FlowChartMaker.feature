@Flowchart_TC
Feature: FlowChartMaker TestCases



#Supported shapes:circle,cloud,Diamond,RoundRectangle,Process,Hexagon

@TC_1
Scenario Outline: Verify that a user can create a flowchart with the sequence: Start > Read A > Read B > Calculate C + A = B > Print C > End
Given the user opens the flowchart application 
When the user draws a flowchart by selecting <shape_1>, <shape_2>, <shape_3>, <shape_4>, <shape_5>, and <shape_6>
And the user enters <text_1> inside <shape_1>, <text_2> inside <shape_2>, <text_3> inside <shape_3>, <text_4> inside <shape_4>, <text_5> inside <shape_5>, and finally <text_6> inside <shape_6>
Then the user verifies that the flowchart is created


Examples:
|shape_1|shape_2|shape_3|shape_4|shape_5|shape_6|text_1|text_2|text_3|text_4|text_5|text_6|
|circle|cloud|Diamond|RoundRectangle|Process|Hexagon|Start|Read A|Read B|Calculate C + A = B|Print C|End|


@TC_2
Scenario Outline: Verify that a user can delete a flowchart with the sequence: Start > Read A > Read B > Calculate C + A = B > Print C > End
Given the user opens the flowchart application 
When the user draws a flowchart by selecting <shape_1>, <shape_2>, <shape_3>, <shape_4>, <shape_5>, and <shape_6>
And the user enters <text_1> inside <shape_1>, <text_2> inside <shape_2>, <text_3> inside <shape_3>, <text_4> inside <shape_4>, <text_5> inside <shape_5>, and finally <text_6> inside <shape_6>
#Then the user verifies that the flowchart is created
And the user deletes the flowchart and verifies that the flowchart is not available

Examples:
|shape_1|shape_2|shape_3|shape_4|shape_5|shape_6|text_1|text_2|text_3|text_4|text_5|text_6|
|circle|cloud|Diamond|RoundRectangle|Process|Hexagon|Start|Read A|Read B|Calculate C + A = B|Print C|End|

@TC_3
Scenario Outline: Verify the text inside a flowchart with the sequence: Start > Read A > Read B > Calculate C + A = B > Print C > End
Given the user opens the flowchart application 
When the user draws a flowchart by selecting <shape_1>, <shape_2>, <shape_3>, <shape_4>, <shape_5>, and <shape_6>
And the user enters <text_1> inside <shape_1>, <text_2> inside <shape_2>, <text_3> inside <shape_3>, <text_4> inside <shape_4>, <text_5> inside <shape_5>, and finally <text_6> inside <shape_6>
Then the user verifies that the flowchart is created
And the user verifies that the text inside the flowchart shapes is correct


Examples:
|shape_1|shape_2|shape_3|shape_4|shape_5|shape_6|text_1|text_2|text_3|text_4|text_5|text_6|
|circle|cloud|Diamond|RoundRectangle|Process|Hexagon|Start|Read A|Read B|Calculate C + A = B|Print C|End|