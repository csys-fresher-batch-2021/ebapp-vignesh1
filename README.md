#Electricity Bill Calculator

Feature 1:

      ->Get Number Of List,
      
      -> Test case Included(DisplayTestCase).
 
Feature 2:

      -> PerUnitPrice and Generate Total Bill,
      
         I will change the code to database in next sprint
         
         static vaules:
         
         Type              Units            PerUnitPrice
         Home              0-100              0.0
                           101-400            20.0
                           401-1000(max)      30.0
                           
         Commercial        0-100              10.0
                           101-400            40.0
                           401-1000(max)      60.0
                           
         Agriculture       0-100              5.0
                           101-400            10.0
                           401-1000(max)      20.0
                           
    -> Test case Included(PerUnitTestCase),
    
    -> Test case Included(TotalBillTestCase).

Feature:3 

        ->Admin Login.

         Admin CustomerId:
               Admin1,
               Admin2.

         Admin password:
              Admin@123.

Feature:4 

     Register User.

    - >RegistrationValidation
       name:^[a-zA-Z+\\s]+$
       mobile number:(0/91)?[7-9][0-9]{9}
       consumer No:[0]{1}[1-9]{1}[0-9]{10}(Eg:033490032324)
       customer Id:^[a-zA-Z]([._-](?![._-])|[a-zA-Z0-9]){4,15}[a-zA-Z0-9]$
       password:^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^)])(?=\\S+$).{8,20}$
   
Feature:5 

     User login.

    ->UserValidation


