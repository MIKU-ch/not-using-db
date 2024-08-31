package raisetech.notUsingDB;

import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class NotUsingDbApplication {

  private String name = "Shiobara Miku";
  private int age = 25;
  private Map<String, Integer> student = new HashMap<>();


  public static void main(String[] args) {
    SpringApplication.run(NotUsingDbApplication.class, args);
  }

  //名前を取得
  @GetMapping("/name")
  public String getName() {
    return name;
  }

  //年齢を取得
  @GetMapping("/age")
  public int getAge() {
    return age;
  }

  //学生の基本情報を取得
  @GetMapping("/studentInfo")
  public String getStudentInfo() {
    return name + " " + age + "歳";
  }

  //名前を上書き
  @PostMapping("/name")
  public void setStudentName(String name) {
    this.name = name;
  }

  // 学生情報（名前と年齢）を追加
  @PostMapping("/addStudent")
  public String addStudent(String name, int age) {
    student.put(name, age);
    return "Added student: " + name + " with age: " + age;
  }

  // 学生情報（全員分）を取得
  @GetMapping("/allStudents")
  public Map<String, Integer> getAllStudents() {
    return student;
  }
}
