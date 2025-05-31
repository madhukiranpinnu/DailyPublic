package RestAssured.Basic.POJO.JIRA;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Request {
    @JsonProperty("fields")
   private Fields fields;
}
