package com.lazy.system.feign;

import com.lazy.common.core.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(contextId = "remoteUserService", value = "lazy-smm-biz")
public interface RemoteUserService {
    @GetMapping("/sys/user/info/{userId}")
    R queryInfoById(@PathVariable(value = "userId") Long userId);
}
