<img src="https://i.goopics.net/ip4368.png" alt="drawing" width="300" heigth="300"/> 

Library Project
==============================================================

Description
--------------------------------------------------------------

First of all, this application was realized in binomial as part of a database project of the second semester of DUT Informatique at the IUT of Vélizy.
The aim of this project was to develop an application serving as an intermediary between users (librarian and students) and a library whose data are stored in a database. This project is coded in Java and uses a JDBC driver to access a database managed with PL/SQL.

Visuals
--------------------------------------------------------------

Here are some screenshots of the application.

![image_connection][login]
![image_search][search]
![image_reservation][booking]
![image_add_book][add_book]
![image_pret_book][book_ready]
![image_rendu_livre][book_return]
![image_delay][delay]
![image_account_management][account_management]

Installation
--------------------------------------------------------------

Here are the different steps necessary to use the application. I would like to point out that to run the project, it is necessary to have Java and JDK installed, and to have a database manager. Moreover, the project is executable on any operating system. 

##### First step

You must download the application file. To do this click on the Github logo below.

[<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/9/91/Octicons-mark-github.svg/2048px-Octicons-mark-github.svg.png" alt="drawing" width="40" heigth="40"/>](https://github.com/arthurpellegrini/library_project)

Then go to the green "code" button and select "download zip".

##### Second step

![image1][import_csv]

You need to rebuild the database using the files in the PL/SQL folder. 
Then modify the connection identifiers in the code, in the constructor of the Jdbc class. 
Finally, we will have to add the JDBC driver, it is in the lib folder, and it is called class12.jar. To do this, you must add it to the "BuildPath" of your project.

##### Third step

You will have to run the application. To avoid you to search, I specify that the main method is in the file WindowConnection.java. To do this, you must compile and then run the project. If everything went well, the application should have launched, you just have to test our application!

Usage
--------------------------------------------------------------

When you launch the application, you must connect to an account in the database. Then you have access to different features depending on whether you have logged in with a student or a librarian account. 

The only functionality in common with these two types of account is the search for a book according to search criteria.
A student account can also reserve a book. 
A librarian account can accept a book reservation, make a reservation into a loan, and record the return of a book in the database. In addition, a librarian account also allows for the display of out-of-date loans, the addition of new books, and the management of student accounts.

Support
--------------------------------------------------------------

If you have a question or a problem, do not hesitate to contact us at the following email address: arthur.pellegrini2002@gmail.com

Roadmap
--------------------------------------------------------------

* Fix known bugs
* Prevent borrowing of a book already borrowed
* Fix the number of copies for each book
* Improve the application's interface


Contributions
--------------------------------------------------------------

We welcome all kinds of contributions. People can propose changes through Github by submitting commits.

Authors and thanks
--------------------------------------------------------------

The authors of this project are the following: 

* GACHE Antoine 
* PELLEGRINI Arthur

We would also like to thank the following people for their help in developing this application: 

* DELORME Nathan
* LENFANTIN Alexandre
* ZEITOUNI Karine

Project status 
--------------------------------------------------------------

The development of this project was stopped after it was submitted to our University jury. But it is possible that the application will be improved afterwards.

[//]: # (Reference link used in the body of the Markdown)
[import_csv]: https://i.goopics.net/tt83jo.png
[login]: https://i.goopics.net/xtb3dv.png
[search]: https://i.goopics.net/2l2lu1.png
[booking]: https://i.goopics.net/ccb7zp.png
[add_book]: https://i.goopics.net/jfs74v.png
[book_ready]: https://i.goopics.net/do3i5s.png
[book_return]: https://i.goopics.net/eix6au.png
[delay]: https://i.goopics.net/0m8mvy.png
[account_management]: https://i.goopics.net/vvo51b.png
