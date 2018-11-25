# SchoolManager
This programm is a tool customely designed to provide assistance in scheduling of courses for students of Higher Education Institutions as well as training courses for enrollers of said Institutions.

## Logic behind this programm:
We have an SQL database (which is manipulated trough Hibarnate ORM) with tables respectively:

### LEARN_CLASS
#### ID column
Supposed to be of use if we will have particular materials that are to be used in this part of given course, or  if we are to track presence of each student.

#### Subject ID 
Each class is a part of course of particular subject. This is were we store this subject.

#### Teacher ID
Tells us by wich teacher lesson will be/was conducted.

#### Skill assigned
Which describes what competence is required to teach this subject.

#### Attending groups
We store a link to a Set of groups that are to be attending/attended this particular class. Which is obviuosly convinient to keep track of things.


### Subject
#### ID


![alt text](https://i.gyazo.com/3397a421f8f0620b53472f79b487a72c.png)
<div style="text-align:center"> Figure: "Data manipulations" </div>
