package dataaccess;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.data.mongodb.repository.MongoRepository;
import utils.errorlogging.ErrorLogging;

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
}
