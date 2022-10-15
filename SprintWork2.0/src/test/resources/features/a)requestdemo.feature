Feature: Request demo
Scenario: The user requests demo video
Given the user is in the request demo page "<SheetName>" and <RowNumber>
When he enters all details
Then he submits the details 

Examples:
|SheetName|RowNumber|
|rdemo_valid|0|

Scenario: The user requests demo video with invalid details
Given The user is in the request demo page "<SheetName>" and <RowNumber>
When He enters invalid details
Then He submits the details

Examples:
|SheetName|RowNumber|
|rdemo_invalid|0|
|rdemo_invalid|1|
|rdemo_invalid|2|
