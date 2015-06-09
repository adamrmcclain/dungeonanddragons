package processdata;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import monster.Monsters;
import utils.json.JsonUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Created by Adam And Lauren on 5/31/2015.
 */
public class ProcessMonsters {

    public Monsters getMonsters(String monsterInput){
        JsonUtils jsonUtils = new JsonUtils();
        JsonNode monsterNode = jsonUtils.getJsonNodeFromString(monsterInput);
        return jsonUtils.mapJsonToMonster(monsterNode);
    }

    public ObjectNode getMonsterList(String monsterInput){
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode monsterNode = mapper.createObjectNode();
        monsterNode.putPOJO("Monsters", getMonsterArray(monsterInput));
        return monsterNode;
    }

    protected ArrayNode getMonsterArray(String monsterInput) {
       Collection<String> monsters = getMonsterInformation(monsterInput);
        return getMonsterJson(monsters);
    }

    private ArrayNode getMonsterJson(Collection<String> monsters) {
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode monsterNode = mapper.createArrayNode();

        monsters.stream().forEach(monster -> {
            monsterNode.add(getMonsterJson(monster));
        });

        return monsterNode;
    }

    protected ObjectNode getMonsterJson(String monster) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode monsterNode = mapper.createObjectNode();

        List<String> monsterValues = Arrays.asList(monster.split("\\n\\n"));

        String[] monsterNameSizeAlignment = monsterValues.get(0).split("\\n");
        String monsterName = monsterNameSizeAlignment[0];
        String size = monsterNameSizeAlignment[1].split(",")[0].trim();
        String alignment = monsterNameSizeAlignment[1].split(",")[1].trim();

        monsterNode.put(Constants.MonsterName,monsterName);
        monsterNode.put(Constants.Size,size);
        monsterNode.put(Constants.Alignment,alignment);

        int actionIndex = monsterValues.indexOf(Constants.Actions);
        int legendaryIndex = monsterValues.indexOf(Constants.LegendaryActions);
        int reactionIndex = monsterValues.indexOf(Constants.Reactions);
        int challengeIndex = 0;

        for (int i = 2; i < actionIndex; i++) {
            boolean isChallengeRow = addAttributesToJson(monsterNode, monsterValues.get(i));
            if(isChallengeRow){
                challengeIndex = i;
                break;
            }
        }

        if(challengeIndex != 0) {
            monsterNode.putPOJO(Constants.AdditionalInformation, createArrayNode(monsterValues.subList(challengeIndex, actionIndex)));
        }

        if(legendaryIndex > -1){
            monsterNode.putPOJO("Legendary Actions", createArrayNode(monsterValues.subList(legendaryIndex + 1,monsterValues.size())));
            monsterNode.putPOJO("Actions", createArrayNode(monsterValues.subList(actionIndex + 1, legendaryIndex)));
        }
        else if(reactionIndex > -1){
            monsterNode.putPOJO("Reactions", createArrayNode(monsterValues.subList(reactionIndex + 1,monsterValues.size())));
            monsterNode.putPOJO("Actions", createArrayNode(monsterValues.subList(actionIndex + 1, reactionIndex)));
        }
        else
        {
            monsterNode.putPOJO(Constants.Actions, createArrayNode(monsterValues.subList(actionIndex + 1, monsterValues.size())));
        }

