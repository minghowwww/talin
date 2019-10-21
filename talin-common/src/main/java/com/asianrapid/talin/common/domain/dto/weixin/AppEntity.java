package com.asianrapid.talin.common.domain.dto.weixin;

import lombok.Data;

@Data
public class AppEntity {
    /**
     * appId
     */
    private String appId;
    /**
     * appName
     */
    private String appName;

    public AppEntity() {
    }

    public AppEntity(String appId, String appName) {
        this.appId = appId;
        this.appName = appName;
    }
}
