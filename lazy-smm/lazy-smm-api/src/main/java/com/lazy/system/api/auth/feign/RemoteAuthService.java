package com.lazy.system.api.auth.feign;

import com.lazy.common.core.domain.R;
import com.lazy.system.api.auth.entity.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(contextId = "remoteAuthService", value = "lazy-smm-provider")
public interface RemoteAuthService {
    @GetMapping("/sys/account/query/{loginname}")
    R<Account> queryAuth(@PathVariable("loginname") String loginname);
}
