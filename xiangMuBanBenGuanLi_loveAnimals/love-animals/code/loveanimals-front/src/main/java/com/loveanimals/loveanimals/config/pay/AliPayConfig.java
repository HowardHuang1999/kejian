package com.loveanimals.loveanimals.config.pay;

import org.springframework.context.annotation.Configuration;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author ligen
 * @title: AliPayConfig
 * @projectName demo
 * @description:
 * @date 2019/6/1014:20
 */
@Configuration
public class AliPayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
//    netapp映射的地址，，，根据自己的需要修改
    private static String neturl = "http://6dynnj.natappfree.cc";

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号 按照我文章图上的信息填写
    public static String app_id = "2016102500758558";

    // 商户私钥，您的PKCS8格式RSA2私钥  刚刚生成的私钥直接复制填写
    public static String merchant_private_key ="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCdB293nWyOGx6GxvXFxVf76cff54CmVW4h0h+obB4xWAmKHl+cHfo0uImc1NV5skKFNkqALX6J21ZGQIuVsZgdDTq+8z7ZDJ2Y4bSnIkYODouSm4fTUeie4YzCrRwAroEofq4QQedgLUDigE7ykLG59V3saZ3FAYlkXy3uOJ4/qJc1+PFm81+0xOsZd6MD1etLWARoW+jVJ4ErfmiR29MA+7N38EzNeI8E6C04Cl0Z72sS24OmV8u9rQWGwqs2E/q5UwoHDipeu9Z9auO7U24KZbTBCc3/0OvOVBoa4TfIzdY9VNr5bye66KR9d6y8o2cxRAybg6zMhqe6AOrcURBbAgMBAAECggEBAI7fjgcKYBPoDt1YN5SLWuNlMSvC6iXtQvhYw98tCEejL4LQ4fMcv2Oqp+LfL6C7lZS48g4v1ps9ywC+h4JbBOkh+Vp13bAEr3vDmOgc4hq2Fz38bxfRxdKRq84RTZI9NF0Q7fTy0b+LTScI0UwYZOyqmJua+SafoE+H3jWKpEmL/6pj+Utq0dARZnd3dOGpxKu1ycJ3X3QRoh1JOU+q48cE6EX30V10VgGGkXwKQG98aDNAC7rh3Rss6ejKhHCesACNaK7h5j+/r3EuwLTW4L7nLM5LF+ljCYvwwZ3/0PlCW6xoXhCqUnXW9o8TW7p0RCpx0T6ewmdAeLM3hYI4CIkCgYEA3uU5cCj6PtUZTo5poILgz2l8EuUXGUNMWUS743BSdrgU4/cnLluoB079kz4dcCe7GgDiplTjoIJv35Q3lhF12KkwRfq/B14rXWIGaHp9mi+R3bei6RjDuFNZZmlr8+OQsfByVXeADuXZgqyInrs+S/ngblWEJCvL3CWxT18B+z0CgYEAtFnitM1Izzi5O0fwcxNYOqvPVz95XmGvlDcY58+buq8wUm3vCP+yrWw72+v03bBsp1BRLifIA+95+EXxAKI+ws3fYgCyoaHM8BgOS7HeZyOB9O/blTJtf4ayz0c0Fw6L9Pbg9O3eM+ITBjpQvBd841docfYXxwIYknSHAP6603cCgYBqN/RCRdTTInwX2nftnNEDJnKREokKae61T7L19K3nk1upMzuBtP4C1Zqzk1M2AkkAYFGiECwVbnNfqWM/6XwuTpoJjy9/lFm3+6GwIkc+tdKeRQemaz3B1j5xNmXSaKyojzv9DKCC+PfJdOz6L6LFVAOmsKvzDMfuViwD9fOcxQKBgA+1NHWi25CQ1DFBlsOvD6QsiqaCtMNvpqc2FUk7X8jmsUK8qHEUNC++mYgSCQW19ACukiN++4C8PtdM4Cy59NVqsOYMQYKqYPsYXUZie4hoI01+BpX8CmVtCe3bucG4VqBDUFyEyzGhox6LvbRkJ1B1sHccg/2lRRacZ5XCmesJAoGAHpZD2jGPDL885rbfDMAQn2sEpt4rNz4KylfYjhjm6MOqw0025vBQDSzUYwiBRVdcmcLqi6RFJkL2gu3ivWA3mBEy4tlB4coQ9HxrGM3Tud1ElfkJkuxWC7cHQFaCcNc26MuQ+RBINzFFI6NkuNJ8cavjAKe/UgULrYjw2hSCmcg=";

    // 支付宝公钥,对应APPID下的支付宝公钥。 按照我文章图上的信息填写支付宝公钥，别填成商户公钥
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlVw/BlJpdKVFw7O+fpuM3Otpaly6JGmtzDCEdMzNatVnQg5Zok4LlRAB+kr3vxPUIv8wiuFoq/68CEBqtt/FhbNYLvjF4rih1MnkixxPINMbnJLOWeKMv3bdye6HfAc7xfdOxoZU08M6TaSNw22lEXM7VScf9hGS/P3Nx5xmQVrDpYbly0B6lG3gk3YRHf5+OcuOhypQXcNLAEYg/U6br7ad03cyogDYoRsLdi4VUNwbxNJ5w43WAyKulqQD6sXLYeoOfSsT6+oIe3lf9UC3RwvO8Fce10NKgyd/1n9V4b2TTBqlOx0s2GP0Mz3zqB0JDUEirAoxj0rz9neXOESv3QIDAQAB";
    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，其实就是你的一个支付完成后返回的页面URL
    public static String notify_url = neturl+"/alipay/notify_url";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，其实就是你的一个支付完成后返回的页面URL
    //public static String return_url = neturl+"/alipay/return_url";
    public static String return_url = "https://www.baidu.com/";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



}
