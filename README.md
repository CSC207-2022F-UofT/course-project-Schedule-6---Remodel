# Schedule 6

SSchedule 6 is a timetable, and task manager application. Users are able to import their calendars, add, edit, and delete events on the timetable. The To-do list enables users to create, edit, and delete tasks.

Students can use this application to enter class schedules, events, and assignments in order to keep track of their tasks. With this program, students are able to access all of their calendar events and tasks from one place and across multiple devices.

# Group members
- Nizar Abdouss([@nizarabdouss](https://github.com/nizarabdouss))
- Steven Li([@stevenli-uoft](https://github.com/stevenli-uoft))
- Selena Wang([@slnwang](https://github.com/slnwang))
- Tammy Wang([@TammyZhuoWang](https://github.com/TammyZhuoWang))
- Mike Wang([@mikewzh418](https://github.com/mikewzh418))
- Tristen White([@Tristenwhite](https://github.com/Tristenwhite))
- Brian Xue([@Bri-xX](https://github.com/Bri-xX))

# Project installation
## Mac User Font Download
Mac users need to download a font in order for the program to display properly. To do so, download the [Gill Sans MT Condensed font](https://www.dafontfree.net/gill-sans-mt-condensed-regular/f64848.htm). To add the font into the system, open Font Book through spotlight search (command + space) and find the plus button to add a new font. This will pull up a Finder window where the downloaded font can be selected and opened. Gill Sans MT Condensed will appear in the “User” section of Font Book

# Running the project
To run our project run `Main` in `src/main/java/main`

# User Interface (UI)
## User registration and login
<img src="https://github.com/CSC207-2022F-UofT/course-project-Schedule-6---Remodel/blob/main/image/login.png" width=50% height=50%>
On the login page, a first time user would need to register an account by clicking on the registration button, which opens up the registration page.

<img src="https://github.com/CSC207-2022F-UofT/course-project-Schedule-6---Remodel/blob/main/image/registration.png" width=50% height=50%>
After an account is created, the user can re-enter their username and password to login.


## Dashboard
![Picture of schedule](image/schedule.png)
After logging in, the dashboard as seen above will show up. This dashboard contains the users timetable and to-do list. The first time a user logs in, both the timetable and to-do list will be empty, but an existing user who already has events and tasks saved, will see those same events and tasks show up on the timetable and to-do list when they log back in.
## Events
Users are able to add events in two ways:
1. While in week view, users can directly click on any time of a day, and drag how long they would want their event to be.
2. Click on the “ADD FUTURE EVENT” button on the top right, and a screen would pop up allowing users to input the required info for an event they want to create (as shown below).
<img src="https://github.com/CSC207-2022F-UofT/course-project-Schedule-6---Remodel/blob/main/image/addEvent.png" width=50% height=50%>

## Editing and deleting events
To edit an event, user can double click an event on the timetable, and make their required edits to the event, as seen in the screenshot below
![Picture of editing event](image/editEvent.png)
To delete an event, users can select an event, and click the delete button on their keyboard.
![Picture of deleting an event](image/delEvent.png)

## Saving events
To save any changes made to the Timetable, press the “SAVE” button at the top of the timetable screen, beside the “ADD FUTURE EVENT” button.

## Import
If a user has an existing calendar that can be downloaded as an ICS file, users are able to import an ICS file to our project and have those events appear on their timetable.


## Tasks
The list of tasks is sorted by oldest to newest task added by default. If a user wants to sort their tasks, the user can click the headers at the top of the table. If the user clicks a header once, it will sort the tasks in an ascending order (0-9, then A-Z). If the user clicks a header again, it will sort the tasks in a descending order (Z-A, then 9-0). The third click will return the table to its default view. 

## Add task
<img src="https://github.com/CSC207-2022F-UofT/course-project-Schedule-6---Remodel/blob/main/image/task.png" width=50% height=50%>
To add a new task, the user can input the description, category and date of the task in the space above the To-Do List table in the prompted text fields. To add the task to the table, the user can click the “ADD” button below their inputs. 

## Edit task
<img src="https://github.com/CSC207-2022F-UofT/course-project-Schedule-6---Remodel/blob/main/image/editTask.png" width=50% height=50%>
To edit a task, the user can double click the description or the category of the task they want to edit. To finish editing, the user can press enter on their keyboard. 

## Delete task
To delete a task, the user can select the task they wish to delete by clicking on it and pressing the “DELETE” button at the top of the page. The selected task will be highlighted blue.

## Saving tasks
To save any changes made to the Tasks list, press the “SAVE” button at the top of the screen.


