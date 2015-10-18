package com.mcclain.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.mcclain.config.SecretSantaConfig;
import com.mcclain.model.Exclusions;
import com.mcclain.model.Person;
import com.mcclain.model.SecretSanta;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SecretSantaService {

    private SecretSantaConfig config;

    @Autowired
    public SecretSantaService(SecretSantaConfig config){
        this.config = config;
    }

    public List<SecretSanta> getSecretSantaList(){
        
        return null;
    }
    
    public void populateReceiver(List<SecretSanta> secretSantas){
        secretSantas.forEach(secretSanta -> generateReceiver(secretSanta, secretSantas));
    }

    public void generateReceiver(SecretSanta secretSanta, List<SecretSanta> secretSantas) {
        SecretSanta randomReceiver = secretSantas
                .stream()
                .filter(receiver -> filterReceiver(receiver, secretSanta.getExclusions()))
                .findAny()
                .get();

        secretSanta.setReceiver(randomReceiver.getGiver());
        randomReceiver.setHasGiver(true);
    }

    public boolean filterReceiver(SecretSanta receiver, List<Exclusions> exclusions) {
        if(receiver.getHasGiver()){
            return false;
        }
        List<Boolean> passesExclusion = new ArrayList<>();
        exclusions
                .stream()
                .forEach(exclusion -> passesExclusion.add(evaluateExclusion(exclusion, receiver)));
        long numberOfFailedExclusions = passesExclusion.stream().filter(pass -> pass).count();
        return numberOfFailedExclusions > 0;
    }

    public Boolean evaluateExclusion(Exclusions exclusion, SecretSanta receiver) {
        String value = getObjectValue(receiver.getGiver(),exclusion.getObject());
        return null;
    }

    public String getObjectValue(Person giver, String object) {
        String objectValue = null;
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter writer = objectMapper.writer().withDefaultPrettyPrinter();
        try {
            String giverJson = writer.writeValueAsString(giver);
            JsonNode jsonNode = objectMapper.readTree(giverJson);
            objectValue = jsonNode.get(object).textValue();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return objectValue;
    }


}
