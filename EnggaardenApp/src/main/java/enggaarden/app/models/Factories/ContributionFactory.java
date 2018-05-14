package enggaarden.app.models.Factories;

import enggaarden.app.models.Entities.ActivityType;
import enggaarden.app.models.Entities.Contribution;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class ContributionFactory
{

    public List<Contribution> getContributions(SqlRowSet rowSet)
    {
        ArrayList<Contribution> contributions = new ArrayList<>();
        while(rowSet.next())
        {
            contributions.add(new Contribution(rowSet.getInt(1),
                    ActivityType.valueOf(rowSet.getString(2)),
                    rowSet.getDouble(3),rowSet.getDate(4)));
        }
        return contributions;
    }

    public Contribution getContribution(SqlRowSet rowSet)
    {
        rowSet.next();

        Contribution contribution = new Contribution(rowSet.getInt(1),
                ActivityType.valueOf(rowSet.getString(2)),
                rowSet.getDouble(3),rowSet.getDate(4));

        return contribution;
    }

}
