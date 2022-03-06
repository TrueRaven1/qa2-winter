package requesters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Reservation;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ReservationsRequester {
    private final String URL = "http://www.qaguru.lv:8089/tickets/getReservations.php";

    public List<Reservation> getReservations() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForEntity(URL, String.class).getBody();

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(response, new TypeReference<List<Reservation>>() {});
    }
}
