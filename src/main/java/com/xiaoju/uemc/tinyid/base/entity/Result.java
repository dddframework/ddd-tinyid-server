package com.xiaoju.uemc.tinyid.base.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author du_imba
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private int code;
    private long id;
}
