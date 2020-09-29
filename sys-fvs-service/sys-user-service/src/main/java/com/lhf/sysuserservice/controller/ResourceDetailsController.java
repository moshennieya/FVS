package com.lhf.sysuserservice.controller;

import com.lhf.sysfvscommon.dto.ResourceDetailsDTO;
import com.lhf.sysfvscommon.entity.ResourceDetails;
import com.lhf.sysuserservice.service.inter.ResourceDetailsService;
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
    private ResourceDetailsService resourceDetailsService;


    @PostMapping("insert")
    public boolean insert(@RequestBody ResourceDetails params) {
        return this.resourceDetailsService.insert(params);
    }


    @DeleteMapping("/delete/{resourceId}")
    public boolean delete(@PathVariable String resourceId) {
        return this.resourceDetailsService.delete(resourceId);
    }


    @PutMapping("update")
    public boolean update(@RequestBody ResourceDetails params) {
        return this.resourceDetailsService.update(params);
    }


    @GetMapping("/queryByClientId/{clientId}")
    public List<ResourceDetailsDTO> queryByClientId(@PathVariable String clientId) {
        return this.resourceDetailsService.queryByClientId(clientId);
    }
}
