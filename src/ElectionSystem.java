import java.util.*;

public class ElectionSystem {
    public static void main(String[] args) {
        Election election = new Election();
        LinkedList<String> candidates = new LinkedList<>();
        candidates.add("Marcus Fenix");
        candidates.add("Dominic Santiago");
        candidates.add("Damon Baird");
        candidates.add("Cole Train");
        candidates.add("Anya Stroud");
        election.initializeCandidates(candidates);
        int p = 100;

        //casting of votes
        for (int i = 0; i < p; i++) {
            election.castRandomVote();
        }

        //get top candidates
        List<String> topCandidates = election.getTopKCandidates(3);
        System.out.println("Top 3 candidates: " + topCandidates);

        //rig election
        String rig = "Marcus Fenix";
        election.rigElection(rig);

        //get top after rig
        List<String> topCandidates2 = election.getTopKCandidates(3);
        System.out.println("Top 3 candidates: " + topCandidates2);

        //audit
        election.auditElection();
    }
}
