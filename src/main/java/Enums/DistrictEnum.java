package Enums;

public enum DistrictEnum {
    GOLOSEEVSKIY("Голосеевский"),
    DARNITSKIY("Дарницкий"),
    DESNYANSKIY("Деснянский"),
    DNEPROVSKIY("Днепровский"),
    OBOLONSKIY("Оболонский"),
    PECHERSKIY("Печерский"),
    PODOLSKIY("Подольский"),
    SVYATOSHINSKIY("Святошинский"),
    SOLOMENSKIY("Соломенский"),
    SHEVCHENKOVSKIY("Шевченковский");

    DistrictEnum(String displayName) {this.displayName = displayName;}

    private String displayName;
    public String getDisplayName() {return displayName;}

}
