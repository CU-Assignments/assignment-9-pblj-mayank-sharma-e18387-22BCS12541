package easy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class AppConfig {

    public Course course() {
        return new Course("Spring Framework", 6);
    }

    public Student student() {
        return new Student("Teesha Madan", course());
    }
}
