package com.lhf.sysuserservice.controller;

import com.lhf.sysfvscommon.dto.ClientDetailsDTO;
import com.lhf.sysfvscommon.entity.ClientDetails;
import com.lhf.sysuserservice.service.inter.ClientDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/9/15 15:13
 */
@RestController
@RequestMapping("client")
public class ClientDetailsController {

    @Resource
    private ClientDetailsService clientDetailsService;


    @GetMapping("/queryById/{clientId}")
    public ClientDetailsDTO queryByClientId(@PathVariable String clientId) {
        return this.clientDetailsService.queryByClientId(clientId);
    }

    @PostMapping("/insert")
    public boolean insert(@RequestBody ClientDetails clientDetails) {
        return this.clientDetailsService.insert(clientDetails);
    }

    @PutMapping("update")
    public boolean update(@RequestBody ClientDetails clientDetails) {
        return this.clientDetailsService.update(clientDetails);
    }

    @DeleteMapping("delete/{clientId}")
    public boolean delete(@PathVariable String clientId) {
        return this.clientDetailsService.delete(clientId);
    }
}
