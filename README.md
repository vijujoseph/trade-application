# trade-application

Application download and setup
Git clone url : https://github.com/vijujoseph/trade-application.git <br />
Application use Maven Build, so follow the below steps: <br />
Maven -> Download sources <br />
Maven -> clean install (mvn clean install) <br />

Trade Application contains two projects as below:
1. Front-Office-Application: All the incoming trades are initially sent to Front-Office-App. This app transfer the message to rabbit MQ to process it further.

   API Specification is below:
   Trade Order POST: http://localhost:8080/trade/order  <br />
   ~~~~e.g)
   http://localhost:8080/trade/order
   
   Request Body:
    {
      "tradeId": "T3",
      "version": "3",
      "counterPartyId": "CP-3",
      "bookId": "B3",
      "maturityDate": "1621891595261",
      "createdDate": "1621891595261",
      "expired": true
    }

2. Back-Office-Application: This app is a consumer app which will consumes all the trades in trade-queue. The data will be initiated by Front-Office-App. 

   API Specification is below:
   GET: http://localhost:8081/trade/orders
   
   ~~~~e.g)
   GET: http://localhost:8081/trade/orders
   
   Response Body:
      [
         {
            "id":1,
            "tradeId":"T3",
            "version":"3",
            "counterPartyId":"CP-3",
            "bookId":"B3",
            "maturityDate":"2021-05-24T21:26:35.261+00:00",
            "createdDate":"2021-05-25T14:49:56.321+00:00",
            "expired":true
         },
         {
            "id":2,
            "tradeId":"T4",
            "version":"4",
            "counterPartyId":"CP-4",
            "bookId":"B4",
            "maturityDate":"2021-05-24T21:26:35.261+00:00",
            "createdDate":"2021-05-25T15:12:56.702+00:00",
            "expired":true
         },
         {
            "id":3,
            "tradeId":"T4",
            "version":"4",
            "counterPartyId":"CP-4",
            "bookId":"B4",
            "maturityDate":"2021-05-24T21:26:35.261+00:00",
            "createdDate":"2021-05-25T15:12:58.949+00:00",
            "expired":true
         }
      ]
