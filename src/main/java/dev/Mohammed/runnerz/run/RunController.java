package dev.Mohammed.runnerz.run;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

//Using CRUD

@RestController
@RequestMapping("/api/runs") //This is the main path to the runs API
public class RunController {


    private final RunRepository runRepository;

    public RunController(RunRepository runRepository) {

        this.runRepository = runRepository;
    }



    @GetMapping("")  // This is to get all the data in the database
    List<Run> findAll(){
        return runRepository.findAll();
    }


    @GetMapping("/{id}")  // This is to get the data by id
    Run findId(@PathVariable Integer id){
        Optional<Run> run = runRepository.findById(id);
        if(run.isEmpty()){

            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return run.get();
    }



    // post
    @PostMapping("")  // This is to create new run information
    void create(@RequestBody Run run){
        runRepository.create(run);
    }

    // put




    // delete


    }



