package enggaarden.app.models.repositories;

import enggaarden.app.models.Address;
import enggaarden.app.models.Member;
import enggaarden.app.models.MemberType;
import enggaarden.app.models.Subscription;
import enggaarden.app.models.interfaces.MemberRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemberRepository implements MemberRepositoryInterface
{
    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public List<Member> get()
    {
        String sql = "SELECT * FROM Members m " +
                "JOIN Addresses a USING (memberId) " +
                "JOIN Subscriptions s USING (memberId);";

        SqlRowSet rowSet = jdbc.queryForRowSet(sql);
        ArrayList<Member> members = new ArrayList<>();

        while(rowSet.next())
        {
            members.add(new Member(rowSet.getInt(1),rowSet.getString(2),rowSet.getString(3),
                    rowSet.getString(4),rowSet.getInt(5),rowSet.getDate(6),
                    new Address(rowSet.getString(9),rowSet.getInt(10),rowSet.getString(11)),
                    new Subscription(rowSet.getDate(12)),
                    MemberType.valueOf(rowSet.getString(7)),rowSet.getBoolean(8)));
        }
        return members;
    }

    @Override
    public Member get(int id)
    {
        String sql = "SELECT * FROM Members " +
                "WHERE MemberId = " + id + ";";

        SqlRowSet rowSet = jdbc.queryForRowSet(sql);

        rowSet.next();

        Member member = new Member(rowSet.getInt(1),rowSet.getString(2),rowSet.getString(3),
                rowSet.getString(4),rowSet.getInt(5),rowSet.getDate(6),
                new Address(rowSet.getString(8),rowSet.getInt(9),rowSet.getString(10)),
                new Subscription(rowSet.getDate(11)),
                MemberType.valueOf(rowSet.getString(7)),rowSet.getBoolean(12));

        return member;
    }

    @Override
    public void create(Member member)
    {
        String sql = "INSERT INTO members" ;

    }

    @Override
    public void update(Member member)
    {

    }

    @Override
    public void delete(int id)
    {

    }
}
