public enum Styles {
        BLACK("\u001B[30m"),
        RED("\u001B[31m"),
        GREEN("\u001B[32m"),
        YELLOW("\u001B[33m"),
        BLUE("\u001B[34m"),
        PURPLE("\u001B[35m"),
        CYAN("\u001B[36m"),
        WHITE("\u001B[37m"),


        BLACK_BG("\u001B[40m"),
        RED_BG("\u001B[41m"),
        GREEN_BG("\u001B[42m"),
        YELLOW_BG("\u001B[43m"),
        BLUE_BG("\u001B[44m"),
        PURPLE_BG("\u001B[45m"),
        CYAN_BG("\u001B[46m"),
        WHITE_BG("\u001B[47m"),


        BOLD("\u001B[1m"),
        UNDERLINE("\u001B[4m"),


        RESET("\u001B[0m"),


        //ICON
        CHECK("\u001B[32m" + "\u2714" + " Check" + "\u001B[0m");
        //SAVEDATA("\u001B[32m" + "\u2714" + " SAVED " + "\u001B[32m" + "\u2714" + "\u001B[0m");

        private final String code;

        Styles(String code) {
            this.code = code;
        }

        @Override
        public String toString() {
                return code;
        }
}
