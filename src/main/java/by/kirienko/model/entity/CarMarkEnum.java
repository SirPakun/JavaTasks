package by.kirienko.model.entity;

public enum CarMarkEnum {
    BMV("BMW"),
    SKODA("Škoda"),
    TESLA("Tesla"),
    MERCEDES("Mercedes-Benz"),
    LADA("Lada");

    private String markName;

    CarMarkEnum(String markName){
        this.markName = markName;
    }

    public String getMarkName() {
        return markName;
    }

    @Override
    public String toString() {
        return "CarMarkEnum{" +
                "markName='" + markName + '\'' +
                "} " + super.toString();
    }
}
