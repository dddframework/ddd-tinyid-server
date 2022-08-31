package com.xiaoju.uemc.tinyid.server.vo;

import lombok.Data;

/**
 * @author du_imba
 */
@Data
public class Response<T> {
    private T data;
    private Integer code = 200;
    private String message = "";

    public static final int SYS_ERROR = 500;

}
