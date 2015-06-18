package utils.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;

import monster.Monster;
import monster.Monsters;
import utils.errorlogging.ErrorLogging;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Adam And Lauren on 6/6/2015.
 */
public class JsonUtils {

    public JsonNode getJsonNodeFromString(String jsonMessage){
        JsonNode jsonNode = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            jsonNode = mapper.readTree(jsonMessage);
        } catch (IOException e) {
            Map<String,Object> inputs = new HashMap<>();
            inputs.put("jsonMessage", jsonMessage);
            ErrorLogging.log("JsonUtils.getJsonNodeFromString", inputs ,e);
            e.printStackTrace();
        }
        return jsonNode;
    }

    public Monsters mapJsonToMonsters(JsonNode monsterJsonMessage){
        Monsters monsters = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY,true);
        JsonParser jsonParser = monsterJsonMessage.traverse();
        try {
            monsters = mapper.readValue(jsonParser, Monsters.class);
        } catch (IOException e) {
            Map<String,Object> inputs = new HashMap<>();
            inputs.put("monsterJsonMessage", monsterJsonMessage);
            ErrorLogging.log("JsonUtils.mapJsonToMonsters", inputs ,e);
            e.printStackTrace();
        }
        return monsters;
    }

    public JsonNode getJsonNodeFromMonster(Monster monster){
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        JsonNode returnValue = null;
        try {
            String json = ow.writeValueAsString(monster);
            returnValue = getJsonNodeFromString(json);
        } catch (JsonProcessingException e) {
            Map<String, Object> input = new HashMap<>();
            input.put("monster", monster);
            ErrorLogging.log("getJsonNOdeFromMonster",input,e);
        }

        return returnValue;
    }

    public Monster mapJsonToMonster(JsonNode monsterJsonMessage){
        Monster monster = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY,true);
        JsonParser jsonParser = monsterJsonMessage.traverse();
        try {
            monster = mapper.readValue(jsonParser, Monster.class);
        } catch (IOException e) {
            Map<String,Object> inputs = new HashMap<>();
            inputs.put("monsterJsonMessage", monsterJsonMessage);
            ErrorLogging.log("JsonUtils.mapJsonToMonster", inputs ,e);
            e.printStackTrace();
        }
        return monster;
    }

}
