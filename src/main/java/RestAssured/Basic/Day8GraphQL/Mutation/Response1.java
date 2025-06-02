package RestAssured.Basic.Day8GraphQL.Mutation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
@Data
public class Response1 {
    @JsonProperty("data")
    private Data data;
    @lombok.Data
public static class Data{
    @JsonProperty("createLocation")
    private CreateLocation createLocation;
}
@lombok.Data
public static class CreateLocation{
    @JsonProperty("id")
    private int id;
}
}
