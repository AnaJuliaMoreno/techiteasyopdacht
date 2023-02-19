package nl.novi.techiteasy.Controller;

import nl.novi.techiteasy.Exceptions.IndexOutOfBoundsException;
import nl.novi.techiteasy.Exceptions.NameLongerThan20Char;
import nl.novi.techiteasy.Exceptions.RecordNotFoundException;
import nl.novi.techiteasy.Model.Television;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("television")
public class TelevisionController {

    private List<Television> televisions = new ArrayList<>();


    @GetMapping("")
    public ResponseEntity<List<Television>> getAllTelevisions() {
        return ResponseEntity.ok(televisions);
        // THE SAME AS:   return new ResponseEntity("television", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Television> getTelevision(@PathVariable int id) {
        if (id > televisions.size() || id <= 0) {
            throw new IndexOutOfBoundsException("You have entered an invalid number, try again");
        } else {
            return new ResponseEntity<>(televisions.get(id), HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTelevisionList(@PathVariable int id, @RequestBody Television tv) {
        if (id >= 0 && id < televisions.size()) {
            televisions.set(id, tv);
            return new ResponseEntity<>(tv, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid id", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<Television> createTelevision(@RequestBody Television tv) {
        if (tv.name.length() <= 20) {
            televisions.add(tv);
            return new ResponseEntity<>(tv, HttpStatus.CREATED);
        }
        throw new NameLongerThan20Char("TV name is too long, write less than 20 characters");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTvById(@PathVariable int id) {
        if (id >= 0 && id > televisions.size()) {
            return new ResponseEntity<>("Invalid id", HttpStatus.NOT_FOUND);
        } else {
            televisions.remove(id);
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }
}





