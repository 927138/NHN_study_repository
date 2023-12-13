import com.yh.jdbcexercise.domain.Student;
import com.yh.jdbcexercise.repository.StudentRepository;
import com.yh.jdbcexercise.repository.imp.StudentPrepareStatementRepository;
import java.util.Iterator;
import java.util.Optional;
import java.util.Random;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@Slf4j
public class StatementStudendTest {


     private static StudentRepository studentRepository;

     @BeforeAll
     static void setUp(){

          studentRepository =   new StudentPrepareStatementRepository();

          Random random = new Random();
          Iterator<Integer> iter = random.ints(20, 50).iterator();

          for(int i=0; i<10; i++){
               String id = "student"+i;
               String name= "학생"+i;
               Student.GENDER gender = i % 2 == 0 ? Student.GENDER.W : Student.GENDER.M;
               int age = iter.next();


               int x = studentRepository.deleteById(id);
               int y = studentRepository.save(new Student(id, name, gender, age));
               log.info("studentRepository method return value(delete, save) : {}, {}", x, y);
          }studentRepository.deleteById("student100");
     }

     @Test
     @Order(1)
     @DisplayName("insert student : student 100")
     void save(){
          Student student = new Student("student100", "name100", Student.GENDER.W, 12);
          int result = studentRepository.save(student);
          Assertions.assertEquals(1, result);

     }

     @Test
     @Order(2)
     @DisplayName("findById-student1")
     void findById() {
          Optional<Student> studentOptional = studentRepository.findById("student1");
          log.info("student:{}", studentOptional.get());

          Assertions.assertAll(
                  ()->Assertions.assertEquals("student1",studentOptional.get().getId()),
                  ()->Assertions.assertEquals("학생1",studentOptional.get().getName()),
                  ()->Assertions.assertEquals(Student.GENDER.M,studentOptional.get().getGender())
          );

     }

     @Test
     @Order(3)
     @DisplayName("findById-marco10000")
     void findById_10000(){
          Optional<Student> studentOptional = studentRepository.findById("student10000");
          Assertions.assertFalse(studentOptional.isPresent());
     }

     @Test
     @Order(4)
     @DisplayName("update : student1")
     void update() {

          Student student = new Student("student1","엔에이치엔아카데미", Student.GENDER.W,30);
          int result = studentRepository.update(student);
          //Assume.assumeFalse(result>0);

          Optional<Student> newStudent = studentRepository.findById(student.getId());
          log.debug(newStudent.toString());

          Assertions.assertAll(
                  ()->Assertions.assertEquals("student1", newStudent.get().getId()),
                  ()->Assertions.assertEquals("엔에이치엔아카데미", newStudent.get().getName()),
                  ()->Assertions.assertEquals(Student.GENDER.W, newStudent.get().getGender()),
                  ()->Assertions.assertEquals(30, newStudent.get().getAge())
          );

     }

     @Test
     @Order(5)
     @DisplayName("delete : student1")
     void deleteById() {
          String id="student1";
          int result = studentRepository.deleteById(id);
          Optional<Student> studentDto = studentRepository.findById(id);
          Assertions.assertFalse(studentDto.isPresent());
     }

}
