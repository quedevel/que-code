package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class IOUtils {

    /**
     * httpRequestList에서 Content_Type 추출하기
     * @param httpRequestList
     * @return String
     * @throws IOException
     */
    public static String getContentType(List<String> httpRequestList) throws IOException {
        String result = "";
        if(httpRequestList.size() > 0){
            Optional<String> optional = httpRequestList.stream().filter(s -> s.indexOf("Accept:") >= 0).findFirst();
            result = optional.isPresent()? optional.get().split(" ")[1].split(",")[0] : "";
        }
        return result;
    }

    /**
     * httpRequestList에서 Content_Length 추출하기
     * @param httpRequestList
     * @return int
     * @throws IOException
     */
    public static int getContentLength(List<String> httpRequestList) throws IOException {
        int result = 0;
        if(httpRequestList.size() > 0){
            Optional<String> optional = httpRequestList.stream().filter(s -> s.indexOf("Content-Length") >= 0).findFirst();
            result = optional.isPresent()? Integer.parseInt(optional.get().split(":")[1].trim()) : 0;
        }
        return result;
    }

    /**
     * queryString to Map
     * @param queryString
     * @return Map<String, String>
     */
    public static Map<String, String> convertQueryStringToMap(String queryString){
        Map<String, String> result = new HashMap<>();
        String[] pArr = queryString.split("&");
        if (pArr.length > 0){
            for(String p : pArr){
                String[] param = p.split("=");
                result.put(param[0], param[1]);
            }
        }
        return result;
    }

    /**
     * content data 읽기
     * @param br
     * @param contentLength
     * @return String
     * @throws IOException
     */
    public static String readData(BufferedReader br, int contentLength) throws IOException {
        char[] body = new char[contentLength];
        br.read(body, 0, contentLength);
        return String.copyValueOf(body);
    }
}
