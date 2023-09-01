package ticket.air;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ticket.air.service.ServicePriceTicket;
import ticket.air.service.ServiceTimeTicket;

@SpringBootApplication
public class AirApplication implements CommandLineRunner {

    @Autowired
    private ServiceTimeTicket serviceTimeTicket;
    @Autowired
    private ServicePriceTicket servicePriceTicket;


    public static void main(String[] args) {
        SpringApplication.run(AirApplication.class, args);

    }


    @Override
    public void run(String... args) throws Exception {
        serviceTimeTicket.showFlights();
        servicePriceTicket.showDifferencePrice();

    }
}
