package dto.request;

/**
 * Created by JacksonGenerator on 26.11.2020.
 */

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;


public class BlockDTO {
    @JsonProperty("Key")
    private String key;
    @JsonProperty("Amount")
    private Integer amount;
    @JsonProperty("OrderId")
    private String orderId;
    @JsonProperty("PayInfo")
    private String payInfo;
    @JsonProperty("CustomFields")
    private String customFields;



    public BlockDTO(String key, Integer amount, String orderId, String payInfo, String customFields) {
        this.key = key;
        this.amount = amount;
        this.orderId = orderId;
        this.payInfo = payInfo;
        this.customFields = customFields;

    }

    @Override
    public String toString() {
        return "Key=" + key +
                "&Amount=" + amount +
                "&OrderId=" + orderId +
                "&PayInfo=" + payInfo +
                "&CustomFields=" + customFields;
    }

    public String getKey() {
        return key;
    }

    public String getAmount() {
        return amount.toString();
    }

    public String getOrderId() {
        return orderId;
    }

    public String getPayInfo() {
        return payInfo;
    }

    public String getCustomFields() {
        return customFields;
    }
}
