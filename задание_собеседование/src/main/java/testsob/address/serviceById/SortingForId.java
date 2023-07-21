package testsob.address.serviceById;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import testsob.address.model.Address;
import testsob.address.parsers.AddressParser;

import javax.xml.bind.JAXBException;
import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class SortingForId {


    private final AddressParser addressParser;
    private final AddressService addressService;
    private final TimeConverter timeConverter;


    public void showSelectAddress(String[] idArray, String dateInput) throws JAXBException {
        List<Address> objectList = addressParser.unMarshalingObject();
        List<Address> sorted = addressService.selectById(objectList, idArray);
        LocalDate localDate = timeConverter.timeConverter(dateInput);
        addressService.filtrByDate(sorted, localDate);
    }
}
