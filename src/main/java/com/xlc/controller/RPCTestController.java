package com.xlc.controller;

import com.xlc.Feign.EchoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RPCTestController {

    @Autowired
    private RestTemplate urlCleanedRestTemplate;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EchoClient echoClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    private static final String SERVICE_PROVIDER_ADDRESS = "http://cloud-serviceb";

    @GetMapping("/echo-rest/{str}")
    public String rest(@PathVariable String str) {
        return urlCleanedRestTemplate
                .getForObject(SERVICE_PROVIDER_ADDRESS + "/echo/" + str,
                        String.class);
    }

    @GetMapping("/index")
    public String index() {
        return restTemplate.getForObject(SERVICE_PROVIDER_ADDRESS, String.class);
    }

    @GetMapping("/test")
    public String test() {
        return restTemplate
                .getForObject(SERVICE_PROVIDER_ADDRESS + "/test", String.class);
    }

    @GetMapping("/sleep")
    public String sleep() {
        return restTemplate
                .getForObject(SERVICE_PROVIDER_ADDRESS + "/sleep", String.class);
    }

    @GetMapping("/notFound-feign")
    public String notFound() {
        return echoClient.notFound();
    }

    @GetMapping("/divide-feign")
    public String divide(@RequestParam Integer a, @RequestParam Integer b) {
        return echoClient.divide(a, b);
    }

    @GetMapping("/divide-feign2")
    public String divide(@RequestParam Integer a) {
        return echoClient.divide(a);
    }

    @GetMapping("/echo-feign/{str}")
    public String feign(@PathVariable String str) {
        return echoClient.echo(str);
    }

    @GetMapping("/services/{service}")
    public Object client(@PathVariable String service) {
        return discoveryClient.getInstances(service);
    }

    @GetMapping("/services")
    public Object services() {
        return discoveryClient.getServices();
    }

}