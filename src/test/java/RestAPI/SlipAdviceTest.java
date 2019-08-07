package RestAPI;

import ResponseObjects.MessageResponse;
import ResponseObjects.SearchResponse;
import ResponseObjects.SlipResponse;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.when;
import static org.junit.Assert.*;

public class SlipAdviceTest {

    private static final String BASE_URI = "https://api.adviceslip.com";
    private static final int SLIP_ID = 55;
    private static final String QUERY = "you";
    private static final int SLIP_BUG_ID = 400;
    private static final String QUERY_BUG = "Jheni";

    @Before
    public void setup() {
        RestAssured.baseURI = BASE_URI;
        RestAssured.registerParser("text/html", Parser.JSON);
    }

    @Test
    public void shouldBeAbleToGetRandomAdvice() {
        SlipResponse slipResponse = when()
                .get("/advice")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(SlipResponse.class);

        assertNotNull(slipResponse.getSlip());
        assertTrue(slipResponse.getSlip().getSlip_id() != 0);
        assertTrue(slipResponse.getSlip().getAdvice().length() > 0);
    }


    @Test
    public void shouldBeAbleToGetAdviceBySlipId() {
        String expectedAdvice = "Do not seek praise, seek criticism.";

        SlipResponse slipResponse = when()
                .get("/advice/{slip_id}", SLIP_ID)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(SlipResponse.class);

        assertEquals(slipResponse.getSlip().getAdvice(), expectedAdvice);
    }

    @Test
    public void shouldBeAbleToGetAdviceBySearchQuery() {
        int expectedTotalResults = 92;

        SearchResponse searchResponse = when()
                .get("advice/search/{query}", QUERY)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(SearchResponse.class);


        assertEquals(expectedTotalResults, searchResponse.getTotal_results());
        assertEquals(expectedTotalResults, searchResponse.getSlips().length);
    }

    @Test
    public void shouldBeAbleToGetMessageById(){
        String expectedError = "Advice slip not found.";

        MessageResponse messageResponse = when()
            .get("/advice/{slip_id}", SLIP_BUG_ID)
            .then()
            .assertThat()
            .statusCode(HttpStatus.SC_OK)
            .extract()
            .as(MessageResponse.class);

        assertEquals(messageResponse.getMessage().getText(), expectedError);

    }

    @Test
    public void shouldBeAbleToGetMessageByQuery(){
        String expectedError1 = "No advice slips found matching that search term.";

        MessageResponse messageResponse = when()
                .get("/advice/search/{query}", QUERY_BUG)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(MessageResponse.class);

        assertEquals(messageResponse.getMessage().getText(), expectedError1);

    }
}
