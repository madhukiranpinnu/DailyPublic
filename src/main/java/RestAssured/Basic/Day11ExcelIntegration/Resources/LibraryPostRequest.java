package RestAssured.Basic.Day11ExcelIntegration.Resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LibraryPostRequest {
    @JsonProperty("name")
    private String name;
    @JsonProperty("isbn")
    private String isbn;
    @JsonProperty("aisle")
    private String aisle;
    @JsonProperty("author")
    private String author;
}
