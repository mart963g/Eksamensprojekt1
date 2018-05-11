package enggaarden.app.models.interfaces;

import enggaarden.app.models.User;

public interface UserRepositoryInterface
{
    User get(String username, String password);
}
