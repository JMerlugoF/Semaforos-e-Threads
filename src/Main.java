import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws Exception {
        
        int permissoes = 1;
        Semaphore porta = new Semaphore(permissoes);
        
        for(int pessoa = 1; pessoa <= 4; pessoa++){
            Thread threadPorta = new ThreadPorta(pessoa, porta);
            threadPorta.start();
            
        }  
    
    }
}
