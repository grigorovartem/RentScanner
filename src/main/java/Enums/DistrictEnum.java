package Enums;

public enum DistrictEnum {
    GOLOSEEVSKIY("Голосеевский"),
    DARNITSKIY("Дарницкий"), ;

    DistrictEnum(String displayName) {this.displayName = displayName;}

    private String displayName;
    public String getDisplayName() {return displayName;}

}
