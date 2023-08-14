public enum TrainerCategory
{
    HEADTRAINER, ASSISTANTTRAINER, FITNESSTRAINER, GOALKEEPERTRAINER;
    public String toString() {
        if (this == HEADTRAINER) {
            return "Head Trainer";
        } else if (this == ASSISTANTTRAINER) {
            return "Assistant Trainer";
        } else if (this == FITNESSTRAINER) {
            return "Fitness Trainer";
        } else if (this == GOALKEEPERTRAINER){
            return "Goalkeeper Trainer";
        } 
        return "-";
    }

}
