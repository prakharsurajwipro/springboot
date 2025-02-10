package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;
import java.util.Random;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberController {

    private final AtomicLong atomicLong = new AtomicLong();
    private final Random random = new Random();

    @GetMapping("/number")
    public NumberResponse getNumber() {
        long wholeNumber = atomicLong.incrementAndGet();
        int randomnum = random.nextInt(101); // Generates a number between 0 and 100

        return new NumberResponse(wholeNumber, randomnum);
    }
}
