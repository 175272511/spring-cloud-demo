package com.zibba;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;

/**
 * Created by liuhui on 2017/7/26.
 * 使用configuration可以覆盖默认配置
 *
 */
//@FeignClient(value = "eureka-provider", fallback = ConsumerClientHystrix.class, configuration = DisableHystrixConfig.class)
@FeignClient(value = "eureka-provider", fallback = ConsumerClientHystrix.class)
public interface FeignConsumerClient extends ConsumerClient {
}
