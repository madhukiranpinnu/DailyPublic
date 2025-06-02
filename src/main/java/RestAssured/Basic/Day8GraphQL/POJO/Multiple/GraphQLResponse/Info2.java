package RestAssured.Basic.Day8GraphQL.POJO.Multiple.GraphQLResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Info2 {
    @JsonProperty("count")
    private int count;
    @JsonProperty("pages")
    private String pages;
}
