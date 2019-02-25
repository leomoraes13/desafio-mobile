package ca.leomoraes.fulllabstore.model;

public class TriggerResponse {
    private String query;
    private int page;
    private boolean isQueryChange;

    public TriggerResponse(String query, int page, boolean isQueryChange) {
        this.query = query;
        this.page = page;
        this.isQueryChange = isQueryChange;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public boolean isQueryChange() {
        return isQueryChange;
    }

    public void setQueryChange(boolean queryChange) {
        isQueryChange = queryChange;
    }
}
