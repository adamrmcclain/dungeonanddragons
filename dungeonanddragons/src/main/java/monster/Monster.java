
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
    "MonsterName",
    "Size",
    "Race",
    "Alignment",
    "ArmorClass",
    "HitPoints",
    "Speed",
    "Stats",
    "SavingThrows",
    "Skills",
    "DamageImmunities",
    "DamageResistances",
    "ConditionImmunities",
    "Senses",
    "Languages",
    "Challenge",
    "Experience",
    "Actions",
    "LegendaryActions",
    "Reactions",
    "AdditionalInformation"
})
public class Monster {

    @JsonProperty("MonsterName")
    private String MonsterName;
    @JsonProperty("Size")
    private String Size;
    @JsonProperty("Race")
    private String Race;
    @JsonProperty("Alignment")
    private String Alignment;
    @JsonProperty("ArmorClass")
    private String ArmorClass;
    @JsonProperty("HitPoints")
    private String HitPoints;
    @JsonProperty("Speed")
    private String Speed;
    @JsonProperty("Stats")
    private monster.Stats Stats;
    @JsonProperty("SavingThrows")
    private List<String> SavingThrows = new ArrayList<String>();
    @JsonProperty("Skills")
    private List<String> Skills = new ArrayList<String>();
    @JsonProperty("DamageImmunities")
    private List<String> DamageImmunities= new ArrayList<String>();
    @JsonProperty("DamageResistances")
    private List<String> DamageResistances = new ArrayList<String>();
    @JsonProperty("ConditionImmunities")
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
    @JsonProperty("LegendaryActions")
    private List<String> LegendaryActions = new ArrayList<String>();
    @JsonProperty("Reactions")
    private List<String> Reactions = new ArrayList<String>();
    @JsonProperty("AdditionalInformation")
    private List<String> AdditionalInformation = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The MonsterName
     */
    @JsonProperty("MonsterName")
    public String getMonsterName() {
        return MonsterName;
    }

    /**
     * 
     * @param MonsterName
     *     The MonsterName
     */
    @JsonProperty("MonsterName")
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
    @JsonProperty("ArmorClass")
    public String getArmorClass() {
        return ArmorClass;
    }

    /**
     * 
     * @param ArmorClass
     *     The ArmorClass
     */
    @JsonProperty("ArmorClass")
    public void setArmorClass(String ArmorClass) {
        this.ArmorClass = ArmorClass;
    }

    /**
     * 
     * @return
     *     The HitPoints
     */
    @JsonProperty("HitPoints")
    public String getHitPoints() {
        return HitPoints;
    }

    /**
     * 
     * @param HitPoints
     *     The HitPoints
     */
    @JsonProperty("HitPoints")
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
    @JsonProperty("LegendaryActions")
    public List<String> getLegendaryActions() {
        return LegendaryActions;
    }

    /**
     * 
     * @param LegendaryActions
     *     The LegendaryActions
     */
    @JsonProperty("LegendaryActions")
    public void setLegendaryActions(List<String> LegendaryActions) {
        this.LegendaryActions = LegendaryActions;
    }

    /**
     * 
     * @return
     *     The AdditionalInformation
     */
    @JsonProperty("AdditionalInformation")
    public List<String> getAdditionalInformation() {
        return AdditionalInformation;
    }

    /**
     * 
     * @param AdditionalInformation
     *     The AdditionalInformation
     */
    @JsonProperty("AdditionalInformation")
    public void setAdditionalInformation(List<String> AdditionalInformation) {
        this.AdditionalInformation = AdditionalInformation;
    }

    @JsonProperty("DamageImmunities")
    public List<String> getDamageImmunities() {
        return DamageImmunities;
    }

    @JsonProperty("DamageImmunities")
    public void setDamageImmunities(List<String> damageImmunities) {
        DamageImmunities = damageImmunities;
    }

    @JsonProperty("DamageResistances")
    public List<String> getDamageResistances() {
        return DamageResistances;
    }

    @JsonProperty("DamageResistances")
    public void setDamageResistances(List<String> damageResistances) {
        DamageResistances = damageResistances;
    }

    @JsonProperty("ConditionImmunities")
    public List<String> getConditionImmunities() {
        return ConditionImmunities;
    }

    @JsonProperty("ConditionImmunities")
    public void setConditionImmunities(List<String> conditionImmunities) {
        ConditionImmunities = conditionImmunities;
    }

    @JsonProperty("SavingThrows")
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

    @JsonProperty("SavingThrows")
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
