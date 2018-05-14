package enggaarden.app.models.interfaces;

import enggaarden.app.models.Entities.Member;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.List;

public interface MemberRepositoryInterface {

    SqlRowSet get();
    SqlRowSet get(int id);
    void postMember(Member member);
    void updateMember(Member member);
    void delete(int id);
}
