package RestAssured.Basic.POJO.Example3;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestPojo {
    @JsonProperty("name")
    private String name;
    @JsonProperty("isbn")
    private String isbn;
    @JsonProperty("aisle")
    private String aisle;
    @JsonProperty("author")
    private String author;
}
