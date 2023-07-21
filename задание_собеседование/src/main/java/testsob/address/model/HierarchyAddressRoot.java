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
@XmlRootElement(name = "ITEMS")
@XmlAccessorType(XmlAccessType.FIELD)
public class HierarchyAddressRoot {

    @XmlElement(name = "ITEM")
    private List<HierarchyAddress> items;

    public List<HierarchyAddress> getItems() {
        return items;
    }

    public void setItems(List<HierarchyAddress> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "ITEMS{" +
                "items=" + items +
                '}';
    }
}