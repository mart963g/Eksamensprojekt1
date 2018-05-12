package enggaarden.app.models.repositories;

import enggaarden.app.models.Member;
import enggaarden.app.models.interfaces.MemberRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

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
        String sql = "SELECT * FROM Members " +
                "WHERE MemberId = " + id + ";";

        SqlRowSet rowSet = jdbc.queryForRowSet(sql);

        return rowSet;
    }

    // Posting a full member to the db !!!!NOT COMPLETE!!!!
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

        /*
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
        */
    }

    @Override
    public void updateMember(Member member)
    {

    }

    @Override
    public void delete(int id)
    {

    }
}
