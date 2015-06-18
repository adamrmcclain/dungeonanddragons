package processdata;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import junit.framework.TestCase;
import common.Constants;
import monster.Monsters;
import org.junit.Test;
import utils.json.JsonUtils;

import java.util.Collection;

/**
 * Created by Adam And Lauren on 5/31/2015.
 */
public class ProcessMonstersTest extends TestCase {

    String monsterInput = "AIR ELEMENTAL\r\n" +
            "Large elemental, neutral\r\n" +
            "\r\n" +
            "Armor Class 15\r\n" +
            "\r\n" +
            "Hit Points 90 (12d10 + 24)\r\n" +
            "\r\n" +
            "Speed 0 ft., fly 90 ft. (hover)\r\n" +
            "\r\n" +
            "STR\tDEX\tCON\tINT\tWIS\tCHA\r\n" +
            "14 (+2)\t20 (+5)\t14 (+2)\t6 (?2)\t10 (+0)\t6 (?2)\r\n" +
            "\r\n" +
            "Damage Resistances lightning, thunder; bludgeoning, piercing, and slashing from nonmagical weapons\r\n" +
            "\r\n" +
            "Damage Immunities poison\r\n" +
            "\r\n" +
            "Condition Immunities exhaustion, grappled, paralyzed, petrified, poisoned, prone, restrained, unconscious\r\n" +
            "\r\n" +
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
            "\r\n" +
            "If the saving throw is successful, the target takes half the bludgeoning damage and isn’t flung away or knocked prone.\r\n" +
            " \r\n" +
            " \r\n" +
            "ASSASSIN\r\n" +
            "Medium humanoid (any race), any non-good alignment\r\n" +
            "\r\n" +
            "Armor Class 15 (studded leather)\r\n" +
            "\r\n" +
            "Hit Points 78 (12d8 + 24)\r\n" +
            "\r\n" +
            "Speed 30 ft.\r\n" +
            "\r\n" +
            "STR\tDEX\tCON\tINT\tWIS\tCHA\r\n" +
            "11 (+0)\t16 (+3)\t14 (+2)\t13 (+1)\t11 (+0)\t10 (+0)\r\n" +
            "\r\n" +
            "Saving Throws Dex +7, Int +5\r\n" +
            "\r\n" +
            "Skills Acrobatics +7, Deception +4, Perception +4, Stealth +11\r\n" +
            "\r\n" +
            "Damage Resistances poison\r\n" +
            "\r\n" +
            "Senses passive Perception 14\r\n" +
            "\r\n" +
            "Languages Thieves’ cant plus any two languages\r\n" +
            "\r\n" +
            "Challenge 8 (3,900 XP)\r\n" +
            "\r\n" +
            "Assassinate. During its first turn, the assassin has advantage on attack rolls against any creature that hasn’t taken a turn. Any hit the assassin scores against a surprised creature\r\n" +
            "is a critical hit.\r\n" +
            "\r\n" +
            "Evasion. If the assassin is subjected to an effect that allows it to make a Dexterity saving throw to take only half damage, the assassin instead takes no damage if it succeeds on the saving throw, and only half damage if it fails.\r\n" +
            "\r\n" +
            "Sneak Attack (1/Turn). The assassin deals an extra 13 (4d6) damage when it hits a target with a weapon attack and has advantage on the attack roll, or when the target is within 5 feet of an ally of the assassin that isn’t incapacitated and the assassin doesn’t have disadvantage on the attack roll.\r\n" +
            "\r\n" +
            " \r\n" +
            "\r\n" +
            "ACTIONS\r\n" +
            "\r\n" +
            "Multiattack. The assassin makes two shortsword attacks.\r\n" +
            "\r\n" +
            "Shortsword. Melee Weapon Attack: +7 to hit, reach 5 ft., one target. Hit: 6 (1d6 + 3) piercing damage, and the target must make a DC 15 Constitution saving throw, taking 24 (7d6) poison damage on a failed save, or half as much damage on a successful one.\r\n" +
            "\r\n" +
            "Light Crossbow. Ranged Weapon Attack: +7 to hit, range 80/320 ft., one target. Hit: 7 (1d8 + 3) piercing damage, and the target must make a DC 15 Constitution saving throw, taking 24 (7d6) poison damage on a failed save, or half as much damage on a successful one.\r\n" +
            "\r\n" +
            "BANDIT\r\n" +
            "Medium humanoid (any race), any non-lawful alignment\r\n" +
            "\r\n" +
            "Armor Class 12 (leather armor)\r\n" +
            "\r\n" +
            "Hit Points 11 (2d8 + 2)\r\n" +
            "\r\n" +
            "Speed 30 ft.\r\n" +
            "\r\n" +
            "STR\tDEX\tCON\tINT\tWIS\tCHA\r\n" +
            "11 (+0)\t12 (+1)\t12 (+1)\t10 (+0)\t10 (+0)\t10 (+0)\r\n" +
            "\r\n" +
            "Senses passive Perception 10\r\n" +
            "\r\n" +
            "Languages any one language (usually Common)\r\n" +
            "\r\n" +
            "Challenge 1/8 (25 XP)\r\n" +
            "\r\n" +
            "ACTIONS\r\n" +
            "\r\n" +
            "Scimitar. Melee Weapon Attack: +3 to hit, reach 5 ft., one target. Hit: 4 (1d6 + 1) slashing damage.\r\n" +
            "\r\n" +
            "Light Crossbow. Ranged Weapon Attack: +3 to hit, range 80 ft./320 ft., one target. Hit: 5 (1d8 + 1) piercing damage.";

