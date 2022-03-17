package com.example.demo;

import com.example.demo.exceptions.ValidationException;
import com.example.demo.services.ExecutorService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final ExecutorService executorService;

    @Autowired
    public ConsoleRunner(ExecutorService executorService) {
        this.executorService = executorService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            String result;

            try {
                result = executorService.execute(command);
            } catch (ValidationException ex) {
                result = ex.getMessage();
            }

            System.out.println(result);

            command = scanner.nextLine();
        }

    }
}
