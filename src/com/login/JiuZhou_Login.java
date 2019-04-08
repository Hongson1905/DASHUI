package com.login;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @description 九州娱乐城登录
 * @author HGH
 * @date 2019/4/8 9:37
 */
public class JiuZhou_Login {

    private boolean isLogined = false;//是否已经登录成功
    public String url_base = "http://wa33.net/SiteSort/index.aspx";

    public JiuZhou_Login(){

    }

    public void login(){
        if (isLogined)return;
        System.out.println(">>>>>>>INFO:JiuZhou:start login");

        try {
            CloseableHttpClient client = null;
            CloseableHttpResponse response = null;
            try {
                HttpGet httpGet = new HttpGet(url_base);

                client = HttpClients.createDefault();
                response = client.execute(httpGet);
                HttpEntity entity = response.getEntity();
                String result = EntityUtils.toString(entity);
                System.out.println(result);
            } finally {
                if (response != null) {
                    response.close();
                }
                if (client != null) {
                    client.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        isLogined = true;

    }


    public static void main(String[] args) {
        JiuZhou_Login jiuZhou_login = new JiuZhou_Login();
        jiuZhou_login.login();
    }

}
