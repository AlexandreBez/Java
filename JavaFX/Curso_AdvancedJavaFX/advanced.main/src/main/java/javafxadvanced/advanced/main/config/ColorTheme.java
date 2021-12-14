package javafxadvanced.advanced.main.config;

public enum ColorTheme {
    LIGHT,
    DEFAULT,
    DARK;

    public static String getClassPath(ColorTheme colorTheme){
        switch (colorTheme){
            case LIGHT:
                return "src/main/resources/javafxadvanced/advanced/main/img/themeLight.css";
            case DEFAULT: 
                return "src/main/resources/javafxadvanced/advanced/main/img/themeDefault.css";
            case DARK:
                return "src/main/resources/javafxadvanced/advanced/main/img/themeDark.css";
            default:
                return null;
        }
    }
}