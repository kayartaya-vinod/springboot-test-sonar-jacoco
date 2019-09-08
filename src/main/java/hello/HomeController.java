package hello;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/")
	public String greeting() {
		return "Hello World";
	}

	// this is a dummy comment
	@GetMapping("/{name}")
	public Map<String, String> greeting(@PathVariable String name) {
		int a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z;
		Map<String, String> msg = new HashMap<String, String>();
		msg.put("message", String.format("Hello, %s!", name));
		msg.put("time", new Date().toString());
		return msg;
	}

}