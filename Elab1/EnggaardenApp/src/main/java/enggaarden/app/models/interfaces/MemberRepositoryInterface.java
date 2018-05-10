package enggaarden.app.models.interfaces;

import enggaarden.app.models.Member;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.List;

public interface MemberRepositoryInterface {

    SqlRowSet get();
    SqlRowSet get(int id);
    void create(Member member);
    void update(Member member);
    void delete(int id);
}
