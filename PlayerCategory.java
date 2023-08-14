public enum PlayerCategory
{
    ESTRELA, PROMESSA, REGULAR, NONE;
    public String toString() {
        if (this == ESTRELA) {
            return "Estrela";
        } else if (this == PROMESSA) {
            return "Promessa";
        } else if (this == REGULAR) {
            return "Regular";
        } else if (this == NONE) {
            return "-";
        }
        return "-";
    }

}
