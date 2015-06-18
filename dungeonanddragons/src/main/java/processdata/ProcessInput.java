package processdata;

import dataaccess.MongoConnection;
import monster.Monsters;
import utils.errorlogging.ErrorLogging;

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
                System.out.println("monster string : " + monsterInput);
                ProcessMonsters processMonsters = new ProcessMonsters();
                Monsters monsters = processMonsters.getMonsters(monsterInput);
                MongoConnection mongoConnection = new MongoConnection();
                mongoConnection.postMonsters(monsters);
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
