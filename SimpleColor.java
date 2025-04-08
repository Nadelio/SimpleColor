public class SimpleColor {

    public enum Colors {
        BLACK("\u001B[30m"),
        RED("\u001B[31m"),
        GREEN("\u001B[32m"),
        YELLOW("\u001B[33m"),
        BLUE("\u001B[34m"),
        MAGENTA("\u001B[35m"),
        CYAN("\u001B[36m"),
        WHITE("\u001B[37m"),
        BRIGHT_BLACK("\u001B[90m"),
        BRIGHT_RED("\u001B[91m"),
        BRIGHT_GREEN("\u001B[92m"),
        BRIGHT_YELLOW("\u001B[93m"),
        BRIGHT_BLUE("\u001B[94m"),
        BRIGHT_MAGENTA("\u001B[95m"),
        BRIGHT_CYAN("\u001B[96m"),
        BRIGHT_WHITE("\u001B[97m");

        private String c;
        private Colors(String color) { this.c = color; }
        public String toString() { return c; }
    }
    
    public enum BackgroundColors {
        BLACK("\u001B[40m"),
        RED("\u001B[41m"),
        GREEN("\u001B[42m"),
        YELLOW("\u001B[43m"),
        BLUE("\u001B[44m"),
        MAGENTA("\u001B[45m"),
        CYAN("\u001B[46m"),
        WHITE("\u001B[47m"),
        GRAY("\u001B[100m"),
        BRIGHT_RED("\u001B[101m"),
        BRIGHT_GREEN("\u001B[102m"),
        BRIGHT_YELLOW("\u001B[103m"),
        BRIGHT_BLUE("\u001B[104m"),
        BRIGHT_MAGENTA("\u001B[105m"),
        BRIGHT_CYAN("\u001B[106m"),
        LIGHT_GRAY("\u001B[107m");

        private String c;
        private BackgroundColors(String color) { this.c = color; }
        public String toString() { return c; }
    }

    public enum TextStyles {
        BOLD("\u001B[1m"),
        ITALIC("\u001B[3m"),
        UNDERLINE("\u001B[4m"),
        STRIKETHROUGH("\u001B[9m"),
        RESET("\u001B[0m");

        private String c;
        private TextStyles(String style) { this.c = style; }
        public String toString() { return c; }
    }

    @Deprecated
    private static void test(){
        System.out.println("\nTesting Foreground Colors:");
        for(Colors color : Colors.values()) {
            System.out.println("  " + colorize(color.name(), color));
        }

        System.out.println("Testing Background Colors:");
        for(BackgroundColors bgColor : BackgroundColors.values()) {
            System.out.println("  " + colorize(bgColor.name(), bgColor));
        }

        System.out.println("Testing Text Styles:");
        for(TextStyles style : TextStyles.values()) {
            System.out.println("  " + colorize(style.name(), style));
        }

        System.out.println("Testing Debug, Info, Warning, Error, Success, and Highlight methods:");
        System.out.println("  " + DEBUG("Debug message"));
        System.out.println("  " + INFO("Info message"));
        System.out.println("  " + WARNING("Warning message"));
        System.out.println("  " + ERROR("Error message"));
        System.out.println("  " + SUCCESS("Success message"));
        System.out.println("  " + DEFAULT("Default message"));
        System.out.println("  " + NOTICE("Highlight message"));

        
        System.out.println("Testing Bold, Italic, Underline, and Strikethrough methods:");
        System.out.println("  " + BOLD("Bold message"));
        System.out.println("  " + ITALIC("Italic message"));
        System.out.println("  " + UNDERLINE("Underline message"));
        System.out.println("  " + STRIKETHROUGH("Strikethrough message"));

        System.out.println("Testing Custom Colorization:");
        System.out.println("  " + colorize("Custom message", Colors.RED, BackgroundColors.YELLOW, TextStyles.STRIKETHROUGH));
        System.out.println("  " + colorize("Custom message", Colors.GREEN, BackgroundColors.BLUE));
        System.out.println("  " + colorize("Custom message", Colors.YELLOW, TextStyles.ITALIC));
        System.out.println("  " + colorize("Custom message", BackgroundColors.CYAN, TextStyles.UNDERLINE));
        System.out.println("  " + colorize("Custom message", Colors.MAGENTA));
        System.out.println("  " + colorize("Custom message", BackgroundColors.WHITE));
        System.out.println("  " + colorize("Custom message", TextStyles.STRIKETHROUGH));

        System.out.println("Testing nested colorization calls:");
        System.out.println("  " + colorize(colorize(colorize("Nested message", Colors.RED), BackgroundColors.YELLOW), TextStyles.STRIKETHROUGH));
        System.out.println("Successfully tested all colorization calls.");
    }
    
    /**
     * <p>
     * Colorizes the text with the specified color, background color, and style.
     * <p>
     * @param text The text to colorize.
     * @param color The foreground color.
     * @param bgColor The background color.
     * @param style The text style.
     * @return The colorized text
     */
    public static String colorize(String text, Colors color, BackgroundColors bgColor, TextStyles style) {
        return "" + color + bgColor + style + text + TextStyles.RESET;
    }

    /**
     * <p>
     * Colorizes the text with the specified color and background color.
     * <p>
     * @param text The text to colorize.
     * @param color The foreground color.
     * @param bgColor The background color.
     * @return The colorized text
     */
    public static String colorize(String text, Colors color, BackgroundColors bgColor) {
        return "" + color + bgColor + text + TextStyles.RESET;
    }

    /**
     * <p>
     * Colorizes the text with the specified color and style.
     * <p>
     * @param text The text to colorize.
     * @param color The foreground color.
     * @param style The text style.
     * @return The colorized text
     */
    public static String colorize(String text, Colors color, TextStyles style) {
        return "" + color + style + text + TextStyles.RESET;
    }

    /**
     * <p>
     * Colorizes the text with the specified background color and style.
     * <p>
     * @param text The text to colorize.
     * @param bgColor The background color.
     * @param style The text style.
     * @return The colorized text
     */
    public static String colorize(String text, BackgroundColors bgColor, TextStyles style) {
        return "" + bgColor + style + text + TextStyles.RESET;
    }

    /**
     * <p>
     * Colorizes the text with the specified color.
     * <p>
     * @param text The text to colorize.
     * @param color The foreground color.
     * @return The colorized text
     */
    public static String colorize(String text, Colors color) {
        return color + text + TextStyles.RESET;
    }

    /**
     * <p>
     * Colorizes the text with the specified background color.
     * <p>
     * @param text The text to colorize.
     * @param bgColor The background color.
     * @return The colorized text
     */
    public static String colorize(String text, BackgroundColors bgColor) {
        return bgColor + text + TextStyles.RESET;
    }

    /**
     * <p>
     * Colorizes the text with the specified style.
     * <p>
     * @param text The text to colorize.
     * @param style The text style.
     * @return The colorized text
     */
    public static String colorize(String text, TextStyles style) {
        return style + text + TextStyles.RESET;
    }

    /**
     * <p>
     * Debug message format for text. This is a blue color.
     * <p>
     * @param text
     * @return The formatted text
     */
    public static String DEBUG(String text) {
        return colorize(text, Colors.BLUE);
    }

    /**
     * <p>
     * Info message format for text. This is a magenta color.
     * <p>
     * @param text
     * @return The formatted text
     */
    public static String INFO(String text) {
        return colorize(text, Colors.MAGENTA);
    }

    /**
     * <p>
     * Warning message format for text. This is a yellow color.
     * <p>
     * @param text
     * @return The formatted text
     */
    public static String WARNING(String text) {
        return colorize(text, Colors.YELLOW);
    }

    /**
     * <p>
     * Error message format for text. This is a red color.
     * <p>
     * @param text
     * @return The formatted text
     */
    public static String ERROR(String text) {
        return colorize(text, Colors.RED);
    }

    /**
     * <p>
     * Success message format for text. This is a green color.
     * <p>
     * @param text
     * @return The formatted text
     */
    public static String SUCCESS(String text) {
        return colorize(text, Colors.GREEN);
    }

    /**
     * <p>
     * Highlight message format for text. This is a black text on blue background.
     * <p>
     * @param text
     * @return The formatted text
     */
    public static String NOTICE(String text) {
        return colorize(text, Colors.BLACK, BackgroundColors.BLUE);
    }

    /**
     * <p>
     * Default system message format for text. This is a cyan color.
     * <p>
     * @param text
     * @return The formatted text
     */
    public static String DEFAULT(String text) {
        return colorize(text, Colors.CYAN);
    }

    /**
     * <p>
     * Resets the text color and style to default.
     * <p>
     * @param text
     * @return The formatted text
     */
    public static String BOLD(String text) {
        return TextStyles.BOLD + text + TextStyles.RESET;
    }

    /**
     * <p>
     * Italicizes the text. This is not supported in all terminals, but it is included for completeness.
     * <p>
     * @param text
     * @return The formatted text
     */
    public static String ITALIC(String text) {
        return TextStyles.ITALIC + text + TextStyles.RESET;
    }

    /**
     * <p>
     * Underlines the text.
     * <p>
     * @param text
     * @return The formatted text
     */
    public static String UNDERLINE(String text) {
        return TextStyles.UNDERLINE + text + TextStyles.RESET;
    }

    /**
     * <p>
     * Strikethroughs the text.
     * <p>
     * @param text
     * @return The formatted text
     */
    public static String STRIKETHROUGH(String text) {
        return TextStyles.STRIKETHROUGH + text + TextStyles.RESET;
    }
}