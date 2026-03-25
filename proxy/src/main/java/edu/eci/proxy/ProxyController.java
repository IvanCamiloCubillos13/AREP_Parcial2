package edu.eci.proxy;

import edu.eci.proxy.ProxyService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProxyController {

    private final ProxyService proxyService = new ProxyService();

    @GetMapping("/math")
    public String proxy(@RequestParam("value") String value) {
        return proxyService.forwardRequest(value);
    }
}
