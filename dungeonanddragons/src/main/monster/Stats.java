
package monster;

import java.util.HashMap;
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
    "Strength",
    "Dexterity",
    "Constitution",
    "Intelligence",
    "Wisdom",
    "Charisma"
})
public class Stats {

    @JsonProperty("Strength")
    private String Strength;
    @JsonProperty("Dexterity")
    private String Dexterity;
    @JsonProperty("Constitution")
    private String Constitution;
    @JsonProperty("Intelligence")
    private String Intelligence;
    @JsonProperty("Wisdom")
    private String Wisdom;
    @JsonProperty("Charisma")
    private String Charisma;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The Strength
     */
    @JsonProperty("Strength")
    public String getStrength() {
        return Strength;
    }

    /**
     * 
     * @param Strength
     *     The Strength
     */
    @JsonProperty("Strength")
    public void setStrength(String Strength) {
        this.Strength = Strength;
    }

    /**
     * 
     * @return
     *     The Dexterity
     */
    @JsonProperty("Dexterity")
    public String getDexterity() {
        return Dexterity;
    }

    /**
     * 
     * @param Dexterity
     *     The Dexterity
     */
    @JsonProperty("Dexterity")
    public void setDexterity(String Dexterity) {
        this.Dexterity = Dexterity;
    }

    /**
     * 
     * @return
     *     The Constitution
     */
    @JsonProperty("Constitution")
    public String getConstitution() {
        return Constitution;
    }

    /**
     * 
     * @param Constitution
     *     The Constitution
     */
    @JsonProperty("Constitution")
    public void setConstitution(String Constitution) {
        this.Constitution = Constitution;
    }

    /**
     * 
     * @return
     *     The Intelligence
     */
    @JsonProperty("Intelligence")
    public String getIntelligence() {
        return Intelligence;
    }

    /**
     * 
     * @param Intelligence
     *     The Intelligence
     */
    @JsonProperty("Intelligence")
    public void setIntelligence(String Intelligence) {
        this.Intelligence = Intelligence;
    }

    /**
     * 
     * @return
     *     The Wisdom
     */
    @JsonProperty("Wisdom")
    public String getWisdom() {
        return Wisdom;
    }

    /**
     * 
     * @param Wisdom
     *     The Wisdom
     */
    @JsonProperty("Wisdom")
    public void setWisdom(String Wisdom) {
        this.Wisdom = Wisdom;
    }

    /**
     * 
     * @return
     *     The Charisma
     */
    @JsonProperty("Charisma")
    public String getCharisma() {
        return Charisma;
    }

    /**
     * 
     * @param Charisma
     *     The Charisma
     */
    @JsonProperty("Charisma")
    public void setCharisma(String Charisma) {
        this.Charisma = Charisma;
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
