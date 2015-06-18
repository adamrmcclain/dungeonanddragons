package dataaccess;

import junit.framework.TestCase;
import monster.Monsters;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import processdata.ProcessMonsters;

/**
 * Created by Adam And Lauren on 5/31/2015.
 */
public class MongoConnectionTest extends TestCase {


    MongoConnection mongoConnection = new MongoConnection();
    ProcessMonsters processMonsters = new ProcessMonsters();
    String monsterString;
    Monsters monsters;

    @Before
    public void setUp() throws Exception {
        monsterString = "AIR ELEMENTAL\r\n" +
                "Large elemental, neutral\r\n" +
                "\r\n" +
                "Armor Class 15\r\n" +
                "\r\n" +
                "Hit Points 90 (12d10 + 24)\r\n" +
                "\r\n" +
                "Speed 0 ft., fly 90 ft. (hover)\r\n" +
                "\r\n" +
                "STR\tDEX\tCON\tINT\tWIS\tCHA\r\n" +
                "14 (+2)\t20 (+5)\t14 (+2)\t6 (-2)\t10 (+0)\t6 (-2)\r\n" +
                "\r\n" +
                "Damage Resistances lightning, thunder; bludgeoning, piercing, and slashing from nonmagical weapons\r\n" +
                "\r\n" +
                "Damage Immunities poison\r\n" +
                "\r\n" +
                "Condition Immunities exhaustion, grappled, paralyzed, petrified, poisoned, prone, restrained, unconscious\r\n\r\n" +
                "Senses darkvision 60 ft., passive Perception 10\r\n" +
                "\r\n" +
                "Languages Auran\r\n" +
                "\r\n" +
                "Challenge 5 (1,800 XP)\r\n" +
                "\r\n" +
                "Air Form. The elemental can enter a hostile creature’s space and stop there. It can move through a space as narrow as 1 inch wide without squeezing.\r\n" +
                "\r\n" +
                "ACTIONS\r\n" +
                "\r\n" +
                "Multiattack. The elemental makes two slam attacks.\r\n" +
                "\r\n" +
                "Slam. Melee Weapon Attack: +8 to hit, reach 5 ft., one target. Hit: 14 (2d8 + 5) bludgeoning damage.\r\n" +
                "\r\n" +
                "Whirlwind (Recharge 4–6). Each creature in the elemental’s space must make a DC 13 Strength saving throw. On a failure, a target takes 15 (3d8 + 2) bludgeoning damage and is flung up 20 feet away from the elemental in a random direction and knocked prone. If a thrown target strikes an object, such as a wall or floor, the target takes 3 (1d6) bludgeoning damage for every 10 feet it was thrown. If the target is thrown at another creature, that creature must succeed on a DC 13 Dexterity saving throw or take the same damage and be knocked prone.\r\n" +
                "If the saving throw is successful, the target takes half the bludgeoning damage and isn’t flung away or knocked prone.";

        monsters = processMonsters.getMonsters(monsterString);
    }

    @After
    public void tearDown() throws Exception {
       mongoConnection.deleteMonsterData(monsters);
    }

    @Test
    public void testPostMonsterData(){
        mongoConnection.postMonsters(monsters);
    }

    @Test
    public void testDeleteMonsterData() throws Exception {
        mongoConnection.postMonsters(monsters);
        mongoConnection.deleteMonsterData(monsters);
    }

    @Test
    public void testGetMonsterData() throws Exception {
        mongoConnection.postMonsters(monsters);

        Monsters monster = mongoConnection.getMonsterData("{\"Monster Name\":\"AIR ELEMENTAL\"}");
        assertEquals("6 (-2)", monster.getMonsters().get(0).getStats().getCharisma());
    }
}