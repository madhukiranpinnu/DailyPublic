package RestAssured.Basic.POJO.ReqresRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponsePost {
    @JsonProperty("name")
    private String name;
    @JsonProperty("job")
    private String job;
    @JsonProperty("id")
    private String id;
    @JsonProperty("createdAt")
    private String createdAt;
}
