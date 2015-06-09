
package monster;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "Monster Name",
    "Size",
    "Race",
    "Alignment",
    "Armor Class",
    "Hit Points",
    "Speed",
    "Stats",
    "Saving Throws",
    "Skills",
    "Damage Immunities",
    "Damage Resistances",
    "Condition Immunities",
    "Senses",
    "Languages",
    "Challenge",
    "Experience",
    "Actions",
    "Legendary Actions",
    "Reactions",
    "Additional Information"
})
public class Monster {

    @JsonProperty("Monster Name")
    private String MonsterName;
    @JsonProperty("Size")
    private String Size;
    @JsonProperty("Race")
    private String Race;
    @JsonProperty("Alignment")
    private String Alignment;
    @JsonProperty("Armor Class")
    private String ArmorClass;
    @JsonProperty("Hit Points")
    private String HitPoints;
    @JsonProperty("Speed")
    private String Speed;
    @JsonProperty("Stats")
    private monster.Stats Stats;
    @JsonProperty
    private List<String> SavingThrows = new ArrayList<String>();
    @JsonProperty("Skills")
    private List<String> Skills = new ArrayList<String>();
    @JsonProperty("Damage Immunities")
    private List<String> DamageImmunities= new ArrayList<String>();
    @JsonProperty("Damage Resistances")
    private List<String> DamageResistances = new ArrayList<String>();
    @JsonProperty("Condition Immunities")
    private List<String> ConditionImmunities = new ArrayList<String>();
    @JsonProperty("Senses")
    private List<String> Senses = new ArrayList<String>();
    @JsonProperty("Languages")
    private List<String> Languages = new ArrayList<String>();
    @JsonProperty("Challenge")
    private String Challenge;
    @JsonProperty("Experience")
    private String Experience;
    @JsonProperty("Actions")
    private List<String> Actions = new ArrayList<String>();
    @JsonProperty("Legendary Actions")
    private List<String> LegendaryActions = new ArrayList<String>();
    @JsonProperty("Reactions")
    private List<String> Reactions = new ArrayList<String>();
    @JsonProperty("Additional Information")
    private List<String> AdditionalInformation = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The MonsterName
     */
    @JsonProperty("Monster Name")
    public String getMonsterName() {
        return MonsterName;
    }

    /**
     * 
     * @param MonsterName
     *     The Monster Name
     */
    @JsonProperty("Monster Name")
    public void setMonsterName(String MonsterName) {
        this.MonsterName = MonsterName;
    }

    /**
     * 
     * @return
     *     The Size
     */
    @JsonProperty("Size")
    public String getSize() {
        return Size;
    }

    /**
     * 
     * @param Size
     *     The Size
     */
    @JsonProperty("Size")
    public void setSize(String Size) {
        this.Size = Size;
    }

    /**
     * 
     * @return
     *     The Race
     */
    @JsonProperty("Race")
    public String getRace() {
        return Race;
    }

    /**
     * 
     * @param Race
     *     The Race
     */
    @JsonProperty("Race")
    public void setRace(String Race) {
        this.Race = Race;
    }

    /**
     * 
     * @return
     *     The Alignment
     */
    @JsonProperty("Alignment")
    public String getAlignment() {
        return Alignment;
    }

    /**
     * 
     * @param Alignment
     *     The Alignment
     */
    @JsonProperty("Alignment")
    public void setAlignment(String Alignment) {
        this.Alignment = Alignment;
    }

    /**
     * 
     * @return
     *     The ArmorClass
     */
    @JsonProperty("Armor Class")
    public String getArmorClass() {
        return ArmorClass;
    }

    /**
     * 
     * @param ArmorClass
     *     The Armor Class
     */
    @JsonProperty("Armor Class")
    public void setArmorClass(String ArmorClass) {
        this.ArmorClass = ArmorClass;
    }

    /**
     * 
     * @return
     *     The HitPoints
     */
    @JsonProperty("Hit Points")
    public String getHitPoints() {
        return HitPoints;
    }

    /**
     * 
     * @param HitPoints
     *     The Hit Points
     */
    @JsonProperty("Hit Points")
    public void setHitPoints(String HitPoints) {
        this.HitPoints = HitPoints;
    }

    /**
     * 
     * @return
     *     The Speed
     */
    @JsonProperty("Speed")
    public String getSpeed() {
        return Speed;
    }

    /**
     * 
     * @param Speed
     *     The Speed
     */
    @JsonProperty("Speed")
    public void setSpeed(String Speed) {
        this.Speed = Speed;
    }

