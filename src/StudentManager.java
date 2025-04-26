import java.util.List;
import java.util.ArrayList;

public class StudentManager {
    private DatabaseManager dbManager;
    private static final boolean USE_MONGODB = true;  // Set to true to use MongoDB or false for JSON fallback

    // Constructor initializes the database manager
    public StudentManager() {
        try {
            if (USE_MONGODB) {
                dbManager = new DatabaseManager();
            }
        } catch (Exception e) {
            System.out.println("❌ Failed to connect to the database: " + e.getMessage());
            dbManager = null;  // Fallback to JSON manager
        }
    }

    // Add a new student
    public void addStudent(Student student) {
        if (dbManager == null) {
            System.out.println("⚠️ Database not connected. Adding student to JSON.");
            List<Student> students = JsonManager.loadStudents();
            students.add(student);
            JsonManager.saveStudents(students);
            System.out.println("✅ Student added to JSON file.");
            return;
        }

        try {
            dbManager.addStudent(student);
            System.out.println("✅ Student added successfully to MongoDB!");
        } catch (Exception e) {
            System.out.println("❌ Failed to add student to MongoDB: " + e.getMessage());
        }
    }

    // Get all students
    public List<Student> getAllStudents() {
        if (dbManager == null) {
            System.out.println("⚠️ Database not connected. Fetching students from JSON.");
            return JsonManager.loadStudents();
        }

        try {
            return dbManager.getAllStudents();
        } catch (Exception e) {
            System.out.println("❌ Failed to retrieve students from MongoDB: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // Search for a student by ID
    public Student searchById(String id) {
        if (dbManager == null) {
            System.out.println("⚠️ Database not connected. Searching students in JSON.");
            List<Student> students = JsonManager.loadStudents();
            for (Student student : students) {
                if (student.getId().equalsIgnoreCase(id)) {
                    return student;
                }
            }
            System.out.println("❌ Student not found in JSON.");
            return null;
        }

        try {
            return dbManager.searchById(id);
        } catch (Exception e) {
            System.out.println("❌ Failed to search student in MongoDB: " + e.getMessage());
            return null;
        }
    }
}
