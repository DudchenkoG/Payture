package dto.request;

/**
 * Created by JacksonGenerator on 26.11.2020.
 */

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;


public class PayInfoDTO {
    @JsonProperty("SecureCode")
    private Integer secureCode;
    @JsonProperty("EMonth")
    private Integer eMonth;
    @JsonProperty("EYear")
    private Integer eYear;
    @JsonProperty("Amount")
//    private BigDecimal amount;
    private Integer amount;
    @JsonProperty("CardHolder")
    private String cardHolder;
    @JsonProperty("PAN")
    private Long pAN;
    @JsonProperty("OrderId")
    private String orderId;


    public PayInfoDTO(Integer secureCode, Integer eMonth, Integer eYear, Integer amount, String cardHolder, Long pAN,
                      String orderId) {
        this.secureCode = secureCode;
        this.eMonth = eMonth;
        this.eYear = eYear;
        this.amount = amount;
        this.cardHolder = cardHolder;
        this.pAN = pAN;
        this.orderId = orderId;

    }

    @Override
    public String toString() {
        try {
            return URLEncoder.encode("SecureCode=" + secureCode +
                    ";EMonth=" + eMonth +
                    ";EYear=" + eYear +
                    ";Amount=" + amount +
                    ";CardHolder=" + new String(cardHolder.getBytes("UTF-8"),"UTF-8") +
                    ";PAN=" + pAN +
                    ";OrderId=" + orderId, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer getSecureCode() {
        return secureCode;
    }

    public Integer geteMonth() {
        return eMonth;
    }

    public Integer geteYear() {
        return eYear;
    }

    public Integer getAmount() {
        return amount;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public Long getpAN() {
        return pAN;
    }

    public String getOrderId() {
        return orderId;
    }
}