import java.util.ArrayList;
import java.util.Arrays;

public class Competition {
    public static int[] votes;

    public static void main(String[] args) throws InterruptedException {

        int t = 3000;   // length in time of vote (ms) [approximating 1hour=1second in sim]
        int numBakers = 3; // number of bakers to vote for

        // init votes array to 0s
        votes = new int[numBakers];

        /* create a thread that creates viewers in an infinite loop UNTIL an interrupt message
         * is sent to it after the allotted time for the vote has passed */
        Thread voters = new Thread(new VotingQueue(numBakers));

        // voting OPENS
        voters.start();

        // wait t time before closing voting
        Thread.sleep(t);

        // voting CLOSES
        voters.interrupt();

        // check and print results
        int total = Arrays.stream(votes).sum();
        System.out.print("\nfinal result is:\n\n" +
                "total votes: " + total);
        for (int i = 0; i < numBakers; i++) {
            System.out.print("\nBaker " + (i+1) + ": " + votes[i]);
        }
    }
}
