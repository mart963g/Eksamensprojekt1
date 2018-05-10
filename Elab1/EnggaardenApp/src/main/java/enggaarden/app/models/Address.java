package enggaarden.app.models;

public class Address {
    private String street;
    private int zipCode;
    private String city;

    public Address()
    {
    }

    public Address(String street, int zipCode, String city)
    {
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public int getZipCode()
    {
        return zipCode;
    }

    public void setZipCode(int zipCode)
    {
        this.zipCode = zipCode;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }
}
