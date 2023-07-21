package testsob.address.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "ITEM")
@XmlAccessorType(XmlAccessType.FIELD)
public class HierarchyAddress {

    @XmlAttribute(name = "ID")
    private String id;
    @XmlAttribute(name = "OBJECTID")
    private String objectId;
    @XmlAttribute(name = "PARENTOBJID")
    private String parentObId;
    @XmlAttribute(name = "CHANGEID")
    private String changedId;
    @XmlAttribute(name = "PREVID")
    private String previd;
    @XmlAttribute(name = "NEXTID")
    private String nextId;
    @XmlAttribute(name = "UPDATEDATE")
    private String updateDate;
    @XmlAttribute(name = "STARTDATE")
    private String startDate;
    @XmlAttribute(name = "ENDDATE")
    private String endDate;
    @XmlAttribute(name = "ISACTIVE")
    private String isActive;


    @Override
    public String toString() {
        return "ITEM{" +
                "ID=" + id +
                ", OBJECTID=" + objectId +
                ", PARENTOBJID='" + parentObId + '\'' +
                ", CHANGEID=" + changedId +
                ", PREVID=" + previd +
                ", NEXTID=" + nextId +
                ", UPDATEDATE=" + updateDate +
                ", STARTDATE=" + startDate +
                ", ENDDATE=" + endDate +
                ", ISACTIVE=" + isActive +
                '}';
    }
}