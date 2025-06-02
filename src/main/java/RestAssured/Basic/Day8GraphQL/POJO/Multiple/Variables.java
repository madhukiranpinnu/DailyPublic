package RestAssured.Basic.Day8GraphQL.POJO.Multiple;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Variables {
    @JsonProperty("char")
    private int charet;
    @JsonProperty("loc")
    private int loc;
    @JsonProperty("name")
    private String name;
}
