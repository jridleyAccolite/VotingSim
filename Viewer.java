import java.util.Random;



public class Viewer implements Runnable{
    static int numOptions;  // number of voting options available

    public Viewer(int n){
        numOptions = n;
    }

    @Override
    public void run() {
        // choose random baker to vote for
        Random r = new Random();
        int a = r.nextInt(numOptions);

        // update votes using lock on votes array
        synchronized(Competition.votes){
            System.out.println("voting for baker "+(a+1));

            // cast vote
            Competition.votes[a] += 1;

            // print updated vote tallies
            System.out.print("Votes are: ");
            for (int i = 0; i < numOptions; i++) {
                System.out.print(Competition.votes[i]);
                if(i < numOptions-1){
                    System.out.print("-");
                }
                else{
                    System.out.println("");
                }
            }
        }
    }
}