    ProcessMonsters processMonsters = new ProcessMonsters();
    JsonUtils jsonUtils = new JsonUtils();


    @Test
    public void testGetMonsterList() throws Exception {
        ObjectNode monsters = processMonsters.getMonsterList(monsterInput);
        Monsters monsters1 = jsonUtils.mapJsonToMonsters(jsonUtils.getJsonNodeFromString(monsters.toString()));
        assertEquals(3,monsters1.getMonsters().size());
    }

    @Test
    public void testGetMonsterInformation() throws Exception {
        Collection<String> monsterArray = processMonsters.getMonsterInformation(monsterInput);
        assertNotNull(monsterArray);
        assertEquals(3, monsterArray.size());
        assertTrue(monsterArray.toArray()[1].toString().contains("ASSASSIN"));
    }

    @Test
    public void testFindMonsterNames() throws Exception {
        Collection<String> monsterNames = processMonsters.findMonsterNames(monsterInput);
        assertEquals(3, monsterNames.size());
        assertEquals("AIR ELEMENTAL", monsterNames.toArray()[0]);
    }

    @Test
    public void testGetMonsterJson() throws Exception {
        String monster = "VAMPIRE\r\n" +
                "Medium undead (shapechanger), lawful evil\r\n" +
                "\r\n" +
                "Armor Class 16 (natural armor)\r\n" +
                "\r\n" +
                "Hit Points 144 (17d8 + 68)\r\n" +
                "\r\n" +
                "Speed 30 ft.\r\n" +
                "\r\n" +
                "STR\tDEX\tCON\tINT\tWIS\tCHA\r\n" +
                "18 (+4)\t18 (+4)\t18 (+4)\t17 (+3)\t15 (+2)\t18 (+4)\r\n" +
                "\r\n" +
                "Saving Throws Dex +9, Wis +7, Cha +9 Skills Perception +7, Stealth +9\r\n" +
                "\r\n" +
                "Damage Resistances necrotic; bludgeoning, piercing, and slashing from nonmagical weapons\r\n" +
                "\r\n" +
                "Senses darkvision 120 ft., passive Perception 17 Languages the languages it knew in life Challenge 13 (10,000 XP)\r\n" +
                "\r\n" +
                "Shapechanger. If the vampire isn’t in sunlight or running water, it can use its action to polymorph into a Tiny bat or a Medium cloud of mist, or back into its true form.\r\n" +
                "\r\n" +
                "While in bat form, the vampire can’t speak, its walking speed is 5 feet, and it has a flying speed of 30 feet. Its statistics, other than its size and speed, are unchanged. Anything it is wearing transforms with it, but nothing it is carrying does. It reverts to its true form if it dies.\r\n" +
                "\r\n" +
                "While in mist form, the vampire can’t take any actions, speak, or manipulate objects. It is weightless, has a flying speed of 20 feet, can hover, and can enter a hostile creature’s space and stop there. In addition, if air can pass through a space, the mist can do so without squeezing, and it can’t pass through water. It has advantage on Strength, Dexterity, and Constitution saving throws, and it is immune to all nonmagical damage, except the damage it takes from sunlight.\r\n" +
                "\r\n" +
                "Legendary Resistance (3/Day). If the vampire fails a saving throw, it can choose to succeed instead.\r\n" +
                "\r\n" +
                "Misty Escape. When it drops to 0 hit points outside its resting place, the vampire transforms into a cloud of mist (as in the Shapechanger trait) instead of falling unconscious, provided that it isn’t in sunlight or running water. If it can’t transform, it is destroyed.\r\n" +
                "\r\n" +
                "While it has 0 hit points in mist form, it can’t revert to its vampire form, and it must reach its resting place within 2 hours or be destroyed. Once in its resting place, it reverts to its vampire form. It is then paralyzed until it regains at least 1 hit point. After spending 1 hour in its resting place with 0 hit points, it regains 1 hit point.\r\n" +
                "\r\n" +
                "Regeneration. The vampire regains 20 hit points at the start of its turn if it has at least 1 hit point and isn’t in sunlight or running water. If the vampire takes radiant damage or damage from holy water, this trait doesn’t function at the start of the vampire’s next turn.\r\n" +
                "\r\n" +
                "Spider Climb. The vampire can climb difficult surfaces, including upside down on ceilings, without needing to make an ability check.\r\n" +
                "\r\n" +
                "Vampire Weaknesses. The vampire has the following flaws:\r\n" +
                "\r\n" +
                "Forbiddance. The vampire can’t enter a residence without an invitation from one of the occupants.\r\n" +
                "\r\n" +
                "Harmed by Running Water. The vampire takes 20 acid damage if it ends its turn in running water.\r\n" +
                "\r\n" +
                "Stake to the Heart. If a piercing weapon made of wood is driven into the vampire’s heart while the vampire is\r\n" +
                " \r\n" +
                "\r\n" +
                "incapacitated in its resting place, the vampire is paralyzed until the stake is removed.\r\n" +
                "\r\n" +
                "Sunlight Hypersensitivity. The vampire takes 20 radiant damage when it starts its turn in sunlight. While in sunlight, it has disadvantage on attack rolls and ability checks.\r\n" +
                "\r\n" +
                "ACTIONS\r\n" +
                "\r\n" +
                "Multiattack (Vampire Form Only). The vampire makes two attacks, only one of which can be a bite attack.\r\n" +
                "\r\n" +
                "Unarmed Strike (Vampire Form Only). Melee Weapon Attack:\r\n" +
                "\r\n" +
                "+9 to hit, reach 5 ft., one creature. Hit: 8 (1d8 + 4) bludgeoning damage. Instead of dealing damage, the vampire can grapple the target (escape DC 18).\r\n" +
                "\r\n" +
                "Bite (Bat or Vampire Form Only). Melee Weapon Attack: +9 to hit, reach 5 ft., one willing creature, or a creature that is grappled by the vampire, incapacitated, or restrained. Hit: 7\r\n" +
                "\r\n" +
                "(1d6 + 4) piercing damage plus 10 (3d6) necrotic damage. The target’s hit point maximum is reduced by an amount equal to the necrotic damage taken, and the vampire regains hit points equal to that amount. The reduction lasts until the target finishes a long rest. The target dies if this effect reduces its hit point maximum to 0. A humanoid slain in this way and then buried in the ground rises the following night as a vampire spawn under the vampire’s control.\r\n" +
                "\r\n" +
                "Charm. The vampire targets one humanoid it can see within 30 feet of it. If the target can see the vampire, the target must succeed on a DC 17 Wisdom saving throw against this magic or be charmed by the vampire. The charmed target regards the vampire as a trusted friend to be heeded and protected. Although the target isn’t under the vampire’s control, it takes the vampire’s requests or actions in the most favorable way it can, and it is a willing target for the vampire’s bit attack.\r\n" +
                "\r\n" +
                "Each time the vampire or the vampire’s companions do anything harmful to the target, it can repeat the saving throw, ending the effect on itself on a success. Otherwise, the effect lasts 24 hours or until the vampire is destroyed, is on a different plane of existence than the target, or takes a bonus action to end the effect.\r\n" +
                "\r\n" +
                "Children of the Night (1/Day). The vampire magically calls 2d4 swarms of bats or rats, provided that the sun isn’t up. While outdoors, the vampire can call 3d6 wolves instead. The called creatures arrive in 1d4 rounds, acting as allies of the vampire and obeying its spoken commands. The beasts remain for 1 hour, until the vampire dies, or until the vampire dismisses them as a bonus action.\r\n" +
                "\r\n" +
                "LEGENDARY ACTIONS\r\n" +
                "\r\n" +
                "The vampire can take 3 legendary actions, choosing from the options below. Only one legendary action option can be used at a time and only at the end of another creature’s turn. The vampire regains spent legendary actions at the start of its turn.\r\n" +
                "\r\n" +
                "Move. The vampire moves up to its speed without provoking opportunity attacks.\r\n" +
                "\r\n" +
                "Unarmed Strike. The vampire makes one unarmed strike. Bite (Costs 2 Actions). The vampire makes one bite attack.";

        processMonsters.getMonsterJson(monster);
    }

