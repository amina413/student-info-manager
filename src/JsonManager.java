import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class JsonManager {
    private static final String FILE_NAME = "students.json";
    private static final Gson gson = new Gson();

    // Save student list to JSON file
    public static void saveStudents(List<Student> students) {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            gson.toJson(students, writer);
            System.out.println("Students saved to JSON file.");
        }catch (IOException e){
          System.out.println("Failed to save students: " + e.getMessage());
        }
    }

    // Load student list from JSON file
    public static List<Student> loadStudents(){
        try (FileReader reader = new FileReader(FILE_NAME)){
            Type listType = new TypeToken<List<Student>>(){}.getType();
            return gson.fromJson(reader, listType);
        }catch (IOException e){
            System.out.println("No saved students found, starting fresh. ");
            return new java.util.ArrayList<>();
        }
    }
}
