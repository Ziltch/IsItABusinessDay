package main;

/**
 * @Author Ole K. Olsen
 * 03.06.2017.
 */
public enum TypeOfDay {
    DAYOFF("dayoff"),
    BUSINESSDAY("businessday"),
    SQUEEZEDINDAY("squeezedinday");

    private final String typeOfDayCode;

    private TypeOfDay(String typeOfDayCode) {
        this.typeOfDayCode = typeOfDayCode;
    }

    public String getTypeOfDayCode() {
        return this.typeOfDayCode;
    }
}
