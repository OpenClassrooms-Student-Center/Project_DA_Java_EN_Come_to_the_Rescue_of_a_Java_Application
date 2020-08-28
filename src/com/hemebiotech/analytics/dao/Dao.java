package com.hemebiotech.analytics.dao;
import java.util.List;

/**
 * DAO pattern : this represents the spec for data access object
 * @param <T>
 */
public interface Dao <T> {

    /**
     * If no data is available, returns an empty List
     *
     * @return ArrayList of all T obtained from a data source, duplicates are possible/probable
     */
    List<T> getAll();

}

