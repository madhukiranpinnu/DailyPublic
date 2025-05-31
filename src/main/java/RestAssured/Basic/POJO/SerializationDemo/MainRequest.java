package RestAssured.Basic.POJO.SerializationDemo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MainRequest {
    @JsonProperty("accuracy")
    private int accuracy;
    @JsonProperty("name")
    private String name;
    @JsonProperty("phone_number")
    private String phone_number;
    @JsonProperty("address")
    private String address;
    @JsonProperty("website")
    private String website;
    @JsonProperty("language")
    private String language;
    @JsonProperty("types")
    private List<String> types;
    @JsonProperty("location")
    private Location location;
}
