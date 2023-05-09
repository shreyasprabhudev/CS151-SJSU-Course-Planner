# Project Title
SJSU Course Planner 

# Team Information
**Team #5:** Natalie Kao, Jisoo Kim, Shreyas Prabhudev <br />

**Proposal Contribution:** 
<br />Natalie Kao - Edited and updated final proposal. Completed Steps to run your code, solution, operations, state diagram, use case diagram.
<br />Jisoo Kim -  Completed steps to run the code, class diagram, and readme file for the first proposal where we explain what our diagrams represent. Helped edit the final proposal as well. Help come up with the operations and functionality of our project idea. 
<br />Shreyas Prabhudev - Created initial proposal for mid point check in and added in the sequence diagram as well as editing the other sections

**Presentation Contribution:** 
<br /> Natalie Kao - Create slides and talk about student operations
<br /> Jisoo Kim - Create slides and in charge of admin operations. Also in charge of the home page design with an image that has a path way to sign up and log in. 
<br /> Shreyas Prabhudev - Create slides and will discuss how the different pages interact and the operations for student and advisor

**Project Code Contribution:** 
<br />Natalie Kao - Implement majority of back end and MVC pattern, create StudentPage and implement methods for each selection 
<br />Jisoo Kim - Implemented majority of the front end (home page and admin page), implemented methods that each role can perform, helped with creating a login and sign up system that stores the user data into a txt file. Also worked on password exceptions to make sure that we have requirements to set up a strong password. 
<br />Shreyas Prabhudev - Implemented cross page functionality to sync the different login/signup views with the buttons and connect it to a text backend; validated user logins and created methods to read/write from files for users; created and wrote to individual files for the courses that each student takes and which ones they removed

**Report Contribution:** 
<br /> Natalie Kao - Created and made entire report; made use case and state diagrams
<br /> Jisoo Kim - Edited and fixed operations; made class diagram
<br /> Shreyas Prabhudev - Edited by adding assumptions and high-level description; made sequence diagram

# Problem/Issue to Resolve
SJSU students need a better way to plan and organize their courses to complete their degree requirements efficiently, where all the information can be found at one place.  
	
