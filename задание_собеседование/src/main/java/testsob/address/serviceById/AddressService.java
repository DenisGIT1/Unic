package testsob.address.serviceById;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import testsob.address.model.Address;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AddressService {


    private final TimeConverter TimeConverter;

    protected void filtrByDate(List<Address> selectedList, LocalDate dateInput) {
        for (Address obj : selectedList) {
            LocalDate dateSt = TimeConverter.timeConverter(obj.getStartDate());
            LocalDate dateEn = TimeConverter.timeConverter(obj.getEndDate());
            if ((dateInput.isAfter(dateSt)) && (dateInput.isBefore(dateEn))) {
                System.out.println((obj.getObjectId() + ": " + obj.getTypeName() + " " + obj.getName()));
            }
        }
    }

    protected List<Address> selectById(List<Address> objects, String[] idArray) {
        List<Address> selectedList = new ArrayList<>();
        for (String strId : idArray) {
            selectedList.addAll(findById(strId, objects));
        }
        return selectedList;
    }

    private List<Address> findById(String id, List<Address> objects) {
        return objects.stream().filter(x -> x.getObjectId().equals(id)).collect(Collectors.toList());
    }
}
