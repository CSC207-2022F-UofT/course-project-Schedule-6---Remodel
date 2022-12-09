# Schedule 6

Schedule 6 is a schedule, and task manager application. Users are able to import their calendars and add events in the schedule manager. Task manager enables users to create, edit, and delete tasks.

Students can use this application to enter class schedules, events, and assignments in order to keep track of their tasks. With this program students are able to access all of their calendar events and tasks from one place.

# Group members
- Nizar Abdouss([@nizarabdouss](https://github.com/nizarabdouss))
- Steven Li([@stevenli-uoft](https://github.com/stevenli-uoft))
- Selena Wang([@slnwang](https://github.com/slnwang))
- Tammy Wang([@TammyZhuoWang](https://github.com/TammyZhuoWang))
- Mike Wang([@mikewzh418](https://github.com/mikewzh418))
- Tristen White([@Tristenwhite](https://github.com/Tristenwhite))
- Brian Xue([@Bri-xX](https://github.com/Bri-xX))

# 1 Entities 

## Entities.User
The User entity stores information about individual schedule 6 users.
### Attributes
* `userName`
* `password`
## Entities.Entry
The Entry entity stores information on each individual event created by the User.
### Attributes
* `title`
* `StartDate`
* `EndDate`
* `startTime`
* `endTime`
## Entities.Task
The Task entity stores information on each individual task created by the User.
### Attributes
* `description`
* `date`
* `category`

# 2 Usecases
## Event 
### Functions
* `create()`
    * Creates an instance of Event 
* `loadEvents()`
    * Fetches & Loads existing events in the DataBase
## Import
### Functions
* `create()`
    * Creates events based on the imported Ics file
## Task 
### Functions
* `create()`
* `loadTasks()`
## User
### Functions
* `loginCheck()`
* `create()`

# 3 Database
## MongoDB
## Data structure
## Data storage
## Data access

# 4 User Interface (UI)
## User login
![Picture of login](image/login.png)
## User registration
![Picture of registration](image/registration.png)
## Schedule
![Picture of schedule](image/schedule.png)
## Import schedule
![Picture of login](image/####.png)
## Add event
![Picture of adding event](image/addEvent.png)
## Edit event
![Picture of editing event](image/editEvent.png)
## Delete event
![Picture of deleting an event](image/delEvent.png)
## To-do list
![Picture of login](image/####.png)
## Add task
![Picture of login](image/task.png)
## Edit task
![Picture of login](image/editTask.png)
## Delete task
![Picture of login](image/####.png)

# 5 Project installation

# 6 Running the project
