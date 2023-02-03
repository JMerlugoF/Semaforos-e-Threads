import java.util.concurrent.Semaphore;

public class ThreadPorta extends Thread {
    
    private int pessoa;
    private String pessoas[] = {"Joao", "Maria", "Mateus", "Rodrigo"};
    private Semaphore porta;

    public ThreadPorta (int pessoa, Semaphore porta) {
        this.porta = porta;
        this.pessoa = pessoa;
    }

    @Override
    public void run() {
        
        anda();
        try {
            System.out.println("Pessoa #" + pessoa + " chegou na porta");
            porta.acquire();
            Thread.sleep((int)(Math.random() * 1000) + 1000); //vai levar de 1 a 2 segundos pra passar
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        } finally {
            porta.release(); //libera o semáforo
            pessoaPassou();
        }
    }

    public void anda() {
        int distancia = 0;
        System.out.println("Pessoa #" + pessoa + " começou a andar!");

        while(distancia < 200) {
            distancia += (int) (Math.random() * 2) + 4;
            try {
                Thread.sleep(1000);

            } catch (InterruptedException exception) {
                exception.printStackTrace();
            } 
        }
    }

    public void pessoaPassou(){
        System.out.println("Pessoa #"+ pessoa +" passou a porta!");
    }
}
