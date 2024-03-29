package by.epam.task05.entity;

public enum UserRole {
    GUEST,
    CLIENT,
    MANAGER,
    ADMIN;

    public static UserRole createRole(int value) {
        switch(value) {
            case 1:
                return UserRole.GUEST;
            case 2:
                return UserRole.CLIENT;
            case 3:
                return UserRole.MANAGER;
            case 4:
                return UserRole.ADMIN;
            default: throw new IllegalArgumentException();
        }
    }

    public static UserRole createRole(String value)
    {
        switch(value) {
            case "guest":
                return UserRole.GUEST;
            case "client":
                return UserRole.CLIENT;
            case "manager":
                return UserRole.MANAGER;
            case "admin":
                return UserRole.ADMIN;

            case "Guest":
                return UserRole.GUEST;
            case "Client":
                return UserRole.CLIENT;
            case "Manager":
                return UserRole.MANAGER;
            case "Admin":
                return UserRole.ADMIN;
            default: throw new IllegalArgumentException();
        }
    }

    public int toInt()
    {
        switch(this) {
            case GUEST:
                return 1;
            case CLIENT:
                return 2;
            case MANAGER:
                return 3;
            case ADMIN:
                return 4;
            default: throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString()
    {
        switch(this) {
            case GUEST:
                return "guest";
            case CLIENT:
                return "client";
            case MANAGER:
                return "manager";
            case ADMIN:
                return "admin";
            default: throw new IllegalArgumentException();
        }
    }
}
