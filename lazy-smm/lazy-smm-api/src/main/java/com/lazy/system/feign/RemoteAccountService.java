package com.lazy.system.feign;

import com.lazy.common.core.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(contextId = "remoteAccountService", value = "lazy-smm-biz")
public interface RemoteAccountService {
    @GetMapping("/sys/account/info/query")
    R queryInfo(@RequestParam(value = "username") String username);

    @GetMapping("/sys/account/info/query/{userId}")
    R queryInfoByUserId(@PathVariable(value = "userId") Long userId);
}
