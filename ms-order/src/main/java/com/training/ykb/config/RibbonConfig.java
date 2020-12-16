package com.training.ykb.config;

import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.NoOpPing;

public class RibbonConfig {

    public IRule loadBalancerRule() {
        return new BestAvailableRule();
    }

    public IPing loadbaPing() {
        return new NoOpPing();
    }


}
