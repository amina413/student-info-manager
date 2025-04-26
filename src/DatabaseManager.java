import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private final MongoClient mongoClient;
    private final MongoDatabase database;
    private final MongoCollection<Document> collection;

    public DatabaseManager() {
        try {
            // Replace with your own MongoDB URL from Atlas
            String uri = "mongodb+srv://bunuamina1:Mimizara4@amina.2zw3a.mongodb.net/student_db?retryWrites=true&w=majority&appName=Amina";
            mongoClient = MongoClients.create(uri);

            database = mongoClient.getDatabase("student_db");
            collection = database.getCollection("students");
        } catch (Exception e) {
            System.out.println("❌ Error connecting to MongoDB: " + e.getMessage());
            throw e; // Important: re-throw so StudentManager can know
        }
    }

    public void addStudent(Student student) {
        try {
            Document doc = new Document("id", student.getId())
                    .append("name", student.getName())
                    .append("email", student.getEmail())
                    .append("course", student.getCourse());
            collection.insertOne(doc);
            System.out.println("✅ Student added to MongoDB!");
        } catch (Exception e) {
            System.out.println("❌ Failed to add student to MongoDB: " + e.getMessage());
            throw e; // rethrow so StudentManager can react
        }
    }

    public List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<>();
        try {
            FindIterable<Document> documents = collection.find();
            for (Document doc : documents) {
                Student student = new Student(
                        doc.getString("id"),
                        doc.getString("name"),
                        doc.getString("email"),
                        doc.getString("course")
                );
                studentList.add(student);
            }
        } catch (Exception e) {
            System.out.println("❌ Failed to fetch students from MongoDB: " + e.getMessage());
            throw e;
        }
        return studentList;
    }

    public Student searchById(String id) {
        try {
            Bson filter = Filters.eq("id", id);
            Document doc = collection.find(filter).first();
            if (doc != null) {
                return new Student(
                        doc.getString("id"),
                        doc.getString("name"),
                        doc.getString("email"),
                        doc.getString("course")
                );
            } else {
                System.out.println("⚠️ No student found with ID: " + id);
                return null;
            }
        } catch (Exception e) {
            System.out.println("❌ Failed to search for student: " + e.getMessage());
            throw e;
        }
    }
}
