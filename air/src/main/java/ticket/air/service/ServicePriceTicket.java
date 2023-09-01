package ticket.air.service;


import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ticket.air.model.Ticket;
import ticket.air.parser.Parser;

import java.io.IOException;
import java.util.*;

@Service
@AllArgsConstructor
public class ServicePriceTicket {

    private final Parser parser;
    private final Logger logger = LoggerFactory.getLogger(ServicePriceTicket.class);


    public void showDifferencePrice() throws IOException {
        List<Integer> lis = getListPrices(sortedByCity(parser.jsonParser()));
        Integer dif = averagePrice(lis) - medianPrice(lis);
        logger.info("\n" + "Средняя цена - медианная цена = " + dif);
    }

    private Integer averagePrice(List<Integer> list) {
        int sum = list.stream().mapToInt(Integer::intValue).sum();
        return sum / list.size();
    }

    private Integer medianPrice(List<Integer> list) {
        Collections.sort(list);
        if (list.size() / 2 != 0) {
            return list.get(list.size() / 2);
        } else {
            return (list.get((list.size() / 2) - 1) + list.get(list.size() / 2)) / 2;
        }
    }

    private List<Integer> getListPrices(List<Ticket> list) {
        List<Integer> priceList = new ArrayList<>();
        for (Ticket t : list) {
            priceList.add(t.getPrice());
        }
        return priceList;
    }

    private List<Ticket> sortedByCity(List<Ticket> array) {
        List<Ticket> sort = new ArrayList<>();
        for (Ticket t : array) {
            if (t.getOrigin_name().equals("Владивосток") && t.getDestination_name().equals("Тель-Авив")) {
                sort.add(t);
            }
        }
        return sort;
    }
}