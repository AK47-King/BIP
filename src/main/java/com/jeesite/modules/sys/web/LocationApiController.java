package com.jeesite.modules.sys.web;

import com.jeesite.common.web.BaseController;
import com.jeesite.modules.bip.loc.entity.LocInfo;
import com.jeesite.modules.bip.loc.service.LocInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Api(value="LocationController",tags={"Location接口"})
public class LocationApiController extends BaseController {
    @Autowired
    private LocInfoService locInfoService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "locationId", paramType="query" ,value = "位置ID", required = true, dataType = "string"),
            })
    @RequestMapping(value = "${apiPath}/location/{locId}", method = RequestMethod.GET)
    public LocInfo search(String locId) {
        return locInfoService.get(locId);
    }
}
