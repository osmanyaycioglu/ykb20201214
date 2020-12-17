package com.training.ykb.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.training.ykb.accounting.client.IAccountingClient;
import com.training.ykb.error.RestException;
import com.training.ykb.order.models.Order;
import com.training.ykb.order.models.PaymentRequest;

@Service
public class AccountingFacade {

    @Autowired
    private RestTemplate      rt;

    @Autowired
    private EurekaClient      ec;

    @Autowired
    private IAccountingClient iac;

    public String pay(final Order order) throws RestException {
        PaymentRequest pr = new PaymentRequest();
        pr.setOrderId(1);
        pr.setAmount(10_000);
        return this.iac.pay(pr);
    }

    public String payOld(final Order order) {
        PaymentRequest pr = new PaymentRequest();
        pr.setOrderId(1);
        pr.setAmount(100);
        return this.rt.postForObject("http://ACCOUNTING/accounting/payment/request",
                                     pr,
                                     String.class);
    }

    public String pay2(final Order order) {
        PaymentRequest pr = new PaymentRequest();
        pr.setOrderId(1);
        pr.setAmount(100);

        Application applicationLoc = this.ec.getApplication("ACCOUNTING");
        List<InstanceInfo> instancesLoc = applicationLoc.getInstances();
        for (InstanceInfo instanceInfoLoc : instancesLoc) {
            System.out.println("Ip : " + instanceInfoLoc.getIPAddr() + ":" + instanceInfoLoc.getPort());
        }
        RestTemplate rto = new RestTemplate();
        return this.rt.postForObject("http:///accounting/payment/request",
                                     pr,
                                     String.class);
    }

}