    /**
     * 
     * @return
     *     The Stats
     */
    @JsonProperty("Stats")
    public monster.Stats getStats() {
        return Stats;
    }

    /**
     * 
     * @param Stats
     *     The Stats
     */
    @JsonProperty("Stats")
    public void setStats(monster.Stats Stats) {
        this.Stats = Stats;
    }

    /**
     * 
     * @return
     *     The Skills
     */
    @JsonProperty("Skills")
    public List<String> getSkills() {
        return Skills;
    }

    /**
     * 
     * @param Skills
     *     The Skills
     */
    @JsonProperty("Skills")
    public void setSkills(List<String> Skills) {
        this.Skills = Skills;
    }

    /**
     * 
     * @return
     *     The Senses
     */
    @JsonProperty("Senses")
    public List<String> getSenses() {
        return Senses;
    }

    /**
     * 
     * @param Senses
     *     The Senses
     */
    @JsonProperty("Senses")
    public void setSenses(List<String> Senses) {
        this.Senses = Senses;
    }

    /**
     * 
     * @return
     *     The Languages
     */
    @JsonProperty("Languages")
    public List<String> getLanguages() {
        return Languages;
    }

    /**
     * 
     * @param Languages
     *     The Languages
     */
    @JsonProperty("Languages")
    public void setLanguages(List<String> Languages) {
        this.Languages = Languages;
    }

    /**
     * 
     * @return
     *     The Challenge
     */
    @JsonProperty("Challenge")
    public String getChallenge() {
        return Challenge;
    }

    /**
     * 
     * @param Challenge
     *     The Challenge
     */
    @JsonProperty("Challenge")
    public void setChallenge(String Challenge) {
        this.Challenge = Challenge;
    }

    /**
     * 
     * @return
     *     The Experience
     */
    @JsonProperty("Experience")
    public String getExperience() {
        return Experience;
    }

    /**
     * 
     * @param Experience
     *     The Experience
     */
    @JsonProperty("Experience")
    public void setExperience(String Experience) {
        this.Experience = Experience;
    }

    /**
     * 
     * @return
     *     The Actions
     */
    @JsonProperty("Actions")
    public List<String> getActions() {
        return Actions;
    }

    /**
     * 
     * @param Actions
     *     The Actions
     */
    @JsonProperty("Actions")
    public void setActions(List<String> Actions) {
        this.Actions = Actions;
    }

    /**
     * 
     * @return
     *     The LegendaryActions
     */
    @JsonProperty("Legendary Actions")
    public List<String> getLegendaryActions() {
        return LegendaryActions;
    }

    /**
     * 
     * @param LegendaryActions
     *     The Legendary Actions
     */
    @JsonProperty("Legendary Actions")
    public void setLegendaryActions(List<String> LegendaryActions) {
        this.LegendaryActions = LegendaryActions;
    }

    /**
     * 
     * @return
     *     The AdditionalInformation
     */
    @JsonProperty("Additional Information")
    public List<String> getAdditionalInformation() {
        return AdditionalInformation;
    }

    /**
     * 
     * @param AdditionalInformation
     *     The Additional Information
     */
    @JsonProperty("Additional Information")
    public void setAdditionalInformation(List<String> AdditionalInformation) {
        this.AdditionalInformation = AdditionalInformation;
    }

    @JsonProperty("Damage Immunties")
    public List<String> getDamageImmunities() {
        return DamageImmunities;
    }

    @JsonProperty("Damage Immunties")
    public void setDamageImmunities(List<String> damageImmunities) {
        DamageImmunities = damageImmunities;
    }

    @JsonProperty("Damage Resistances")
    public List<String> getDamageResistances() {
        return DamageResistances;
    }

    @JsonProperty("Damage Resistances")
    public void setDamageResistances(List<String> damageResistances) {
        DamageResistances = damageResistances;
    }

    @JsonProperty("Condition Immunties")
    public List<String> getConditionImmunities() {
        return ConditionImmunities;
    }

    @JsonProperty("Condition Immunties")
    public void setConditionImmunities(List<String> conditionImmunities) {
        ConditionImmunities = conditionImmunities;
    }

    @JsonProperty("Saving Throws")
    public List<String> getSavingThrows() {
        return SavingThrows;
    }

    @JsonProperty("Reactions")
    public void setReactions(List<String> reactions) {
        Reactions = reactions;
    }

    @JsonProperty("Reactions")
    public List<String> getReactions() {
        return Reactions;
    }

    @JsonProperty("Saving Throws")
    public void setSavingThrows(List<String> savingThrows) {
        SavingThrows = savingThrows;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
