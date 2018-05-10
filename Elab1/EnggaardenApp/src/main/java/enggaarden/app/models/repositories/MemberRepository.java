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
    public SqlRowSet get()
    {
        String sql = "SELECT * FROM Members m " +
                "JOIN Addresses a USING (memberId) " +
                "JOIN Subscriptions s USING (memberId);";

        SqlRowSet rowSet = jdbc.queryForRowSet(sql);

        return rowSet;
    }

    @Override
    public SqlRowSet get(int id)
    {
        String sql = "SELECT * FROM Members " +
                "WHERE MemberId = " + id + ";";

        SqlRowSet rowSet = jdbc.queryForRowSet(sql);

        return rowSet;
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
