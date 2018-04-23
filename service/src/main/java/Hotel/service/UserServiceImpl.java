package Hotel.service;

import Hotel.dao.IDAO.UserDAO;
import Hotel.entity.Roomuser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service("user-service")
public class UserServiceImpl implements UserService {

    @Inject
    private UserDAO dao;

    public UserDAO getDao() {
        return dao;
    }

    public void setDao(UserDAO dao) {
        this.dao = dao;
    }

    @Override
    @Transactional(readOnly = true)
    public Roomuser getUserById(int id) {
        return dao.getUserById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Roomuser> login(String uLogin, String uPass) {
        return dao.login(uLogin, uPass);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int regUser(Roomuser user) {
        List<Roomuser> newUserList = dao.getUserByLogin(user.getULogin());
        if (newUserList.size() == 0) {
            return dao.regUser(user);
        } else {
            return -1;
        }
    }

}
