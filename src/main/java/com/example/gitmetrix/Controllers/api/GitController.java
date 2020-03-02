package com.example.gitmetrix.Controllers.api;

import com.example.gitmetrix.Process.Command.GitCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/git")
public class GitController {
  @GetMapping
  public String gitCommand(@RequestParam final String param) {
    return new GitCommand(param, new ProcessBuilder()).run().result();
  }
}
