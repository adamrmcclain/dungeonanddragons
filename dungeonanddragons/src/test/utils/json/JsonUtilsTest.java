package utils.json;

import com.fasterxml.jackson.databind.JsonNode;
import monster.Monsters;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Adam And Lauren on 6/6/2015.
 */
public class JsonUtilsTest {

    String monsterJsonString = "{\"Monsters\":[{\"Monster Name\":\"AIR ELEMENTAL\",\"Size\":\"Large elemental\",\"Alignment\":\"neutral\",\"Armor Class\":\"Hit Points 90 (12d10 + 24)\",\"Speed\":\"0 ft., fly 90 ft. (hover)\",\"Stats\":{\"Strength\":\"14 (+2)\",\"Dexterity\":\"20 (+5)\",\"Constitution\":\"14 (+2)\",\"Intelligence\":\"6 (?2)\",\"Wisdom\":\"10 (+0)\",\"Charisma\":\"6 (?2)\"},\"Damage Resistances\":[\" lightning\",\" thunder; bludgeoning\",\" piercing\",\" and slashing from nonmagical weapons\"],\"Damage Immunities\":[\" poison\"],\"Condition Immunities\":[\" exhaustion\",\" grappled\",\" paralyzed\",\" petrified\",\" poisoned\",\" prone\",\" restrained\",\" unconscious\\nSenses darkvision 60 ft.\",\" passive Perception 10\"],\"Languages\":[\" Auran\"],\"Challenge\":\" 5 \",\"Experience\":\"1,800 XP)\",\"Additional Information\":[\"Challenge 5 (1,800 XP)\",\"Air Form. The elemental can enter a hostile creature?s space and stop there. It can move through a space as narrow as 1 inch wide without squeezing.\"],\"ACTIONS\":[\"Multiattack. The elemental makes two slam attacks.\",\"Slam. Melee Weapon Attack: +8 to hit, reach 5 ft., one target. Hit: 14 (2d8 + 5) bludgeoning damage.\",\"Whirlwind (Recharge 4?6). Each creature in the elemental?s space must make a DC 13 Strength saving throw. On a failure, a target takes 15 (3d8 + 2) bludgeoning damage and is flung up 20 feet away from the elemental in a random direction and knocked prone. If a thrown target strikes an object, such as a wall or floor, the target takes 3 (1d6) bludgeoning damage for every 10 feet it was thrown. If the target is thrown at another creature, that creature must succeed on a DC 13 Dexterity saving throw or take the same damage and be knocked prone.\",\"If the saving throw is successful, the target takes half the bludgeoning damage and isn?t flung away or knocked prone.\\n \\n \\n\"]},{\"Monster Name\":\"ASSASSIN\",\"Size\":\"Medium humanoid (any race)\",\"Alignment\":\"any non-good alignment\",\"Armor Class\":\"Hit Points 78 (12d8 + 24)\",\"Speed\":\"30 ft.\",\"Stats\":{\"Strength\":\"11 (+0)\",\"Dexterity\":\"16 (+3)\",\"Constitution\":\"14 (+2)\",\"Intelligence\":\"13 (+1)\",\"Wisdom\":\"11 (+0)\",\"Charisma\":\"10 (+0)\"},\"Saving Throws\":[\" Dex +7\",\" Int +5\"],\"Skills\":[\" Acrobatics +7\",\" Deception +4\",\" Perception +4\",\" Stealth +11\"],\"Damage Resistances\":[\" poison\"],\"Senses\":[\" passive Perception 14\"],\"Languages\":[\" Thieves? cant plus any two languages\"],\"Challenge\":\" 8 \",\"Experience\":\"3,900 XP)\",\"Additional Information\":[\"Challenge 8 (3,900 XP)\",\"Assassinate. During its first turn, the assassin has advantage on attack rolls against any creature that hasn?t taken a turn. Any hit the assassin scores against a surprised creature\\nis a critical hit.\",\"Evasion. If the assassin is subjected to an effect that allows it to make a Dexterity saving throw to take only half damage, the assassin instead takes no damage if it succeeds on the saving throw, and only half damage if it fails.\",\"Sneak Attack (1/Turn). The assassin deals an extra 13 (4d6) damage when it hits a target with a weapon attack and has advantage on the attack roll, or when the target is within 5 feet of an ally of the assassin that isn?t incapacitated and the assassin doesn?t have disadvantage on the attack roll.\",\" \"],\"ACTIONS\":[\"Multiattack. The assassin makes two shortsword attacks.\",\"Shortsword. Melee Weapon Attack: +7 to hit, reach 5 ft., one target. Hit: 6 (1d6 + 3) piercing damage, and the target must make a DC 15 Constitution saving throw, taking 24 (7d6) poison damage on a failed save, or half as much damage on a successful one.\",\"Light Crossbow. Ranged Weapon Attack: +7 to hit, range 80/320 ft., one target. Hit: 7 (1d8 + 3) piercing damage, and the target must make a DC 15 Constitution saving throw, taking 24 (7d6) poison damage on a failed save, or half as much damage on a successful one.\"]},{\"Monster Name\":\"BANDIT\",\"Size\":\"Medium humanoid (any race)\",\"Alignment\":\"any non-lawful alignment\",\"Armor Class\":\"Hit Points 11 (2d8 + 2)\",\"Speed\":\"30 ft.\",\"Stats\":{\"Strength\":\"11 (+0)\",\"Dexterity\":\"12 (+1)\",\"Constitution\":\"12 (+1)\",\"Intelligence\":\"10 (+0)\",\"Wisdom\":\"10 (+0)\",\"Charisma\":\"10 (+0)\"},\"Senses\":[\" passive Perception 10\"],\"Languages\":[\" any one language (usually Common)\"],\"Challenge\":\" 1/8 \",\"Experience\":\"25 XP)\",\"Additional Information\":[\"Challenge 1/8 (25 XP)\"],\"ACTIONS\":[\"Scimitar. Melee Weapon Attack: +3 to hit, reach 5 ft., one target. Hit: 4 (1d6 + 1) slashing damage.\",\"Light Crossbow. Ranged Weapon Attack: +3 to hit, range 80 ft./320 ft., one target. Hit: 5 (1d8 + 1) piercing damage.\\n\"]}]}";


    @Test
    public void testGetJsonNodeFromString() throws Exception {
        JsonUtils jsonUtils = new JsonUtils();
        JsonNode monster = jsonUtils.getJsonNodeFromString(monsterJsonString);
        String s = monster.get("Monsters").get(0).get("Monster Name").asText();
        assertEquals("AIR ELEMENTAL", s);
    }

    @Test
    public void testMapJsonToMonster() throws Exception {
        JsonUtils jsonUtils = new JsonUtils();
        JsonNode monster = jsonUtils.getJsonNodeFromString(monsterJsonString);
        Monsters monsters = jsonUtils.mapJsonToMonster(monster);
        assertEquals("AIR ELEMENTAL", monsters.getMonsters().get(0).getMonsterName());
    }
}