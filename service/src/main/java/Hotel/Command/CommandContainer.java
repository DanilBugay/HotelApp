package Hotel.Command;

import java.util.HashMap;
import java.util.Map;
import Hotel.Command.Admin.*;
import Hotel.Command.Client.*;
import Hotel.Command.Order.*;
import Hotel.Command.User.*;

public class CommandContainer {

    private static final Map<String, Command> COMMANDS = new HashMap<>();

    static {
        COMMANDS.put("AdminConfirm", new AdminConfirm());
        COMMANDS.put("AdminOrders", new AdminOrders());
        COMMANDS.put("HotelLogin", new HotelLogin());
        COMMANDS.put("HotelLogOut", new HotelLogOut());
        COMMANDS.put("HotelReg", new HotelReg());
        COMMANDS.put("HotelCatalog", new HotelCatalog());
        COMMANDS.put("CartAdd", new CartAdd());
        COMMANDS.put("LoadCart", new LoadCart());
        COMMANDS.put("MakeOrder", new MakeOrder());
        COMMANDS.put("Home", new Home());
    }

    public static Command get(String commandName) {
        if (commandName == null || !COMMANDS.containsKey(commandName)) {
            return COMMANDS.get("noCommand");
        }

        return COMMANDS.get(commandName);
    }

}
