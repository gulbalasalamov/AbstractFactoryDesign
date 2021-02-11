package model;

public enum Manufacturer {
    HP, LG, ACER, LENOVO, MONSTER, ASUS, FUJITSU, TOSHIBA, DELL, APPLE, XIOAMI, SAMSUNG, VESTEL,TEST;

    public String toString() {
        switch (this) {
            case HP:
                return "Hp";
            case LG:
                return "Lg";
            case ACER:
                return "Acer";
            case LENOVO:
                return "Lenovo";
            case MONSTER:
                return "Monster";
            case ASUS:
                return "Asus";
            case FUJITSU:
                return "Fujitsu";
            case TOSHIBA:
                return "Toshiba";
            case DELL:
                return "Dell";
            case APPLE:
                return "Apple";
            case XIOAMI:
                return "Xiaomi";
            case SAMSUNG:
                return "Samsung";
            case VESTEL:
                return "Vestel";
            case TEST:
                return "Test";
            default:
                return "unspecified";
        }
    }
}
