package my.service.myAuth.log;

import ch.qos.logback.core.PropertyDefinerBase;

/**
 * @author: kevin Chang
 * @since : 2022/1/11
 */
public class APLogDefiner extends PropertyDefinerBase {
    @Override
    public String getPropertyValue() {
        return "AuthService";
    }
}
