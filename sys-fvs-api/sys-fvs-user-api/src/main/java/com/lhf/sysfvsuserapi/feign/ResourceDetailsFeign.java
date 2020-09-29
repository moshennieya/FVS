package com.lhf.sysfvsuserapi.feign;

import com.lhf.sysfvscommon.dto.ClientDetailsDTO;
import com.lhf.sysfvscommon.dto.ResourceDetailsDTO;
import com.lhf.sysfvscommon.entity.ClientDetails;
import com.lhf.sysfvscommon.entity.ResourceDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/9/15 17:01
 */
@FeignClient(value = "sys-user-service", contextId = "resourceDetailsFeign")
@RequestMapping("resource")
public interface ResourceDetailsFeign {

    /**
     * 添加
     *
     * @return
     */
    @PostMapping("insert")
    boolean insert(@RequestBody ResourceDetails params);

    /**
     * 删除
     *
     * @param resourceId
     * @return
     */
    @DeleteMapping("delete")
    boolean delete(@RequestBody String resourceId);

    /**
     * 修改
     *
     * @param params
     * @return
     */
    @PutMapping("update")
    boolean update(@RequestBody ResourceDetails params);

    /**
     * 根据clientId查询所有资源
     *
     * @param clientId
     * @return
     */
    @GetMapping("queryById/{clientId}")
    List<ResourceDetailsDTO> queryByClientId(@PathVariable String clientId);

}
