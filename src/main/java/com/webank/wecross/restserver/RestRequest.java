package com.webank.wecross.restserver;

import com.webank.wecross.exception.WeCrossException;

public class RestRequest<T> {

    private String version;
    private String path;
    private String method;
    private String accountName;
    private T data;

    public void checkRestRequest(String path, String method) throws WeCrossException {
        String errorMessage;
        if (this.version == null) {
            errorMessage = "\"version\" not found in request package";
            throw new WeCrossException(WeCrossException.ErrorCode.FIELD_MISSING, errorMessage);
        }

        if (this.path == null) {
            errorMessage = "\"path\" not found in request package";
            throw new WeCrossException(WeCrossException.ErrorCode.FIELD_MISSING, errorMessage);
        }

        if (this.method == null) {
            errorMessage = "\"method\" not found in request package";
            throw new WeCrossException(WeCrossException.ErrorCode.FIELD_MISSING, errorMessage);
        }

        if (!Versions.checkVersion(version)) {
            errorMessage = "Unsupported version :" + version;
            throw new WeCrossException(WeCrossException.ErrorCode.VERSION_ERROR, errorMessage);
        }

        if (!this.path.equals(path)) {
            errorMessage = "Expect path: " + path;
            throw new WeCrossException(WeCrossException.ErrorCode.PATH_ERROR, errorMessage);
        }

        if (!this.method.equals(method)) {
            errorMessage = "Expect method: " + method;
            throw new WeCrossException(WeCrossException.ErrorCode.METHOD_ERROR, errorMessage);
        }
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
