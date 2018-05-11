package enggaarden.app.models.Factories;

import enggaarden.app.models.Address;
import enggaarden.app.models.Member;
import enggaarden.app.models.MemberType;
import enggaarden.app.models.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class MemberFactory
{
    public List<Member> getMembers(SqlRowSet rowSet)
    {
        ArrayList<Member> members = new ArrayList<>();

        while (rowSet.next())
        {
            members.add(new Member(rowSet.getInt(1), rowSet.getString(2), rowSet.getString(3),
                    rowSet.getString(4), rowSet.getInt(5), rowSet.getDate(6),
                    rowSet.getString(9), rowSet.getInt(10), rowSet.getString(11),
                    rowSet.getDate(12),
                    MemberType.valueOf(rowSet.getString(7)), rowSet.getBoolean(8)));
        }
        return members;
    }

    public Member getMember(SqlRowSet rowSet)
    {
        rowSet.next();

        Member member = new Member(rowSet.getInt(1),rowSet.getString(2),rowSet.getString(3),
                rowSet.getString(4),rowSet.getInt(5),rowSet.getDate(6),
                rowSet.getString(8),rowSet.getInt(9),rowSet.getString(10),
                rowSet.getDate(11), MemberType.valueOf(rowSet.getString(7)),rowSet.getBoolean(12));

        return member;
    }
}
