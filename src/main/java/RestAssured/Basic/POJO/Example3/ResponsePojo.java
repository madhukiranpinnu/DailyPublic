package RestAssured.Basic.POJO.Example3;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponsePojo {
    @JsonProperty("Msg")
    private String Msg;
    @JsonProperty("ID")
    private String ID;
}
