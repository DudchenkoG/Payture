import com.github.javafaker.Faker;
import dto.request.BlockDTO;
import dto.request.CustomFieldsDTO;
import dto.request.PayInfoDTO;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class test {
    @Test()
    public void block() {
        String url = "https://sandbox3.payture.com/api/Block";
        CustomFieldsDTO customFieldsDTO = new CustomFieldsDTO(
                "192.168.1.1",
                "Product=Ticket");

        PayInfoDTO payInfoDTO = new PayInfoDTO(
                123,
                11,
                22,
                12000+Integer.parseInt(Faker.instance().number().digits(3)),
                "vasya pupkin",
                4111111111100031L,
                "6d42768f-5e71-9ae5-f741-dd179361"+ Faker.instance().number().digits(4));

        BlockDTO blockDTO = new BlockDTO(
                "Merchant",
                payInfoDTO.getAmount(),
                payInfoDTO.getOrderId(),
                payInfoDTO.toString(),
                customFieldsDTO.toString());

        Response response = given().contentType("Content-Type: application/x-www-form-urlencoded")
                .post(url+"?"+blockDTO.toString());

        Assert.assertEquals(response.getStatusCode(), 200, "ой всё");
        String stringResponse = response.asString();
        Assert.assertTrue(stringResponse.contains("Success=\"True\""));
        Assert.assertTrue(stringResponse.contains("OrderId=\""+ blockDTO.getOrderId()+ "\""));
        Assert.assertTrue(stringResponse.contains("Key=\""+ blockDTO.getKey()+ "\""));
        Assert.assertTrue(stringResponse.contains("Amount=\""+ blockDTO.getAmount()+ "\""));
    }
}