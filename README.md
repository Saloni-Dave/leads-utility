API1 : POST http://localhost:8080/api/leads/create
Request : 
{
    "leadId": "123456",
    "firstName": "Saloni",
    "middleName": "",
    "lastName": "KV",
    "mobileNumber": "6234567890",
    "gender": "Male",
    "dob": "18/12/1997",
    "email": "v@gmail.com"
}

Response : 
{"status":"success","data":"Created Lead Successfully"}


API2 : GET http://localhost:8080/api/leads/fetch/7976632968
{"status":"success","data":[{"leadId":1,"firstName":"Saloni","lastName":"Dave","middleName":"S","mobileNumber":"7976632968","gender":"Female","dob":"1997-03-18","email":"saloni.dave@gmail.com"}]}
