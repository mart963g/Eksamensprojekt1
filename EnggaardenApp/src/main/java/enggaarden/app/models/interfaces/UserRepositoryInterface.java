package enggaarden.app.models.interfaces;

import enggaarden.app.models.Entities.User;

public interface UserRepositoryInterface
{
    User get(String username, String password);
}
