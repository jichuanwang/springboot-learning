package com.dolphin.http;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.net.URI;
import java.net.URL;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by wangjichuan on 2018/12/2.
 */
public class HttpTest    {

    private static AtomicInteger count = new AtomicInteger();

    @Test
    public void testUrl() throws Exception{
        URI uri = new URIBuilder()
                .setScheme("http")
                .setPort(80)
                .setPath("/app/getActivityAllSendInformation")
                .setHost("app.yatiku.com")
                .setParameter("catalogId","5")
                .setParameter("codeId","0")
                .build();
        System.out.println(uri);;
    }

    public static void main(String[] args) throws Exception{

        ExecutorService executor = Executors.newFixedThreadPool(10);
        for(int i=0;i<10000000;i++){
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        CloseableHttpClient httpClient = HttpClients.createDefault();
                        HttpGet httpGet = new HttpGet("http://app.yatiku.com/app/getActivityAllSendInformation?catalogId="+count.get()+"&codeId=0");
                        CloseableHttpResponse response = httpClient.execute(httpGet);
                        response.close();
                        count.incrementAndGet();
                        System.out.println("当前完成了"+count.get());
                        httpClient.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
            });
        }


    }
}
