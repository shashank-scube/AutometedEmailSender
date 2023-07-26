# AutometedemailSender
=========================

Description:
-------------------------
AutometedEmailMultiSender is a Spring Boot-based web application that facilitates the sending of emails to multiple recipients using a custom HTML template. The application allows users to perform CRUD operations to manage recipient data and efficiently broadcast emails to a recipients.

Features:
-------------------------
- CRUD operations using Spring Boot for managing recipients.
- Sending emails using the gmail smtp properties in Spring Boot.
- Storing recipient data in MySQL database using JPA repository.

Prerequisites:
-------------------------
Before running the project, make sure you have the following installed:
- Add below dependency by using Spring Initializr
       -Spring Web(web)
       -Spring Data JPA(sql)
       -MySQL Driver(sql)
       -Thymeleaf(sql)
- For mail part you need to setup a smpt servieice susing your email or any other third-party smtp services provider.
- For the email  amtp setup fallow this
     1)Go to the Account Setting.
     2)setup the 2-step verification
     3)Scroll down in the 2-step verifiication you will find  App passwords;
     4)then you have to generate password which is used as you password in the application.propertices
      note:-save this passwd because its display only once .
    5)now you need to go to the gmail and settings in the setting you will find Forwarding and POP/IMAP
    6)hear you need to check the IMAP enable thats it. 

-Mysql setup


