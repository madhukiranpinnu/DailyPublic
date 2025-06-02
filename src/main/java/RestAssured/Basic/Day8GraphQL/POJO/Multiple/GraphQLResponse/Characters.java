package RestAssured.Basic.Day8GraphQL.POJO.Multiple.GraphQLResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Characters {
    @JsonProperty("info")
    private Info1 info;
}
