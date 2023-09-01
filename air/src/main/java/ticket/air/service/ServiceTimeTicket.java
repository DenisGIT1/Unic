package ticket.air.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ticket.air.model.Ticket;
import ticket.air.parser.Parser;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@AllArgsConstructor
public class ServiceTimeTicket {

    private final Parser parser;

    public void showFlights() throws IOException, ParseException {
        minTimeByCarriers(parser.jsonParser(), carriersList((parser.jsonParser()))).forEach(System.out::println);
    }

    private List<Map<String, String>> minTimeByCarriers(List<Ticket> list, List<String> carriers) throws ParseException {
        List<Map<String, String>> result = new ArrayList<>();
        for (String s : carriers) {
            List<Ticket> uniqCarrier = new ArrayList<>();
            for (Ticket ticket : list) {
                if (ticket.getCarrier().equals(s)) {
                    uniqCarrier.add(ticket);
                }
            }
            result.add(sortedByCity(uniqCarrier));
        }
        return result;
    }

    private List<String> carriersList(List<Ticket> list) {
        List<String> carriers = new ArrayList<>();
        for (Ticket a : list) {
            carriers.add(a.getCarrier());
        }
        return carriers.stream().distinct().toList();
    }

    private Map<String, String> sortedByCity(List<Ticket> array) throws ParseException {
        Map<String, String> flights = new HashMap<>();
        Set<Long> fli = new HashSet<>();
        for (Ticket t : array) {
            if (t.getOrigin_name().equals("Владивосток") && t.getDestination_name().equals("Тель-Авив")) {
                Long time = minuteDifference(t);
                fli.add(time);
            }
        }
        Long minTime = fli.stream().min(Long::compare).get();
        flights.put(array.get(0).getCarrier(), converterTime(minTime));
        return flights;
    }

    private Long minuteDifference(Ticket t) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        Date d1 = format.parse(t.getArrival_date() + " " + t.getArrival_time());
        Date d2 = format.parse(t.getDeparture_date() + " " + t.getDeparture_time());
        return (d1.getTime() - d2.getTime()) / 60000;
    }

    private String converterTime(Long time) {
        return " " + time / 60 + ":" + time % 60;
    }
}