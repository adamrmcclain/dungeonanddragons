package utils.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    public Monsters mapJsonToMonster(JsonNode monsterJsonMessage){
        Monsters monsters = null;
        ObjectMapper mapper = new ObjectMapper();
        JsonParser jsonParser = monsterJsonMessage.traverse();
        try {
            monsters = mapper.readValue(jsonParser, Monsters.class);
        } catch (IOException e) {
            Map<String,Object> inputs = new HashMap<>();
            inputs.put("monsterJsonMessage", monsterJsonMessage);
            ErrorLogging.log("JsonUtils.mapJsonToMonster", inputs ,e);
            e.printStackTrace();
        }
        return monsters;
    }

}
