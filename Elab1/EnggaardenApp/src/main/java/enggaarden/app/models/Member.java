package enggaarden.app.models;

import java.sql.Date;

public class Member {
    private int memberId;
    private String firstName;
    private String lastName;
    private String mail;
    private int phoneNumber;
    private Date creationDate;
    private Address address;
    private Subscription subscription;
    private MemberType memberType;
    private boolean isBoard;

    public Member()
    {
    }

    public Member(int memberId, String firstName,
                  String lastName, String mail,
                  int phoneNumber, Date creationDate,
                  Address address, Subscription subscription,
                  MemberType memberType, boolean isBoard)
    {
        this.memberId = memberId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.creationDate = creationDate;
        this.address = address;
        this.subscription = subscription;
        this.memberType = memberType;
        this.isBoard = isBoard;
    }

    public int getMemberId()
    {
        return memberId;
    }

    public void setMemberId(int memberId)
    {
        this.memberId = memberId;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public int getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getMail()
    {
        return mail;
    }

    public void setMail(String mail)
    {
        this.mail = mail;
    }

    public Date getCreationDate()
    {
        return creationDate;
    }

    public void setCreationDate(Date creationDate)
    {
        this.creationDate = creationDate;
    }

    public Address getAddress()
    {
        return address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

    public Subscription getSubscription()
    {
        return subscription;
    }

    public void setSubscription(Subscription subscription)
    {
        this.subscription = subscription;
    }

    public MemberType getMemberType()
    {
        return memberType;
    }

    public void setMemberType(MemberType memberType)
    {
        this.memberType = memberType;
    }
}
