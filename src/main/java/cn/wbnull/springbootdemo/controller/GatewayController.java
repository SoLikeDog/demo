package cn.wbnull.springbootdemo.controller;

import com.dd.plist.Base64;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class GatewayController {

    @RequestMapping(value = "/gateway")
    public String gateway() {
        return "Hello World";
    }
    @PostMapping("/coupon/listtwo")
    public String couponList2(@RequestBody String base64) {
        try {
//Vulnerability Trigger Point
            Base64.decodeToObject(base64);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return "ok";
    }
}
