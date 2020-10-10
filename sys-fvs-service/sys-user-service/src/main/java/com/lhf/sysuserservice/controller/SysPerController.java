package com.lhf.sysuserservice.controller;

import com.lhf.sysfvscommon.dto.SysPerDTO;
import com.lhf.sysfvscommon.entity.SysPer;
import com.lhf.sysfvscommon.util.Result;
import com.lhf.sysuserservice.service.inter.SysPersService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/10/6 14:49
 */
@RestController
@RequestMapping("per")
public class SysPerController {

    @Resource
    private SysPersService sysPersService;


    @PostMapping("insert")
    public Boolean insert(@RequestBody SysPer params) {
        return this.sysPersService.insert(params);
    }

    @GetMapping("any")
    public List<SysPerDTO> queryAny(@RequestParam(required = false) String menuName, @RequestParam(required = false)Integer menuType,
                                            @RequestParam(required = false) String per, @RequestParam(required = false) Integer parentId) {
        return this.sysPersService.queryAny(new SysPer(per, menuName, menuType, parentId));
    }
}
