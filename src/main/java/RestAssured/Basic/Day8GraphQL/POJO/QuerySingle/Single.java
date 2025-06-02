package RestAssured.Basic.Day8GraphQL.POJO.QuerySingle;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Single {
    @JsonProperty("query")
    private String query;
    @JsonProperty("variables")
    private String variables;
}
