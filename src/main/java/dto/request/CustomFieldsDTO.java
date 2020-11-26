package dto.request;

/**
 * Created by JacksonGenerator on 26.11.2020.
 */

import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URLEncoder;


public class CustomFieldsDTO {
    @JsonProperty("IP")
    private String ip;
    @JsonProperty("Description")
    private String description;


    public CustomFieldsDTO(String ip, String description) {
        this.ip = ip;
        this.description = description;
    }

    @Override
    public String toString() {
        return URLEncoder.encode("IP=" + ip +
                ";"+description);
    }
}