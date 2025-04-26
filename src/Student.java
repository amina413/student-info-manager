public class Student {
    private String id;
    private String name;
    private String email;
    private String course;

    // Default constructor (needed for JSON or MongoDB libraries)
    public Student(){

    }
    // Parameterized constructor
    public Student(String id, String name, String email, String course){
        this.id = id;
        this.name = name;
        this.email = email;
        this.course = course;
    }

    // Getters and Setters
    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    // toString method to print student info

    @Override
    public String toString(){
        return "Student ID: " + id +
                "\nName: " + name +
                "\nEmail: " + email +
                "\nCourse: " + course + "\n";
    }
}