    @Test
    public void testAddAttributesToJson(){
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode monsters = mapper.createArrayNode();
        ObjectNode monsterAttributes = mapper.createObjectNode();

        processMonsters.addAttributesToJson(monsterAttributes, "Armor Class 16 (natural armor)");
        processMonsters.addAttributesToJson(monsterAttributes, "STR\tDEX\tCON\tINT\tWIS\tCHA\r\n" +
                "17 (+3)\t14 (+2)\t10 (+0)\t1 (-5)\t3 (-4)\t1 (-5)");

        monsters.add(monsterAttributes);
        ObjectNode root = mapper.createObjectNode();
        root.putPOJO("Monsters",monsters);

        JsonUtils jsonUtils = new JsonUtils();
        Monsters monsters1 = jsonUtils.mapJsonToMonsters(jsonUtils.getJsonNodeFromString(root.toString()));

        assertEquals("16 (natural armor)", monsterAttributes.get(Constants.ArmorClass).asText());
        assertEquals(monsters1.getMonsters().get(0).getStats().getStrength(), "17 (+3)");
    }

    @Test
    public void testGetMonsters(){
            Monsters monsters = processMonsters.getMonsters(monsterInput);
            assertEquals(3,monsters.getMonsters().size());
            assertEquals("AIR ELEMENTAL",monsters.getMonsters().get(0).getMonsterName());
            monsters.getMonsters().get(0).getConditionImmunities().stream().forEach(s -> System.out.println(s));
            assertEquals(8, monsters.getMonsters().get(0).getConditionImmunities().size());
    }
}