        return monsterNode;
    }

    private ArrayNode createArrayNode(List<String> info) {
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode additonalInformation = mapper.createArrayNode();
        info.forEach(s -> additonalInformation.add(s));
        return additonalInformation;
    }

    protected Collection<String> getMonsterInformation(String monsterInput) {
        Collection<String> monsterNames = findMonsterNames(monsterInput);
        Collection<String> monsterInfo = new ArrayList<>();
        Stream<String> monsterStream = monsterNames.stream();

        //TODO: Convert to stream
        /*monsterStream.forEach((monsterName) -> {

        });*/

        for (int i = 0; i < monsterNames.size() ; i++) {
            int startIndex = monsterInput.indexOf((String) monsterNames.toArray()[i]);
            int endIndex = monsterNames.size() == i + 1 ? monsterInput.length() : monsterInput.indexOf((String) monsterNames.toArray()[i + 1]);
            String monster = monsterInput.substring(startIndex,endIndex);
            monsterInfo.add(monster);
        }
        return monsterInfo;
    }

    protected Collection<String> findMonsterNames(String monsterInput) {
        Collection<String> monsterNames = new ArrayList<>();
        Pattern pattern = Pattern.compile(Constants.CapitalWordRegex);
        Matcher matcher = pattern.matcher(monsterInput);

        int counter = 0;

        while(matcher.find()){
            String monsterName = matcher.group(0).trim();
            if(!(monsterName.equals(Constants.Charisma) || monsterName.equals(Constants.Actions) || monsterName.equals(Constants.LegendaryActions))){
                monsterNames.add(monsterName);
            }
            counter++;
        }

        return monsterNames;
    }


    public boolean addAttributesToJson(ObjectNode monsterNode, String attribute) {
        ObjectMapper mapper = new ObjectMapper();

        if(attribute.startsWith(Constants.ArmorClass)){
            monsterNode.put(Constants.ArmorClass, attribute.replace(Constants.ArmorClass,"").trim());
            return false;
        }

        if(attribute.startsWith(Constants.HitPonts)){
            monsterNode.put(Constants.ArmorClass, attribute.replace(Constants.ArmorClass,"").trim());
            return false;
        }

        if(attribute.startsWith(Constants.Speed)){
            monsterNode.put(Constants.Speed, attribute.replace(Constants.Speed,"").trim());
            return false;
        }

        if(attribute.startsWith(Constants.StatisticList)){
            ObjectNode statsNode = getStatisticsNode(attribute, mapper);
            monsterNode.putPOJO(Constants.Stats, statsNode);
            return false;
        }

        if(attribute.startsWith(Constants.DamageImmunities)){
            attachArrayNode(attribute,Constants.DamageImmunities,monsterNode);
            return false;
        }

        if(attribute.startsWith(Constants.Skills)){
           attachArrayNode(attribute, Constants.Skills,monsterNode);
            return false;
        }

        if (attribute.startsWith(Constants.Senses)){
            attachArrayNode(attribute, Constants.Senses,monsterNode);
            return false;
        }

        if (attribute.startsWith(Constants.Languages)){
            attachArrayNode(attribute, Constants.Languages,monsterNode);
            return false;
        }

        if (attribute.startsWith(Constants.Challenge)){
            String[] challenge = attribute.replace(Constants.Challenge,"").split("\\(");
            monsterNode.put(Constants.Challenge,challenge[0]);
            monsterNode.put(Constants.Experience,challenge[1].replace("\\)",""));
            return true;
        }

        if(attribute.startsWith(Constants.ConditionImmunities)){
            attachArrayNode(attribute, Constants.ConditionImmunities,monsterNode);
            return false;
        }

        if(attribute.startsWith(Constants.DamageResistances)){
            attachArrayNode(attribute, Constants.DamageResistances,monsterNode);
            return false;
        }

        if(attribute.startsWith(Constants.SavingThrows)){
            attachArrayNode(attribute, Constants.SavingThrows,monsterNode);
            return false;
        }

        return false;
    }

    private void attachArrayNode(String attributeInput, String attributeName, ObjectNode rootNode) {
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode arrayNode = mapper.createArrayNode();
        String[] attributes = attributeInput.replace(attributeName, "").split(",");
        Stream<String> attributeStream = Stream.of(attributes);
        attributeStream.forEach(attribute -> arrayNode.add(attribute));
        rootNode.putPOJO(attributeName,arrayNode);
    }

    private ObjectNode getStatisticsNode(String attribute, ObjectMapper mapper) {
        ObjectNode statsNode = mapper.createObjectNode();
        String[] statistics = attribute.replace(Constants.StatisticList,"").trim().split("\\t");
        statsNode.put("Strength", statistics[0]);
        statsNode.put("Dexterity", statistics[1]);
        statsNode.put("Constitution", statistics[2]);
        statsNode.put("Intelligence", statistics[3]);
        statsNode.put("Wisdom", statistics[4]);
        statsNode.put("Charisma", statistics[5]);
        return statsNode;
    }
}
