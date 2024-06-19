INSERT INTO role (role_id, role_title, role_description) VALUES (1, 'Admin', 'Administrator');
INSERT INTO role (role_id, role_title, role_description) VALUES (2, 'Teacher', 'Teacher Role');
INSERT INTO role (role_id, role_title, role_description) VALUES (3, 'Student', 'Student Role');


INSERT INTO user (user_id, user_role_id, user_name, user_email, user_dob, user_address) VALUES 
(1, 1, 'John Admin', 'john.admin@example.com', '1980-01-01', 'Admin Street'),
(2, 2, 'Jane Teacher', 'jane.teacher@example.com', '1975-05-20', 'Teacher Lane'),
(3, 3, 'Johnny Student', 'johnny.student@example.com', '2000-09-15', 'Student Avenue');


INSERT INTO student (student_id, student_name, student_mobile, student_email, student_address, student_username, student_password, student_college_id) VALUES 
(1, 'Johnny Student', '1234567890', 'johnny.student@example.com', 'Student Avenue', 'johnny', 'password', 1);


INSERT INTO subject (subject_id, subject_name, subject_type, subject_description, subject_student_id) VALUES 
(1, 'Mathematics', 'Core', 'Basic Mathematics', 1),
(2, 'Physics', 'Core', 'Basic Physics', 1);


INSERT INTO class (class_id, class_name, class_description, class_type, class_student_id, class_room) VALUES 
(1, 'Math Class', 'Math Class Description', 'Lecture', 1, 'Room 101'),
(2, 'Physics Class', 'Physics Class Description', 'Lecture', 1, 'Room 102');


INSERT INTO attendance (attendance_id, attendance_student_id, attendance_type, attendance_description) VALUES 
(1, 1, 'Present', 'Attended Math Class'),
(2, 1, 'Absent', 'Missed Physics Class');
