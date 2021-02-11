package model;

public enum Choice {
    COMPUTER, SMARTPHONE;

    @Override
    public String toString() {
        switch (this) {
            case COMPUTER:
                return "computer";
            case SMARTPHONE:
                return "smartphone";
            default:
                return "unspecified";
        }
    }
}
