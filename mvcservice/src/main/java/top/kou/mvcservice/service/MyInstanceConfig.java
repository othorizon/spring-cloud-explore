package top.kou.mvcservice.service;


import com.netflix.appinfo.MyDataCenterInstanceConfig;
import org.springframework.util.StringUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author dell  让注册到服务的名称是机器的ip ，非主机名
 *
 */
public class MyInstanceConfig extends MyDataCenterInstanceConfig{
    @Override
    public String getHostName(boolean refresh) {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            return super.getHostName(refresh);
        }
    }

    /**
     * 实例id是显示在服务中心列表页的status字段，就是boot项目中的
     * `eureka.instance.instance-id=${spring.cloud.client.ipAddress}:${server.port}`这个配置，
     * 因为boot项目里可以获取ip地址来显示。所以这里采用重写方法的方式来实现
     * @return
     */
    @Override
    public String getInstanceId() {
        try {
            return InetAddress.getLocalHost().getHostAddress()+":"+getNonSecurePort();
        } catch (UnknownHostException e) {
            return "Unknown";
        }
    }
}
