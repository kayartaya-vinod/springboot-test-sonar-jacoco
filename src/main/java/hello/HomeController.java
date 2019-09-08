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
    
    @GetMapping("/{name}")
    public Map<String, String> greeting(@PathVariable String name) {
    	Map<String, String> m = new HashMap<String, String>();
    	m.put("message", String.format("Hello, %s!", name));
    	m.put("time", new Date().toString());
    	return m;
    }

}