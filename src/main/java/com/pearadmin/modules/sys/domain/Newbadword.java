package com.pearadmin.modules.sys.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.pearadmin.common.web.base.BaseDomain;

/**
 * 敏感词表对象 newbadword
 * 
 * @author shenyi
 * @date 2021-11-02
 */
@Data
public class Newbadword extends BaseDomain
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 敏感词 */
    private String badword;

    /** 种类 */
    private String kind;

}
