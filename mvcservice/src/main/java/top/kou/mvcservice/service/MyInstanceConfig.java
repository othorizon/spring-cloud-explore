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


}
