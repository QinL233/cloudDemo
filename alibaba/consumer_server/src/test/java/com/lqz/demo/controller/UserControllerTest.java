package com.lqz.demo.controller;

import com.lqz.demo.entity.User;
import com.lqz.demo.util.SerializingUtil;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年06月15日 11:36:00
 */
//@SpringBootTest
public class UserControllerTest {

    @Test
    void proto() throws MalformedURLException {
        String url = "http://localhost:8080/user/save2";
        User user = new User();
        user.setId(1);
        user.setUsername("username");
        user.setPassword("password");
        byte[] body = SerializingUtil.serialize(user);
        doPostTestTwo(url,body);
    }

    void doPostTestTwo(String url, byte[] body) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(url);

        httpPost.setEntity(new ByteArrayEntity(body));

        httpPost.setHeader("Content-Type", ProtobufHttpMessageConverter.PROTOBUF.toString());
        httpPost.setHeader("Accept", ProtobufHttpMessageConverter.PROTOBUF.toString());

        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
            HttpEntity responseEntity = response.getEntity();
            System.out.println("响应状态为:" + response.getStatusLine());
            if (responseEntity != null) {
                System.out.println("响应内容长度为:" + responseEntity.getContentLength());
                System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
