package com.voiz94.ordergenerationservice.util;

import com.voiz94.ordergenerationservice.util.interfaces.IOrderCodeGenerator;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;

@Component
public class OrderCodeGenerator implements IOrderCodeGenerator {
    @Override
    public UUID generate() {
        //String date = java.time.LocalDate.now().toString().replace("-", "");
        //String id = date + (new Random().nextInt(100));
        return UUID.randomUUID();
    }
}
