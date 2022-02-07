package util;

import java.io.BufferedReader;
import java.io.IOException;

public class IOUtils {

    /**
     * InputStream에서 url 추출하기
     * @param bufferedReader
     * @return
     * @throws IOException
     */
    public static String getUrl(BufferedReader bufferedReader) throws IOException {
        String result = "";
        if(bufferedReader.ready()){
            result = bufferedReader.readLine().split(" ")[1];
        }
        return result;
    }

    /**
     * InputStream에서 Content_Type 추출하기
     * @param bufferedReader
     * @return
     * @throws IOException
     */
    public static String getContentType(BufferedReader bufferedReader) throws IOException {
        String result = "";
        while (bufferedReader.ready()){
            String temp = bufferedReader.readLine();
            if(temp.indexOf("Accept") >= 0){
                result = temp.split(",")[0].split(" ")[1];
                break;
            }
        }
        return result;
    }
}
