package gl.linpeng.cloud.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	private final Logger logger = Logger.getLogger(getClass());

	@Autowired
	private DiscoveryClient client;

	@RequestMapping(value = "/greeting", method = RequestMethod.GET)
	public String add(@RequestParam
	String name) {
		ServiceInstance instance = client.getLocalServiceInstance();
		String hello = String.format("Hello %s", name);
		logger.info("/greeting, host:" + instance.getHost() + ", service_id:"
				+ instance.getServiceId() + ", result:" + hello);
		return hello;
	}
}
