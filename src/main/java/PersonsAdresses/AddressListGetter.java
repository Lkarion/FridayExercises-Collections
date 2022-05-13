package PersonsAdresses;

import java.util.LinkedList;
import java.util.List;

public class AddressListGetter {
    public static List<Address> getAddressList(List<Person> listP){
        List<Address> listAddress = new LinkedList<>();
        for (Person p: listP) {
            listAddress.add(p.getAddress());
        }
        return listAddress;
    }
}
