package com.etc.demo.returnentity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ReturnOrder {
    private Integer oId;
    private String gName;
    private Integer oState;
    private String gPrice;
    private String gImag1;
}
