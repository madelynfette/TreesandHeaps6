import java.util.*;

class Election {
    private PriorityQueue<Candidate>cHeap;
    private HashMap<String,Candidate>cMap;

    private class Candidate {
        String name;
        int votes;

        Candidate(String name) {

            this.name =name;
            this.votes =0;
        }
    }

    public Election() {

        this.cHeap =new PriorityQueue<>((a, b)->b.votes- a.votes);
        this.cMap =new HashMap<>();
    }

    public void initializeCandidates(LinkedList<String>candidates) {
        for (String candidate: candidates) {

            Candidate c=new Candidate(candidate);
            cHeap.add(c);
            cMap.put(candidate, c);
        }
    }

    public void castVote(String candidate) {
        Candidate c = cMap.get(candidate);
        if (c != null) {

            cHeap.remove(c);
            c.votes++;
            cHeap.add(c);
        }
    }

    public void castRandomVote() {
        Random rand =new Random();
        List<String>candidates =new ArrayList<>(cMap.keySet());

        String randomCandidate =candidates.get(rand.nextInt(candidates.size()));
        castVote(randomCandidate);
    }

    public void rigElection(String candidate) {
        Candidate c =cMap.get(candidate);

        if (c != null) {
            cHeap.remove(c);
            int p =c.votes + cHeap.size() + 1;

            c.votes= p;
            cHeap.add(c);
        }
    }


    public List<String> getTopKCandidates(int k) {
        List<String>topCandidates =new ArrayList<>();
        PriorityQueue<Candidate>tHeap =new PriorityQueue<>(cHeap);
        for (int i =0; i< k;i++) {

            if (!tHeap.isEmpty()) {
                topCandidates.add(tHeap.poll().name);
            }
        }

        return topCandidates;
    }

    public void auditElection() {
        PriorityQueue<Candidate> tHeap =new PriorityQueue<>(cHeap);
        while (!tHeap.isEmpty()) {
            Candidate c =tHeap.poll();
            System.out.println(c.name + ": " + c.votes + " votes");
        }
    }

}
