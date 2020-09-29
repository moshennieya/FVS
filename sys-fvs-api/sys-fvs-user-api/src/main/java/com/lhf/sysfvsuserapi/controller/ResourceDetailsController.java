package com.lhf.sysfvsuserapi.controller;

import com.lhf.sysfvscommon.dto.ResourceDetailsDTO;
import com.lhf.sysfvscommon.entity.ResourceDetails;
import com.lhf.sysfvscommon.util.Result;
import com.lhf.sysfvsuserapi.feign.ResourceDetailsFeign;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/9/16 20:24
 */
@RestController
@RequestMapping("resources")
public class ResourceDetailsController {

    @Resource
    private ResourceDetailsFeign resourceDetailsFeign;


    @PostMapping("insert")
    public Result<Boolean> insert(@RequestBody ResourceDetails params) {
        return Result.success(this.resourceDetailsFeign.insert(params));
    }


    @DeleteMapping("/delete/{resourceId}")
    public Result<Boolean> delete(@PathVariable String resourceId) {
        return Result.success(this.resourceDetailsFeign.delete(resourceId));
    }


    @PutMapping("update")
    public Result<Boolean> update(@RequestBody ResourceDetails params) {
        return Result.success(this.resourceDetailsFeign.update(params));
    }


    @GetMapping("/queryByClientId/{clientId}")
    public Result<List<ResourceDetailsDTO>> queryByClientId(@PathVariable String clientId) {
        return Result.success(this.resourceDetailsFeign.queryByClientId(clientId));
    }
}
