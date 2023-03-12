package hello.itemservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    // 단순히 홈으로 요청이 왔을 때 items로 이동하는 컨트롤러
    @RequestMapping("/")
    public String home(){
        return "redirect:/items";
    }



}
