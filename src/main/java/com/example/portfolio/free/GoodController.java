package com.example.portfolio.free;

import com.example.portfolio.domain.GoodForm;
import com.example.portfolio.domain.GoodService;
import com.example.portfolio.domain.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class GoodController {
    private final GoodService goodService;
    private final UserService userService;

    @PostMapping("goodCreate")
    @ResponseBody
    public String goodCreate(GoodForm form){
//        goodService.cretaeGood(form.getName(), form.getPartnerId());
        goodService.goodCountUp(form.getGoodsCount() + 1, form.getPartnerId());
        return null;
    }
}
