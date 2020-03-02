package com.example.gitmetrix.Process.Command;

public interface Command {
  /**
   * run current command.
   */
  Command run();

  /**
   * @return command result.
   */
  String result();
}
