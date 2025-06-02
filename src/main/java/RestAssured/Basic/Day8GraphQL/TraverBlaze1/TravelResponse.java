package RestAssured.Basic.Day8GraphQL.TraverBlaze1;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Setter;

@Data
public class TravelResponse {
    @JsonProperty("data")
    private Data data;
    @lombok.Data
   public static  class Data{
        @JsonProperty("country")
    private Country country;
   }
   @lombok.Data
   public static class Country{
        @JsonProperty("native")
        private String native1;
        @JsonProperty("capital")
        private String capital;
        @JsonProperty("currency")
        private String currency;
        @JsonProperty("emoji")
        private String emoji;
        @JsonProperty("name")
        private String name;
        @JsonProperty("phone")
        private String phone;
        @JsonProperty("continent")
        private Continent continent;
   }
   @lombok.Data
   public static class Continent{
        @JsonProperty("code")
        private String code;
   }
}
