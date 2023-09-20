package com.example.syap_spring;

import com.example.syap_spring.funcs.NumberFlipper;
import com.example.syap_spring.funcs.RemoveDuplicates;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FunctionController {

    @PostMapping("/flipNumber")
    public int flipNumber(@RequestBody int numberToFlip) {
        return NumberFlipper.flipNumber(numberToFlip);
    }

    @GetMapping("/removeDuplicates")
    public List<Integer> removeDuplicates(@RequestParam List<Integer> numbers) {
        return RemoveDuplicates.removeDuplicates(numbers);
    }
}