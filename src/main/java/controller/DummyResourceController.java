package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DummyResourceController {

    @RequestMapping("/stockTicker/{companyTicker}")
    public @ResponseBody String getDummy(@PathVariable String companyTicker) {
        return (companyTicker.equals("ABC")) ? "ABC PLC" : "Unknown Company Name";
    }

}
