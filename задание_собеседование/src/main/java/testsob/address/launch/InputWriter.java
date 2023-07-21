package testsob.address.launch;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import testsob.address.serviceByType.SortingForType;
import testsob.address.serviceById.SortingForId;

import javax.xml.bind.JAXBException;
import java.util.Scanner;


@Service
@AllArgsConstructor
public class InputWriter {

    private final SortingForId sortingForId;
    private final SortingForType sortingForType;


    public void chooseTask() {
        System.out.println("Выберите сервис: (введите цифру)");
        System.out.println("1: Вывести описание адресов (тип + название) на переданную дату по ID");
        System.out.println("2: Вывести актуальные полные адреса (строку с цепочкой адресов по иерархии), в которых встречается тип адреса");
        Scanner sc = new Scanner(System.in);
        String inp = sc.nextLine();
        switch (inp) {
            case "1" -> chooseOne();
            case "2" -> chooseTwo();
        }
        sc.close();
    }


    private void getAddressIdForDate(String[] str, String date) {
        try {
            sortingForId.showSelectAddress(str, date);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    private void getHierarchyAddress(String type) {
        try {
            sortingForType.givListAddress(type);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void chooseOne() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите дату в формате гггг-мм-дд: ");
        String std = sc.nextLine();
        System.out.println("Введите ID без пробелов в формате 12234,34532,34567: ");
        String ids = sc.nextLine();
        String[] str = ids.split(",");
        sc.close();
        getAddressIdForDate(str, std);
    }

    private void chooseTwo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите тип сортировки, например 'пер' 'проезд' 'ул'");
        String type = sc.nextLine();
        sc.close();
        getHierarchyAddress(type);
    }
}