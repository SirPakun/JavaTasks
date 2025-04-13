package by.kirienko.model.entity;

public enum CarTypeEnum {
    ELECTRIC("Electric"),
    GASOLINE("Gasoline");

    private String typeName;

    CarTypeEnum(String typeName){
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    @Override
    public String toString() {
        return "CarTypeEnum{" +
                "typeName='" + typeName + '\'' +
                "} " + super.toString();
    }
}
