package testsob.address.model;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "ADDRESSOBJECTS")
@XmlAccessorType(XmlAccessType.FIELD)
public class AddressRoot {


    @XmlElement(name = "OBJECT")
    private List<Address> objects;

    public List<Address> getObjects() {
        return objects;
    }

    public void setObjects(List<Address> objects) {
        this.objects = objects;
    }

    @Override
    public String toString() {
        return "AddressRoot{" +
                "objects=" + objects +
                '}';
    }
}