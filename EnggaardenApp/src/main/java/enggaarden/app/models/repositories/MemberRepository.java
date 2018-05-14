package enggaarden.app.models.repositories;

import enggaarden.app.models.Entities.Member;
import enggaarden.app.models.Entities.MemberType;
import enggaarden.app.models.interfaces.MemberRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository implements MemberRepositoryInterface
{
    @Autowired
    private JdbcTemplate jdbc;

    // Members for members_overview.html
    @Override
    public SqlRowSet get()
    {
        String sql = "SELECT * FROM Members m " +
                     "JOIN Subscriptions s USING (memberId);";

        SqlRowSet rowSet = jdbc.queryForRowSet(sql);

        return rowSet;
    }

    // Full member for member_details.html
    @Override
    public SqlRowSet get(int id)
    {
        String sql = "SELECT * FROM Members m " +
                "JOIN addresses a USING(memberId)" +
                "JOIN subscriptions s USING(memberId)" +
                " WHERE MemberId = " + id + ";";

        SqlRowSet rowSet = jdbc.queryForRowSet(sql);

        return rowSet;
    }

    // Posting a full member to the db
    @Override
    public void postMember(Member member)
    {
        String count = "SELECT MAX(memberId) FROM Members";
        SqlRowSet rowSet = jdbc.queryForRowSet(count);
        rowSet.next();
        int i = rowSet.getInt(1);

        String sqlMem = "INSERT INTO members VALUES" +
                "(" + (i+1) + ", '" +
                member.getFirstName() + "', '" +
                member.getLastName() + "', '" +
                member.getMail() + "', " +
                member.getPhoneNumber() + ", '" +
                member.getSqlDate() + "', '" +
                member.getMemberType().toString() + "', " +
                member.isBoard() + ");";

        jdbc.update(sqlMem);


        String sqlAdd = "INSERT INTO addresses VALUES(" +
                (i+1) + ", '" +
                member.getAddress().getStreet() + "', " +
                member.getAddress().getZipCode() + ", '" +
                member.getAddress().getCity() + "')";

        jdbc.update(sqlAdd);


        String sqlSub = "INSERT INTO subscriptions VALUES(" +
                (i+1) + ", '" +
                member.getSubscription().getSqlDate() + "')";

        jdbc.update(sqlSub);

    }

    // Posting an updated member to the db
    @Override
    public void updateMember(Member member)
    {

        String sqlMem = "UPDATE members " +
                "SET firstName = '" + member.getFirstName() + "', " +
                "lastName = '" + member.getLastName() + "', " +
                "mail = '" + member.getMail() + "', " +
                "phoneNumber = " + member.getPhoneNumber() + ", " +
                "creationDate = '" + member.getSqlDate() + "', " +
                "memberType = '" + member.getMemberType().toString() + "', " +
                "isBoard = " + member.isBoard() + " " +
                "WHERE memberId = " + member.getMemberId() + ";";
        jdbc.update(sqlMem);

        String sqlAdd = "UPDATE addresses " +
                "SET streetName = '" + member.getAddress().getStreet()  + "', " +
                "zipCode = " + member.getAddress().getZipCode()  + ", " +
                "city = '" + member.getAddress().getCity()  + "' " +
                "WHERE memberId = " + member.getMemberId() + ";";
        jdbc.update(sqlAdd);

        String sqlSub = "UPDATE subscriptions " +
                "SET payDate = '" + member.getSubscription().getSqlDate() + "' " +
                "WHERE memberId = " + member.getMemberId() + ";";
        jdbc.update(sqlSub);

    }

    // Delete a member from the db
    @Override
    public void delete(int id)
    {

    }
}
