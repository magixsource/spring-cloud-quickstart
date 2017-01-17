package gl.linpeng.cloud.web;

import gl.linpeng.cloud.service.GreetingClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	@Autowired
	GreetingClient greetingClient;

	@RequestMapping(value = "/greeting", method = RequestMethod.GET)
	public String greeting() {
		return greetingClient.greeting("heiHei");
	}
}
