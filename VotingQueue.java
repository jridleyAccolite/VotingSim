import java.util.Random;

public class VotingQueue implements Runnable{
    // periodically creates viewers who vote in the competition

    static int numOptions;  // number of options for voters

    public VotingQueue(int numBakers){
        numOptions = numBakers;
    }

    @Override
    public void run() {
        // infinite loop
        while(true){

            Random r = new Random();

            // create new Viewer thread (admitting a voter from the front of the Voting Queue)
            new Thread(new Viewer(numOptions)).start();

            try {
                Thread.sleep(r.nextInt(80, 200));   // wait random interval
            } catch (InterruptedException e) {
                // when interrupted, break from infinite loop, thus ending voting
                break;
            }
        }
    }
}
