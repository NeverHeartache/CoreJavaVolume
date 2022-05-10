package org.corejavavolume.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * HttpClient 测试用例
 *
 * @author he
 */
public class HttpClientTest {

    private static final String fileServer = "10.1.1.109";

    private static final String fileServerPort = "9002";

    private static final String fileName = "d80e1ac14bfa4268a67ddf336878b818-b01.jpg";

    public static void main(String[] args) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://" + fileServer + ":" + fileServerPort + "/file/download/" + fileName  + "?isMini=1");
        httpGet.setHeader("Connection", "keep-alive");
        httpGet.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/101.0.4951.54 Safari/537.36");

        CloseableHttpResponse httpResponse = null;
        try {
            //
            httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            System.out.println(EntityUtils.toString(httpEntity));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            if (httpResponse != null) {
                try {
                    httpResponse.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
