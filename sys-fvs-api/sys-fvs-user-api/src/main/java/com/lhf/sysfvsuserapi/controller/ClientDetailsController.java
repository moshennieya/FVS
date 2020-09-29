package com.lhf.sysfvsuserapi.controller;

import com.lhf.sysfvscommon.dto.ClientDetailsDTO;
import com.lhf.sysfvscommon.entity.ClientDetails;
import com.lhf.sysfvscommon.util.Result;
import com.lhf.sysfvsuserapi.feign.ClientDetailsFeign;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/9/16 8:41
 */
@RestController
@RequestMapping("/client")
public class ClientDetailsController {

    @Resource
    private ClientDetailsFeign clientDetailsFeign;


    @PostMapping("/insert")
    public Result<Boolean> insert(@RequestBody ClientDetails params) {
        return Result.success(this.clientDetailsFeign.insert(params));
    }

    @DeleteMapping("delete/{clientId}")
    public Result<Boolean> delete(@PathVariable String clientId) {
        return Result.success(this.clientDetailsFeign.delete(clientId));
    }

    @PutMapping("update")
    public Result<Boolean> update(@RequestBody ClientDetails params) {
        return Result.success(this.clientDetailsFeign.update(params));
    }

    @GetMapping("query/{clientId}")
    public Result<ClientDetailsDTO> queryByClientId(@PathVariable String clientId) {
        System.out.println(clientId);
        ClientDetailsDTO dto = this.clientDetailsFeign.queryByClientId(clientId);
        System.out.println(dto);
        return Result.success(dto);
    }
}