# Previous works
There are some existing course planning websites that provide similar functionality. However, they may not be tailored to the specific needs and requirements of the college or university. Currently, through myPlanner, adding and taking out classes are taking too long to process and are not flexible to move around, and Professor names are not displayed for each course.
Existing solution exists in [MySJSU](https://cmsweb.cms.sjsu.edu/psc/CSJPRD/EMPLOYEE/SA/c/NUI_FRAMEWORK.PT_LANDINGPAGE.GBL).

# Assumptions / Operating Environments / Intended Usage
The course planning website will be designed for SJSU students, but faculty members can also have access to it as well. The website will be accessible via a web browser and the website will be integrated with the SJSU course catalog. Log-ins are required depending on if you are a student or faculty member. 

# High-level description of Solution (plan, approach, etc) 
The proposed course planning website will provide a comprehensive platform for students to plan and organize their courses. Some features include course catalog, course descriptions, Syllabus, Professor names, course availability information, and course planning tools. We will be using OOP concepts including inheritance, to extend information from a base class (Administration) to sub classes, Student, Professors, and Advisors and implement methods, and also polymorphism, abstraction, and encapsulation to create our methods and classes.

# Diagrams
| File Name  | Summary    | 
| ---------- | ---------- | 
| [classDiagram.pdf](https://github.com/shreyasprabhudev/CS151-SJSU-Course-Planner/blob/main/diagrams/classDiagram.pdf) | UML class diagrams represent the structure of a system by showing the classes, their attributes, operations or methods, and the relationships among them. It illustrates the object-oriented programming concepts such as inheritance, abstraction, and association. Additionally, the UML class diagram also shows the access modifiers for class members such as public, private, and protected, which indicate the visibility and accessibility of the attributes and methods to other classes.  | 
| [useCaseDiagram.pdf](https://github.com/shreyasprabhudev/CS151-SJSU-Course-Planner/blob/main/diagrams/usecase%20diagram.pdf) | Use case diagrams represent the functional requirements of a system by illustrating the interactions between the system and its users or external entities. It is a sequence of actions performed by the user or the system to achieve a specific goal. The use case diagram depicts the users who interact with the system, use cases that the system provides, and the relationships between them. The users are represented as stick figures, while the use cases are represented as ovals. Their relationships are shown as solid lines, which indicates the communication or interaction between them. | 
| [stateDiagram.pdf](https://github.com/shreyasprabhudev/CS151-SJSU-Course-Planner/blob/main/diagrams/stateDiagram.pdf) | State diagrams represent the behavior of a system or an object by modeling its states and transitions between them. It states that the system can enter, depending on the user’s actions. They also depict the states as rectangles and transitions as arrows labeled with triggering events and conditions. It also includes entry and exit actions, composite states, and concurrent states. The purpose of the state diagram is to help understand the system’s dynamics and identify potential problems by modeling the behavior of complex systems. | 
| [sequenceDiagram.pdf](https://github.com/shreyasprabhudev/CS151-SJSU-Course-Planner/blob/main/diagrams/Sequence%20Diagram.pdf) | Sequence diagrams represent the interactions between objects in a system by illustrating the messages exchanged between them over time. To be more exact, it illustrates the interaction between the user, GUI, and system over time. The objects are shown in vertical lifelines and events (messages) as horizontal arrows between them. In this case, Students, Professors, Advisors, and Administrators are shown as the User. This diagram provides a dynamic view of the system’s behavior and is useful in system design, testing, and debugging. |


# Functionality
Our website provides a quicker and more efficient platform for students to see all the class description, availability, syllabus, and pre reqs before adding the class. It will add, update, and delete students, subjects/classes and be up to date if any changes are made. 

# Operations
As students, they will be able to: 
* See the list of courses that are organized by department and course number (drop down and scroll menu)
* Include course names, numbers, and units
* Able to see mandatory classes left to take in order to graduate 
* Add and delete courses 
* Have student ID for login and password (attribute)
* Able to see who their assigned advisor

As advisors, they will be able to: 
* Have advisor ID for login and password 
* Have access to a page to enter one specific Student ID number 
* Allow edits to happen for that specific student 
* See all the assigned students planner 
* See all the courses offered for each department 

As administrations, they will be able to: 
* Have administration ID for login and password 
* Ability to create/delete accounts for students and advisors 
* Ability to add/delete courses
* Ability to add Professors under each courses
* Ability to see and edit all student’s planner 

# Solution
The proposed course planning website will provide a comprehensive platform for students to plan and organize their courses and also view who their advisor is. Features include viewing each major and its corresponding courses and being able to add or remove courses into their planner. Users will be able to select a role and by their user type, a unique ID will be generated based on their role type. We began by first creating the front end, getting our login and sign up page to work as well as storing each user’s information in a txt file. We then developed smaller components and began to implement the classes for each user and the different screens depending on the user type. Then, we planned how to connect all the pages together to get the GUI and backend working along with each other while implementing the needed methods for each class. 

# Steps to Run Code
1. Go to github link: https://github.com/shreyasprabhudev/CS151-SJSU-Course-Planner and copy link to clone
2. Open Eclipse. Select Import and under Git folder select Projects from Git (with smart import)
3. Select clone URI and select Next and in Branch Selection select Next without changing anything
4. Select a directory and make sure both folders are selected and press Finish.
5. In SJSUCoursePlanner, go to src/plannerWeb/Planner and press Run.
6. To create a Student/Admin/Advisor Account, go to Sign Up → Student/Admin/Advisor → Enter Details
7. To login with existing credentials, use the username that was generated for you and your password (if you cannot remember your credentials, you can check the userData.txt file 😀)

# Snapshots of Running Program
Note: Due to the sheer amount of screens due to the numerous options each user have, only the home page, sign up page, and dashboard screens will be shown here.

Home Page - What is shown immediately when running the program

![Screenshot (229)](https://user-images.githubusercontent.com/114033045/236166876-19e175c6-d46a-4a80-a225-38a28f6be4c5.png)

Select User Screen upon choosing Sign Up
![Screenshot (231)](https://user-images.githubusercontent.com/114033045/236167121-1072f867-0b0a-48e4-aa83-b5c42cf3c2fd.png)

Student Page with Major classes showing
<img width="1392" alt="Screenshot_2023-05-09_at_1 25 29_AM" src="https://user-images.githubusercontent.com/114033045/237039477-033ee1be-d351-4b6a-a8d6-325a802c0388.png">

Admin Page 
<img width="1398" alt="Screenshot_2023-05-09_at_1 17 21_AM" src="https://user-images.githubusercontent.com/114033045/237039520-39c48ecb-403a-4979-a4f5-a1fe83aac65a.png">

Advisor page 
<img width="1399" alt="Screenshot_2023-05-09_at_1 16 15_AM" src="https://user-images.githubusercontent.com/114033045/237039594-fd188c67-0758-4fb5-a53f-b22612349c5c.png">


# Other References:
[1] https://1000projects.org/course-planning-project-java.html
