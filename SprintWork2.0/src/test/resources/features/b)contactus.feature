Feature: Contact us
Scenario: The user enters contact page
Given the user views the contact page "<SheetName>" and <RowNumber>
When he enters valid details 
Then he submits the contact details

Examples:
|SheetName|RowNumber|
|contactus_valid|0|


Scenario: The user enters contact page with invalid details
Given The user views the contact page "<SheetName>" and <RowNumber>
When he enters invalid details
Then He submits the contact details

Examples:
|SheetName|RowNumber|
|contactus_invalid|0|




