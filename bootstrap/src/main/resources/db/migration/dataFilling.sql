INSERT INTO role (role_id, role_title, role_description) VALUES (1, 'Admin', 'Administrator');
INSERT INTO role (role_id, role_title, role_description) VALUES (2, 'Teacher', 'Teacher Role');
INSERT INTO role (role_id, role_title, role_description) VALUES (3, 'Student', 'Student Role');


INSERT INTO users (user_id, username, password, role) VALUES 
(1, 'JohnAdmin', 'adminpass', 'Admin'),
(2, 'JaneTeacher', 'teacherpass', 'Teacher'),
(3, 'JohnnyStudent', 'studentpass', 'Student');



INSERT INTO student (student_id, student_name, student_mobile, student_email, student_address, student_username, student_password, student_college_id) VALUES 
(1, 'Johnny Student', '1234567890', 'johnny.student@example.com', 'Student Avenue', 'johnny', 'password', 1);


INSERT INTO subjects (subject_id, subject_name, subject_type, subject_description, subject_student_id) VALUES 
(1, 'Mathematics', 'Core', 'Basic Mathematics', 1),
(2, 'Physics', 'Core', 'Basic Physics', 1);



INSERT INTO class (class_id, class_name, class_description, class_type, class_student_id, class_room) VALUES 
(1, 'Math Class', 'Math Class Description', 'Lecture', 1, 'Room 101'),
(2, 'Physics Class', 'Physics Class Description', 'Lecture', 1, 'Room 102');


INSERT INTO attendance (attendance_id, attendance_student_id, attendance_type, attendance_description) VALUES 
(1, 1, 'Present', 'Attended Math Class'),
(2, 1, 'Absent', 'Missed Physics Class');
