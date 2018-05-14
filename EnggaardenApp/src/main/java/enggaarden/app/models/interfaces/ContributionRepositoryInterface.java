package enggaarden.app.models.interfaces;

import enggaarden.app.models.Entities.Contribution;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public interface ContributionRepositoryInterface
{
    SqlRowSet get();
    SqlRowSet get(int id);
    void postContribution(Contribution contribution);
    void updateContribution(Contribution contribution);
    void deleteContribution(int id);
}