package com.alipay.config;
import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016101400681187";

    // 商户私钥，您的PKCS8格式RSA2私钥
//    public static String merchant_private_key = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDRAQ8ViPkXCgrxk8uhwdxS/gdgz58YL232RC4wqQGE1VW/2FdVlc+8prEvUIMVVvJ4zCsVN07TYNgrQ7m2qEynI0ygmAnFpJolq7clFdpOnoP43mWUZNNQZYdXXnPsBgi/jNAmyVJD325KL1Fme9hN8xXsabFnKBVYdkzbDKzc8q5mRsVb6QQAJQujdOyIRw3F4LyN0iweeIgxVl0b1m2I6rA/xHP4LiR3exO0t/AQ0ML/EqGzQwFnWF+ZkFrhoYipr0fjM85Cu1udzInyOJTfQR8Um1JvGLNR2BZB6JEID6ejDNtAKyHCJTc4zpu2lYVbM/dM+y8jsl1J+DLP1BCdAgMBAAECggEBALEVnJo6fBKxR6R3/UkI4IzQ/59fSwVK6niGPDyudcL+nrD1tMmnLWRCOE5GgUpLaRZApyBKxFcE7yN5Npk07/2NQxeuuljjplfUrlCVu2pxlJAAn0CkTQcJfyrftIh+dFsYDCVQ3orzfJcOkIGs3RDurdypkM4+gBd75JKUosJwsz59zeiKzsXCcreuqWG7kiXSc8nfMnwMgIZaMn6Ecz86EeY2UggqQgNF74aXew1VtRmQ/G/+OYJBfHyXg3udIEhKEuDNqjdNpKPP5thCJLbfsHBlXa6mXYnU0A+VxNzIgBQWHbtKxD5YiXMAatYzDkhGk06z+5deseoCZsDAfmECgYEA+9mFvQCcZrgVpmqsjXkt4+7Avr01Jw15LzJQLapg856zsP+bi7tyLWVaHwTivG5USExR/zuPLlLEXp1rarbHJ1BXpUk51XCYodweCN9XBIMHL/RhTAFuF2YdOBolJ8jqMNp3XRbuogYe2edQD9dB3xa6cSvcqXesMrJ4lVJ6JWMCgYEA1HLIuIObuuU1wDNaygQMMypF+QmCTANRnGdjdO0X3F+pEZ3gbq4gpMw8rarlKgXq21VNM8eA4hbZ3V2RoUMCFaQ9SV60QCDX1hzCjlBSjF9N2ouQcv3Iphl0Ahhktrl/P/3/cn/xvZ4qQH84QjmM8aO4IjDfCYK+BMjA20DB0f8CgYAsJ4zdABhroeaZ0KYD/7Td+2PrjPyepiwS7D1GZFKvI6nZZFb+/pQcBWLxgUfHRYidTFQr7WNC+dvXwr2sbfMon1tebSIom58G8bKKV63H6rj93ViZnL6Sd6KzzVGqUf1NJ2A5/+VCntQV3AobXN/9ntx9LvV2+LZGBShC9bzYhQKBgQDBRvgzXZCFVNg01sPHPC15MwFb0vnWe8J4n1rNWpI1rFXdMBuptgL+ysx9VxeLxrxm9ND6xYsMpatpiCHga1zvIW+cW2tzWC3knl+mJ48iI+ZpaEVvSFGOQ2PWMCkYT+Rj7InEun/MeaOI7/TX0xHWGJOBj6KqPWbwZU+HaP+sMwKBgQD5C4muvlaIQXYDQakNZaZaiS7ZEGVcVPrBpFgqiWhTlVj8jTeXxU1b9oJoD1oFVZNXJYuxk46gJRfyYqqUwwcsN0JgR4ZaM4pn1UhKQsEpbV6QI/vGF+LV9xwMVKCx4PKds1++3ugRUHOqlcLlTdjlBjyhTFRMEa4k4g4nRoi8Gg==";
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCISvh11L5f8lxwdPpojKaWJOzlMWdwy9BuVHT0V8qtYAzGaDcTMVdrV8YWM9z0KGDb7qpJqp0vxjSsqtaKm8tDW8npUKc2X+3U4eOdaL+t9Rx2hgXXlU0UJ9jb3mE1GQyOjfvMJ0JylchxWuC+bUuPXhWoGgC+VakWH3JoyujP3aV5FcCyVfOJgG9BLS2D2rHhiQ5ETE1Rjl9J1ci7tKY/eft1+TdYS4pY/HUPfxxNkNKljzQ5wq2aBjljRPcOZYs0DdR1c5H0vvfTxo71UJE6T5JnuqVGtmpypiuiBmK/bjZJJztIg6HjiBjP9oFEUmF2rdpCfeg95HNKOA8llg+fAgMBAAECggEAIT4wBgWC/cIOm/tcTH3p7/tHsMtxEIkV6KM+944mSE2CMC6hKFRDn1IEZcv2m7LxlRNMg7VSq6FrnaX5uEsxs9dCk17xugiB6QfDzdQL1LFRZPNhn2iyKTVi5pYCHcJjVq34+Z2lzm8MOeHRqYDdCjYHkD3van1YRaYb8MV1LaXlCtkq9y9NzexK8W0wffZMExcmn2/o2AFcMIJQpoVWJvJvZljdhgDcfUn7UoMWgalfdnvsFrAS97voiNoRLWLLUG7BlUkFgARUEcOXdXEesaaFbHtFxUdL0vDKUqeexSL88zWTrWsT9BJlhtDsUY3+b2jDqdVsXndKtY5XwuZD4QKBgQDaKHhQNeikmNJr3Pr+8Tj+GkzPSkJh3+88cYCJaex+tx5pdL29113u++/wn4snnHNCNY7qbBkKXbDP5JkucuDmFGRJifrc676tWNxJ0dXJG3rlPMknNOJbX93OABbC0M+IPpWAbYG8pVk7/0NtzYS6z5I4y8UwEEyasCSyIUSBLwKBgQCf7zE6mxuA+8K08DaSQ4lwXWeOISens6HbBRIkUh5N7p7DhtdiAv71ktoPbHibns/v/EEj0m65Us4AN0hQXAj7XGPcb4FwVIPBvhJN1Y6rkcBFqaSZr8ykbPQRBo8s7qPFb6Guw6U6BiQTKrJaa0Bh+VNo69JrmJhKreKoF2RckQKBgHLbK7zPJRTDgMVZKqxew+rEXfwk1J5DD+l6uHmgUurD7jcHR35TjRjte33sAY9xRx1spTm2f9h9S0Go0R0rTkzUH5i4FGOLmnAZgKE84Jlo5mMaha0moqYI6vYyBcm7tge9K2jaPpvbUgfMdOuycFcKQam1XrPXYP1wD2HZMf/xAoGAUQcLBukcZx2mCKuGylWDJTV9SInNoG4mu2L3TQV5qvwQ3XjMWDCyYVJUPeoztIwiRzCjA/YR+LxV99AKSARI3KhzQ3QOvQ1kb1zPwzVGAfBm3CRVazOg11EH2jRbh2Uj/dxPqs4eQKZp0ngYQi0CQmDh/E81nSODTJqKMaUgSLECgYEAle4vYJ5eNSmEuad6tYHHxHdcKbaY+nqDqGdulY5GJM7Wg454V9OBR6ycR0sVHasT93Xof9xuyi0CF/Dcw6OLZUefr8jbD7e6lyxSCx+ZS+rb2o42C1EsoGrKE3zvVwSOZiapLd66smX16PcZg/K7c72ZQWFtJO4v2TuHn/VYKcM=";

    // 支付宝公钥!!!!,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnib8qB6Rp2mvuTC5b5hHO8MUAMLpqFglwkMg0muogdAMocUXyM9dv/p5qot647mK/VY1Z9d+P4Muol32RgbnKUTWWfc3h6FYC+jhr264AG37xMsO+Y97coRNunfzz2z2bA+tdLOdPd0FsI/5xQDVkFagW+iEXrrM10qAC/O+07lQMN1kUhqBkkg56H/3BFlsC3sIw3qmXchzBiokV0h+wl+wu46QhaEgqiTvCu8uLXUqJ2I1qYaDywRwbEsJtIc3faxQFiPq/4JRL5u9XFmq0nV2K5zExNBK+fUoN6eWASQw40ukCgH3VlNcNBa0+HtvAN7sHZlaZ0jSsA7SnENrBwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

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

