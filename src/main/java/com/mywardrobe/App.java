package com.mywardrobe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);


//        context.getBean(LibDemoService.class).bookDemo();
//
//       // context.close();
//        try {
//           Console.main(args);
//       } catch (SQLException e) {
//           e.printStackTrace();
//        }


    }
}