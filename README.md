# School-Management
This program implements a GUI (graphical user interface) using Java Swing to simulate a student management software used by universities. The project allows the user to add new students using the GUI and to read all the informations of all the registered students, which are the name, the ID, the e-mail, the major and wheter or not the tuition has been paid. Also, the user can search a specific student by its name or ID and, if needed, delete a student from the database.<br>
**Attention:** All the data is stored in the "school.txt" file, so if you delete it you will lose all your data.

# How to Use
When the program is initialized, it will open a window with two buttons. If you want to add a new student or see the list with the informations of those already registered, clic on "Add Student". If you want to search a specific student or delete one from the library, click on "Search Student".
To add a student, simply fill all the informations on the fields in the left of the window and click on "Add". If we want to clear eerything you have written in these fields, simply click on "Clear". The list will be automatically updated when you add the new students.
To search a student, fill the text field in the "Search Student" window and click on Search by Name or by ID, depending on which information you have written. If you click on delete a window will pop-up to confirm if you really want to move forward. Notice that the target of the delete operation will be the student displayed in the right part of the window.

# Compilation and Use
Download all the files of this repository, keeping the structure. Then, execute "$javac *.java" in the folder containing the Main.java file. After this, you will be able to run the program by using "$java Main".
There is no need to create the "school.txt" file, it will be created automatically once you execute the program and the information will be saved even if you close the program.
