package com.mcclain.model;

import lombok.Data;

import java.util.List;

@Data
public class SecretSanta {
    private Person giver;
    List<Exclusions> exclusions;
    private Person receiver;
    private Boolean hasGiver;
}
