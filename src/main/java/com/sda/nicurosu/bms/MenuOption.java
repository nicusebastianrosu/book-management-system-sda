package com.sda.nicurosu.bms;

public enum MenuOption {
    CREATE_BOOK("1", "Create book"),
    CREATE_AUTHOR("2", "Create author"),
    CREATE_REVIEW("3", "Create review"),
    CREATE_BOOK_WITH_AUTHOR("4", "Create book with author"),
    VIEW_ALL_AUTHOR("5", "VIEW ALL AUTHOR"),
    UPDATE_AUTHOR("6", "UPDATE AUTHOR"),
    EXIT("EXIT", "Close the application"),
    UNDEFINED("", "OPTION NOT FOUND");

    private final String option;
    private final String description;

    MenuOption(String option, String description) {
        this.option = option;
        this.description = description;
    }

    public String getOption() {
        return option;
    }

    public String getDescription() {
        return description;
    }
}
