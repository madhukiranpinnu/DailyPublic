package RestAssured.Basic.POJO.ReqresRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Support {
    @JsonProperty("url")
    private String url;
    @JsonProperty("text")
    private String text;
}
