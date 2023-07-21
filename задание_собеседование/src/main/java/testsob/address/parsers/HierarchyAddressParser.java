package testsob.address.parsers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import testsob.address.model.HierarchyAddress;
import testsob.address.model.HierarchyAddressRoot;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

@Service
public class HierarchyAddressParser {


    @Value("${itemPathXML}")
    private String objectPathXML;

    public List<HierarchyAddress> unMarshalingItems() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(HierarchyAddressRoot.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        HierarchyAddressRoot objects = (HierarchyAddressRoot) jaxbUnmarshaller.unmarshal(new File(objectPathXML));
        return objects.getItems();
    }
}