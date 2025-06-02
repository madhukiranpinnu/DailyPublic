package RestAssured.Basic.Day8GraphQL.POJO.Multiple.GraphQLResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Character {
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("type")
    private String type;
    @JsonProperty("status")
    private String status;
    @JsonProperty("species")
    private String species;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("image")
    private String image;
}
