package Hotel.integration;


import Hotel.TestConfig;
import Hotel.additionalEntity.Order;
import Hotel.entity.Room;
import Hotel.entity.Roomhistory;
import Hotel.entity.Roomuser;
import Hotel.service.OrderService;
import Hotel.service.UserService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;

import javax.inject.Inject;
import java.util.List;

@ContextConfiguration(classes = {TestConfig.class})
public class HotelTest extends AbstractTransactionalTestNGSpringContextTests {


    @Inject
    private UserService userService;

    @Inject
    private OrderService orderService;

    @Test
    public void savedUserTest() {
        Roomuser user = new Roomuser();
        user.setUName("Ivan");
        user.setULogin("Navi");
        user.setUPass("IvanNavi");
        user.setUMail("Ivan@mail.com");
        user.setUPhone("+380986804516");
        user.setStatus("0");
        int savedId = userService.regUser(user);
        Roomuser savedUser = userService.getUserById(savedId);
        Assert.assertNotNull(savedUser);
        Assert.assertEquals(savedUser.getUName(), user.getUName());
        Assert.assertEquals(savedUser.getULogin(), user.getULogin());
        Assert.assertEquals(savedUser.getUPass(), user.getUPass());
    }

    @Test(expectedExceptions = EmptyResultDataAccessException.class)
    public void failSavedUserTest() {
        Roomuser user = new Roomuser();
        int savedId = 1;
        Roomuser savedUser = userService.getUserById(savedId);
        Assert.assertNotNull(savedUser);
        Assert.assertEquals(savedUser.getUName(), user.getUName());
        Assert.assertEquals(savedUser.getULogin(), user.getULogin());
        Assert.assertEquals(savedUser.getUPass(), user.getUPass());
    }
}
