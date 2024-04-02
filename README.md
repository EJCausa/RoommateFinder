# RoommateFinder
TO-DO DURING NEXT MEETING:

-RELOCATE ALL PAGE VARIABLES FROM CONTROLLER TO MAIN

-RELOCATE PRINT PAGE FUNCTION FROM CONTROLLER TO MAIN

-CREATE A METHOD TO LET CONTROLLER ACCEPT A STRING FROM MAIN AND THEN DO STUFF

-RENAME MAIN.JAVA TO UI.JAVA

-CREATE A SKELETAL DBOPS.JAVA FILE (CLASS DECLARATION AND COMMENTS LISTING FURTHER TO-DOS SHOULD BE ENOUGH)

-CREATE ADDITIONAL SKELETAL HANDLERS AS NEEDED?

-REVIEW CLASS DIAGRAM

-CHECK IF ANY COMMENTS OUTSTANDING FROM LAST DELIVERABLE



We should not do the first 4 points listed.

Currently, the main is not a UI class. It only handles user input. To display the UI, it is calling methods from the Controller class.

I think it should stay this way so that it follows the Single Responsibility design principle.
It makes more sense to handle user input and UI display in separate classes, rather than combining both into Main.java

Slide 3 of the Design Concepts slides says that a "UI class that implements logic" is an example of bad cohesion.

The only things in the Controller class right now are UI strings and methods to print them. Maybe we should rename Controller.java to UI.java?




