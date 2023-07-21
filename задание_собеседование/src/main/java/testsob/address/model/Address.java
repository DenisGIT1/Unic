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
@XmlRootElement(name = "OBJECT")
@XmlAccessorType(XmlAccessType.FIELD)
public class Address {


    @XmlAttribute(name = "ID")
    private String id;
    @XmlAttribute(name = "OBJECTID")
    private String objectId;
    @XmlAttribute(name = "OBJECTGUID")
    private String objectGuid;
    @XmlAttribute(name = "CHANGEID")
    private String changeid;
    @XmlAttribute(name = "NAME")
    private String name;
    @XmlAttribute(name = "TYPENAME")
    private String typeName;
    @XmlAttribute(name = "LEVEL")
    private String level;
    @XmlAttribute(name = "OPERTYPEID")
    private String operTypeId;
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
    @XmlAttribute(name = "ISACTUAL")
    private String isActual;
    @XmlAttribute(name = "ISACTIVE")
    private String isActive;


    @Override
    public String toString() {
        return "OBJECT{" +
                "ID=" + id +
                ", OBJECTID=" + objectId +
                ", OBJECTGUID='" + objectGuid + '\'' +
                ", CHANGEID=" + changeid +
                ", NAME='" + name + '\'' +
                ", TYPENAME='" + typeName + '\'' +
                ", LEVEL=" + level +
                ", OPERTYPEID=" + operTypeId +
                ", PREVID=" + previd +
                ", NEXTID=" + nextId +
                ", UPDATEDATE=" + updateDate +
                ", STARTDATE=" + startDate +
                ", ENDDATE=" + endDate +
                ", ISACTUAL=" + isActual +
                ", ISACTIVE=" + isActive +
                '}';
    }
}