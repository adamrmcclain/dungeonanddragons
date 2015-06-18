package dataaccess;

import com.fasterxml.jackson.databind.JsonNode;
import com.mongodb.*;
import com.mongodb.util.JSON;
import common.Constants;
import monster.Monster;
import monster.Monsters;
import utils.errorlogging.ErrorLogging;
import utils.json.JsonUtils;

import java.net.UnknownHostException;

/**
 * Created by Adam And Lauren on 5/31/2015.
 */
public class MongoConnection {
    public DB getMongoConnection(){
        try {
            MongoClient mongoClient = new MongoClient();
            return mongoClient.getDB("dungeonsanddragons");
        } catch (UnknownHostException e) {
            ErrorLogging.log("getMongoConnection",null,e);
            e.printStackTrace();
        }
        return null;
    }

    public void postMonsters(Monsters monsters){
        DBCollection monstersCollection = getMonsterCollection();

        monsters.getMonsters().parallelStream().forEach(monster -> postMonster(monster,monstersCollection));
    }

    private void postMonster(Monster monster, DBCollection monstersCollection){
        JsonUtils jsonUtils = new JsonUtils();
        System.out.println("Inserting : " + jsonUtils.getJsonNodeFromMonster(monster).toString());
        DBObject monstersObject = (DBObject) JSON.parse(jsonUtils.getJsonNodeFromMonster(monster).toString());
        monstersCollection.insert(monstersObject);
    }

    public Monsters getMonsterData(String queryString){
        JsonUtils jsonUtils = new JsonUtils();

        DBCollection monstersCollection = getMonsterCollection();
        DBObject query = (DBObject) JSON.parse(queryString);
        DBCursor monsterObject = monstersCollection.find(query);

        String monsterString = getMonsterString(monsterObject);
        JsonNode jsonNodeFromString = jsonUtils.getJsonNodeFromString(monsterString);
        return jsonUtils.mapJsonToMonsters(jsonNodeFromString);
    }

    private String getMonsterString(DBCursor monsterObject) {
        StringBuilder monsterBuilder = new StringBuilder();
        monsterBuilder.append("{\"");
        monsterBuilder.append(Constants.Monsters);
        monsterBuilder.append("\":[");
        while (monsterObject.hasNext()) {
            String monsterString = monsterObject.next().toString();
            monsterBuilder.append(monsterString);
        }
        monsterBuilder.append("]");
        monsterBuilder.append("}");
        return monsterBuilder.toString();
    }

    public  void deleteMonsterData(Monsters monster){
        DBCollection monstersCollection = getMonsterCollection();
        JsonUtils jsonUtils = new JsonUtils();
        monster.getMonsters().parallelStream().forEach(m ->  monstersCollection.remove((DBObject) JSON.parse(jsonUtils.getJsonNodeFromMonster(m).toString())));
    }

    private DBCollection getMonsterCollection() {
        DB mongoConnection = getMongoConnection();
        return mongoConnection.getCollection("monsters");
    }
}
