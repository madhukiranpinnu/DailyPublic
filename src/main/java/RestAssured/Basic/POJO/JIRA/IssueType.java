package RestAssured.Basic.POJO.JIRA;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IssueType {
    @JsonProperty("name")
    private String name;
}
