package com.example.gitmetrix.Controllers.api;

import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

@RestController
@RequestMapping("/test")
public class TestController {

  @GetMapping
  public String test(@RequestParam String command) {
    ProcessBuilder processBuilder = new ProcessBuilder();

    // -- Windows --

    // Run a command
    processBuilder.command("cmd.exe", "/c", command);

    // Run a bat file
    //processBuilder.command("C:\\Users\\mkyong\\hello.bat");

    StringBuilder output = new StringBuilder();

    try {
      Process process = processBuilder.start();

      BufferedReader reader = new BufferedReader(
          new InputStreamReader(process.getInputStream()));

      String line;
      while ((line = reader.readLine()) != null) {
        output.append(line + "\n");
      }

      int exitVal = process.waitFor();
      if (exitVal == 0) {
        System.out.println("Success!");
        System.out.println(output);
      } else {
        //abnormal...
      }

    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    return String.valueOf(output);

  }
}
