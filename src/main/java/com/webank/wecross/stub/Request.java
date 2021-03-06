package com.webank.wecross.stub;

import java.util.Arrays;

public class Request {
    private int type;
    private byte[] data;
    private ResourceInfo resourceInfo;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public ResourceInfo getResourceInfo() {
        return resourceInfo;
    }

    public void setResourceInfo(ResourceInfo resourceInfo) {
        this.resourceInfo = resourceInfo;
    }

    @Override
    public String toString() {
        return "Request{"
                + "type="
                + type
                + ", data="
                + Arrays.toString(data)
                + ", resourceInfo="
                + resourceInfo
                + '}';
    }
}
