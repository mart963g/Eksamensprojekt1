package enggaarden.app.models.interfaces;

import enggaarden.app.models.Member;

import java.util.List;

public interface MemberRepositoryInterface {

    List<Member> get();
    Member get(int id);
    void create(Member member);
    void update(Member member);
    void delete(int id);
}
