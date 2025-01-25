package dev.Mohammed.runnerz.run;

import java.time.LocalDateTime;



public record Run(Integer id,
                  String title,
                  LocalDateTime startedOn,
                  LocalDateTime completedOn,
                  Integer miles,
                  Location location) {


    public Run {

        if(!completedOn.isAfter(startedOn)) {
            throw new IllegalArgumentException("Completed On must be after Stated On");

        }
    }
}