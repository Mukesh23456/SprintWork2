Feature: Contact us
Scenario: The person Enters contact page
Given The person views the contact page "<SheetName>" and <Row>
When He gives the valid details
Then He submits the valid contact details

Examples:
|SheetName|Row|
|contactus_valid|0|

Scenario: The Person enters contact page
Given the Person views contact page "<SheetName>" and <Row>
When He gives the invalid details
Then He submits the invalid contact details

Examples:
|SheetName|Row|
|contactus_invalid|0|
|contactus_invalid|1|
|contactus_invalid|2|
|contactus_invalid|4|