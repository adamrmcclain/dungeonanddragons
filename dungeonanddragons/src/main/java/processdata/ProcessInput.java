package processdata;

import monster.Monsters;
import org.springframework.web.client.RestTemplate;
import utils.errorlogging.ErrorLogging;
import utils.json.JsonUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Adam And Lauren on 6/13/2015.
 */
public class ProcessInput {

    public static void main(String[] args){
        if(args[0].toLowerCase().equals("monster")){
            String fileName = args[1];
            try {
                Path path = Paths.get(fileName);
                String monsterInput = new String(Files.readAllBytes(path));
                ProcessMonsters processMonsters = new ProcessMonsters();
                Monsters monsters = processMonsters.getMonsters(monsterInput);

                JsonUtils jsonUtils = new JsonUtils();

                RestTemplate dndService = new RestTemplate();
                monsters.getMonsters().parallelStream().forEach(monster -> System.out.println(dndService.postForObject("http://localhost:3000/monsters", jsonUtils.getJsonNodeFromMonster(monster),String.class)));
            } catch (IOException e) {
                Map<String, Object> inputs = new HashMap<>();
                inputs.put("args", args);
                ErrorLogging.log("main", inputs, e);
            }

        }else{
            System.out.println("Invalid input ...");
        }
    }
}
