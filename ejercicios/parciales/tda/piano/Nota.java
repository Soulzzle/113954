package parciales.tda.piano;

public enum Nota {
    Do,
    Re,
    Mi,
    Fa,
    Sol,
    La,
    Si;

    //METODOS GENERALES
    @Override
    public String toString() {
        return name();
    }
}
