package com.lazy.system.feign;

import com.lazy.common.core.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(contextId = "remoteRoleService", value = "lazy-smm-biz")
public interface RemoteRoleService {
    @GetMapping("info/query/{userId}")
    R queryInfoByUserId(@PathVariable("userId") Long userId);
}
