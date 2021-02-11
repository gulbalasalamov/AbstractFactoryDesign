package model;

public enum Type {
    SERVER, PC, ANDROID,IPHONE,TEST;

    public String toString() {
        switch (this) {
            case SERVER:
                return "Server";
            case PC:
                return "Pc";
            case ANDROID:
                return "Android";
            case IPHONE:
                return "Iphone";
            case TEST:
                return "Test";
            default:
                return "unspecified";
        }
    }
}