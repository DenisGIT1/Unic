package testsob.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import testsob.address.launch.InputWriter;


@SpringBootApplication
public class AddressApplication implements CommandLineRunner {


    @Autowired
    private InputWriter inputWriter;


    public static void main(String[] args) {
        SpringApplication.run(AddressApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        inputWriter.chooseTask();
    }
}
