package com.voiz94.ordergenerationservice.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class Order {
    private UUID id;
    private String name;
    private String description;
}
