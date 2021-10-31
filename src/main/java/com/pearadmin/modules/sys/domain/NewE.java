package com.pearadmin.modules.sys.domain;

import java.util.ArrayList;
import java.util.Date;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.pearadmin.common.web.base.BaseDomain;

/**
 * 获取文章对象 new_e
 * 
 * @author jmys
 * @date 2021-10-28
 */
@Data
public class NewE extends BaseDomain
{
    private static final long serialVersionUID = 1L;

    /** 文章ID */
    private Long newid;

    /** 文章内容 */
    private String newcontent;

    /** 路径 */
    private String newurl;

    /** 标题 */
    private String newtitle;

    /** 文章创作时间 */
    private Date newcreatetime;

    /** 文章来源 */
    private String newsource;

    /** 文章作者 */
    private String newauthor;

    /** 收集时间 */
    private Date collecttime;

    /** 其他 */
    private String newother;

}
