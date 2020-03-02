package com.example.gitmetrix.Process.Command;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GitCommand implements Command {
  private final String name = "git";
  private String params;
  private String result;
  private ProcessBuilder processBuilder;

  /**
   * @param params - parameters for git command.
   */
  public GitCommand(final String params, final ProcessBuilder processBuilder) {
    this.params = params;
    this.processBuilder = processBuilder;
  }

  /**
   * .
   */
  public Command run() {
    this.processBuilder.command("cmd.exe", "/c", name + " " + params);

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
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    result = String.valueOf(output);
    return this;
  }

  /**
   * @return result.
   */
  public String result() {
    return this.result;
  }
}
