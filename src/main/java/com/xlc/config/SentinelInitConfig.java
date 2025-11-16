package com.xlc.config;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SentinelInitConfig {

    @PostConstruct
    public void initFlowRules() {
        List<FlowRule> rules = new ArrayList<>();

        // 限流规则
        FlowRule rule = new FlowRule();
        rule.setResource("version"); // 方法名或者资源名
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS); // 按 QPS 限流
        rule.setCount(1); // 每秒最多允许 5 次调用
        rules.add(rule);

        FlowRuleManager.loadRules(rules); // 加载规则到 Sentinel
    }
}