package api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import business.api.Uris;
import business.wrapper.TrainingWrapper;
import data.daos.DaosService;

public class TrainingResourceFunctionalTesting {

    RestService restService = new RestService();

    @Autowired
    private DaosService daosService;

    @Test
    public void testShowTrainingUnauthorized() {
        try {
            new RestBuilder<String>(RestService.URL).path(Uris.TRAINING).path(Uris.LIST_TRAININGS).clazz(String.class).get().build();
            fail();
        } catch (HttpClientErrorException httpError) {
            assertEquals(HttpStatus.UNAUTHORIZED, httpError.getStatusCode());
            LogManager.getLogger(this.getClass())
                    .info("testShowTraining (" + httpError.getMessage() + "):\n    " + httpError.getResponseBodyAsString());
        }
    }

    @Test
    public void testShowTraining() {
        String token = restService.loginTrainer();
        String response = new RestBuilder<String>(RestService.URL).path(Uris.TRAINING).path(Uris.LIST_TRAININGS).basicAuth(token, "")
                .clazz(String.class).get().build();

        LogManager.getLogger(this.getClass()).info("testShowTraining (" + response + ")");
    }

    @Test
    public void testCreateTraining() {

    }

    @Test
    public void testDeleteTraining() {
        /*String token = restService.loginTrainer();
        String response = new RestBuilder<String>(RestService.URL).path(Uris.TRAINING).path(Uris.DELETE_TRAINING).basicAuth(token, "")
                .clazz(String.class).get().build();
*/
    }

}
