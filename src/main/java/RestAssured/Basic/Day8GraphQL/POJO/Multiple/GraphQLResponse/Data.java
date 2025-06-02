package RestAssured.Basic.Day8GraphQL.POJO.Multiple.GraphQLResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Data {
    @JsonProperty("character")
    private Character character;
    @JsonProperty("characters")
    private Characters characters;
    @JsonProperty("location")
    private Location location;
    @JsonProperty("locations")
    private Locations locations;
}
