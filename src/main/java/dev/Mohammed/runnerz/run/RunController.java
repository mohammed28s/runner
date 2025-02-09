package dev.Mohammed.runnerz.run;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


//Using CRUD

@ResponseStatus(HttpStatus.OK)
@RestController
@RequestMapping("/api/runs") //This is the main path to the runs API
public class RunController {


    private final RunRepository runRepository;

    public RunController(RunRepository runRepository) {

        this.runRepository = runRepository;
    }


    // fetch all data
    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("")  // This is to get all the data in the database
    List<Run> findAll(){
        return runRepository.findAll();
    }


    // find by id
    @GetMapping("/{id}")  // This is to get the data by id
    Run findId(@PathVariable Integer id){
        Optional<Run> run = runRepository.findById(id);
        if(run.isEmpty()){

            throw new RunNotFoundException();
        }

        return run.get();
    }



    // Create
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")  // This is to create new run information
    void create(@Valid @RequestBody Run run){
        runRepository.create(run);
    }


    // Update
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}") // This is to update the existing data
    void update(@Valid @RequestBody Run run, @PathVariable Integer id){
        runRepository.update(run, id);

    }

    // Delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")  //This is to delete the data
    void delete( @PathVariable Integer id){
        runRepository.delete(id);

    }


}