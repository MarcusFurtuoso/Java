import java.util.Random;

public class PSNovosPacientes implements Runnable{

    private FilaPrioridade<Pessoa> fila;
    private int cont = 7;
    private Random prioridade = new Random();

    public PSNovosPacientes(FilaPrioridade<Pessoa> fila) {
        this.fila = fila;
    }

    @Override
    public void run() {
        
        for (int i=0; i<8; i++) {
            try {
                Thread.sleep(8000);
                Pessoa p = new Pessoa("" + cont, prioridade.nextInt(3));
                fila.enfileira(p);
                cont ++;
                System.out.println(p + " Enfileirada.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
        
    }
    
}