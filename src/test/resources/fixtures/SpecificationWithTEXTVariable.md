
### [Example 1](- "example 1")

Given the input messages:
 
| [input][][Item][itemIM] | [Message Id][messageIdIM] | [Version Id][versionIdIM] | [Rate][rateIM] | [Quantity][quantityIM] |
|:-----------------------:|:-------------------------:|:-------------------------:|:--------------:|:----------------------:|
|            1            |            12355          |             1             |       2        |         100            |
|            2            |            12356          |             1             |       3        |         200            |
|            3            |            12357          |             1             |       3        |          0             |

[input]: - "#inputMsg=generateInputMessage(#TEXT)"
[itemIM]: - "inputMessagesList.add(#inputMsg)"
[messageIdIM]: - "#messageId"
[versionIdIM]:  - "#versionId"
[rateIM]:  - "#rate"
[quantityIM]:  - "#quantity"

When the messages are published [successfully](- "?=publishInputMessages(inputMessagesList)") and [processed](- "processMessages()")     
Then [consume](- "#outputMessages=consumeOutputMessages()") the output messages and verify the that the values match the ones from below table:   

| [output][][Item][itemOM] | [Message Id][messageIdOM] | [Version Id][versionIdOM]] | [Total][totalOM]] | [Status][statusOM]] |
|:------------------------:|:-------------------------:|:--------------------------:|:-----------------:|:-------------------:|
|            1             |          12355            |             1              |       200         |     PROCESSED       |
|            2             |          12356            |             1              |       600         |     PROCESSED       |
|            3             |          12357            |             1              |        0          |     UNPROCESSED     |

[output]: - "#outputMsg=getOutputMessage(#outputMessages, #messageId)"
[itemOM]: - "#itemOM"
[messageIdOM]: - "#messageId"
[versionIdOM]:  - "?=#outputMsg.getVersionId()"
[totalOM]:  - "?=#outputMsg.getTotal()"
[statusOM]:  - "?=#outputMsg.getStatus()"

### [Example 2](- "example 2")

Given the input messages:
 
| [input][][Item][itemIM] | [Message Id][messageIdIM] | [Rate][rateIM] | [Quantity][quantityIM] | [Version Id][versionIdIM] |
|:-----------------------:|:-------------------------:|:--------------:|:----------------------:|:-------------------------:|
|            1            |            57355          |       2        |         100            |             1             |
|            2            |            57356          |       3        |         200            |             1             |
|            3            |            57357          |       3        |          0             |             1             |

[input]: - "#inputMsg=generateInputMessage(#TEXT)"
[itemIM]: - "inputMessagesList.add(#inputMsg)"
[messageIdIM]: - "#messageId"
[versionIdIM]:  - "#versionId"
[rateIM]:  - "#rate"
[quantityIM]:  - "#quantity"

When the messages are published [successfully](- "?=publishInputMessages(inputMessagesList)") and [processed](- "processMessages()")     
Then [consume](- "#outputMessages=consumeOutputMessages()") the output messages and verify the that the values match the ones from below table:   

| [output][][Item][itemOM] | [Message Id][messageIdOM] | [Version Id][versionIdOM]] | [Total][totalOM]] | [Status][statusOM]] |
|:------------------------:|:-------------------------:|:--------------------------:|:-----------------:|:-------------------:|
|            1             |          57355            |             1              |       200         |     PROCESSED       |
|            2             |          57356            |             1              |       600         |     PROCESSED       |
|            3             |          57357            |             1              |        0          |     UNPROCESSED     |

[output]: - "#outputMsg=getOutputMessage(#outputMessages, #messageId)"
[itemOM]: - "#itemOM"
[messageIdOM]: - "#messageId"
[versionIdOM]:  - "?=#outputMsg.getVersionId()"
[totalOM]:  - "?=#outputMsg.getTotal()"
[statusOM]:  - "?=#outputMsg.getStatus()"