package ResponseObjects;

public class SearchResponse {
    private int total_results;
    private int query;
    private Slip[] slips;

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public int getQuery() {
        return query;
    }

    public void setQuery(int query) {
        this.query = query;
    }

    public Slip[] getSlips() {
        return slips;
    }

    public void setSlips(Slip[] slips) {
        this.slips = slips;
    }
}
