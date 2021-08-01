package com.example.apiRestTest.apiRestTest.Entity;

import java.util.ArrayList;
import java.util.List;

public class ResultItunes
{
    private int resultCount;
    private List<ItunesArtist> results = new ArrayList<ItunesArtist>();

    public ResultItunes(){}

    /**
     * @return the resultCount
     */
    public int getResultCount() {
        return resultCount;
    }

    /**
     * @param resultCount the resultCount to set
     */
    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    /**
     * @return the results
     */
    public List<ItunesArtist> getResults() {
        return results;
    }

    /**
     * @param results the results to set
     */
    public void setResults(List<ItunesArtist> results) {
        this.results = results;
    }
}
