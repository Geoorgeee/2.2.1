package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      Car car = new Car(1,"bmw");
      User user = new User("ФФФФФФФФФФФФФФФФФФФФФФФФФФФФФФФФФФФФФф","ФФФФФФФФФФФФФФФФФФФФФФФ","asd@mail.ru",car);
      Car car2 = new Car(1,"basdw");
      User user2 = new User("user12","goga","asd@mail.ru",car2);
      Car car3 = new Car(1,"bm123123321132321132w");
      User user3 = new User("user12","bobik","asd@mail.ru",car3);

      userService.add(user);
      System.out.println(userService.whoOwner(1,"bmw").toString());



 /*     List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }*/

      context.close();
   }
}
