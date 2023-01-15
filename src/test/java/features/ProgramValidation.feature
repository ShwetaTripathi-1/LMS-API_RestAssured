 Feature: Validating Program API
 
 Scenario Outline: Verify if place is being successfully added using SaveProgramAPI
 Given Add Program  payload with "<programName>"  "<programDescription>"  "<programStatus>" "<creationTime>" "<lastModTime>"
 When User calls "AddProgramAPI" with Post request
 Then API call got success with status code 200
 And "Status" in response body is "OK"
 And Verify program created maps to details: "programName" , "programDescription" and "programStatus" using "GetProgramId"
 
 Examples:
 | programName | programDescription | programStatus | creationTime | lastModTime|
 |             |                     |               |              |            |
 |             |                     |               |              |            |
 
# Scenario: Verify If first program name is updated
 #Given Add program payload
 #When User call "UpdateProgramByNameAPI" with Put request
 #Then  API call success with status code 200
 #And Validate "programName"
 
#Scenario: Verify If Scecond program Id is updated
# Given Add program payload
 #When User call "UpdateProgramByIdAPI" with Put request
# Then  API call success with status code 200
 #And Validate "programId"
 
 #Scenario: Varify we get details of all the program using GetAllProgramAPI
 #Given 	User enter the URL 
 #When 	User calls "AllProgramAPI" with Get Http request
 #Then The API call is success with status code 200
 #And User see list of all program as response body
 
 
 