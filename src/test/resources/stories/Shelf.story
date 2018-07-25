Shelf API Tests

Scenario:Create new shelf
Given API for creating new shelf '/shelves'
When create request is sent for shelf
Then shelf should be created
And Status code should be 200

Scenario:Read newly created shelf with specified id
Given API for shelf details '/shelves'
When Read request is sent for specified shelf
Then Fetch details for specified shelf
And Status code should be 200

Scenario:Read all shelves inside rack
Given API for shelf details '/shelves'
When Read request is sent for shelves
Then Fetch details for all shelves
And Status code should be 200

Scenario:Update data for specified shelf
Given API for shelf details '/shelves'
When Update request is sent for shelf
Then shelf data should get updated

Scenario:Remove Specified shelf from list of shelves
Given API for shelf details '/shelves'
When delete request is sent for specified shelf
Then shelf should get deleted
And Status code should be 200

