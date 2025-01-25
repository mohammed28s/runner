package dev.Mohammed.runnerz.run;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

  //This is for adding message for API if it's not found the data in the database s

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RunNotFoundException extends RuntimeException{
    public RunNotFoundException() {
        super("Run Not Found");

    }





}
