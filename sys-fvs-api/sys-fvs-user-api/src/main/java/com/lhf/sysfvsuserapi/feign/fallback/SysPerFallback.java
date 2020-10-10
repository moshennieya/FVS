package com.lhf.sysfvsuserapi.feign.fallback;

import com.lhf.sysfvscommon.dto.SysPerDTO;
import com.lhf.sysfvscommon.entity.SysPer;
import com.lhf.sysfvsuserapi.feign.SysPerFeign;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/10/6 17:18
 */
@Component
public class SysPerFallback implements FallbackFactory<SysPerFeign> {
    private static final Logger logger = LoggerFactory.getLogger(SysPerFallback.class);

    @Override
    public SysPerFeign create(Throwable throwable) {
        return new SysPerFeign() {
            @Override
            public boolean insert(@RequestBody  SysPer params) {
                return false;
            }

            @Override
            public List<SysPerDTO> queryAny(@RequestParam(required = false) String menuName, @RequestParam(required = false) Integer menuType,
                                            @RequestParam(required = false) String per, @RequestParam(required = false) Integer parentId) {
                logger.error("查询失败");
                return null;
            }
        };
    }
}
