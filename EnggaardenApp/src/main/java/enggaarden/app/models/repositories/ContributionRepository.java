package enggaarden.app.models.repositories;

import enggaarden.app.models.Entities.Contribution;
import enggaarden.app.models.interfaces.ContributionRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

@Repository
public class ContributionRepository implements ContributionRepositoryInterface
{
    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public SqlRowSet get()
    {
        String sql = "SELECT * FROM contributions;";
        SqlRowSet rowSet = jdbc.queryForRowSet(sql);

        return rowSet;
    }

    @Override
    public SqlRowSet get(int id)
    {
        String sql = "SELECT * FROM contributions WHERE contributionId=" + id + ";";
        SqlRowSet rowSet = jdbc.queryForRowSet(sql);

        return rowSet;
    }

    @Override
    public void postContribution(Contribution contribution)
    {
        String sql = "INSERT INTO contributions VALUES(" +
                "DEFAULT, '" +
                contribution.getActivity().toString() + "'," +
                contribution.getAmount() + ",'" +
                contribution.getSqlDate() + "');";
        jdbc.update(sql);
    }

    @Override
    public void updateContribution(Contribution contribution)
    {
        String sql = "UPDATE contributions " +
                "SET activityType = '" + contribution.getActivity().toString() + "', " +
                "amount = " + contribution.getAmount() + ", " +
                "paymentDate = '" + contribution.getSqlDate() + "' " +
                "WHERE contributionId = " + contribution.getContributionId() + ";";
        jdbc.update(sql);
    }

    @Override
    public void deleteContribution(int id)
    {

    }
}
