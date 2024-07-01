Feature: Validate Place APIs

@AddPlace
Scenario Outline: Verify if place is added successfully using AddPlace API
				Given Add place Payload with "<name>" "<language>" "<address>"
				When User calls "AddPlaceAPI" with "Post" with http request
				Then The API call got success with status code 200
				And "status" is response body is "OK"
				And "scope" is response body is "APP"
				And verify place_Id created maps to "<name>" using "getPlaceAPI"
				
Examples: 
		|name   |language|address|
		|AAhouse|Telugu  |Hoodi|
#		|BBhouse|Kannada |Hoodi  |

Scenario: Verify if Delete Place functionality is working 

				Given DeletePlace Payload
				When User calls "DeletePlaceAPI" with "Post" with http request
				Then The API call got success with status code 200
				And "status" is response body is "OK"