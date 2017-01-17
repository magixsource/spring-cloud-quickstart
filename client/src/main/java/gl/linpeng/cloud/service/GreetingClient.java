package gl.linpeng.cloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("api-gateway")
public interface GreetingClient {
	@RequestMapping(method = RequestMethod.GET, value = "/api-greeting/greeting")
	String greeting(@RequestParam(value = "name")
	String name);
}
