package com.lhf.sysfvsuserapi.controller;

import com.lhf.sysfvscommon.dto.SysPerDTO;
import com.lhf.sysfvscommon.entity.SysPer;
import com.lhf.sysfvscommon.util.Result;
import com.lhf.sysfvsuserapi.feign.SysPerFeign;
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
    private SysPerFeign sysPerFeign;


    @PostMapping("insert")
    public Result<Boolean> insert(@RequestBody SysPer params) {
        return Result.success(this.sysPerFeign.insert(params));
    }

    @GetMapping("any")
    public Result<List<SysPerDTO>> queryAny(@RequestParam(required = false) String menuName, @RequestParam(required = false) Integer menuType,
                                            @RequestParam(required = false) String per, @RequestParam(required = false) Integer parentId) {
        return Result.success(this.sysPerFeign.queryAny(menuName, menuType, per, parentId));
    }
}
