package Hotel.DB.IDAO;

import Hotel.DBEntity.Roomuser;

public interface UserDAO {

    Roomuser login(String uLogin, String uPass);

    boolean regUser(Roomuser user);

}
