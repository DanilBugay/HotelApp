package Hotel.Entity;

import Hotel.DBEntity.Roomuser;

public enum UserRole {
    CLIENT, ADMIN;

    public static UserRole getRole(Roomuser user) {
        int roleId = Integer.valueOf(user.getStatus());
        return UserRole.values()[roleId];
    }

    public String getName() {
        return name().toLowerCase();
    }
}
