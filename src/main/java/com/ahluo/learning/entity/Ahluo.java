package com.ahluo.learning.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * <pre>
 *      common bean
 * </pre>
 *
 * @author Ahluo on 2016-8-29.
 */
public class Ahluo {
    private long id;
    private String currentName;
    private long duration;

    public static Ahluo getNewInstance() {
        return new Ahluo();
    }

    public long getId() {
        return id;
    }

    public Ahluo setId(long id) {
        this.id = id;
        return this;
    }

    public String getCurrentName() {
        return currentName;
    }

    public Ahluo setCurrentName(String currentName) {
        this.currentName = currentName;
        return this;
    }

    public long getDuration() {
        return duration;
    }

    public Ahluo setDuration(long duration) {
        this.duration = duration;
        return this;
    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return "[NULL]";
        }
    }
}
