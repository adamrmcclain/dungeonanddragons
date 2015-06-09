package dataaccess;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Adam And Lauren on 5/31/2015.
 */
public class MongoConnectionTest extends TestCase {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetMongoDbConnection(){
        MongoConnection mongoConnection = new MongoConnection();
        DB db = mongoConnection.getMongoConnection();
        DBCollection monsters = db.createCollection("Monsters", null);

    }

}