package RestAssured.Basic.Day9E2E.POJOS;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AddCart {
    @JsonProperty("_id")
    private String id;
    @JsonProperty("product")
    private Product product;
    @Data
    public static  class Product{
        @JsonProperty("_id")
        private String id;
        @JsonProperty("productName")
        private String productName;
        @JsonProperty("productCategory")
        private String productCategory;
        private String productSubCategory;
        private int productPrice;
        private String productDescription;
        private String productImage;
        private String productRating;
        private String productTotalOrders;
        private boolean productStatus;
        private String productFor;
        private String productAddedBy;
        @JsonProperty("__v")
        private int v;
    }
}


