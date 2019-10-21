package com.asianrapid.talin.common.domain.dmo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName PayChannelDMO
 * @Author Nio
 * @Date 2019/8/31 0031
 * @Version V1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayChannelDMO {

    private String channelName;

    private String merchantId;

    private String syncUrl;

    private String asynUrl;

    private String publicKey;

    private String privateKey;

}
