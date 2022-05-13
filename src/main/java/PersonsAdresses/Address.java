package PersonsAdresses;

public class Address {
    String street;
    int houseNum;

    public Address(String street, int houseNum) {
        this.street = street;
        this.houseNum = houseNum;
    }

    @Override
    public String toString() {
        return "PersonsAdresses.Address{" +
                "street='" + street + '\'' +
                ", houseNum=" + houseNum +
                '}';
    }
}
