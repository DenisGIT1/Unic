package testsob.address.serviceByType;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import testsob.address.model.Address;
import testsob.address.model.HierarchyAddress;
import testsob.address.parsers.AddressParser;
import testsob.address.parsers.HierarchyAddressParser;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
@AllArgsConstructor
public class SortingForType {


    private final AddressParser AddressParser;
    private final HierarchyAddressParser HierarchyAddressParser;

    public void givListAddress(String type) throws Exception {
        List<Address> objects = AddressParser.unMarshalingObject().stream().filter(x -> x.getIsActive().equals("1")).collect(Collectors.toList());
        List<HierarchyAddress> items = HierarchyAddressParser.unMarshalingItems().stream().filter(x -> x.getIsActive().equals("1")).collect(Collectors.toList());

        List<Address> root = findByType(type, objects);
        List<LinkedList<Address>> parents = findParents(root, items, objects);
        List<LinkedList<Address>> result = new ArrayList<>(parents);
        List<LinkedList<Address>> chields = findChilds(items, objects, result);

        for (LinkedList<Address> parentQWE : chields) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < parentQWE.size(); i++) {
                Address object = parentQWE.get(i);
                stringBuilder.append(object.getTypeName()).append(" ");
                stringBuilder.append(object.getName()).append(" ");
            }
            System.out.println(stringBuilder.toString());
        }
    }

    private List<LinkedList<Address>> findChilds(List<HierarchyAddress> items, List<Address> objects, List<LinkedList<Address>> parents) {
        List<LinkedList<Address>> result = new ArrayList<>();

        for (LinkedList<Address> parent : parents) {
            List<LinkedList<Address>> re = findChilds(items, objects, parent);
            if (re == null) {
                return parents;
            }
            result.addAll(re);
        }
        List<LinkedList<Address>> realResult = findChilds(items, objects, result);
        return realResult;
    }

    private List<LinkedList<Address>> findChilds(List<HierarchyAddress> items, List<Address> objects, LinkedList<Address> parent) {

        List<LinkedList<Address>> result = new ArrayList<>();
        Address last = parent.getLast();
        String objectid = last.getObjectId();

        items.stream()
                .filter(x -> x.getParentObId().equals(objectid))
                .map(x -> findById(x.getObjectId(), objects))
                .forEach(chield -> {
                    if (chield != null) {
                        LinkedList<Address> e = new LinkedList<>(parent);
                        e.add(chield);
                        result.add(e);
                    }
                });

        if (result.size() == 0 || (result.size() == 1 && result.get(0).getLast().equals(last))) {
            return null;
        }
        return result;
    }


    private List<LinkedList<Address>> findParents(List<Address> roots, List<HierarchyAddress> items, List<Address> objects) {
        List<LinkedList<Address>> result = new ArrayList<>();

        for (Address root : roots) {
            LinkedList<Address> links = new LinkedList<>();
            links.add(root);

            while (true) {
                Address parent = findParent(root, items, objects);
                if (nonNull(parent)) {
                    links.addFirst(parent);
                    root = parent;
                    continue;
                }
                result.add(links);
                break;
            }
        }
        return result;
    }

    private Address findParent(Address root, List<HierarchyAddress> items, List<Address> objects) {
        String id = root.getObjectId();
        HierarchyAddress item = items.stream().filter(x -> x.getObjectId().equals(id)).findFirst().orElse(null);
        if (isNull(item)) {
            return null;
        }
        return findById(item.getParentObId(), objects);
    }

    private Address findById(String id, List<Address> objects) {
        return objects.stream().filter(x -> x.getObjectId().equals(id)).findFirst().orElse(null);
    }

    private List<Address> findByType(String type, List<Address> objects) {
        return objects.stream().filter(x -> x.getTypeName().equals(type)).collect(Collectors.toList());
    }
}
