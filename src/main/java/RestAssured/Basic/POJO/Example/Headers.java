package RestAssured.Basic.POJO.Example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Headers {
    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }

    @JsonProperty("Accept")
    private String accept;
    @JsonProperty("Accept-Encoding")
    private String AcceptEncoding;
    @JsonProperty("Content-Length")
    private String contentLength;

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }



    public String getAcceptEncoding() {
        return AcceptEncoding;
    }

    public void setAcceptEncoding(String acceptEncoding) {
        AcceptEncoding = acceptEncoding;
    }

    public String getContentLength() {
        return contentLength;
    }

    public void setContentLength(String contentLength) {
        this.contentLength = contentLength;
    }


    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getxAmznTraceid() {
        return xAmznTraceid;
    }

    public void setxAmznTraceid(String xAmznTraceid) {
        this.xAmznTraceid = xAmznTraceid;
    }

    @JsonProperty("Content-Type")
    private String contentType;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    @JsonProperty("Host")
    private String host;
    @JsonProperty("User-Agent")
    private String userAgent;
    @JsonProperty("X-Amzn-Trace-Id")
    private String xAmznTraceid;
}
