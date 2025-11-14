package cn.com.yis.rpc;

import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class AgentRpcServiceImpl implements AgentRpcService {
    @Override
    public String ping(String name) {
        return "pong:" + (name == null ? "" : name);
    }
}

