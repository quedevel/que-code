package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class IOUtils {

    /**
     * InputStream에서 url 추출하기
     * @param bufferedReader
     * @return String
     * @throws IOException
     */
    public static String getUrl(BufferedReader bufferedReader) throws IOException {
        String result = "";
        if(bufferedReader.ready()){
            String temp = bufferedReader.readLine();
            System.out.println("temp : "+temp);
            result = temp.split(" ")[1];
        }
        System.out.println("url: "+result);
        return result;
    }

    /**
     * InputStream에서 Content_Type 추출하기
     * @param bufferedReader
     * @return String
     * @throws IOException
     */
    public static String getContentType(BufferedReader bufferedReader) throws IOException {
        String result = "";
        while (bufferedReader.ready()){
            String temp = bufferedReader.readLine();
            System.out.println("etc.... : "+temp);
            if(temp.indexOf("Accept:") >= 0){
                result = temp.split(",")[0].split(" ")[1];
                // break; 로그 출력하면서 작업하기 위해 주석처리
            }
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
}
