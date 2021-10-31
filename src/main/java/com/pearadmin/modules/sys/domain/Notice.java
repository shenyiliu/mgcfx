package com.pearadmin.modules.sys.domain;

import java.util.Date;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.pearadmin.common.web.base.BaseDomain;

/**
 * 系统公告对象 notice
 * 
 * @author jmys
 * @date 2021-10-16
 */
@Data
public class Notice extends BaseDomain
{
    private static final long serialVersionUID = 1L;

    /** 公告ID */
    private Long id;

    /** 标题 */
    private String title;

    /** 作者名字 */
    private String name;

    /** 创作时间 */
    private String noticetime;

    /** 内容 */
    private String context;

}
