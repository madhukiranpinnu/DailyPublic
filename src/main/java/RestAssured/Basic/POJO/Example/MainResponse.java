package RestAssured.Basic.POJO.Example;

import java.util.HashMap;
import java.util.Map;

public class MainResponse {
   private Map<String,Object> args=new HashMap<>();
   private String data;
   private Json json;
   private Map<String,Object> files=new HashMap<>();

   public Map<String, Object> getForm() {
      return form;
   }

   public void setForm(Map<String, Object> form) {
      this.form = form;
   }

   public Map<String, Object> getArgs() {
      return args;
   }

   public void setArgs(Map<String, Object> args) {
      this.args = args;
   }

   public String getData() {
      return data;
   }

   public void setData(String data) {
      this.data = data;
   }

   public Json getJson() {
      return json;
   }

   public void setJson(Json json) {
      this.json = json;
   }

   public Map<String, Object> getFiles() {
      return files;
   }

   public void setFiles(Map<String, Object> files) {
      this.files = files;
   }

   public String getMethod() {
      return method;
   }

   public void setMethod(String method) {
      this.method = method;
   }

   public String getOrigin() {
      return origin;
   }

   public void setOrigin(String origin) {
      this.origin = origin;
   }

   public String getUrl() {
      return url;
   }

   public void setUrl(String url) {
      this.url = url;
   }

   private Map<String,Object> form=new HashMap<>();
   private String method;
   private String origin;
   private String url;

   public Headers getHeaders() {
      return headers;
   }

   public void setHeaders(Headers headers) {
      this.headers = headers;
   }

   private Headers headers;
}
