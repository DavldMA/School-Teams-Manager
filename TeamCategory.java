public enum TeamCategory
{
    PETIZES, TRAQUINAS, BENJAMINS;
    public String toString() {
        if (this == PETIZES) {
            return "Sub-7 (Petizes)";
        } else if (this == TRAQUINAS) {
            return "Sub-9 (Traquinas)";
        } else if (this == BENJAMINS) {
            return "Sub-11 (Benjamins)";
        } 
        return "-";
    }
}
