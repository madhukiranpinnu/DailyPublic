package RestAssured.Basic.POJO.Deserialization;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseDemo {
    @JsonProperty("status")
    private String status;
    @JsonProperty("place_id")
    private String place_id;
    @JsonProperty("scope")
    private String scope;
    @JsonProperty("reference")
    private String reference;
    @JsonProperty("id")
    private String id;
}
