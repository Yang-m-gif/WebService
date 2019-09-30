package com.slk.web.framework.Interceptor.AccessIntercept;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

/**
 * Create by 杨明 2019/6/20 0020 下午 15:34
 */
public class LicenseInterceptor  extends AbstractPhaseInterceptor<Message> {

    public LicenseInterceptor() {
        super(Phase.RECEIVE);
    }

    @Override
    public void handleMessage(Message message) throws Fault {
        try {
            if(!priv.license.DecodeLicense.Decode()) {
                throw new Fault(new IllegalAccessException("No permissions"));
            }
        } catch (Exception e) {
            throw new Fault(new IllegalAccessException("No permissions"));
        }
    }
}
