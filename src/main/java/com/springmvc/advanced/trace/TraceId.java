package com.springmvc.advanced.trace;

import java.util.UUID;

public class TraceId {

    private String id;

    private int level;


    public TraceId() {

        this.id = createId();
        this.level = 0;

    }


    public TraceId(String id, int level) {
        this.id = id;
        this.level = level;
    }


    private String createId() {
        return UUID.randomUUID().toString().split("-")[0]; // 앞자리 id만 사용 substring(0,8)
    }

    public TraceId createNextId() {
        return new TraceId(id, level + 1);
    }

    public TraceId createPreviousId() {
        return new TraceId(id, level - 1);
    }

    public boolean isFirstLevel() {
        return level == 0;
    }


    public String getId() {
        return this.id;
    }

    public int getLevel() {
        return this.level;
    }



}
