package dev.Mohammed.runnerz.run;



import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.NotEmpty;  // This is to make the filed not empty
import java.time.LocalDateTime;



public record Run(Integer id,
                  @NotEmpty
                  String title,
                  LocalDateTime startedOn,
                  LocalDateTime completedOn,
                  @Positive
                  Integer miles,
                  Location location) {


    public Run {

        if(!completedOn.isAfter(startedOn)) {
            throw new IllegalArgumentException("Completed On must be after Stated On");

        }
    }
}
