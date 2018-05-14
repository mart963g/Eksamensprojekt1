package enggaarden.app.models.interfaces;

import enggaarden.app.models.Address;
import enggaarden.app.models.Member;
import enggaarden.app.models.Subscription;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.List;

public interface MemberRepositoryInterface {

    SqlRowSet get();
    SqlRowSet get(int id);
    void postMember(Member member, Address address, Subscription subscription);
    void updateMember(Member member);
    void delete(int id);
}
