package my.service.myAuth.log;

import ch.qos.logback.core.PropertyDefinerBase;
import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;

/**
 * @author: kevin Chang
 * @since : 2022/1/11
 */

public class IPLogDefiner extends PropertyDefinerBase {

    @Override
    public String getPropertyValue() {
        return getHostName();
    }

    private String getHostName() {
        String localIp = null;
        try {
            localIp = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {

        }
        String uniqName = UUID.randomUUID().toString().replace("-", "");
        if (localIp == null) {
            uniqName = localIp + "-" + uniqName;

        }else{
            uniqName = localIp;
        }
        return uniqName;
    }
}
