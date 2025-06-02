package RestAssured.Basic.Day8GraphQL.POJO.Multiple;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Query {
    @JsonProperty("query")
    private String query;
    @JsonProperty("variables")
    private Variables variables;

}
