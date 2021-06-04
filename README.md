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
   
Feature:5 

     User login.

    ->UserValidation

