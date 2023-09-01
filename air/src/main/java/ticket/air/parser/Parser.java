package ticket.air.parser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import ticket.air.model.Ticket;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class Parser {

    private ObjectMapper objectMapper = new ObjectMapper();

    public List<Ticket> jsonParser() throws IOException {
        File file = new File("src/main/resources/tickets.json");
        JsonNode requestParams = objectMapper.readTree(file);
        JsonNode subscriptionPath = requestParams.at("/tickets");
        List<Ticket> ticList = objectMapper.readValue(subscriptionPath.traverse(), new TypeReference<List<Ticket>>() {
        });
        return ticList;
    }
}