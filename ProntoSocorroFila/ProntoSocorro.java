public class ProntoSocorro {
    
    public static final int VERDE = 2;
    public static final int AMARELO = 1;
    public static final int VERMELHO = 0;
    public static void main(String[] args) {
        
        FilaPrioridade<Pessoa> fila = new FilaPrioridade<>();

        fila.enfileira(new Pessoa("Pessoa 1", VERDE));
        fila.enfileira(new Pessoa("Pessoa 2", AMARELO));
        fila.enfileira(new Pessoa("Pessoa 3", VERDE));
        fila.enfileira(new Pessoa("Pessoa 4", VERMELHO));
        fila.enfileira(new Pessoa("Pessoa 5", VERMELHO));
        fila.enfileira(new Pessoa("Pessoa 6", AMARELO));

        PSAtendimento atendimento = new PSAtendimento(fila);
        PSNovosPacientes pacientes = new PSNovosPacientes(fila);

        Thread t1 = new Thread(atendimento);
        Thread t2 = new Thread(pacientes);

        t1.start();
        t2.start();
    }
}