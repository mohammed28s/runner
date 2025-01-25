package dev.Mohammed.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunRepository {

    private final List<Run> runs = new ArrayList<>();

    List<Run> findAll() {  //This is to get all data

        return runs;
    }



    Optional<Run> findById(Integer id){   //This is to get data by id

        return runs.stream()
                .filter(run -> run.id() == id)
                .findFirst();
    }



    void create(Run run){  //This is for adding new elements to the runs array list
        runs.add(run);
    }

    void update(Run run){

        runs.get(run.id());
    }


    void update(Run run, Integer id){   //This is to update the data
        Optional<Run> existingRun = findById(id);
        if(existingRun.isPresent()){
            runs.set(runs.indexOf(existingRun.get()), run);

        }
    }


    void delete( Integer id){
        Optional<Run> existingRun = findById(id);
        if(existingRun.isPresent()){
            runs.remove(runs.indexOf(existingRun.get()));

        }


    }



    @PostConstruct
    private void init(){  //This all the information in the runs array

        runs.add(new Run(1,
                "Monday Morning Run",
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(30), 3, Location.INSIDE));


        runs.add(new Run(2,
                "Wednesday Evening Run",
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(30), 6, Location.OUTDOOR));


        runs.add(new Run(3,
                "Friday Muscat Night",
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(55), 10, Location.SUBWAY));

        runs.add(new Run(4,
                "Tuesday Muscat Night",
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(25), 31, Location.COMPLEX));



    }

}