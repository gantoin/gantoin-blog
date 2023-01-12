package fr.gantoin.domain;

public enum TechnoPillColorEnum {
    BLUE("#1E90FF"),
    GREEN("#228B22"),
    ORANGE("#FF8C00"),
    RED("#FF0000"),
    YELLOW("#FFD700"),
    PURPLE("#8A2BE2"),
    GRAY("#808080"),
    BLACK("#000000"),
    WHITE("#FFFFFF");


    private final String color;

    TechnoPillColorEnum(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
