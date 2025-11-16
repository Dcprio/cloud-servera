package com.xlc.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "cloud-serviceb", contextId = "cloud-serviceb")
public interface EchoClient {

    /**
     * Call the echo method of the remote provider or roll back when the service is blown.
     *
     * @param str str
     * @return {@link String}
     */
    @GetMapping("/echo/{str}")
    String echo(@PathVariable("str") String str);

    /**
     * Call the divide method of the remote provider or roll back when the service is blown.
     *
     * @param a a
     * @param b b
     * @return {@link String}
     */
    @GetMapping("/divide")
    String divide(@RequestParam("a") Integer a, @RequestParam("b") Integer b);

    /**
     * Test that the default method calls the remote method is still a remote call.
     *
     * @param a a
     * @return {@link String}
     */
    default String divide(Integer a) {
        return divide(a, 0);
    }

    /**
     * Call the notFound method of the remote provider or roll back when the service is blown.
     *
     * @return {@link String}
     */
    @GetMapping("/notFound")
    String notFound();
}