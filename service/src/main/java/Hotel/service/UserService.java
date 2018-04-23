package Hotel.service;

import Hotel.entity.Roomuser;

import java.util.List;

public interface UserService {

    List<Roomuser> login(String uLogin, String uPass);

    Roomuser getUserById(int id);

    int regUser(Roomuser user);
}
