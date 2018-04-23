package Hotel.dao.IDAO;

import Hotel.entity.Roomuser;

import java.util.List;

public interface UserDAO {

    List<Roomuser> login(String uLogin, String uPass);

    int regUser(Roomuser user);

    List<Roomuser> getUserByLogin(String uLogin);

    Roomuser getUserById(int id);

}
