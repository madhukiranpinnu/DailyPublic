package RestAssured.Basic.POJO.JIRA;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Fields {
    @JsonProperty("project")
    private Project project;
    @JsonProperty("description")
    private String description;
    @JsonProperty("issuetype")
    private IssueType issueType;
    @JsonProperty("summary")
    private String summary;

}
