# send email
```
1. http://localhost:8081/api/ns/email(POST)
Request body
{
    "receiver":"chandra2khadka4@gmail.com",
    "subject":"eSewa Transaction Notification",
    "properties":{
        "recipientName":"chandra khadka",
        "productName":"TOPUP",
        "transactionDate":"2020-01-12",
        "transactionId":"TX2021",
        "transactionAmount":"200",
        "viewMoreUrl":"https://esewa.com.np"
    }
}   
``'