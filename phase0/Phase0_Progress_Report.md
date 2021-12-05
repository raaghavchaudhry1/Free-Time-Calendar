# Phase 0 Progress Report

### **Specification**
Program will allow you to either login or create a new user. If the user decides to login, the program will verify the inputted credentials are correct. Once logged in the user will be allowed to import a calendar file into the program or manually add/remove events from the user's calendar. The user will then be able to create, join, or leave a group as well as see the times and day all studentBuilders in a group are available for work, study, or a meeting.

### **CRC Cards**

We have five entity classes:

1. **Calendar**: Stores and keeps track of a single Student’s schedule using CalenderEvent and OneOffEvent objects.
2. **CalenderEvent**: Contains the start time, end time, duration, and name of a recurring event.
3. **OneOffEvent**: Child class of CalendarEvent for events that only occur on a single date.
4. **Group**: Contains all the studentBuilders that belong to this group.
5. **Student**:  Represents a single user and keeps track of a user’s login details as well as the user’s schedule using a Calendar object.

We also have four use case classes:
1. **CalendarManager**: Interacts with a Student’s calendar to add and remove events.
2. **EventCreator**: Creates events as CalenderEvent and OneOffEvent objects.
3. **GroupManager**: Keeps track of all Groups created as well as adding and removing Students from a Group object.
4. **StudentManager**: Creates new users as Student objects as well as keeping track of all Student’s created.

And finally we have three controller classes:
1. **FreeTimeCalculator**: Uses the GroupManager, EventCreator, and CalendarManager classes to generate the times a group of studentBuilders are free at the same time.
2. **GroupController**: Uses GroupManager to add and remove studentBuilders from a Group object.
3. **LogIn**: Uses the StudentManager class to validate login credentials.

### **Scenario Walkthrough**

A user will start by logging in to the program. The user will start inputting recurring and single events, the program will then create and add these events to the studentBuilder's calendar. These events will then be stored in their personal calendar. The user will then ask the program to display the user's calendar. Afterwards, the program will ask if the user wishes to create or join a new group.

### **Skeleton Program**
We have a main command line interface from which the user of the program will be interacting with. Upon starting the program you will be given the option of logging or creating an account. The main program will also allow the user to add events to a calendar and create and join users. If the user decides to login, the program will use the LogIn class to validate the user’s credentials. If the user decides to create a new account instead, it will use the StudentManager class to create a new Student Object. This Student object contains a studentBuilder’s info and stores a Calendar object. We’ve implemented a Calendar class which stores a studentBuilder’s schedule using CalendarEvent & OneOffEvent objects. CalendarEvent represents a recurring event and OneOffEvent represents a single event. Both classes store an event’s info, such as start time, end time, duration and either a day of the week for recurring events or a date for a single event. When a user inputs a new recurring or single event in the program, the program will use the EventCreator class to create a new CalendarEvent or OneOffEvent object. The program will then use the CalendarManager class to add or remove events from a studentBuilder’s calendar. If a user decides to create or join a group, the program will call upon the GroupManager class to create a new Group object. If the user decides to join or leave a group, the GroupManager will also be used to add or remove a studentBuilder from a group. The Group object keeps track of all the studentBuilders in the group. And finally, we have a FreeTimeCalculator class which generates the time(s) a group of studentBuilders are free at the same time.

### **Completed Tasks**
Vergil & Gilbert implemented the Calendar, CalendarManager, and FreeTimeCalculator classes.

Raaghav & Cathlyn implement the GroupController, EventCreator, GroupManager, CalendarEvent, and OneOffEvent classes.

Tajwaar & Rashid implemented the LogIn, Group, Student, and StudentManager classes.

Raaghav, Gilbert, and Rashid implemented the main commandline interface.

Cathlyn wrote the UnitTests for Phase 0.

### **Future Tasks**
Vergil & Gilbert will implement error checking for the current classes and implement new features in FreeTimeCalculator to handle more use cases.

Raaghav & Cathlyn will implement a stats tracking feature that will keep track and compute different kinds of status for the studentBuilders/group.

Tajwaar & Rashid will begin implementing a basic GUI for the basic tasks of the program.

### **Code Design**
Following the SOLID and Clean Architecture design principles in our initial design phase has made it easier to implement specific functions and classes without intimate knowledge of the implementation details of the other classes. This has allowed our group to implement our classes concurrently, leading to a more efficient workflow.

### **Current Concerns**
What are some general guidelines on how to best package our program? What are some pitfalls to watch out for when packing a program?