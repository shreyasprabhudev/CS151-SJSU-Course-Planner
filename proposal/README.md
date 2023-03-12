Project Title: SJSU Course Planner 
Team #5: Natalie Kao, Jisoo Kim, Shreyas Prabhudev
Team member working on the proposal: Natalie Kao, Jisoo Kim, Shreyas Prabhudev

Problem/issue to resolve: 
SJSU students need a better way to plan and organize their courses to complete their degree requirements efficiently, where all the information can be found at one place.  
	
Previous works : 
There are some existing course planning websites that provide similar functionality. However, they may not be tailored to the specific needs and requirements of the college or university. Currently, through myPlanner, adding and taking out classes are taking too long to process and are not flexible to move around, and Professor names are not displayed for each course.
Existing solution exists in MySJSU

Assumptions / Operating Environments / Intended Usage:
The course planning website will be designed for SJSU students, but faculty members can also have access to it as well. The website will be accessible via a web browser and the website will be integrated with the SJSU course catalog. Log-ins are required depending on if you are a student or faculty member. 

High-level description of Solution (plan, approach, etc) 
The proposed course planning website will provide a comprehensive platform for students to plan and organize their courses. Some features include course catalog, course descriptions, Syllabus, Professor names, course availability information, and course planning tools. We will be using OOP concepts including inheritance, to extend information from a base class (Administration) to sub classes, Student, Professors, and Advisors and implement methods, and also polymorphism, abstraction, and encapsulation to create our methods and classes.

Functionality:
Our website provides a quicker and more efficient platform for students to see all the class description, availability, syllabus, and pre reqs before adding the class. For example, students will no longer need to email specific professors to figure out if he/she is teaching that specific class or research separately to find syllabus. It will add, update, and delete students, professors, subjects/classes and be up to date if any changes are made. 
One unique function that this planner has is that the user can drag-and-drop their classes into certain “slots” for every semester, allowing them to visually see which required classes they have added and which ones they have left. The drag-and-drop feature allows them to quickly and seamlessly make edits to their schedule.

Operations:
Potential Classes [1]:
Administration: oversees the entire course planner and has access to all permissions to edit professors and/or students
Advisor: can assist students with planning out courses by editing their plans but has no additional permissions
Student: can edit their own course plan but has no additional permissions
Professor: can edit the courses they are teaching but does not have any other permissions
Special Operation: drag-and-drop feature for each student according to their major to see which classes are mandatory to take. 

As students, they will be able to: 
See the list of courses that are organized by department and course number
See detailed information about each course
Includes prerequisite, objectives, required texts, when the course is offered (Fall, Winter, Spring, Summer), and units. See past syllabus for each course & Professor’s name for each course. Total estimate amount of seats available for each course 
Able to see mandatory classes left to take in order to graduate (drag & drop feature)
Add and delete courses 
Have student ID for login and password (attribute), enter estimate graduation sem/year
Able to see who their assigned advisor is depending on student’s last 2 digit of their ID

As professors, they will be able to: 
Have teacher ID for login and password 
Update their name under the course that they will be teaching (past records will be default)
Have ability to add their syllabus and required text
See all the courses offered for each department 

As advisors, they will be able to: 
Have advisor ID for login and password 
Have access to a page to enter one specific Student ID number 
Allow edits to happen for that specific student 
See all the assigned students planner 
See all the courses offered for each department 

As administrations, they will be able to: 
Have administration ID for login and password 
Ability to create/delete accounts for professors, students, and advisors 
Ability to add/delete courses
As well as all the required information for each courses: prerequisite, objectives, required texts, when the course is offered, and units
Ability to add Professors under each courses
Ability to see and edit all student’s planner 

Other References:
[1] https://1000projects.org/course-planning-project-java.html
