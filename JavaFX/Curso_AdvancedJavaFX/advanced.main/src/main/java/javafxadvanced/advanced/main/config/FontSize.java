package javafxadvanced.advanced.main.config;

public enum FontSize {
    SMALL,
    MEDIUM,
    BIG;

    public static String getClassPath(FontSize fontSize){
        switch (fontSize){
            case SMALL:
                return "src/main/resources/javafxadvanced/advanced/main/img/fontSmall.css";
            case MEDIUM: 
                return "src/main/resources/javafxadvanced/advanced/main/img/default.css";
            case BIG:
                return "src/main/resources/javafxadvanced/advanced/main/img/fontBig.css";
            default:
                return null;
        }
    }
}