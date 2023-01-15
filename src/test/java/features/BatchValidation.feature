Feature: Validating Batch API

Scenario Outline: Varify if  Batch is  successfully created using CreateBatchAPI 
	Given Add Batch Payload with "<creationTime>" , "<lastModTime>","<batchName>","<batchDescription>","<batchNoOfClasses>","<programId>"
	When User call "CreateBatchAPI" with "POST" request
	Then responce API call got success with status code 201
	And  "batchName" in response body is "Jan23-ABC-SDET-SDET57-002"
	And verify "BatchId" created maps with "<batchName>" using "getBatchById"
	
	Examples:
	|creationTime|lastModTime|batchName|batchDescription|batchNoOfClasses|programId|
	|		null		|	null				|		null	|	null					|null							|	null		|
#	|			null	|			null		|		null	|		null				|		null					|	null		|


#Scenario: Update Batch By Name (Modify 1st batch) and do necessary validations
 #Given A
 #When
# Then


#Scenario: Delete Batch By Id (Delete any batch) and do necessary validations
#	Given
#	When User call "DeleteBatchIDAPI" with PUT request
#	Then
	



#Scenario: Get Batches By Id do necessary validations
#	Given
	#When
#	Then
	