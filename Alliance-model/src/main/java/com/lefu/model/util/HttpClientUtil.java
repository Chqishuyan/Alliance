package com.lefu.model.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;


/**
 * Created by shuyan.qi on 2017/5/16.
 */
public class HttpClientUtil {



    private static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

    /**
     * @Description 一句话描述方法用法
     * @param url
     * @param protocol
     * @param requestData
     * @param charset
     * @return
     * @see
     */
    public static String sendRequest(String method, String url, String protocol, String requestData, String charset) {
        HttpClientBuilder httpClientBuilder = null;
        CloseableHttpClient closeableHttpClient = null;
        HttpPost httpPost = null;
        String result = null;
        try {
            httpClientBuilder = HttpClientBuilder.create();
            RequestConfig config = RequestConfig.custom().setConnectTimeout(15 * 1000).setSocketTimeout(30 * 1000)
                    .build();
            httpClientBuilder.setDefaultRequestConfig(config);

            closeableHttpClient = httpClientBuilder.build();

            httpPost = new HttpPost(url);
            EntityBuilder entity = EntityBuilder.create();
            entity.setText(requestData);
            entity.setContentType(ContentType.APPLICATION_JSON);
            entity.setContentEncoding(charset);
            httpPost.setEntity(entity.build());

            HttpResponse response = closeableHttpClient.execute(httpPost);
            if (response != null) {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    result = EntityUtils.toString(resEntity, charset);
                } else {
                    logger.info("HttpEntity resEntity响应信息为空");
                }
            } else {
                logger.info("HttpResponse response 响应信息为空");
            }
        } catch (IOException ioe) {
            logger.error("Method sendRequest execute exception...");
            ioe.printStackTrace();
        } finally {
            try {
                // 关闭流并释放资源
                if (closeableHttpClient != null)
                    closeableHttpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
                logger.error("Method sendRequest release resource exception...");
            }
        }
        return result;
    }

    /**
     * 发送http请求，返回一个InputStream
     * @param method 请求方式(GET还是POST)
     * @param url
     * @param requestData 请求参数，json格式
     * @param charset 字符集
     * @return
     */
    public static InputStream send(String method, String url, String requestData, String charset){
        InputStream returnInputStream = null;

        HttpClientBuilder httpClientBuilder = null;
        CloseableHttpClient closeableHttpClient = null;
        HttpPost httpPost = null;
        HttpGet httpGet = null;
        CloseableHttpResponse response = null;
        HttpEntity entity = null;
        try {
            httpClientBuilder = HttpClientBuilder.create();
            RequestConfig config = RequestConfig.custom().setConnectTimeout(15 * 1000).setSocketTimeout(30 * 1000)
                    .build();
            httpClientBuilder.setDefaultRequestConfig(config);
            closeableHttpClient = httpClientBuilder.build();

            //get请求
            if("get".equalsIgnoreCase(method)){
                httpGet = new HttpGet(url);
                httpGet.addHeader("Content-Type","text/html; charset=utf-8");

                response = closeableHttpClient.execute(httpGet);
            }

            //post请求
            if("post".equalsIgnoreCase(method)){
                httpPost = new HttpPost(url);
                EntityBuilder entityBuilder = EntityBuilder.create();
                entityBuilder.setText(requestData);
                entityBuilder.setContentType(ContentType.APPLICATION_JSON);
                entityBuilder.setContentEncoding(charset);
                httpPost.setEntity(entityBuilder.build());

                response = closeableHttpClient.execute(httpPost);
            }
            if(null != response){
                entity = response.getEntity();
                if(null != entity){
                    returnInputStream = entity.getContent();
                }
            }
        }catch (IOException e) {
            logger.error("Method send error:"+e);
        }
        return returnInputStream;
    }

}
