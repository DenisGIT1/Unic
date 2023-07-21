package testsob.address.parsers;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;
import testsob.address.model.Address;
import testsob.address.model.AddressRoot;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;


@Service
public class AddressParser {

    @Value("${objectPathXML}")
    private String objectPathXML;

    public List<Address> unMarshalingObject() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(AddressRoot.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        AddressRoot objects = (AddressRoot) jaxbUnmarshaller.unmarshal(new File(objectPathXML));
        return objects.getObjects();
    }
}