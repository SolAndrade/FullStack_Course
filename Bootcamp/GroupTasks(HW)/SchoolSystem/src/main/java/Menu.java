import java.util.Scanner;
import java.util.*;

public class Menu {

    private String commandName;

    private HashMap<String, Teacher> teachersList = new HashMap<>();
    private HashMap<String, Student> studentList = new HashMap<>();
    private HashMap<String, Course> courseList = new HashMap<>();
    static final Scanner INPUT = new Scanner(System.in);


    public void startApplication() {

        String schoolName = "";
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("Introduce the school name: ");
                schoolName = INPUT.nextLine();
                if (schoolName.isBlank()) {
                    throw new IllegalArgumentException("School's name cannot be blank.");
                }
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
        System.out.println("Your school is: " + schoolName.toUpperCase());


        //DATA FOR TEACHER NUMBER
        int teachersNumber = 0;
        validInput = false;
        while (!validInput) {
            try {
                System.out.println("How many teachers are in your school?");
                teachersNumber = Integer.parseInt(INPUT.nextLine());
                if (teachersNumber < 0) {
                    throw new IllegalArgumentException("Number of teachers must be positive");
                }
                validInput = true;
            } catch (NumberFormatException e) {
                System.err.println("Invalid input. Please enter a valid integer.");
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }

        //TEACHER INFO
        for (int i = 0; i < teachersNumber; i++) {
            Scanner scannerFor = new Scanner(System.in);
            String teacherName = "";
            double teacherSalary = 0;
            validInput = false;
            while (!validInput) {
                try {
                    System.out.println("Teacher's name:");
                    teacherName = scannerFor.nextLine();
                    if (teacherName.isBlank()) {
                        throw new IllegalArgumentException("Teacher's name cannot be blank.");
                    }
                    validInput = true;
                } catch (IllegalArgumentException e) {
                    System.err.println(e.getMessage());
                }
            }
            validInput = false;
            while (!validInput) {
                try {
                    System.out.println("Teacher's salary:");
                    teacherSalary = scannerFor.nextDouble();
                    if (teacherSalary < 0) {
                        throw new IllegalArgumentException("Teacher's salary cannot be negative.");
                    }
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.err.println("Invalid input. Please enter a valid number.");
                    scannerFor.nextLine();
                } catch (IllegalArgumentException e) {
                    System.err.println(e.getMessage());
                }
            }

            Teacher teacherInput = new Teacher(teacherName, teacherSalary);
            teachersList.put(teacherInput.getTeacherId(), teacherInput);
        }
        System.out.println(teachersList.values());


        //DATA FOR COURSES NUMBER
        int coursesNumber = 0;
        validInput = false;

        while (!validInput) {
            try {
                System.out.println("How many courses are in your school?");
                coursesNumber = Integer.parseInt(INPUT.nextLine());
                if (coursesNumber < 0) {
                    throw new IllegalArgumentException("Number of courses must be positive");
                }
                validInput = true;
            } catch (NumberFormatException e) {
                System.err.println("Invalid input. Please enter a valid integer.");
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }

        //COURSE INFO
        for (int i = 0; i < coursesNumber; i++) {
            Scanner scannerFor = new Scanner(System.in);

            String courseName = "";
            double coursePrice = 0;

            validInput = false;

            while (!validInput) {
                try {
                    System.out.println("Course's name:");
                    courseName = scannerFor.nextLine();
                    if (courseName.isBlank()) {
                        throw new IllegalArgumentException("Course's name cannot be blank.");
                    }
                    validInput = true;
                } catch (IllegalArgumentException e) {
                    System.err.println(e.getMessage());
                }
            }

            validInput = false;
            while (!validInput) {
                try {
                    System.out.println("Course's price:");
                    coursePrice = scannerFor.nextDouble();
                    if (coursePrice < 0) {
                        throw new IllegalArgumentException("Course's price cannot be negative.");
                    }
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.err.println("Invalid input. Please enter a valid number.");
                    scannerFor.nextLine();
                } catch (IllegalArgumentException e) {
                    System.err.println(e.getMessage());
                }
            }

            Course courseInput = new Course(courseName, coursePrice);
            courseList.put(courseInput.getCourseID(), courseInput);
        }
        System.out.println(courseList.values());


        //DATA FOR STUDENTS NUMBER
        int studentNumber = 0;
        validInput = false;

        while (!validInput) {
            try {
                System.out.println("How many students are in your school?");
                studentNumber = Integer.parseInt(INPUT.nextLine());
                if (studentNumber < 0) {
                    throw new IllegalArgumentException("Number of students must be positive");
                }
                validInput = true;
            } catch (NumberFormatException e) {
                System.err.println("Invalid input. Please enter a valid integer.");
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }

        //STUDENT INFO
        for (int i = 0; i < studentNumber; i++) {

            Scanner scannerFor = new Scanner(System.in);

            String studentName = "";
            String studentAddress = "";
            String studentEmail = "";

            validInput = false;
            while (!validInput) {
                try {
                    System.out.println("Student's name:");
                    studentName = scannerFor.nextLine();
                    if (studentName.isBlank()) {
                        throw new IllegalArgumentException("Student's name cannot be blank.");
                    }
                    validInput = true;
                } catch (IllegalArgumentException e) {
                    System.err.println(e.getMessage());
                }
            }

            validInput = false;
            while (!validInput) {
                try {
                    System.out.println("Student's address:");
                    studentAddress = scannerFor.nextLine();
                    if (studentAddress.isBlank()) {
                        throw new IllegalArgumentException("Student's address cannot be blank.");
                    }
                    validInput = true;
                } catch (IllegalArgumentException e) {
                    System.err.println(e.getMessage());
                }
            }

            validInput = false;
            while (!validInput) {
                try {
                    System.out.println("Student's email:");
                    studentEmail = scannerFor.nextLine();
                    if (studentEmail.isBlank()) {
                        throw new IllegalArgumentException("Student's email cannot be blank.");
                    }
                    validInput = true;
                } catch (IllegalArgumentException e) {
                    System.err.println(e.getMessage());
                }
            }
            Student studentInput = new Student(studentName, studentAddress, studentEmail);
            studentList.put(studentInput.getStudentId(), studentInput);
        }
        System.out.println(studentList.values());

        enterCommand(teachersList, studentList, courseList);
    }

    public void enterCommand(HashMap<String, Teacher> teachersList, HashMap<String, Student> studentList, HashMap<String, Course> courseList) {
        boolean flagCommand = false;

        System.out.println("Enter command: \n ENROLL \n ASSIGN \n SHOW COURSES \n LOOKUP COURSE \n SHOW STUDENTS \n LOOKUP STUDENT \n SHOW TEACHERS \n LOOKUP TEACHER \n SHOW PROFIT \n EXIT");
        while (!flagCommand) {
            commandName = INPUT.nextLine();

            switch (commandName.toUpperCase()) {
                case "ENROLL":
                    enroll(studentList, courseList);
                    break;
                case "ASSIGN":
                    assign(teachersList, courseList);
                    break;
                case "SHOW COURSES":
                    showCourses(courseList);
                    break;
                case "LOOKUP COURSE":
                    lookupCourse(courseList);
                    break;
                case "SHOW STUDENTS":
                    showStudents(studentList);
                    break;
                case "LOOKUP STUDENTS":
                    lookupStudent(studentList);
                    break;
                case "SHOW TEACHERS":
                    showTeachers(teachersList);
                    break;
                case "LOOKUP TEACHER":
                    lookupTeacher(teachersList);
                    break;
                case "SHOW PROFIT":
                    showProfit(courseList, teachersList);
                    break;
                case "EXIT":
                    flagCommand = true;
                    break;
                default:
                    //System.out.println("Write a correct command:");
            }
        }
    }

    // ENROLL METHOD
    public void enroll(HashMap<String, Student> studentList, HashMap<String, Course> courseList) {
        try {
            System.out.println("Enter Student ID:");
            String studentID = INPUT.nextLine();
            System.out.println("Enter Course ID:");
            String courseID = INPUT.nextLine();

            Student student = studentList.get(studentID);
            if (student == null) {
                throw new IllegalArgumentException("Invalid student ID.");
            }

            Course course = courseList.get(courseID);
            if (course == null) {
                throw new IllegalArgumentException("Invalid course ID.");
            }

            student.setCourse(course);

            double price = course.getPrice();
            double moneyEarned = course.getMoney_earned() + price;
            course.setMoney_earned(moneyEarned);

            System.out.println("Enrollment successful:");
            System.out.println(student);
            System.out.println(course);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    public void assign(HashMap<String, Teacher> teachersList, HashMap<String, Course> courseList) {
        try {
            System.out.println("Insert Teacher ID");
            String teacherID = INPUT.nextLine();
            System.out.println("Insert Course ID");
            String courseID = INPUT.nextLine();

            Teacher teacher = teachersList.get(teacherID);
            Course course = courseList.get(courseID);

            if (teacher == null) {
                throw new IllegalArgumentException("Invalid teacher ID.");
            }
            if (course == null) {
                throw new IllegalArgumentException("Invalid course ID.");
            }

            course.setTeacher(teacher);

            System.out.println(courseList.get(courseID));

            System.out.println("Assignment successful:");
            System.out.println(teacher);
            System.out.println(course);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    //SHOW PROFIT METHOD
    public void showProfit(HashMap<String, Course> courseList, HashMap<String, Teacher> teachersList) {
        double courseEarned = 0;
        double teacherSalary = 0;

        for (Course course : courseList.values()) {
            courseEarned += course.getMoney_earned();
        }

        for (Teacher teacher : teachersList.values()) {
            teacherSalary += teacher.getSalary();
        }

        double profit = courseEarned - teacherSalary;
        System.out.println("The profit is " + profit + ".");
    }

    // SHOW METHODS
    public void showCourses(HashMap<String, Course> courseList) {
        System.out.println(courseList.values());
    }

    public void showTeachers(HashMap<String, Teacher> teachersList) {
        System.out.println(teachersList.values());
    }

    public void showStudents(HashMap<String, Student> studentList) {
        System.out.println(studentList.values());
    }

    //LOOKUP METHODS
    public void lookupCourse(HashMap<String, Course> courseList) {
        System.out.println("Insert course ID");
        String courseID = INPUT.nextLine();

        try {
            Course course = courseList.get(courseID);
            if (course == null) {
                throw new IllegalArgumentException("Course ID does not exist.");
            }
            System.out.println(course);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    public void lookupStudent(HashMap<String, Student> studentList) {
        System.out.println("Insert student's ID");
        String studentID = INPUT.nextLine();

        try {
            Student student = studentList.get(studentID);
            if (student == null) {
                throw new IllegalArgumentException("Student ID does not exist.");
            }
            System.out.println(student);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    public void lookupTeacher(HashMap<String, Teacher> teachersList) {
        System.out.println("Insert teacher's ID");
        String teacherID = INPUT.nextLine();

        try {
            Teacher teacher = teachersList.get(teacherID);
            if (teacher == null) {
                throw new IllegalArgumentException("Teacher ID does not exist.");
            }
            System.out.println(teacher);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}

