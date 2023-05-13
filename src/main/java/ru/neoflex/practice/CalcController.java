package ru.neoflex.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CalcController {
    @Autowired
    CalcRepository calcRepository;

    @GetMapping("/sum/{id}")
    public ResponseEntity<Calc> getCalcById(@PathVariable("id") long id) {
        Optional<Calc> calcData = calcRepository.findById(id);

        if (calcData.isPresent()) {
            return new ResponseEntity<>(calcData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/plus/{a}/{b}")
    public long Addition(@PathVariable() int a, @PathVariable int b) {
        long result = a + b;
        Calc calc = calcRepository.save(new Calc(a, b, result, CalcOperator.Addition));
        return result;
    }

    @GetMapping("/minus/{a}/{b}")
    public long Subtraction(@PathVariable() int a, @PathVariable() int b) {
        long result = a - b;
        Calc calc = calcRepository.save(new Calc(a, b, result, CalcOperator.Subtraction));
        return result;
    }

    @DeleteMapping("/sum/{id}")
    public ResponseEntity<HttpStatus> deleteCalc(@PathVariable("id") long id) {
        try {
            calcRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}