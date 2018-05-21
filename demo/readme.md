Request-type=GET
http://localhost:2018/greeting
Param: N/A

Response
{
   "id": 1,
   "content": "Hello, World!"
}
--------------
Request-type=GET
http://localhost:2018/greeting
Param: ?name=test

Response
{
   "id": 2,
   "content": "Hello, test!"
}

----------
Method argument resolver
Assign value which are match to the Object based on the method Arguments

POST
http://localhost:2018/greeting

Request
{
   "idd": -155,
   "contentt": "GreetingAnother"
}

Response
{
   "idd": -155,
   "contentt": "GreetingAnother",
   "greet": null
}
====
request
{
   "idd": -155,
   "contentt": "GreetingAnother1"
}

response
{
   "idd": 0,
   "contentt": "GreetingAnother_Blank",
   "greet": null
}
===

request 
{
   "idd": -155,
   "contentt": "GreetingAnother",
   "greet": {
   		"id":100,
   		"content":"TEST"
   	}
}
response
{
   "idd": -155,
   "contentt": "GreetingAnother",
   "greet":    {
      "id": 100,
      "content": "TEST"
   }
}
-----------------------
Convertor:- string to Object (StringToGreetingConverter)

GET
http://localhost:2018/string-to-greeting
param: ?greet=101,conent
Response
{
   "id": 101,
   "content": "conent"
}


====
Convertor:- string to Object (GreetingCustomerSSNConverter)

POST
http://localhost:2018
/greetingCustomerSSN
?greetingCustomerSsn={    "id": 101,    "content": "conent","ssn":"123-456-789" }


{
   "id": 101,
   "content": "conent"
}
check sysout


====


 ConverterFactory, GenericConverter, and ConditionalGenericConverter
 

https://stackoverflow.com/questions/13048368/difference-between-spring-mvc-formatters-and-converters

Converters are used to convert one Java type to another Java type. For example, from Long to java.util.Date or from Integer to Color or from String to Date. 
It can be used in the web tier or any other tier that needs conversion service.

Formatters are used to convert String to another Java type and back. So, one type must be String.
You cannot, for example, write a formatter that converts a Long to a Date. Examples of formatters are DateFormatter, for parsing String to java.util.Date and formatting a Date.
In addition, formatters' messages can be localized.

Conclusion: formatters are suitable in the web environment, such as a Spring MVC application.



=====================

#Conversion Factory


http://localhost:2018
/userAdmin
?profileType=ADMIN

http://localhost:2018
/userEmployee
?profileType=Employee

