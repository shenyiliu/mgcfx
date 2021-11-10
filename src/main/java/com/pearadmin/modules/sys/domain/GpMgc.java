package com.pearadmin.modules.sys.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.pearadmin.common.web.base.BaseDomain;

/**
 * 高频敏感词对象 gp_mgc
 * 
 * @author jmys
 * @date 2021-11-04
 */
@Data
public class GpMgc extends BaseDomain
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 名称 */
    private String name;

    /** 次数 */
    private Long mgcNum;

}
